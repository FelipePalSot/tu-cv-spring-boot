package com.catandog.tu_cv_spring_boot.cv.controller;


import com.catandog.tu_cv_spring_boot.cv.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//SB , permite mapear rutas web directamente, gracias ala notacion
@RequestMapping("/cv")
@RequiredArgsConstructor
public class CvController {

    private final Person person;

    @GetMapping({ "", "/","/index","*"})
    public String index(Model model){ // model , es para almacenar datos
//        Person person = new Person("Gl", "Chaldu","Dev");
//        model.addAttribute("name","Gl");
//        model.addAttribute("persons",person);
        model.addAttribute("property",person.getFirstName());
        return "index";
    }



}
