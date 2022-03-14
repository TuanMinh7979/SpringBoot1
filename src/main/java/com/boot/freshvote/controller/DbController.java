package com.boot.freshvote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DbController {
    @GetMapping("")
    public String rootView() {
        return "index";
    }

    @GetMapping("db")
    public String db() {
        return "dashboard";
    }
}
