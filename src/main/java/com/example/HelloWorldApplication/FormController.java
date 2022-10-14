package com.example.HelloWorldApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class FormController {

    @GetMapping("/form")
    public String init(Model model) {
        model.addAttribute("moji", "Hello World!");
        //指定された名前に指定された属性を追加する。

        String now =
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒 E曜日"));
        model.addAttribute("datetime", now);

        return "form";
    }

    @PostMapping("/greeting")
    public String result(@RequestParam String countryName, Model model) {
        String countryGreeting = switch (countryName) {
            case "japan" -> "こんにちは！";

            case "us" -> "Hello！";

            case "korean" -> "안녕하세요！";

            case "china" -> "你好！";

            default -> "こんにちは！";

        };
        model.addAttribute("countryGreeting", countryGreeting);
        return "greeting";
    }

}
