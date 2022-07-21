package com.poe.crm.api;

import com.poe.crm.api.dto.ClientDTO;
import com.poe.crm.business.Client;
import com.poe.crm.business.service.CrmService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ClientController {

    @Autowired
    CrmService crmService;

    @GetMapping("clients")
    public List<Client> getAll() {

        return crmService.getAllClients();
    }

    @PostMapping("clients")
    public void createClient(@RequestBody Client client){
        crmService.addClient(client);
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<ClientDTO> findClientById(@PathVariable("id") Long id){
        Optional<Client> o = crmService.findClient(id);
        if(o.isPresent()){
            Client client = o.get();
            ClientDTO clientDTO = new ClientDTO(client);
            clientDTO.setTotalExpense(crmService.calculateExpense(client.getId()));
            return ResponseEntity.status(HttpStatus.OK).body(clientDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        boolean hasDeleted = crmService.deleteClient(id);
        if(hasDeleted){
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("L'identifiant ne correspond à aucun Client");
        }

    }


    @PutMapping("clients/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody Client client){

        if(! id.equals( client.getId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("L'identifiant dans URL ne correspond à identifiant dans body");
        } else {
            if(crmService.updateClient(client)){
                return ResponseEntity.status(HttpStatus.OK).build();
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).
                        body("L'identifiant ne correspond à aucun Client");
            }
        }
    }

    // Exemple : http://localhost:8080/api/searchclients?companyname=Google
    @GetMapping("searchclients")
    public List<Client> searchByCompanyName(
            @RequestParam(value="companyname") String companyName){

        return crmService.searchByCompanyName(companyName);
    }

    // Exemple: http://localhost:8080/api/searchbyfirstnameandlastname?firstname=James&lastname=Bond
    @GetMapping("searchbyfirstnameandlastname")
    public List<Client> searchByFirstNameAndLastName(
            @RequestParam(value="firstname") String firstName,
            @RequestParam(value="lastname") String lastName){

        return crmService.searchByFirstNameAndLastName(firstName,lastName);
    }

}