package com.forestvue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Controller
public class main {
    @RequestMapping(value="/")
    public String index(Model model){
        model.addAttribute("test", "1234");
        return "index";
    }
    @RequestMapping(value="/admin")
    public String admin(Model model){
        return "admin";
    }

    @RequestMapping(value="/auth-failure", produces = "application/json")
    @ResponseBody
    public Object failed(){
        Map<String, String> m = new HashMap<>();
        m.put("auth", "failed");
        return m;
    }
    @GetMapping(value="/auth-success", produces = "application/json")
    @ResponseBody
    public Object success(){
        Map<String, String> m = new HashMap<>();
        m.put("auth", "success");
        return m;
    }
    @RequestMapping(value="/login-page", produces = "application/json")
    @ResponseBody
    public Object login(){
        Map<String, String> m = new HashMap<>();
        m.put("auth", "login");
        return m;
    }
    @RequestMapping(value="/json", produces = "application/json")
    @ResponseBody
    public Object json(){
        Map<String, String> m = new HashMap<>();
        m.put("test", "1234");
        return m;
    }
}

