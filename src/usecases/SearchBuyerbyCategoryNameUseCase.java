package usecases;

import custom.ConsoleColors;
import dao.BuyerDao;
import dao.BuyerDaoImpl;
import exception.ByerException;
import model.SearchBuyerDTO;
import model.SoldItemsDTO;

import java.util.List;
import java.util.Scanner;

public class SearchBuyerbyCategoryNameUseCase {
    public static void main(String[] args) {
        searchBuyerItembyCategory();
    }
    public static void searchBuyerItembyCategory(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the category name to want to find list of bought items by buyers -\n" +
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
            List<SearchBuyerDTO> list= dao.ViewAllBuyersDetails(category);
            System.out.println("---------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Search Buyer By Category Name" + ConsoleColors.RESET+ "---------------------------");

            System.out.println("---------------------------------------------------------------------------------------------");

            System.out.printf("%7s %13s %12s %15s %10s %13s %10s",ConsoleColors.BLACK_BOLD + "Id", "BuyerName","email","ProductName","CategoryName","SellerName","Price"+ ConsoleColors.RESET);
            System.out.println();
            System.out.print("----------------------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%2s %10s %18s %12s %12s %11s %12s",li.getBuyerId(),li.getBuyerName(),li.getEmail(),li.getProductName(),li.getCategoryName(),li.getSellerName(),li.getPrice());
                System.out.println();

            });
            System.out.println("-------------------------------------------------------------------------------------------");

        } catch (ByerException e) {
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
        }
    }
}
