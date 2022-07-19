package com.poe.crm.api;

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
    // @Autowired : injection de Service dans cette classe (récupération automatique du bean)
    // On a plus besoin de déclarer la variable Service ici (Service service = new Service();)
    // car Spring la recherche directement dans le bean correspondant, ce qui nous permet d'utiliser
    // les méthodes du bean injecté
    @Autowired
    CrmService crmService;
    // @GetMapping : traitement d'une requête http GET et mapping de cette requête
    // Equivalent à une annotation @GET + une annotation @RequestMapping


    @GetMapping("clients")
    public List<Client> getAll() {

        return crmService.getAllClients();
    }
    // Traitement d'une requête http POST et mapping de cette requête
    // Equivalent à une annotation @POST + une annotation @RequestMapping



    @PostMapping("clients")
    public void createClient(@RequestBody Client client) {
        crmService.addClient(client);

    }


    // @PathVariable : liaison entre le paramètre "id" de la méthode et l'uri de la requête http
    @GetMapping("clients/{id}")
    public ResponseEntity<Client> findClientById(@PathVariable("id") Long id) {

        Optional<Client> o = crmService.findClient(id);

        if (o.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(o.get());

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}


