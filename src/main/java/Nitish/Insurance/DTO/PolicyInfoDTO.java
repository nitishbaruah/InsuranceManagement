package Nitish.Insurance.DTO;

import Nitish.Insurance.Model.ClaimStatus;
import Nitish.Insurance.Model.PolicyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyInfoDTO {
    private int policyId;
    private PolicyType type;
    private double amount;
    private double premium;
    private LocalDate startDate;
    private LocalDate endDate;
    private ClaimStatus claimStatus;
    private String clientName;

}
