package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "<body>" +
                "<h1>Here we GO!!!</h1>" +
                "<p>This is the start of something <b>BIG</b>!</p>" +
                "</body>";
    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Farewell, Spring!";
    }

    //  Handles request of the form '/hellothere?name=LaunchCode&age=46'
    @GetMapping("hellothere")
    public String helloWithQueryParam(@RequestParam String name, int age) {
        return "Hello there, " + name + ". You are " + age + " years old.";
    }

    //    Handles request of the form '/helloyou/LaunchCode'
    @GetMapping("/hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello! I love that your name is " + name + "! So pretty.";
    }

    //  Redirects a GET request to ROOT page to a specified web page
    @GetMapping
    public String redirectTime() {
        return "redirect:/hello";
    }

    @GetMapping("form")
    public String helloForm() {
    //  Going to '/form' creates this web form which submits a name to '/helloform'
        return "<html><body>" +
                "<form action='helloform'>" +
                "<input type='text' name='name'/>" +
                "<input type='submit' value='Greet me!'/>" +
                "</form></body></html>";
    }
    @RequestMapping(value = "helloform", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloFormHandler(@RequestParam String name) {
    //  Handles input form data from '/form' and returns greeting
        return "Hi, nice to meet you " + name + ". I come in peace!";
    }
    @GetMapping("formPost")
    public String helloForm2() {
        //  Version of above that handles POST requests
        return "<html><body>" +
                "<form action='helloform' method='post'>" +
                "<input type='text' name='name'/>" +
                "<input type='submit' value='Greet me!'/>" +
                "</form></body></html>";
    }


}
