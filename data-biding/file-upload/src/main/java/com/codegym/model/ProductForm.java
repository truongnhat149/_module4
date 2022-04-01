package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
//    private int id;
//
//    private String name;
//
//    private String description;

    private MultipartFile fileData;

    public ProductForm() {
    }

    public ProductForm(MultipartFile image) {
        this.fileData = image;
    }

//    public ProductForm(int id, String name, String description, MultipartFile image) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.image = image;
//    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }

//    public MultipartFile getImage() {
//        return image;
//    }
//
//    public void setImage(MultipartFile image) {
//        this.image = image;
//    }
}