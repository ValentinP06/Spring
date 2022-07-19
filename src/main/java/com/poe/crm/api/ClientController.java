package com.poe.crm.api;

import com.poe.crm.business.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("clients")
    public List<Client> getAll(){

        ArrayList<Client> clients= new ArrayList<>();

        clients.add (new Client("google", "mich", "frt"," email", " 123456789", " RUE DES ", "312345",
                "paris", "france"));
        clients.add (new Client("google", "camelia", "lachant"," email", " 123456789", " RUE DES ", "312345",
                "paris", "france"));

        return clients;

    }
}
