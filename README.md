# Todo
This is simple todo app.
Data will be store in h2 db. This app is develped using angular 1.x and spring boot.
This can be deployed using docker container also.

This have feature add, delete and complete task.

Use below commnd to deploy app.

Pull images from docker hub : 
  - docker pull narendermyname/todo
  
Run todo app : 
  - docker run -p 7001:7001 -t narendermyname/todo

Or run with below java command direct from jar file : 
  - java -jar todo.jar
  
