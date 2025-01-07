package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        Student s= context.getBean(Student.class);
        s.setRollNo(104);
        s.setName("Navin");
        s.setMarks(78);
        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s);
        List<Student> students=service.getStudents();
        System.out.println(students);
    }

}
