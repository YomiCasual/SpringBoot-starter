package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    CommandLineRunner commandLineRunner(StudentRepository repository) {
        System.out.println("Saving");
         return args -> {
               Student mariam = new Student(
                       "Mariam",
                       24,
                       LocalDate.of(2000, 12, 11),
                       "yomionisade@gmail.com"
               );
             Student ayo = new Student(
                     "Ayo",
                     23,
                     LocalDate.of(2000, 12, 11),
                     "kunle@gmail.com"
             );
             repository.save(mariam);
             repository.save(ayo);
         };
    }
}
