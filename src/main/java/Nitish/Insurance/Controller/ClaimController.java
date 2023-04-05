package Nitish.Insurance.Controller;

import Nitish.Insurance.DTO.ClaimDTO;
import Nitish.Insurance.DTO.ClaimInfoDTO;
import Nitish.Insurance.DTO.ClientDTO;
import Nitish.Insurance.DTO.ClientInfoDTO;
import Nitish.Insurance.Service.ClaimService;
import Nitish.Insurance.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @PostMapping("/claims")
    public ResponseEntity<String> addClaim(@RequestBody ClaimDTO claimDTO){
        try{
            String response= claimService.addClaim(claimDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e){
            String response="Error!!";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/claims")
    public ResponseEntity<List<ClaimInfoDTO>> getAllClients(){
       /* try{
            List<Client> clientList=clientService.getAllClient();
            return new ResponseEntity<>(clientList,HttpStatus.FOUND);
        } catch (Exception e){

        } */
        List<ClaimInfoDTO> list=claimService.getClaims();
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

    @GetMapping("/claims/{id}")
    public ResponseEntity<ClaimInfoDTO> getClientById(@PathVariable int id){
       ClaimInfoDTO claim=claimService.getClaim(id);
        return new ResponseEntity<>(claim,HttpStatus.FOUND);
    }

    @PutMapping("/claims")
    public ResponseEntity<String> updateClientInfo(@RequestBody ClaimDTO claimDTO){
        try{
            String response=claimService.update(claimDTO);
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>("Error!!",HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/claims/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable int id){

        try{
            String response=claimService.deleteClaim(id);
            return new ResponseEntity<>(response,HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>("Error!!",HttpStatus.BAD_REQUEST);
        }
    }
}
