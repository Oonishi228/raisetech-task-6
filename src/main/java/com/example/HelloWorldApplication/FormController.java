package com.example.HelloWorldApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class FormController {

    @GetMapping("/form")
    public String init(Model model) {
        model.addAttribute("moji", "hello world!");
        //指定された名前に指定された属性を追加する。

        String now = LocalDateTime.now().format( DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒 E曜日")); // ②
        model.addAttribute( "datetime", now );

        return "form";
    }

    @PostMapping("/greeting")
    public String result(@RequestParam String countryName, Model model) {
        String countryGreeting = "こんにちは！";
        switch (countryName) {
            case "japan":
                countryGreeting = "こんにちは！";
                break;
            case "us":
                countryGreeting = "Hello！";
                break;
            case "korean":
                countryGreeting = "안녕하세요！";
                break;
        }
        model.addAttribute("countryGreeting", countryGreeting);
        return "greeting";
    }

}
