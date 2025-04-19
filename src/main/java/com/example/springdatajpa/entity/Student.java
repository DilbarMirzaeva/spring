package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @Id
    @SequenceGenerator(name="student_seq",sequenceName = "student_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    private Integer id;

    @Column(name="name",nullable = false,columnDefinition = "TEXT")
    private String name;

    @Column(name="surname",nullable = false)
    private String surname;

    @Column(name="date_birth",nullable = false)
    private Integer dateOfBirth;

    @Column(name="student_num",nullable = false,unique = true)
    private String studentNum;


}
