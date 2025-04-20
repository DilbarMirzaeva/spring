package spring_application_full.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_application_full.model.Student;
import spring_application_full.service.StudentService;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final StudentService studentService;

    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list";
    }
//---------------------------------------
    @GetMapping("students/create")
    public String createStudentForm(){
        return "students/create";
    }

    @PostMapping("/students")
    public String createStudent(@RequestParam("name") String name){
        Student student=new Student();
        student.setName(name);
        studentService.createStudent(student);
        return "redirect:/students";
    }
//---------------------------------------------
    @GetMapping("students/update/{id}")
    public String updateStudentForm(@PathVariable long id, Model model){
        Student student=studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "students/update";
    }

    @PutMapping("students/{id}")
    public String updateStudent(@PathVariable long id,@RequestParam  String name){
        Student student=studentService.getStudentById(id);
        student.setName(name);
        studentService.updateStudent(student);
        return "redirect:/students";
    }
//----------------------------------------------------
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
