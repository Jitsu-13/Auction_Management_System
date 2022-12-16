package dao;

import exception.SellerException;
import model.Seller;


public interface SellerDao {
    public Seller SellerLogin(String email, String password) throws SellerException;

    public String RegisterSeller(Seller seller) throws SellerException;
}
