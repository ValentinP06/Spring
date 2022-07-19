package com.poe.TpBiblio;

import com.poe.TpBiblio.business.Book;
import com.poe.TpBiblio.business.service.CrmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TpBiblioApplicationTests {


	@Autowired
	CrmService crmService;
	@Test
	void contextLoads() {
		Book book = new Book();
		book.setName("voyage au centre de la terre");
		book.setCategory("aventure");
		crmService.addBook(book);

		Assertions.assertEquals(1, crmService.getAllBooks().size());
	}

}
