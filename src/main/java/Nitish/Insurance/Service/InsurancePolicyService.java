package Nitish.Insurance.Service;

import Nitish.Insurance.Converter.Converter;
import Nitish.Insurance.DTO.PolicyDTO;
import Nitish.Insurance.DTO.PolicyInfoDTO;
import Nitish.Insurance.Model.Claim;
import Nitish.Insurance.Model.ClaimStatus;
import Nitish.Insurance.Model.Client;
import Nitish.Insurance.Model.InsurancePolicy;
import Nitish.Insurance.Repository.ClientRepository;
import Nitish.Insurance.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsurancePolicyService {
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    ClientRepository clientRepository;

    public String addPolicy(PolicyDTO policyDTO)throws Exception{
        Client client=clientRepository.findById(policyDTO.getClientId()).get();
        InsurancePolicy insurancePolicy= Converter.policyEntity(policyDTO);
        Claim claim=new Claim();
        claim.setClaimStatus(ClaimStatus.NotClaimed);
        insurancePolicy.setClaim(claim);
        claim.setInsurancePolicy(insurancePolicy);
        client.getPolicyList().add(insurancePolicy);
        insurancePolicy.setClient(client);
        clientRepository.save(client);
        return "Policy successfully added";
    }

    public List<PolicyInfoDTO> getPolicies(){
        List<InsurancePolicy> list=insurancePolicyRepository.findAll();
        List<PolicyInfoDTO> policyList=new ArrayList<>();
        for(InsurancePolicy policy:list){
            policyList.add(Converter.policyInfo(policy));
        }
        return policyList;
    }

    public PolicyInfoDTO getPolicyById(int id){
        PolicyInfoDTO policy =Converter.policyInfo(insurancePolicyRepository.findById(id).get());
        return policy;
    }

    public String deletePolicy(int id){
        insurancePolicyRepository.deleteById(id);
        return "Successfully deleted";
    }
    public String updatePolicy(int id,PolicyDTO policyDTO) throws Exception {
        InsurancePolicy policy=insurancePolicyRepository.findById(id).get();
        if(!policyDTO.getType().equals(policy.getType())){
            policy.setType(policyDTO.getType());
        }
        if(policyDTO.getAmount()!= policy.getAmount()){
            policy.setAmount(policyDTO.getAmount());
        }
        if(policyDTO.getStartDate()!=null){
            policy.setStartDate(policyDTO.getStartDate());
        }
        if(policyDTO.getEndDate()!=null){
            policy.setEndDate(policyDTO.getEndDate());
        }
        if(policyDTO.getPremium()!=policy.getPremium()){
            policy.setPremium(policyDTO.getPremium());
        }
        insurancePolicyRepository.save(policy);
        return "updated successfully";
    }
}
