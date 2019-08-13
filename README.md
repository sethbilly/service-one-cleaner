# service-one-cleaner
An optimization restful API endpoint for optimizing the
number of senior and junior cleaners needed for cleaning 
rooms in partner structures.
## Getting Started

These instructions will get you a copy of the project up and running
on your local machine for development, testing and even to production.

### Prerequisites
You need to install the following
```
jdk8
maven
```

### Installing
Clone folder and run maven in the root of the directory. A step by step
series of actions that tell you how to get project running.

```
root_directory > mvn package
```
Compiles and builds classes and resources into jar file. A target folder 
is generated containing the build.
#### windows
```
project_root_directory > java -jar \target\spo-cleaner-1.0.jar
```
#### unix 
```
project_root_directory > java -jar /target/spo-cleaner-1.0.jar
```

This will spin an embedded tomcat server and the application
can be accessed on localhost and port set in the application.properties
file in the source directory of the project
```
http://localhost:<server.port>
```

### API Endpoints
```
POST /optimize
```
This endpoint accepts an input json of sample below
Input:
- array of rooms (int) for every structure
- cleaning capacity Junior Cleaner (int)
- cleaning capacity Senior Cleaner (int)
######*sample request*
*{
  "rooms": [35, 21, 17, 28],
  "senior": 10,
  "junior": 6
}*
```
curl -d '{"rooms": [35, 21, 17, 28],"senior": 10,"junior": 6}' -H "Content-Type: application/json" -X POST http://localhost:8080/optimize
```
######*sample response*
Output:
- array of maps which include the optimal number of Juniors and Seniors for ever
structure
*{
    {senior: 3, junior: 1}, 
    {senior: 1, junior: 2}, 
    {senior: 2, junior: 0}, 
    {senior: 1, junior: 3}
}*

## Deployment
The build in the target can be executed on cloud or server hosting platform

