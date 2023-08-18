package com.example.spring.jpa.tutorial.SpringJPATutorial1.repository;

import com.example.spring.jpa.tutorial.SpringJPATutorial1.entity.Guardian;
import com.example.spring.jpa.tutorial.SpringJPATutorial1.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student= Student.builder()
                .emailId("sivatejakolasani@gmail.com")
                .firstName("siva")
                .LastName("kolasani")
                //.guardianName("venkata")
                //.guardianEmail("sivateja716@gmail.com")
                //.guardianMobile("3167719970")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian=Guardian.builder()
                .email("sivateja716@gmail.com")
                .name("venkata")
                .mobile("3167719970")
                .build();
        Student student=Student.builder()
                .firstName("bablu")
                .emailId("kolasani.pegasian@gmail.com")
                .LastName("kolasani")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printStudentByfirstName(){
        List<Student> students=
                studentRepository.findByfirstName("siva");
        System.out.println("students = " + students);
} @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("studentList= " + studentList);
    }@Test
public void printgetStudentFirstNameByEmailAddress(){
             String firstName=
studentRepository.getStudentFirstNameByEmailAddress(
"sivatejakolasani@gmail.com");
        System.out.println("firstName = " + firstName);
}
@Test
public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "sivateja","sivatejakolasani@gmail.com"

        );
}

}