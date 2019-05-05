# Twitch Event Viewer
## live demo
https://evening-spire-26420.herokuapp.com/

Module Design
1. Auth Module - context for user authentication including twitch OAuth
2. Event Module - context for event webhook, event crud, event related models

## Event Pub/Sub
for interview purpose, user follow event is implemented and the rest of the streamer event could use the same design.

### history user follow events
history user follow events are fetched through twitch api with limit = 10

### real time user follow events
real time user follow events are designed to use Web hook & Pusher

webhook work flow:
1. frontend lookup stream info(mainly _id) using twitch user api
1. frontend listen on Pusher chanel.
1. frontend create subscription though POST request to twitch server.
1. backend receive GET request from twitch server, and confirm subscription.
1. backend receive POST request from twitch server when event occurs.
1. backend save event info and user Pusher to publish event
1. frontend Pusher event gets triggered and updated event list.


### How would you deploy the above on AWS? (ideally a rough architecture diagram will help)
1. Spring boot application can be easily deployed with a clean docker container with only Java 8 installed. 
    1. config AWS EC2 server(install docker)
    1. dockerfile mainly for mounting purpose
    1. package Spring application as a jar file 
    1. copy the jar file into docker 
    1. user "javac" command to start the application in docker

1. Log file could be mounted on server or sent to a centralized logging service.
1. frontend static file could be optimized with CDN(AWS CloudFront)

### Where do you see bottlenecks in your proposed architecture and how would you approach scaling this app starting from 100 reqs/day to 900MM reqs/day over 6 months?
1. The Web hook flow is the bottleneck in my design. Since all events will be POST to our backend api. And then re-publish using Pusher.better design is to use frontend socket instead of webhook, so webhook flow mentioned above could be mostly avoided.
1. backend event listener could be optimized with message queue, especially when frontend uses socket.
1. For interview purpose I did not use a frontend MVC framework. But frontend framework can limit the visits to the backend(especially good for bandwidth with CDN.)
1. SQL persistence layer / Cache / Redis could speed up the application and save database query. 
1. stateless module could be extracted to be its own micro-service, and scale horizontally and add load balancer.


# Tech stack
Spring boot - Backend Application, Spring mvc, Spring security, Spring Data Jpa
 
Thymeleaf - Template rendering

PostgreSQL - Database

Bootstrap - frontend style

Git & Github - Version control

Heroku - CI & Server 

Third patry - Twitch, Pusher(Pub/Sub for webhook)