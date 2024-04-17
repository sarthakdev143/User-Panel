package com.example.userpanel.Controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.userpanel.Repo.PanelRepo;
import com.example.userpanel.Entity.PanelBean;
import com.example.userpanel.Service.PanelService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ExtraCont {
    @Autowired
    private PanelService panelService;
    @Autowired
    private PanelRepo repo;

    @GetMapping("/")
    public String login(Model model) {
        PanelBean LoginObject = new PanelBean();
        model.addAttribute("loginObject", LoginObject);
        return "login";
    }

    @GetMapping("/nav-to-signup")
    public String signup(Model model) {
        PanelBean SignUpObject = new PanelBean();
        model.addAttribute("signupObject", SignUpObject);
        return "sign-up";
    }

    @GetMapping("/nav-to-login")
    public String login() {
        return "redirect:/";
    }

    @PostMapping("/create-account")
    public String createAccount(@ModelAttribute("signupObject}") PanelBean PanelBean) {
        panelService.save(PanelBean);
        return "redirect:/";
    }

    @PostMapping("/profile")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
            Model model) {
        // Validate user credentials
        if (panelService.authenticate(username, password)) {
            session.setAttribute("username", username);
            PanelBean panelBean = repo.findByUsername(username);
            model.addAttribute("userInfo", panelBean); // Add username to the model
            return "profile"; // Redirect to profile page after successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/"; // Return to login form with error message
        }
    }

    @GetMapping("/admin-panel")
    public String adminPanel(Model model) {
        List<PanelBean> userList = (List<PanelBean>) panelService.getAllUsers();
        model.addAttribute("userList", userList);
        return "admin-panel";
    }
}