SPRING BOOT BASICS (1 Hour)
 What is @RestController?

It tells Spring that this class will handle HTTP requests.

Combines:

@Controller → handles web requests

@ResponseBody → returns data (JSON) directly

Used to define REST APIs.

Example:

@RestController
public class HelloController {

    @GetMapping("/hello") url pattern for get http request
    public String hello() {
        return "Hello World!";
    }
}

----------------------------------------------------------------------------
What is @Service?

Marks a service class that contains business logic.

Example: calculations, validation, processing.

@Service
public class GreetingService {
    public String getMessage() {
        return "Hello from Service!";
    }
}
-------------------------------------------------------------------
What is @Repository?

Indicates a database access class (DAO layer).
Used with:
JPA repositories
Database operations
Spring also gives automatic exception translation.

Example:

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

---------------------------------------------------------------------------

Create First Endpoint: /hello

Controller:

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Spring Boot!";
    }
}


Run → Open browser →
👉 http://localhost:8080/hello
You’ll see:

Hello Spring Boot!
