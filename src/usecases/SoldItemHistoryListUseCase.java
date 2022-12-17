package usecases;

import custom.ConsoleColors;
import dao.SellerDao;
import dao.SellerDaoImpl;
import exception.SellerException;
import model.SoldItemsDTO;


import java.util.List;
import java.util.Scanner;

public class SoldItemHistoryListUseCase {
    public static void main(String[] args) {
        soldItemHistory();
    }
    public static void soldItemHistory(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the SellerId to view Sold Items list");
        int sellerId =sc.nextInt();
        SellerDao dao=new SellerDaoImpl();
        try {
            List<SoldItemsDTO> list=dao.SoldItemHistory(sellerId);
            System.out.println("---------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Sold Items" + ConsoleColors.RESET+ "---------------------------");

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

        } catch (SellerException e) {
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
        }
    }
}
