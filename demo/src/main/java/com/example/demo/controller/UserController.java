package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.UserDetails;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity userDetails() {
        List userDetails = userService.getUserDetails();
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseEntity userDetails(@PathVariable int id) {
        UserDetails userDetails = userService.findDetails(id);
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }
    @PostMapping(value = "/insert",  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity insert(UserDetails userDetails, HttpServletResponse servletResponse) throws IOException {
        Long inserted = userService.insert(userDetails);
        servletResponse.sendRedirect("/list");
        return new ResponseEntity(inserted, HttpStatus.OK);
    }

}
