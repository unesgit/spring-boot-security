package com.example.authBasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.authBasic.model.Login;

@Controller
public class LoginController {
    
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public ModelAndView projectBase() {
        return new ModelAndView("redirect:/dashboard");
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage(ModelMap model) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }
    
}