import models.Menu;
import models.ProductService;
import models.ReadCsvFiles;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ProductService productService = new ProductService();

        Menu menu = new Menu(productService);
        ReadCsvFiles csvFile = new ReadCsvFiles(productService);

        csvFile.loadProducts();

        menu.start();


    }
}