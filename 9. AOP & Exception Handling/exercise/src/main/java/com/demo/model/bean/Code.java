package com.demo.model.bean;

import javax.persistence.*;

@Entity
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeId;
    private int code;
    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;
    public Code() {
    }

    public Code(Integer codeId, int code, Book book) {
        this.codeId = codeId;
        this.code = code;
        this.book = book;
    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
