package dao;

import exception.ByerException;
import model.Buyer;

public interface BuyerDao {
    public Buyer BuyerLogin(String email, String password) throws ByerException;

    public String RegisterBuyer(Buyer buyer) throws ByerException;

}
