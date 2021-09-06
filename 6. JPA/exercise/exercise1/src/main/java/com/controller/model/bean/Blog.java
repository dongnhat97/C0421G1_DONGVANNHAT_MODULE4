package com.controller.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String blockName;
    private String blockSummary;
    private String blockContent;

    public Block() {
    }

    public Block(Long id, String blockName, String blockSummary, String blockContent) {
        this.id = id;
        this.blockName = blockName;
        this.blockSummary = blockSummary;
        this.blockContent = blockContent;
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
}
