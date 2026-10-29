package models;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public Product(Long id, String name, BigDecimal price, Integer quantity) {

        if(quantity < 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        if(price.compareTo(BigDecimal.ZERO) < 0 ){

            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");

        }


        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {

        if(price.compareTo(BigDecimal.ZERO) < 0 ){

            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");

        }

        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {


        if(quantity < 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void addProduct(int quantity){

        if (quantity < 0){
            throw new IllegalArgumentException("A quantidade deve ser maior que 0.");
        }

        this.quantity += quantity;

    }

    public void removeProduct(int quantity){
        if(quantity < 0){
            throw new IllegalArgumentException("A quantidade deve ser maior que 0.");
        }

        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return "Código do produto: " + getId()
                + "\nProduto: " + getName()
                + "\nQuantidade: " + getQuantity()
                + "\nPreço: " + getPrice();
    }
}
