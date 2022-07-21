package com.poe.TpBiblio;

import com.poe.TpBiblio.business.Book;
import com.poe.TpBiblio.business.service.CrmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTests {



    @Test
    void testAjoutBook() {
        CrmService crmService = new CrmService();
        Book book = new Book();
        book.setName("livre dela jungle");
        book.setCategory("enfant");

        crmService.addBook(book);


        Assertions.assertEquals(1, crmService.getAllBooks().size());

    }
}
