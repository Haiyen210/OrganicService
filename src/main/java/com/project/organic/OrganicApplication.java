package com.project.organic;

import com.project.organic.service.FileStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class OrganicApplication implements CommandLineRunner {
	@Resource
	FileStorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(OrganicApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.init();
	}
}
