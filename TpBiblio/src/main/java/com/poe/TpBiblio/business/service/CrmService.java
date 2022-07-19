package com.poe.TpBiblio.business.service;

import com.poe.TpBiblio.business.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrmService {


    ArrayList<Book> books = new ArrayList<>();
    long index = 0;

    public List<Book> getAllBooks(){
        return books;
    }


    public void addBook(Book book){
        index++;
        book.setId(index);
        books.add(book);
    }

    public Optional<Book> findBook(Long id){
        for(Book book : books){
            if(book.getId().equals(id)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

}
