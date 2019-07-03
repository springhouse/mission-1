package com.forestvue.controller;

import com.forestvue.domain.UserDrawInfo;
import com.forestvue.service.WellService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j
public class WellController {

    @Autowired
    WellService wellService;

    @RequestMapping(value="/")
    public String index(Model model){
        model.addAttribute("test", "1234");
        return "index";
    }
    @GetMapping(value="/list", produces = "application/json")
    @ResponseBody
    public Object list(){
        Map<String, Object> m = new HashMap<>();
        m.put("users", wellService.getUsers());
        return m;
    }

    @PostMapping(value="/draw", produces = "application/json")
    @ResponseBody
    public Object draw(@RequestBody UserDrawInfo info){
        wellService.draw(info);
        Map<String, String> m = new HashMap<>();
        m.put("message", "success");
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

