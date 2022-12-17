package dao;

import exception.ByerException;
import model.Buyer;
import model.SoldItemsDTO;

import java.util.List;

public interface BuyerDao {
    public Buyer BuyerLogin(String email, String password) throws ByerException;

    public String RegisterBuyer(Buyer buyer) throws ByerException;

    public List<SoldItemsDTO> searchItemByCategory(String categoryName) throws ByerException;

}
