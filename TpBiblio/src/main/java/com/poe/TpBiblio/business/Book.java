package com.poe.TpBiblio.business;

public class Book {

    private Long id;
    private String name;
    private String category;

        public Book(){
}

    public Book( String name, String category) {

        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
