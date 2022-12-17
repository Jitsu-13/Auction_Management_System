package dao;

import exception.SellerException;
import model.Products;
import model.Seller;
import model.SoldItemsDTO;

import java.util.List;


public interface SellerDao {
    public Seller SellerLogin(String email, String password) throws SellerException;

    public String RegisterSeller(Seller seller) throws SellerException;

    public String CreateListofProductstoSell(List<Products> products) throws SellerException;

    public String UpdateProductPrice(int productId,int price) throws SellerException;

    public String DeleteProductItems(int productId) throws SellerException;

    public List<SoldItemsDTO> SoldItemHistory(int sellerId) throws SellerException;


}
