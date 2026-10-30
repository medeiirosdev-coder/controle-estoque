package models;

import java.math.BigDecimal;
import java.util.*;

public class ProductService {

    private Map<Long, Product> products = new HashMap<>();

    public ProductService() {
    }

    public Product findById(Long id){

        Product product = products.get(id);

        if (product == null){
            throw new IllegalArgumentException("Produto não encontrado: " + id);
        }

        return product;

    }

    public void loadProducts(Long id, String name, BigDecimal price, int quantity){

        products.put(id, new Product(id,name,price,quantity));

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

        if (quantity > product.getQuantity()){
            throw new IllegalArgumentException("Quantidade de retirada maior que quantidade disponível\nQuantidade Disponível: " + product.getQuantity());
        }

        product.removeProduct(quantity);

    }

    public Product fetchProduct(Long id){

        return findById(id);

    }

    public List<Product> fetchAll(){

        return products.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Product::getName,
                                String.CASE_INSENSITIVE_ORDER
                        )
                )
                .toList();

    }

    public String fetchTotalProductValue(Long id){

        Product product = findById(id);

        return product.calculateTotalProductValue(product);


    }

}
