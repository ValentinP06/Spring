package com.poe.TpBiblio.business.service;

import com.poe.TpBiblio.business.Book;
import com.poe.TpBiblio.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrmService {


    ArrayList<Book> books = new ArrayList<>();
    long index = 0;

    @Autowired
    BookRepository bookRepository;
    public List<Book> getAllBooks(){

        return bookRepository.findAll();
    }


    public void addBook(Book book){

         bookRepository.save(book);
    }

    public Optional<Book> findBook(Long id){
        for(Book book : books){
            if(book.getId().equals(id)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    public void updateBook(Book book){
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                books.remove(b);
                books.add(book);
                break;
            }
        }
    }
    public void deleteBook(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) ;
            books.remove(book);
            break;
        }
    }

}
