package usecases;

import custom.ConsoleColors;
import dao.AdminDao;
import dao.AdminDaoImpl;
import exception.AdminException;
import model.Products;
import model.SearchBuyerDTO;

import java.util.List;
import java.util.Scanner;

public class DailyDisputeReportUseCase {
    public static void main(String[] args) {
        dailyDisputeReport();
    }
    public static void dailyDisputeReport(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter date you want to find dispute list of");
        String date=sc.next();
        AdminDao dao=new AdminDaoImpl();
        try {
            List<Products> list= dao.DailyDisputeReport(date);
            System.out.println("---------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Date Wise Dispute Report" + ConsoleColors.RESET+ "---------------------------");

            System.out.println("---------------------------------------------------------------------------------------------");

            System.out.printf("%7s %13s %7s %12s %12s",ConsoleColors.BLACK_BOLD + "Id", "ProductName","SellerId","CategoryId","Price"+ ConsoleColors.RESET);
            System.out.println();
            System.out.print("----------------------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%2s %10s %8s %10s %12s",li.getProductId(),li.getProductName(),li.getSellerId(),li.getCategoryId(),li.getPrice());
                System.out.println();

            });
            System.out.println("-------------------------------------------------------------------------------------------");

        } catch (AdminException e) {
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
        }
    }
}
