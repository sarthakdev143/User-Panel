package com.example.userpanel.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userpanel.Entity.PanelBean;

public interface PanelRepo extends JpaRepository<PanelBean, Long> {

    PanelBean findByUsername(String Username);

}
