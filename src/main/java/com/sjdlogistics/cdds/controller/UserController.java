package com.sjdlogistics.cdds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping(value = "/index")
    public String login() {
        return "index";
    }

    @RequestMapping(value = "/expImport")
    public String expImport() {
        return "expImport";
    }

    @RequestMapping(value = "/impImport")
    public String impImport() {
        return "impImport";
    }

    @RequestMapping(value = "/waybillImport")
    public String waybillImport() {
        return "waybillImport";
    }

}
