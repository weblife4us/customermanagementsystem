# Customer Management System

##PROD build of the project
In order to build the project locally you must:
1. execute: <br>
 `mvn clean install`<br> 
  _it will_:<br>
  a. build Java code,<br> 
  b. run Java unit-tests + integration, <br>
  c. build ReactJS part and place it in the `target/public/class`. <br>
  The resulting .jar file can be found in `target`

2. run .jar file using:<br> 
    `java -jar target/frame-0.0.1-SNAPSHOT.jar`
    
## Dev build of the project
1. Run Spring Boot locally (port 9090) <br>
2. Run webpack server locally: <br>
        a. in console open `front-end` dir <br>
        b. execute `npm start` <br>
        
Webpack server will run on port 3000 (unless other specified)
        