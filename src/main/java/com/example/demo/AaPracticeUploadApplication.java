package com.example.demo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AaPracticeUploadApplication implements CommandLineRunner {

	@Resource
	public FileStorage fileStorage;
	
	public static void main(String[] args) {
		SpringApplication.run(AaPracticeUploadApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileStorage.deleteAll();
		fileStorage.init();
	}

}

