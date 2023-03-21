package com.project.issuetracker;
import com.project.issuetracker.UsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class IssuetrackerApplication {

	public static Object main;

	public static void main(String[] args) {
		SpringApplication.run(IssuetrackerApplication.class, args);
		System.out.println("Running.....");
	}

}
