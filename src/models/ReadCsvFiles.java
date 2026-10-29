package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class ReadCsvFiles {

    private final ProductService productService ;

    public ReadCsvFiles(ProductService productService) {
        this.productService = productService;
    }

    public void loadProducts(){

        String path = "C:\\temp\\Java\\desafio-controle-estoque\\data\\products.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            line = br.readLine();

            while (line != null) {

                String[] fields = line.split(";");
                Long id = Long.parseLong(fields[0]);
                String name = fields[1];
                BigDecimal price = new BigDecimal(fields[2]);
                int quantity = Integer.parseInt(fields[3]);


                productService.loadProducts(id,name,price,quantity);


                line = br.readLine();


            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
