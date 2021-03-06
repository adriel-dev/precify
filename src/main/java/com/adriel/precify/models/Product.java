package com.adriel.precify.models;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity @Table(name = "product")
public class Product {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;
    private Double costPrice;
    private Double salePrice;

    @Column(nullable = false)
    private Double profitMargin;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    @Column(nullable = false)
    private ZonedDateTime registerDateTime;
    
    @OneToMany(mappedBy = "product_id")
    private List<Recipe> products;

    @OneToMany(mappedBy = "product")
    private List<ProductPacking> productsPacking;

    public Product(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(Double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public ZonedDateTime getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(ZonedDateTime registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}