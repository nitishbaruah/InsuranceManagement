package Nitish.Insurance.Controller;

import Nitish.Insurance.DTO.PolicyDTO;
import Nitish.Insurance.DTO.PolicyInfoDTO;
import Nitish.Insurance.Model.InsurancePolicy;
import Nitish.Insurance.Repository.InsurancePolicyRepository;
import Nitish.Insurance.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InsuranceController {
    @Autowired
    InsurancePolicyService insurancePolicyService;

    @PostMapping("/policies")
    public ResponseEntity<String> addPolicy(@RequestBody PolicyDTO policyDTO){
        try {
            String response= insurancePolicyService.addPolicy(policyDTO);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch (Exception e){
            String response="Error!!";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        //return "";
    }

    @GetMapping("/policies")
    public ResponseEntity<List<PolicyInfoDTO>> getAllPolicies(){
        return new ResponseEntity<>(insurancePolicyService.getPolicies(), HttpStatus.FOUND);
    }

    @GetMapping("/policies/{id}")
    public ResponseEntity<PolicyInfoDTO> getPolicyById(@PathVariable int id){
        return new ResponseEntity<>(insurancePolicyService.getPolicyById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/policies/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        return new ResponseEntity<>(insurancePolicyService.deletePolicy(id),HttpStatus.ACCEPTED);

    }

    @PutMapping("/policies/{id}")
    public ResponseEntity<String> updatePolicy(@PathVariable int id ,@RequestBody PolicyDTO policyDTO){
        try {
            String response= insurancePolicyService.updatePolicy(id,policyDTO);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch (Exception e){
            String response="Error!!";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

}
