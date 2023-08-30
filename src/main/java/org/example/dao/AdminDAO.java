package org.example.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admin")
public class AdminDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    private String userName;
    private String password;
    private String email;
}
