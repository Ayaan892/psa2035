package com.crm.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;

    @NotBlank
    @Size(min=3, message="At least three characters")
    private String name;

    @Email
    private String emailId;
    @Size(min=10, max=10, message="should be ten digits")
    private String mobile;

}
