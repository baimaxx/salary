package com.zb.web;

import com.zb.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("salary")
public class MainController {

    @Autowired
    private MainService service;

    @GetMapping
    public String getSalary(
            @CookieValue(name = "userid", required = false) String userId,
            @CookieValue(name = "username", required = false) String userName,
            String code, String period, Model model) {

        if (StringUtils.isEmpty(userId) && StringUtils.isEmpty(code)) {
            return "error-oauth-code";
        }
        model.addAllAttributes(service.getSalary(userId, userName, code, period));
        return "salary";
    }
}
