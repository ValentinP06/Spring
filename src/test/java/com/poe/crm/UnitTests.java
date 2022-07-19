package com.poe.crm;

import com.poe.crm.business.Client;
import com.poe.crm.business.service.CrmService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class UnitTests {

	@Test
	void testAjoutClient() {
		CrmService crmService = new CrmService();
		Client client = new Client();
		client.setFirstName("alain");
		client.setLastName("delon");
		crmService.addClient(client);


		Assertions.assertEquals(1,crmService.getAllClients().size());


	}

}
