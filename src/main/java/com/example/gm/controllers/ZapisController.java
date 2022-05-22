package com.example.gm.controllers;

import com.example.gm.models.User;
import com.example.gm.models.Zapis;
import com.example.gm.servises.ZapisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ZapisController {
    private final ZapisService zapisServise;

    @GetMapping("/")
    public String zapis(@RequestParam(name = "id", required = false) Long id, @RequestParam(name = "catname", required = false) String catname, Model model) {
        model.addAttribute("zapis", zapisServise.zapisList(id));
        model.addAttribute("catname", zapisServise.categoryList(catname));
        return "zapis";
    }

    @GetMapping("/zapis/zapform/{title}")
    public String zapisform(@RequestParam(name = "id", required = false) Long id, @RequestParam(name = "email", required = false) String email, @PathVariable String title, Model model){
        model.addAttribute("zapis", zapisServise.zapisList(id));
        model.addAttribute("catname", zapisServise.categoryList(title));
        model.addAttribute("users", zapisServise.userslist(email));
        return "zapform";
    }

    @PostMapping("/zapis/zapform/save")
    public String saveZap(User user, Zapis zapis) throws IOException {
        zapisServise.saveZap(user, zapis);
        return "redirect:/";
    }
}
