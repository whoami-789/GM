package com.example.gm.controllers;

import com.example.gm.models.Zapis;
import com.example.gm.servises.ZapisServise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ZapisController {
    private final ZapisServise zapisServise;

    @GetMapping("/")
    public String zapis(@RequestParam(name = "id", required = false) String id, @RequestParam(name = "catname", required = false) String catname,
                        Principal principal, Model model) {
        model.addAttribute("zapis", zapisServise.zapisList(id));
        model.addAttribute("catname", zapisServise.categoryList(catname));
        model.addAttribute("users", zapisServise.getUsersByPrincipal(principal));
        return "zapis";
    }

    @GetMapping("/zapis/zapform/{title}")
    public String zapisform(@RequestParam(name = "id", required = false) String id, @PathVariable String title, Principal principal, Model model){
        model.addAttribute("zapis", zapisServise.zapisList(id));
        model.addAttribute("catname", zapisServise.categoryList(title));
        model.addAttribute("users", zapisServise.getUsersByPrincipal(principal));
        return "zapform";
    }

    @PostMapping("/zapis/zapform/save")
    public String saveZap(Principal principal, Zapis zapis, Controller controller){
        return "redirect:/";
    }
}
