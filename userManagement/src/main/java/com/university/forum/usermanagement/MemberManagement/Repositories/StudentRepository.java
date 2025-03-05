package com.university.forum.usermanagement.MemberManagement.Repositories;

import com.university.forum.usermanagement.MemberManagement.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
