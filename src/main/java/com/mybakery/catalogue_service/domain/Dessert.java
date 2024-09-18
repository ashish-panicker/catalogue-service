package com.mybakery.catalogue_service.domain;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import org.springframework.hateoas.server.core.Relation;

@Entity
@Table(name = "desserts")
@Relation(collectionRelation = "desserts")
@JsonRootName(value = "dessert")
public class Dessert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false)
    private Double price;

    @Column(name = "image_thumbnail", nullable = false, length = 255)
    private String imageThumbnail;

    @Column(name = "image_mobile", nullable = false, length = 255)
    private String imageMobile;

    @Column(name = "image_tablet", nullable = false, length = 255)
    private String imageTablet;

    @Column(name = "image_desktop", nullable = false, length = 255)
    private String imageDesktop;

    public Dessert() {}

    // Getters and Setters

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getImageMobile() {
        return imageMobile;
    }

    public void setImageMobile(String imageMobile) {
        this.imageMobile = imageMobile;
    }

    public String getImageTablet() {
        return imageTablet;
    }

    public void setImageTablet(String imageTablet) {
        this.imageTablet = imageTablet;
    }

    public String getImageDesktop() {
        return imageDesktop;
    }

    public void setImageDesktop(String imageDesktop) {
        this.imageDesktop = imageDesktop;
    }
}