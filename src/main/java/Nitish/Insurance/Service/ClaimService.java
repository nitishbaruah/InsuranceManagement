package Nitish.Insurance.Service;

import Nitish.Insurance.Converter.Converter;
import Nitish.Insurance.DTO.ClaimDTO;
import Nitish.Insurance.DTO.ClaimInfoDTO;
import Nitish.Insurance.Model.Claim;
import Nitish.Insurance.Model.ClaimStatus;
import Nitish.Insurance.Model.InsurancePolicy;
import Nitish.Insurance.Repository.ClaimRepository;
import Nitish.Insurance.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimService {
    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    public String addClaim(ClaimDTO claimDTO) throws Exception{
        InsurancePolicy policy=insurancePolicyRepository.findById(claimDTO.getPolicyId()).get();
        Claim claim=policy.getClaim();
        claim.setDescription(claimDTO.getDescription());
        claim.setClaimStatus(claimDTO.getClaimStatus());
        claim.setDate(claimDTO.getDate());
        insurancePolicyRepository.save(policy);
        return "Successfully Added";
    }

    public String update(ClaimDTO claimDTO) throws Exception{
        InsurancePolicy policy=insurancePolicyRepository.findById(claimDTO.getPolicyId()).get();
        Claim claim=policy.getClaim();

        if(!claimDTO.getDescription().equals(claim.getDescription()))
            claim.setDescription(claimDTO.getDescription());

        if(!claimDTO.getClaimStatus().equals(claim.getClaimStatus()))
            claim.setClaimStatus(claimDTO.getClaimStatus());

        if (!claimDTO.getDate().equals(claim.getDate()))
            claim.setDate(claimDTO.getDate());

        insurancePolicyRepository.save(policy);
        return "Successfully updated";
    }

    public List<ClaimInfoDTO> getClaims() {
        List<Claim> list=claimRepository.findAll();
        List<ClaimInfoDTO> claimList=new ArrayList<>();
        for(Claim claim:list){
            claimList.add(Converter.claimInfo(claim));
        }
        return claimList;
    }
    public ClaimInfoDTO getClaim(int id) {
        ClaimInfoDTO claim=Converter.claimInfo(claimRepository.findById(id).get());
        return claim;
    }

    public String deleteClaim(int id) throws Exception{
        Claim claim=claimRepository.findById(id).get();
        claim.setDescription(null);
        claim.setClaimStatus(ClaimStatus.NotClaimed);
        claim.setDate(null);
        claimRepository.save(claim);
        return "Successfully deleted";
    }
}
