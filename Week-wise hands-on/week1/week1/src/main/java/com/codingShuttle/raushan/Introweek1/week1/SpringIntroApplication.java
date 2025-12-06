package com.codingShuttle.raushan.Introweek1.week1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIntroApplication implements CommandLineRunner {

	@Autowired
	Apple obj;

	@Autowired
	dbService ds;
	public static void main(String[] args) {
		SpringApplication.run(SpringIntroApplication.class, args);
	}


	public void run(String... args){
//		obj.activity();
		System.out.println("Run method");
		System.out.println(ds.printDB());
	}


}
