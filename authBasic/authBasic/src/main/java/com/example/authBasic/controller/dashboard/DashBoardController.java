package com.example.authBasic.controller.dashboard;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.authBasic.security.SecurityUtils;

@RestController
public class DashBoardController {
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView showMainMenu(ModelMap model) {
        ModelAndView mav = new ModelAndView("dashboard");
        model.put("name", SecurityUtils.getConnectedUserName());
        model.put("password", SecurityUtils.getConnectedUserPassword());
        return mav;
    }
    
}
