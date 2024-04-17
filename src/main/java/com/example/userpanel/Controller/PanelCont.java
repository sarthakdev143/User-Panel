package com.example.userpanel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.userpanel.Service.PanelService;

@Controller
public class PanelCont {
    @Autowired
    private PanelService panelService;

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
