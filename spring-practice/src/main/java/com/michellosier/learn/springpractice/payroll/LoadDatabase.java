package com.michellosier.learn.springpractice.payroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initEmployeeDatabase(EmployeeRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));

        };
    }

    @Bean
    CommandLineRunner initOrderDatabase(OrderRepository repository){
        repository.save(new Order("MacBook Pro", Status.COMPLETED));
        repository.save(new Order("iPhone", Status.IN_PROGRESS));

        return args -> {
            repository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }


}
