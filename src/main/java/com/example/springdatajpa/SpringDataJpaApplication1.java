package com.example.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication1.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
//        return args->{
//            Student student1=new Student(null,"Nigar","Mirzayeva",2004,"259");
//            studentRepository.save(student1);
//        };
//    }

}
