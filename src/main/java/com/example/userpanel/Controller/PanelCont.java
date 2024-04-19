package com.example.userpanel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.userpanel.Entity.PanelBean;
import com.example.userpanel.Service.PanelService;

@Controller
public class PanelCont {
    @Autowired
    private PanelService panelService;

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute("userInfo") PanelBean PanelBean) {
        panelService.save(PanelBean);
        return "profile";
    }
}
