package com.university.forum.usermanagement.MemberManagement.Models;

import com.university.forum.usermanagement.MemberManagement.Models.Abstract_Classes.Personnel;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Association extends Personnel {
    private String associationName;
}
