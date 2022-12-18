package main;

import usecases.AdminLoginUseCase;
import usecases.DailySellingReportUsecase;
import usecases.ViewBuyerListUseCase;
import usecases.ViewSellerListUseCase;

public class AdminMain {

    public static boolean AdminLogin(){
        AdminLoginUseCase login=new AdminLoginUseCase();
        boolean result=login.adminLogin();
        return result;
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


}
