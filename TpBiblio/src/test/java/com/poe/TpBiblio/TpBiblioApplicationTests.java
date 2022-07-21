package com.poe.TpBiblio;

import com.poe.TpBiblio.business.Book;
import com.poe.TpBiblio.business.service.CrmService;
import com.poe.TpBiblio.dao.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TpBiblioApplicationTests {


	@Autowired
	CrmService crmService;

	@Autowired
	BookRepository bookRepository;

	@Test
	void TestAddLoads() {
		Book book = new Book();
		book.setName("voyage au centre de la terre");
		book.setCategory("aventure");
		crmService.addBook(book);

		Assertions.assertEquals(1, crmService.getAllBooks().size());
	}

	@Test
	void TestBookRepository(){
		List<Book> sqlBooks= bookRepository.findAll();
		Assertions.assertTrue(sqlBooks.size()>0);

	}


}
