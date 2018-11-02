package com.xsy.SpringBoot.Controller;


import com.xsy.SpringBoot.DAO.PersonDao;
import com.xsy.SpringBoot.Entity.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        PersonDao single = new PersonDao("aa",11);
        List<PersonDao> people = new ArrayList<PersonDao>();
        PersonDao p1 = new PersonDao("xx",11);
        PersonDao p2 = new PersonDao("yy",22);
        PersonDao p3 = new PersonDao("zz",33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        Msg msg = new Msg("Title","Content","extraInfo AdminOnly");
        model.addAttribute("msg",msg);
        return "index";
    }
}
