package models;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final ProductService productService = new ProductService();

    public void start(){

        boolean running = true;

        while (running){

            System.out.println("\n==== CONTROLE DE ESTOQUE ====");
            System.out.println("1 - Criar Novo Produto");
            System.out.println("2 - Adicionar Produto");
            System.out.println("3 - Remover Produto");
            System.out.println("4 - Consultar Produto");
            System.out.println("0 - Sair");
            System.out.println("Escolha: ");

            int option = sc.nextInt();

            switch (option){

                case 1 -> newProduct();
                case 2 -> addProduct();
                case 3 -> removeProduct();
                case 4 -> searchProduct();
                case 0 -> running = false;
                default -> System.out.println("Opção inválida");
            }



        }
    }

    public void newProduct(){

        System.out.println("ID do Produto: ");
        Long id = sc.nextLong();

        System.out.println("Nome do Produto: ");
        String name = sc.nextLine();

        System.out.println("Preço do Produto: ");
        BigDecimal price = sc.nextBigDecimal();

        System.out.println("Quantidade do Produto: ");
        int quantity = sc.nextInt();

        productService.registerProduct(id,name,price,quantity);

    }

    public void addProduct(){

    }

}
