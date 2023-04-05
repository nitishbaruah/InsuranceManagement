package Nitish.Insurance.Service;

import Nitish.Insurance.Converter.Converter;
import Nitish.Insurance.DTO.ClientDTO;
import Nitish.Insurance.DTO.ClientInfoDTO;
import Nitish.Insurance.Model.Client;
import Nitish.Insurance.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public String addClient(ClientDTO clientDTO) throws Exception{
        Client client= Converter.clientEntity(clientDTO);
        clientRepository.save(client);
        return "Client name:"+client.getName()+"\n"
                +"Client ID:" +client.getId()+"\n"
                +"Successfully Added";
    }

    public List<ClientInfoDTO> getAllClient() {
        List<Client> list= clientRepository.findAll();
        List<ClientInfoDTO> clientList=new ArrayList<>();
        for (Client client:list){
            clientList.add(Converter.clientInfo(client));
        }
        return clientList;
    }

    public ClientInfoDTO getClientById(int id) {
        ClientInfoDTO client=Converter.clientInfo(clientRepository.findById(id).get());

        return client;
    }

    public String updateClientInfo(int id,ClientDTO clientDTO)throws Exception{
        Client client=clientRepository.findById(id).get();
        if(clientDTO.getName()!=null){
            client.setName(clientDTO.getName());
        }
        if(clientDTO.getDob()!=null){
            client.setDateOfBirth(clientDTO.getDob());
        }
        if(clientDTO.getContact()!=null){
            client.setContact(clientDTO.getContact());
        }
        if(clientDTO.getAddress()!=null){
            client.setAddress(clientDTO.getAddress());
        }
        clientRepository.save(client);
        return "Successfully Updated";
    }
    public String deleteClient(int id)throws Exception{
        //Client client=clientRepository.findById(id).get();
        clientRepository.deleteById(id);
        return "Successfully deleted";
    }
}
