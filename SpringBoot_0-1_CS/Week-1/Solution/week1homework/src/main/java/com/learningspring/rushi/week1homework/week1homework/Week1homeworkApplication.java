package com.learningspring.rushi.week1homework.week1homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week1homeworkApplication implements CommandLineRunner {

	@Autowired
	CakeBaker cakeBaker;

	public static void main(String[] args) {

		/*
		HOMEWORK QUESTION: Alice and her Bakery
		
		- Create a class called CakeBaker, that is dependent on two other
		classes called Frosting and Syrup. This class has a function
		called bakeCake().
		- Create two interfaces of type Frosting and Syrup with a
		function called getFrostingType and getSyrupType respectively.
		- Create two implementations of these two interfaces (so total 4
		classes) for Chocolate and Strawberry flavors.
		- Use Dependency injection to inject the Frosting and Syrup
		dependencies into CakeBaker and also to call the bakeCake
		function of the CakeBaker class
		*/

		SpringApplication.run(Week1homeworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(cakeBaker.bakeCake());
	}
}
