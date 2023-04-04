package Nitish.Insurance.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;
    private LocalDate dateOfBirth;
    private String Address;
    private String contact;

    @OneToMany(mappedBy = "client",cascade =CascadeType.ALL)
    private List<InsurancePolicy> policyList;

}
