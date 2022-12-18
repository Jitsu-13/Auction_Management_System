package main;

import custom.ConsoleColors;
import usecases.*;

public class AdminMain {

    public static boolean AdminLogin(){
        AdminLoginUseCase login=new AdminLoginUseCase();
        boolean result=login.adminLogin();
        return result;
    }
    public static void AdminHomeWindow() {
//        System.out.println(ConsoleColors.BROWN_BACKGROUND+ ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Admin Home Window : "+ ConsoleColors.RESET);
        System.out.println("Press 1 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View the registered buyer list" + ConsoleColors.RESET);
        System.out.println("Press 2 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View the registered Seller list" + ConsoleColors.RESET);
        System.out.println("Press 3 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View the daily selling report" + ConsoleColors.RESET);
        System.out.println("Press 4 to"+ConsoleColors.PURPLE_BOLD_BRIGHT+" View the daily dispute report" + ConsoleColors.RESET);
        System.out.println("Press 5 to"+ConsoleColors.PURPLE_BOLD_BRIGHT+" Solve the dispute report" + ConsoleColors.RESET);
        System.out.println("Press 6 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);
    }
    public static void viewBuyers(){
        ViewBuyerListUseCase viewBuyerListUseCase=new ViewBuyerListUseCase();
        viewBuyerListUseCase.viewBuyerList();
    }
    public static void viewSellers(){
        ViewSellerListUseCase viewSellerListUseCase=new ViewSellerListUseCase();
        viewSellerListUseCase.viewSellerList();
    }
    public static void dailySellingReport(){
        DailySellingReportUsecase dailySellingReportUsecase=new DailySellingReportUsecase();
        dailySellingReportUsecase.dailySellingReport();
    }
    public static void dailyDisputeReport(){
        DailyDisputeReportUseCase dailyDisputeReportUseCase=new DailyDisputeReportUseCase();
        dailyDisputeReportUseCase.dailyDisputeReport();
    }
    public static void solveDispute(){
        ResolveDisputeUseCase resolveDisputeUseCase =new ResolveDisputeUseCase();
        resolveDisputeUseCase.disputeResolve();
    }


}
