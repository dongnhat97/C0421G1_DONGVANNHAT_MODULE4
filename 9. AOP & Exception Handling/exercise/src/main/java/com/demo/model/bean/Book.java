package com.demo.model.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int count;
    @OneToMany(mappedBy = "code",cascade = CascadeType.ALL)
    List<Code> codes;
    public Book() {
    }

    public Book(Integer id, String name, int count, List<Code> codes) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.codes = codes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Code> getCodes() {
        return codes;
    }

    public void setCodes(List<Code> codes) {
        this.codes = codes;
    }
}
