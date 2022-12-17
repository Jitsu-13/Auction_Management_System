package dao;

import exception.ByerException;
import exception.SellerException;
import model.Products;
import model.Seller;
import utility.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoImpl implements SellerDao{
    @Override
    public Seller SellerLogin(String email, String password) throws SellerException {
        Seller seller=null;

        try(Connection conn= DBUtility.provideConnection()){

            PreparedStatement ps=conn.prepareStatement("Select * from seller where email=? AND password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                seller =new Seller();
                seller.setSellerId(rs.getInt("sellerID"));
                seller.setSellerName(rs.getString("sellerName"));
                seller.setEmail(rs.getString("email"));
                seller.setPassword(rs.getString("password"));
                seller.setLocation(rs.getString("location"));

            }else{
                throw new SellerException("Invalid email/password");
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());

        }


        return seller;
    }

    //======================================*****************=========================================================/

    @Override
    public String RegisterSeller(Seller seller) throws SellerException {

        String result="Not Registered-Bad Details (Enter Unique Email)";

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps=conn.prepareStatement("insert into seller (sellerName,email,password,location) values (?,?,?,?)");

            ps.setString(1, seller.getSellerName());
            ps.setString(2, seller.getEmail());
            ps.setString(3, seller.getPassword());
            ps.setString(4, seller.getLocation());

            int x= ps.executeUpdate();
            if(x>0){
                result="Registered Successfully";
            }else{
                throw new SellerException(result);
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());
        }

        return result;
    }

    //======================================*****************=========================================================/

    @Override
    public String CreateListofProductstoSell(List<Products> products) throws SellerException {
        String result="Not Listed";

        try(Connection conn=DBUtility.provideConnection()){
            int count=0;
            for(int i=0;i<products.size();i++){
                String productName = products.get(i).getProductName();
                int sellerId = products.get(i).getSellerId();
                int categoryId = products.get(i).getCategoryId();
                int price = products.get(i).getPrice();
                PreparedStatement ps = null;
                try {
                    ps = conn.prepareStatement("insert into products (productName,sellerId,categoryId,price) values(?,?,?,?)");
                    ps.setString(1, productName);
                    ps.setInt(2, sellerId);
                    ps.setInt(3, categoryId);
                    ps.setInt(4, price);
                    int x = ps.executeUpdate();
                    count++;
                } catch (SQLException e) {
                    System.out.println("Mismatch in data");
                }
            };
            if(count>0){
                result="Products Inserted in Auction List Successfully";
            }else{
                throw new SellerException(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());
        }
        return result;
    }

    //======================================*****************=========================================================/

    @Override
    public String UpdateProductPrice(int productId,int price) throws SellerException {
        String result;

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps=conn.prepareStatement("update products set price=? where productId=?");

            ps.setInt(1,price );
            ps.setInt(2, productId);

            int x= ps.executeUpdate();
            if(x>0){
                result="Updated Successfully";
            }else{
                throw new SellerException("No Product found with productId- "+productId );
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());
        }

        return result;
    }

    //======================================*****************=========================================================/

    @Override
    public String DeleteProductItems(int productId) throws SellerException {
        String result;

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps=conn.prepareStatement("delete from products where productId=?");

            ps.setInt(1, productId);

            int x= ps.executeUpdate();
            if(x>0){
                result="Deleted Successfully";
            }else{
                throw new SellerException("No Product found with productId- "+productId );
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());
        }

        return result;
    }

}
