package org.datamapping.springdatajpamapping;

import org.datamapping.springdatajpamapping.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaMappingApplication implements CommandLineRunner {

    @Autowired
    private DataService initializeDataInDB;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaMappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initializeDataInDB.initializeData();
    }
}