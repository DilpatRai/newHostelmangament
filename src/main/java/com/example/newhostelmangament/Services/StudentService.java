package com.example.newhostelmangament.Services;


import com.example.newhostelmangament.Entity.Student;
import com.example.newhostelmangament.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    // CRUD operations
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return null;
        }

        student.setName(studentDetails.getName());
        student.setRollNumber(studentDetails.getRollNumber());
        // Update other fields as needed

        return studentRepository.save(student);
    }

    public boolean deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return false;
        }

        studentRepository.delete(student);
        return true;
    }
}