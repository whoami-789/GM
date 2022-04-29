package com.example.gm.controllers;

import com.example.gm.servises.ZapisServise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ZapisController {
    private final ZapisServise zapisServise;

    @GetMapping("/")
    public String zapis(@RequestParam(name = "title", required = false) String title, @RequestParam(name = "catname", required = false) String catname,Principal principal, Model model) {
        model.addAttribute("zapis", zapisServise.zapisList(title));
        model.addAttribute("catname", zapisServise.categoryList(catname));
        model.addAttribute("users", zapisServise.getUsersByPrincipal(principal));
        return "zapis";
    }
}
