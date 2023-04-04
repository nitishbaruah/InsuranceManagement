package Nitish.Insurance.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientInfoDTO {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String Address;
    private String contact;
    private List<PolicyListClientDTO> policyList;
}
