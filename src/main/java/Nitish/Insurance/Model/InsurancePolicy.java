package Nitish.Insurance.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="policy")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    //@Column(unique = true)
    //private int policyId;
    @Enumerated(value = EnumType.STRING)
    private PolicyType type;
    private double amount;
    private double premium;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToOne(mappedBy = "insurancePolicy",cascade = CascadeType.ALL)
    private Claim claim;

    @ManyToOne
    @JoinColumn
    private Client client;

}
