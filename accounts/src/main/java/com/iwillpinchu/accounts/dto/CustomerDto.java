package com.iwillpinchu.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer Information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer", example = "Shiva Tiwari"
    )
    @NotBlank(message = "Name Cannot be null or empty")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;

    @Schema(
            description = "Email address of the customer", example = "tutor@gmail.com"
    )
    @NotBlank(message = "Email Cannot be null or empty")
    @Email
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountsDto accountsDto;
}
