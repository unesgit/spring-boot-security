package com.example.authBasic.controller.dashboard;

import java.util.stream.Collectors;

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
        ModelAndView mav;
        if (SecurityUtils.getConnectedUserRoles().stream().map(g -> g.getAuthority()).collect(Collectors.toList()).contains("ROLE_ADMIN")) {
            mav = new ModelAndView("dashboard_admin");
        } else {
            mav = new ModelAndView("dashboard_user");
        }
        model.put("name", SecurityUtils.getConnectedUserName());
        return mav;
    }
    
}
