package com.example.elearning;

import com.example.elearning.dao.ProfileRepository;
import com.example.elearning.entities.Formateur;
import com.example.elearning.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ElearningApplication implements CommandLineRunner {

    @Autowired
    private ProfileRepository profileRepository;

    public static void main(String[] args) {
        SpringApplication.run(ElearningApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Profile prf1=profileRepository.save(new Formateur("oumayma01","oumayma01","Oumayma Amri","oumayma@gmail.com",3,"JAVA"));
    }
}

