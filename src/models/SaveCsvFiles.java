package models;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class SaveCsvFiles {

    public void saveFile(Path path, Map<Long, Product> products){


        try (BufferedWriter bw = Files.newBufferedWriter(path)) {

            bw.write("id;name;price;quantity");
            bw.newLine();

            for(Product product : products.values()){

                bw.write(product.getId() + ";" + product.getName() + ";" + product.getPrice() + ";" + product.getQuantity());
                bw.newLine();

            }



        } catch (IOException e){
            e.getStackTrace();
        }



    }


}
