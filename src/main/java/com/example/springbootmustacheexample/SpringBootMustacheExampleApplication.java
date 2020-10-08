package com.example.springbootmustacheexample;

import com.example.springbootmustacheexample.model.User;
import com.example.springbootmustacheexample.model.ValueSet;
import com.example.springbootmustacheexample.model.enumerator.Gender;
import com.example.springbootmustacheexample.repository.UserRepository;
import com.example.springbootmustacheexample.repository.ValueSetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootMustacheExampleApplication {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMustacheExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadGender(ValueSetRepository repository) {
        return (args) -> {
            // save genders
            repository.save(new ValueSet("male", "Male", "Male.", "https://www.hl7.org/fhir/codesystem-administrative-gender.html"));
            repository.save(new ValueSet("female", "Female", "Female.", "https://www.hl7.org/fhir/codesystem-administrative-gender.html"));

            // fetch all genders
            logger.info("Genders found with findAll():");
            logger.info("-------------------------------");
            for (ValueSet valueSet : repository.findAll()) {
                logger.info(valueSet.toString());
            }
            logger.info("");
        };
    }

    @Bean
    public CommandLineRunner loadData(UserRepository repository, ValueSetRepository gender) {
        return (args) -> {
            // save a couple of users
            repository.save(new User("Charlie Croker", "charlie@cappucino.com", gender.findById(1L).get(),"98765432", "Los Angeles, California"));
            repository.save(new User("Andre Croker", "andre@cappucino.com", gender.findById(1L).get(),null, "Los Angeles, California"));

            // fetch all users
            logger.info("Customers found with findAll():");
            logger.info("-------------------------------");
            for (User user : repository.findAll()) {
                logger.info(user.toString());
            }
            logger.info("");

            // fetch an individual user by ID
            User user = repository.findById(1L).get();
            logger.info("Customer found with findOne(1L):");
            logger.info("--------------------------------");
            logger.info(user.toString());
            logger.info("");

            logger.info("");
        };
    }
}
