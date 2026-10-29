package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {

    Map<Long, Product> products = new HashMap<>();


    public Product findById(Long id){

        Product product = products.get(id);

        if (product == null){
            throw new IllegalArgumentException("Produto não encontrado: " + id);
        }

        return product;

    }

    public void registerProduct(Long id, String name, BigDecimal price, Integer quantity){


        if (products.containsKey(id)){
            throw new IllegalArgumentException("Já existe um Produto com esse ID");
        }

        products.put(id, new Product(id,name,price,quantity));


    }

    public void addProduct(Long id, int quantity){

        Product product = findById(id);

        product.addProduct(quantity);

    }

    public void removeProduct(Long id, int quantity){

        Product product = findById(id);

        product.removeProduct(quantity);

    }

    public Product fetchProduct(Long id){

        return findById(id);

    }

    public List<Product> fetchAll(){

        return new ArrayList<>(products.values());

    }

}
