package Nitish.Insurance.DTO;

import Nitish.Insurance.Model.PolicyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDTO {

    private int clientId;
    private PolicyType type;
    private double amount;
    private double premium;
    private LocalDate startDate;
    private LocalDate endDate;
}
