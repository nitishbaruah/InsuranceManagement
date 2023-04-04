package Nitish.Insurance.DTO;

import Nitish.Insurance.Model.ClaimStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimDTO {
    private int policyId;
    private String description;
    private ClaimStatus claimStatus;
    private LocalDate date;
}
