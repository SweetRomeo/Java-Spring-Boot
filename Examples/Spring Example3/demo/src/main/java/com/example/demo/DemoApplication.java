package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        StudentRepo repo = context.getBean(StudentRepo.class);

        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
        Student s3 = context.getBean(Student.class);

        s1.setRollNo(101);
        s1.setName("John");
        s1.setMarks(75);

        s2.setRollNo(102);
        s2.setName("Jane");
        s2.setMarks(75);

        s3.setRollNo(103);
        s3.setName("Jack");
        s3.setMarks(60);

        repo.save(s1);
        repo.save(s2);
        repo.save(s3);

//        Optional<Student> s = repo.findById(s1.getRollNo());
//
//        System.out.println(s);

        System.out.println(repo.findByName("John"));
        System.out.println(repo.findByMarks(60));
        System.out.println(repo.findByMarksGreaterThan(70));
    }
}
