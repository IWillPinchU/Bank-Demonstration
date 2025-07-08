package com.iwillpinchu.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Accounts Information"
)
public class AccountsDto {
    @Schema(
            description = "Account Number of Bank account", example = "3454433243"
    )
    @NotBlank(message = "Account number can not be blank")
    @Pattern(regexp = "(^&|[0-9]{10})")
    private Long accountNumber;

    @Schema(
            description = "Account type of Bank account", example = "Savings"
    )
    @NotBlank(message = "Account Type can not be Blank")
    private String accountType;

    @Schema(
            description = "Bank branch address", example = "123 New Delhi"
    )
    @NotBlank(message = "Branch Address can not be Blank")
    private String branchAddress;
}
