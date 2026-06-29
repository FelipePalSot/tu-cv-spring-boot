package com.catandog.tu_cv_spring_boot.cv.controller;

import com.catandog.tu_cv_spring_boot.cv.model.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/skills")
public class SkillsController {

    private final List<Skill> skills = new ArrayList<>();

    /**
    * Model metodo 1 de almacenar datos de un objeto
    * */

//    @GetMapping
//    public String showSkills(Model model){
//       model.addAttribute("skills", skills);
//
//        return "skills";
//    }

    @GetMapping
    public String showskills(@RequestParam(defaultValue = "", required = false) String filter, Model model){
        List<Skill> skillsFilter = skills.stream()
                        .filter(skill -> skill.getName().toLowerCase().contains(filter.toLowerCase()))
                                .toList();
        model.addAttribute("skills", skillsFilter);
        model.addAttribute("filter", filter);
        return "skills";
    }

    /**
     * @ModelAttribute metodo 2 de almacenar datos de un objeto
     * */
//        @ModelAttribute(name="skills2")
//        public List<Skill> getSkills(){
//            return skills;
//        }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("skills", new Skill());

        return "add-skill";
    }

    @PostMapping("add")
    public String addSkill(@ModelAttribute Skill skill) {
        skills.add(skill);

        return "redirect:/skills";
    }
//        redirect:/skills no es el nombre de una vista,
//        sino una instrucción para que Spring le diga al
//        navegador que vaya a la URL /skills.

//        Es el patrón Post-Redirect-Get (PRG) y es algo que no hemos visto aun

    //PRueba sin stageado


    @GetMapping("/{index}")
    public String showSkillDEtail(@PathVariable int index, Model model){
        if(index>=0 && index < skills.size()){
            Skill skill = skills.get(index);
            model.addAttribute("skill", skill);
            return "skill-detail";
        }
        return "redirect:/skills";
    }

}
