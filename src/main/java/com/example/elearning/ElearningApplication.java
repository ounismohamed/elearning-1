package com.example.elearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ElearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElearningApplication.class, args);
    }

//    @RequestMapping(path="/index")
//
//    public  String testreturn(){
//
//        return "index";
//    }

}

