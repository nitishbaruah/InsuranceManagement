package Nitish.Insurance.Controller;

import Nitish.Insurance.DTO.ClientDTO;
import Nitish.Insurance.DTO.ClientInfoDTO;
import Nitish.Insurance.Model.Client;
import Nitish.Insurance.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<String> addClient(@RequestBody ClientDTO clientDTO){
        try{
            String response= clientService.addClient(clientDTO);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch (Exception e){
            String response="Error!, client not added.";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientInfoDTO>> getAllClients(){
       /* try{
            List<Client> clientList=clientService.getAllClient();
            return new ResponseEntity<>(clientList,HttpStatus.FOUND);
        } catch (Exception e){

        } */
        List<ClientInfoDTO> clientList=clientService.getAllClient();
        return new ResponseEntity<>(clientList,HttpStatus.FOUND);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientInfoDTO> getClientById(@PathVariable int id){
        ClientInfoDTO client=clientService.getClientById(id);
        return new ResponseEntity<>(client,HttpStatus.FOUND);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<String> updateClientInfo(@PathVariable int id,@RequestBody ClientDTO clientDTO){
        String response=clientService.updateClientInfo(id,clientDTO);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable int id){
        String response=clientService.deleteClient(id);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
}


