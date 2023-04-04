package Nitish.Insurance.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="claim")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int claimId;

    private String Description;
    private LocalDate date;

    @Enumerated(value=EnumType.STRING)
    private ClaimStatus claimStatus;

    @OneToOne
    @JoinColumn
    private InsurancePolicy insurancePolicy;
}
