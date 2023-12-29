package com.rbnbproject.rbnbcloneproject;

import com.rbnbproject.rbnbcloneproject.enums.ServiceLogementType;
import com.rbnbproject.rbnbcloneproject.model.House;
import com.rbnbproject.rbnbcloneproject.model.Image;
import com.rbnbproject.rbnbcloneproject.model.ServiceLogement;
import com.rbnbproject.rbnbcloneproject.services.HouseServiceImpl;
import com.rbnbproject.rbnbcloneproject.services.ServiceLogementServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RbnbcloneprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbnbcloneprojectApplication.class, args);
    }

}
