package Nitish.Insurance.DTO;

import Nitish.Insurance.Model.ClaimStatus;
import Nitish.Insurance.Model.PolicyType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimInfoDTO {
    private int policyId;
    private PolicyType policyType;
    private int claimId;
    private String Description;
    private LocalDate date;
    private ClaimStatus claimStatus;
}
