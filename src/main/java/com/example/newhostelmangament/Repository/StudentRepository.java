package com.example.newhostelmangament.Repository;

import com.example.newhostelmangament.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}