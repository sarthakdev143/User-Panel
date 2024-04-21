package com.example.userpanel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    public String updateProfile(@ModelAttribute("userInfo") PanelBean panelBean,
            @RequestParam("imageFile") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                panelBean.setData(file.getBytes());
                panelBean.setImageType(file.getContentType());
            } catch (Exception e) {
                // Handle the exception as needed
                System.out.println("\n\nException : " + e);
            }
        }
        panelService.save(panelBean);
        return "profile";
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        PanelBean panelBean = panelService.findById(id);
        if (panelBean == null || panelBean.getData() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, panelBean.getImageType())
                .body(panelBean.getData());
    }

    @GetMapping("/delete-account/{id}")
    public String deleteAccount(@PathVariable Long id) {
        panelService.deleteById(id);
        return "redirect:/";
    }
}
