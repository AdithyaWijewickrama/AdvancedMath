package com.amath.advacedmath.gui.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class IndexController {
    @GetMapping("/differential")
    public String differestiate(@RequestParam(required = true) String expression){
        return "";
    }
}
