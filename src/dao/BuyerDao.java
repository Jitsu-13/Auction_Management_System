package dao;

import exception.ByerException;
import model.Buyer;
import model.SearchBuyerDTO;
import model.SoldItemsDTO;

import java.time.LocalDate;
import java.util.List;

public interface BuyerDao {
    public Buyer BuyerLogin(String email, String password) throws ByerException;

    public String RegisterBuyer(Buyer buyer) throws ByerException;

    public List<SoldItemsDTO> searchItemByCategory(String categoryName) throws ByerException;

    public String BuyItem(int buyerId, LocalDate date,String productName) throws ByerException;

    public List<SearchBuyerDTO> ViewAllBuyersDetails(String categoryName) throws ByerException;


}
