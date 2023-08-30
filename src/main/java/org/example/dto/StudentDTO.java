package org.example.dto;

import jakarta.persistence.Lob;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @Valid

    private int id;

    @NotBlank(message = "1")
    private String firstName;

    @NotBlank(message = "2")
    private String lastName;

    @NotBlank(message = "3")
    private String gender;

    @Min(value = 12,message = "4")
    @Max(value = 65,message = "4")
    private int age;

    @Pattern(regexp = "([0-9]{12})|([0-9]{9}[v])",message = "5")
    private String nic;

    @NotBlank(message = "6")
    private String address;

    @NotBlank(message = "7")
    private String batch;

    @Lob
    private Blob image;

}
