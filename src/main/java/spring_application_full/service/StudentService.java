package spring_application_full.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_application_full.exceptions.StudentNotFoundException;
import spring_application_full.model.Student;
import spring_application_full.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    public String createStudent(Student student){
        int i=studentRepository.save(student);
        if(i>0){
            return "Student created successfully";
        }else{
            throw new RuntimeException("Student cannot be created");
        }
    }

    public String updateStudent(Student student){
        int i=studentRepository.update(student);
        if(i>0){
            return "Student updated successfully";
        }else{
            throw new StudentNotFoundException("Student with id "+student.getId()+" not found");
        }
    }

    public String deleteStudent(long id){
        int i=studentRepository.delete(id);
        if(i>0){
            return "Student deleted successfully";
        }else{
            throw new StudentNotFoundException("Student with id "+id+" not found");
        }
    }

    public Student getStudentById(long id){
        Student student= studentRepository.getById(id);
        if (student==null){
            throw new StudentNotFoundException("Student with id "+id+" not found");
        }
        return student;
    }
}
