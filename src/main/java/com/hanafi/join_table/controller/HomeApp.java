package com.hanafi.join_table.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/")
public class HomeApp {

    
    @GetMapping
    public String index(){
        String me="";
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();

        return "Login "+principal.getName()+" = "+principal.getDetails().toString()+" / "+principal.getPrincipal().toString()+"<br>"+"<a href=/logout/>Logout</a>";
    }
    @GetMapping("/logout")
    public ModelAndView fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @GetMapping("/login")
    public ModelAndView login()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
