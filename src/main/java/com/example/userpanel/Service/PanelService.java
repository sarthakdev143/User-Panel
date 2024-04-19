package com.example.userpanel.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.userpanel.Entity.PanelBean;
import com.example.userpanel.Repo.PanelRepo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PanelService {
    @Autowired
    private PanelRepo repo;

    public void save(PanelBean panelBean) {
        repo.save(panelBean);
    }

    public boolean authenticate(String username, String password) {
        PanelBean userInfo = repo.findByUsername(username);
        if (userInfo != null && userInfo.getPassword().equals(password)) {
            return true; // Authentication successful
        }
        return false; // Authentication failed
    }

    // Admin Panel
    public List<PanelBean> getAllUsers() {
        return repo.findAll();
    }
}
