package com.controller.model.bean;

import javax.persistence.*;

@Entity
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String blockName;
    private String blockSummary;
    private String blockContent;


    @Column(name="start_time", columnDefinition = "DATE")
    private String startTime;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "strategy_Id",referencedColumnName = "id")
    private Category category;


    public Block() {
    }

    public Block(Long id, String blockName, String blockSummary, String blockContent, String startTime, Category category) {
        this.id = id;
        this.blockName = blockName;
        this.blockSummary = blockSummary;
        this.blockContent = blockContent;
        this.startTime = startTime;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getBlockSummary() {
        return blockSummary;
    }

    public void setBlockSummary(String blockSummary) {
        this.blockSummary = blockSummary;
    }

    public String getBlockContent() {
        return blockContent;
    }

    public void setBlockContent(String blockContent) {
        this.blockContent = blockContent;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
