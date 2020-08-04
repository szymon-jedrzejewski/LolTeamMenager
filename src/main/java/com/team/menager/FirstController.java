package com.team.menager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/first_view")
    public String hello() {
        return "index";
    }
}
