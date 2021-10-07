package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(value="hello", method={RequestMethod.GET, RequestMethod.POST})
public class HelloController {

    @GetMapping
    public String hello(){
        return "<body>" +
                "<h1>Here we GO!!!</h1>" +
                "<p>This is the start of something <b>BIG</b>!</p>" +
                "</body>";
    }
    //  Lives at '/hello/goodbye'
    @GetMapping("goodbye")
    public String goodbye(){
        return "Farewell, Spring!";
    }

    //  Handles request of the form '/hello/hellothere?name=LaunchCode&age=46'
    @GetMapping("hellothere")
    public String helloWithQueryParam(@RequestParam String name, int age) {
        return "Hello there, " + name + ". You are " + age + " years old.";
    }

    //    Handles request of the form '/hello/helloname/LaunchCode'
    @GetMapping("/helloname/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello! I love that your name is " + name + "! So pretty.";
    }

    //  Creates web form [name, language] which submits a name to '/hello/helloformhandler'
    @GetMapping("formget")
    public String helloForm() {
        return "<html><body>" +
                "<form action='helloformhandler'>" +
                "<input type='text' name='name' placeholder='Name'/>" +
                "<select name='language'>" +
                    "<option value='choose'>Choose a language</option>" +
                    "<option value='English'>English</option>" +
                    "<option value='Latin'>Latin</option>" +
                    "<option value='French'>French</option>" +
                    "<option value='German'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'/>" +
                "</form></body></html>";
    }

    //  Handles input form data from '/form' and returns greeting
    @RequestMapping(value="helloformhandler")
    public String helloFormHandler(@RequestParam String name, @RequestParam String language) {
        if (language.equals("English")) {
            return "Hi, " + name + ", nice to meet you.";
        } else if (language.equals("Latin")) {
            return "Salve, " + name + ", volup est te convenisse.";
        } else if (language.equals("French")) {
            return "Bonjour, " + name + ".";
        } else if (language.equals("German")) {
            return "Guten tag, " + name + ", wie geht's?";
        } else {
            return "Please select a language.";
        }
    }

    //  Version of above that handles POST requests
    @PostMapping("formpost")
    public String helloForm2() {
        return "<html><body>" +
                "<form action='helloformhandler' method='post'>" +
                "<input type='text' name='name' placeholder='Name'/>" +
                "<select name='language'>" +
                    "<option value='choose'>Choose a language</option>" +
                    "<option value='English'>English</option>" +
                    "<option value='Latin'>Latin</option>" +
                    "<option value='French'>French</option>" +
                    "<option value='German'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'/>" +
                "</form></body></html>";
    }


}
