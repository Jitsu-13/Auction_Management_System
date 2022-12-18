package usecases;

import custom.ConsoleColors;
import dao.AdminDao;
import dao.AdminDaoImpl;
import dao.BuyerDao;
import dao.BuyerDaoImpl;
import exception.AdminException;
import exception.ByerException;
import model.SearchBuyerDTO;
import model.SoldItemsDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DailySellingReportUsecase {
    public static void main(String[] args) {
        dailySellingReport();
    }
    public static void dailySellingReport(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter date you want to find list of sold items");
        String date=sc.next();
        AdminDao dao=new AdminDaoImpl();
        try {
            List<SearchBuyerDTO> list= dao.DailySellingReport(date);
            System.out.println("---------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Products Category Wise" + ConsoleColors.RESET+ "---------------------------");

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

        } catch (AdminException e) {
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
        }
    }
}
