package usecases;

import custom.ConsoleColors;
import dao.SellerDao;
import dao.SellerDaoImpl;
import exception.SellerException;
import model.Products;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CreateProductListUseCase {
    public static void main(String[] args) {
        createProductList();
    }
    public static void createProductList(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("------" + ConsoleColors.PURPLE_BACKGROUND + ConsoleColors.YELLOW_BOLD_BRIGHT + "Enter the number of products you want to insert in auction list" + ConsoleColors.RESET + "---------");
            int N = sc.nextInt();
            List<Products> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                System.out.println("Enter Details of Product-" + (i + 1));
                Products products = new Products();
                System.out.println("Enter Product Name-");
                String name = sc.next();
                products.setProductName(name);
                System.out.println("Enter Category ID-");
                int cid = sc.nextInt();
                products.setCategoryId(cid);
                System.out.println("Enter Seller ID-");
                int sid = sc.nextInt();
                products.setSellerId(sid);
                System.out.println("Enter Price-");
                int price = sc.nextInt();
                products.setPrice(price);
                list.add(products);
                System.out.println("---------------------------------------------------------------------------------");
            }

            SellerDao dao = new SellerDaoImpl();
            String result;
            try {
                result = dao.CreateListofProductstoSell(list);
                System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
            } catch (SellerException e) {
                result = e.getMessage();
                System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
            }
        }catch (InputMismatchException i){
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
        }


    }
}
