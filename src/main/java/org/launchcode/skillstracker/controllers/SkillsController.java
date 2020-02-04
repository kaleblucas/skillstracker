package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class SkillsController {

    @GetMapping
    @ResponseBody
    public String skills(){
        String header = "Skills Tracker";
        String subheader = "We have a few skills we would like to learn. Here is the list!";
        String firstOption = "Java";
        String secondOption = "Javascript";
        String thirdOption = "Python";
        String html =
                "<html>" +
                "<body>" +
                "<h1>" + header + "</h1>" +
                "<h2>" + subheader + "</h2>" +
                "<ol>" +
                "<li>" + firstOption + "</li>" +
                "<li>" + secondOption + "</li>" +
                "<li>" + thirdOption + "</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
        return html;
    }

    @GetMapping("form")
    @ResponseBody
    public String skillsForm(){

        String nameForm =
                "Name: <input type=\"text\" name=\"name\"><br>";
        String formChoice =
                "<option value='Java'>Java</option>\n" +
                "<option value='JavaScript'>Javascript</option>\n" +
                "<option value='Python'>Python</option>\n";
        String firstChoiceForm =
                "My favorite language: <select name=\"firstChoice\" id=\"firstChoice\">\n" +
                formChoice +
                "</select>";
        String secondChoiceForm =
                "My second favorite language: <select name=\"secondChoice\" id=\"secondChoice\">\n" +
                formChoice +
                "</select>";
        String thirdChoiceForm =
                "My third favorite language: <select name=\"thirdChoice\" id=\"thirdChoice\">\n" +
                formChoice +
                "</select>";

        String submit = "<input type=\"submit\" value=\"Submit\">";

        String html =
                        "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/favoritelanguagelist'>"+
                        nameForm + "<br>" + firstChoiceForm + "<br>" + secondChoiceForm + "<br>" + thirdChoiceForm  + "<br>" + submit +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    @RequestMapping(value = "favoritelanguagelist", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String skillsFormResponse(@RequestParam String name, @RequestParam String firstChoice, @RequestParam String secondChoice, @RequestParam String thirdChoice){

        String html =
                "<html>" +
                        "<body>" +
                        "<h1>" + name + "</h1>" +
                        "<ol>" +
                        "<li>" + firstChoice + "</li>" +
                        "<li>" + secondChoice + "</li>" +
                        "<li>" + thirdChoice + "</li>" +
                        "</ol>" +
                        "</body>" +
                        "</html>";
        return html;
    }
}
