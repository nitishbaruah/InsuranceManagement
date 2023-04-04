package Nitish.Insurance.Converter;

import Nitish.Insurance.DTO.*;
import Nitish.Insurance.Model.Claim;
import Nitish.Insurance.Model.ClaimStatus;
import Nitish.Insurance.Model.Client;
import Nitish.Insurance.Model.InsurancePolicy;

import java.util.ArrayList;
import java.util.List;

public class Converter {

        public static Client clientEntity(ClientDTO clientDTO){
            Client client= Client.builder().name(clientDTO.getName())
                    .dateOfBirth(clientDTO.getDob())
                    .contact(clientDTO.getContact())
                    .Address(clientDTO.getAddress()).
                    policyList(new ArrayList<>()).build();
            return client;
        }
        public static InsurancePolicy policyEntity(PolicyDTO policyDTO){
            InsurancePolicy insurancePolicy=InsurancePolicy.builder()
                    .type(policyDTO.getType())
                    .premium(policyDTO.getPremium())
                    .amount(policyDTO.getAmount())
                    .startDate(policyDTO.getStartDate())
                    .endDate(policyDTO.getEndDate()).build();
            insurancePolicy.setClaim(new Claim());
            insurancePolicy.getClaim().setClaimStatus(ClaimStatus.NotClaimed);
            return insurancePolicy;
        }
        public static ClientInfoDTO clientInfo(Client client){
            List<PolicyListClientDTO> policyList=new ArrayList<>();
            List<InsurancePolicy> list=client.getPolicyList();
            for(InsurancePolicy policy:list){
                PolicyListClientDTO policyListClientDTO= PolicyListClientDTO.builder()
                        .policyID(policy.getId())
                        .policyType(policy.getType()).build();
                policyList.add(policyListClientDTO);
            }
            ClientInfoDTO clientInfoDTO= ClientInfoDTO.builder().id(client.getId())
                    .name(client.getName())
                    .contact(client.getContact())
                    .Address(client.getAddress())
                    .dateOfBirth(client.getDateOfBirth())
                    .policyList(policyList).build();

            return clientInfoDTO;

        }
        public static PolicyInfoDTO policyInfo(InsurancePolicy policy){
            PolicyInfoDTO policyInfoDTO= PolicyInfoDTO.builder()
                    .policyId(policy.getId())
                    .type(policy.getType())
                    .amount(policy.getAmount()).premium(policy.getPremium())
                    .startDate(policy.getStartDate()).endDate(policy.getEndDate())
                    .clientName(policy.getClient().getName())
                    .claimStatus(policy.getClaim().getClaimStatus())
                    .build();
            return policyInfoDTO;
        }
        public static ClaimInfoDTO claimInfo(Claim claim){
            ClaimInfoDTO claimInfoDTO= ClaimInfoDTO.builder()
                    .claimId(claim.getClaimId())
                    .Description(claim.getDescription())
                    .claimStatus(claim.getClaimStatus())
                    .date(claim.getDate())
                    .policyId(claim.getInsurancePolicy().getId())
                    .policyType(claim.getInsurancePolicy().getType())
                    .build();
            return claimInfoDTO;
        }

}
