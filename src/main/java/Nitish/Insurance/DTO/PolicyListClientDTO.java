package Nitish.Insurance.DTO;

import Nitish.Insurance.Model.PolicyType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyListClientDTO {
    private int policyID;
    private PolicyType policyType;
}
