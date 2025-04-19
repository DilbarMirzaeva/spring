package com.example.springdatajpa.service;

import com.example.springdatajpa.entity.Student;
import com.example.springdatajpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(int id, Student student) {
        return studentRepository.findById(id)
                .map(student1 -> {
                    student1.setName(student.getName());
                    student1.setSurname(student.getSurname());
                    student1.setStudentNum(student.getStudentNum());
                    student1.setDateOfBirth(student.getDateOfBirth());
                    return studentRepository.save(student1);
                })
                .orElse(null);
    }
}
