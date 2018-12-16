package com.techdisqus.services.transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TransactionApp {

    public static void main(String[] args) throws Exception {
       SpringApplication.run(TransactionApp.class, args);
    
    }

    @Bean
    RestTemplate rest() {
    	return new RestTemplate();
    }
    
}
