package usecases;

import custom.ConsoleColors;
import dao.BuyerDao;
import dao.BuyerDaoImpl;
import exception.ByerException;
import model.SoldItemsDTO;

import java.util.List;
import java.util.Scanner;

public class SearchItembyCategoryListUseCase {
    public static void main(String[] args) {
        searchItemCategory();
    }
    public static void searchItemCategory(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Category Name to want to find list of products -\n" +
                "|       1001 | Bikes        |\n" +
                "|       1002 | Cars         |\n" +
                "|       1003 | Watches      |\n" +
                "|       1004 | Shoes        |\n" +
                "|       1005 | Jewellery    |\n" +
                "|       1006 | Paintings    |\n" +
                "|       1007 | Alcohols     |\n" +
                "|       1008 | Swords)      |\n"+
            "------------------------------------------");
        String category =sc.next();
        BuyerDao dao=new BuyerDaoImpl();
        try {
            List<SoldItemsDTO> list= dao.searchItemByCategory(category);
            System.out.println("---------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Search Product By Category" + ConsoleColors.RESET+ "---------------------------");

            System.out.println("---------------------------------------------------------------------------------");

            System.out.printf("%7s %13s %15s %15s %10s %15s",ConsoleColors.BLACK_BOLD + "Id", "ProductName","SellerName","CategoryName","Price", "Status" + ConsoleColors.RESET);
            System.out.println();
            System.out.print("---------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%2s %12s %12s %16s %13s %14s",li.getProductId(),li.getProductName(),li.getSellerName(),li.getCategoryName(),li.getPrice(),li.getStatus());
                System.out.println();

            });
            System.out.println("---------------------------------------------------------------------------------");

        } catch (ByerException e) {
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
        }
    }
}
