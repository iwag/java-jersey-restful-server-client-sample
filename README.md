[![Build Status](https://travis-ci.org/iwag/java-jersey-restful-server-client-sample.svg?branch=master)](https://travis-ci.org/iwag/java-jersey-restful-server-client-sample)

# java-jersey-restful-server-client-sample
RESTful Server/Client sample with Jersey in Java8

## How to run a server

```bash
cd projserver
mvn test clean package
java -jar target/dependency/jetty-runner.jar target/*.war
```

# Make a simple CRUD server

First of all, we need to create a model class. This class is a resouce and subject to deal with API.

```Task.java
@XmlRootElement // important
public class Task {
    private String description;
    private Integer priority;
    private String untilDate;

    public Task(String description, Integer priority, String untilDate) {
        this.description = description;
        this.priority = priority;
        this.untilDate = untilDate;
    }

    public Task() { // important
    }

    // getter and setter methods are followed. this is also nessesary
```

Next, create a resouce class with GET method.

```TaskResource.java
@Path("task") // is supporsed to be http://BASE_URL/task 
public class TaskResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Task get() {
        return new Task("sample", 0, "2017/08/10");
    }

}
```

Compile and run (see above)

```bash
java -jar target/dependency/jetty-runner.jar target/*.war 2>&1                                                     2017-08-14 02:04:25.580:INFO::main: Logging initialized @262ms
2017-08-14 02:04:25.589:INFO:oejr.Runner:main: Runner
2017-08-14 02:04:25.713:INFO:oejs.Server:main: jetty-9.3.3.v20150827
2017-08-14 02:04:29.446:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@e6ea0c6{/,file:///Users/iwag/Devel/src/github.com/iwag/java-jersey-restful-server-client-sample/projserver/target/projserver/,AVAILABLE}{file:///Users/iwag/Devel/src/github.com/iwag/java-jersey-restful-server-client-sample/projserver/target/projserver.war}
2017-08-14 02:04:29.485:INFO:oejs.ServerConnector:main: Started ServerConnector@7daa0fbd{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
2017-08-14 02:04:29.485:INFO:oejs.Server:main: Started @4169ms
```

Let's request it via cURL.

```
$ curl -i -H "Content-Type: application/json" 'localhost:8080/task'                                               HTTP/1.1 200 OK
Date: Mon, 14 Aug 2017 09:05:31 GMT
Content-Type: application/json
Content-Length: 62
Server: Jetty(9.3.3.v20150827)

{"description":"sample","priority":0,"untilDate":"2017/08/10"}%
```

Well done. Now we've done with GET(READ) among CRUD.
To implement CUD is following.

```TaskResource.java
    @DELETE
    public Response delete() {
        // write deleting code
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(Task t) {
        System.out.println(t);
        // write deleting code
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Task t) {
        System.out.println(t);
        // write creating code
        return Response.status(Response.Status.ACCEPTED).build();
    }

```

To accept a request's body as JSON we use Consumes. When response no body, you might want to use ResponseBuilder.

Let's run.

```
$ curl -XPOST -i -H "Content-Type: application/json" 'localhost:8080/task' -d'{"description":"", "priority":1, "untilDate":""}'
HTTP/1.1 202 Accepted
Date: Mon, 14 Aug 2017 10:42:34 GMT
Content-Length: 0
Server: Jetty(9.3.3.v20150827)

$ curl -XPUT -i -H "Content-Type: application/json" 'localhost:8080/task' -d'{"description":"", "priority":1, "until_date":""}'
HTTP/1.1 202 Accepted
Date: Mon, 14 Aug 2017 10:43:45 GMT
Content-Length: 0
Server: Jetty(9.3.3.v20150827)

$ curl -XDELETE -i -H "Content-Type: application/json" 'localhost:8080/task'                                     
HTTP/1.1 202 Accepted
Date: Mon, 14 Aug 2017 10:43:55 GMT
Content-Length: 0
Server: Jetty(9.3.3.v20150827)
```

## JAXB tip

Sometimes field names in Java is not appropriate for JSON convention such as mixup between snake_case and camelCase.
Use XmlElement annotation to change field name.

```Task.java
    @XmlElement(name = "until_date")
    private String untilDate;
```
