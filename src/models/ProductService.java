package models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductService {

    Map<Long, Product> products = new HashMap<>();


    public void registerProduct(Long id, String name, BigDecimal price, Integer quantity){


        if (products.containsKey(id)){
            throw new IllegalArgumentException("Já existe um Produto com esse ID");
        }

        products.put(id, new Product(id,name,price,quantity));


    }


}
