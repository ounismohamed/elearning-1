package com.example.elearning;

import com.example.elearning.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ElearningApplication implements CommandLineRunner {

    @Autowired
    private ProfileRepository profileRepository;

    public static void main(String[] args) {
        SpringApplication.run(ElearningApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*Profile prf1=profileRepository.save(new Formateur("oumayma01","oumayma01","Oumayma Amri","oumayma@gmail.com",3,"JAVA"));
        Profile prf2=profileRepository.save(new Formateur("sahar01","sahar01","Sahar Ben Hamouda","sahar@gmail.com",5,"ANGULAR"));
        Profile prf3=profileRepository.save(new Formateur("rayen01","rayen01","Rayen Ben Said","rayen@gmail.com",2,".NET"));
        Profile apr1=profileRepository.save(new Apprenant("rahma01","rahma01","Rahma AA","rahma@gmail.com"));
        Profile apr2=profileRepository.save(new Apprenant("mohamed01","mohamed01","Mohamed CC","mohamed@gmail.com"));
*/
    }
}

