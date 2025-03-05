package com.university.forum.usermanagement.MemberManagement.Controllers;


import com.university.forum.usermanagement.MemberManagement.Services.MessageProducer;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private final MessageProducer messageProducer;
    public HelloController(final MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }


    @Operation(summary = "Say Hello", description = "Returns a hello message.")
    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "Helmi") String name) {
        return "Hello, " + name + "!";
    }
    @Operation(summary = "say hi", description = "ll")
    @GetMapping("/hi")
    public String hi(@RequestParam (defaultValue = "monji") String name) {
        return "Hi " + name + "!";
    }

    @Operation(summary = "test the rabbitmq")
    @GetMapping("/test/{message}")
    public String testRabbitmq(@PathVariable String message) {
        messageProducer.sendMessage(message);
        return "message sent : "+message;
    }

    @Operation(summary = "test the rabbitmq2")
    @GetMapping("/test2/{message}")
    public String testRabbitmq2(@PathVariable String message) {
        messageProducer.sendMessage(message);
        return "message sent : "+message;
    }
}
