package com.codingShuttle.raushan.Introweek1.week1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dbService {

//    @Autowired
    final private DB db;

    // Constructer Injection
    public dbService(DB db){
        this.db=db;
    }

    String printDB(){
        return db.getData();
    }

    @PostConstruct
    void printPostData(){
        System.out.println("It is running post-construct");
    }

    @PreDestroy
    void printPreData(){
        System.out.println("It is running before destroy.");
    }
}
