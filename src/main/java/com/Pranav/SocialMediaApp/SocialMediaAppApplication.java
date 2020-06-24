package com.Pranav.SocialMediaApp;

import com.Pranav.SocialMediaApp.Domain.Friend;
import com.Pranav.SocialMediaApp.Domain.User;
import com.Pranav.SocialMediaApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SocialMediaAppApplication {




	public static void main(String[] args) {

	SpringApplication.run(SocialMediaAppApplication.class, args);
	}

}
