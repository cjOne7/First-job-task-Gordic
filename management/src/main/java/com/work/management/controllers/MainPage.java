package com.work.management.controllers;

import com.work.management.models.Person;
import com.work.management.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Controller
public class MainPage {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("personsInfo", personRepository.findAll());
        return "main/home";
    }

    @PostMapping("/")
    public String addNewRecord(@RequestParam String name, @RequestParam String email,
                               @RequestParam Date dateOfBirth, @RequestParam String sex,
                               @RequestParam String education, @RequestParam(required = false, defaultValue = "") String about,
                               Model model) {
        if (about.trim().length() > 500 || name.trim().length() > 60 || sex.trim().length() > 10
                || education.trim().length() > 255 || email.trim().length() > 255) {
            return "redirect:/";
        }

        Person person = new Person(name, email, dateOfBirth, sex, education, about);
        personRepository.save(person);
        model.addAttribute("personsInfo", personRepository.findAll());
        return "redirect:/";
    }
}
