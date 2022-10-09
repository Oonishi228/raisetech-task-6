package com.example.HelloWorldApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String write(Model model) {
        model.addAttribute("moji", "hello world!");
        //指定された名前に指定された属性を追加する。

        LocalDateTime nowDate = LocalDateTime.now();
        //現在日時をLocalDateTimeクラスで取得
        DateTimeFormatter dtf2 =
                DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒 E曜日");
        String formatNowDate = dtf2.format(nowDate);
        //日時の表示形式を指定
        model.addAttribute("timeDate", formatNowDate);

        return "helloindex";
    }
}
