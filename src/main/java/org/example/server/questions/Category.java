package org.example.server.questions;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Category {
    @Id
    private String name;
    private String color;
    public Category(String name,String color){
        this.name=name;
        this.color=color;
    }
}
