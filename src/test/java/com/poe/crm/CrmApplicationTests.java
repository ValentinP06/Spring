package com.poe.crm;


import com.poe.crm.business.Client;
import com.poe.crm.business.service.CrmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CrmApplicationTests {

    @Autowired
    CrmService crmService;

    @Test
    void contextLoads(){
        Client client = new Client();
        client.setFirstName("alain");
        client.setLastName("delon");
        crmService.addClient(client);


        Assertions.assertEquals(1,crmService.getAllClients().size());
    }

}
