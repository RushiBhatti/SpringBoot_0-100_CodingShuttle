package com.learningspring.rushi.week2homework.Week2Homework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learningspring.rushi.week2homework.Week2Homework.annotations.PasswordValidation;
import com.learningspring.rushi.week2homework.Week2Homework.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Title of Department must not be blank")
    @NotNull(message = "Required field in department: title")
    @Size(min = 3, max = 50, message = "Title of department can be in range [3,50]")
    private String title;

    @NotNull(message = "Required field in department: numberOfStudents")
    @Min(value = 2, message = "Department must have at least 2 students")
    @PrimeNumberValidation
    private Integer numberOfStudents;

    @NotNull(message = "Required field in department: isActive")
    @JsonProperty("isActive")
    private Boolean isActive;

    @NotNull(message = "Required field in department: createdAt")
    @PastOrPresent(message = "Creation date of department can be in Past or Present only")
    private LocalDate createdAt;

    @NotNull(message = "Required field in department: password")
    @NotBlank(message = "Password of Department must not be blank")
    @PasswordValidation
    private String password;
}
