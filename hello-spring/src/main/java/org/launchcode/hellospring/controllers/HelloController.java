package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "<body>" +
                "<h1>Here we GO!!!</h1>" +
                "<p>This is the start of something <b>BIG</b>!</p>" +
                "</body>";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Farewell, Spring!";
    }

    //  Handles request of the form '/hellothere?name=Mark&age=46'
    @GetMapping("hellothere")
    public String helloWithQueryParam(@RequestParam String name, int age, Model model) {
        String greeting = "Hello, " + name + "! I see that you are " + age + " years old.";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //    Handles request of the form '/helloyou/LaunchCode'
    @GetMapping("/hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Yo, " + name + ", it's great to meet you. Let's play Rolemaster.";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //  Redirects a GET request to ROOT page to a specified web page
    @GetMapping
    @ResponseBody
    public String redirectTime() {
        return "redirect:/hello";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
    //  Going to '/form' creates this web form which submits a name to '/helloform'
        return "<html><body>" +
                "<form action='helloform'>" +
                "<input type='text' name='name'/>" +
                "<input type='submit' value='Greet me!'/>" +
                "</form></body></html>";
    }
    @RequestMapping(value = "helloform", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloFormHandler(@RequestParam String name) {
    //  Handles input form data from '/form' and returns greeting
        return "Hi, nice to meet you " + name + ". I come in peace!";
    }
    @GetMapping("formPost")
    public String helloForm2() {
        //  Version of above that handles POST requests
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("LaunchCode", "Java", "JavaScript"));
        model.addAttribute("names", names);
        return "hellolist";
    }


}
