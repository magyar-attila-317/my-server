package hu.progmasters.myserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class MyServerApplication {

    private static final Logger logger = LoggerFactory.getLogger(MyServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MyServerApplication.class, args);
    }

    @Value("${server.port}")
    private String portNumber;

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        logger.info("Server has been called on port" + portNumber + "...");
        return new ResponseEntity<>("<h1>hello, from port " + portNumber + "!</h1>", HttpStatus.OK);
    }

}
