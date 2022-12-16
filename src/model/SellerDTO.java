package model;

public class SellerDTO {
    private int SellerId;
    private String SellerName;
    private String email;
    private String location;

    public SellerDTO() {
    }

    public SellerDTO(int sellerId, String sellerName, String email, String location) {
        SellerId = sellerId;
        SellerName = sellerName;
        this.email = email;
        this.location = location;
    }

    public int getSellerId() {
        return SellerId;
    }

    public void setSellerId(int sellerId) {
        SellerId = sellerId;
    }

    public String getSellerName() {
        return SellerName;
    }

    public void setSellerName(String sellerName) {
        SellerName = sellerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "SellerDTO{" +
                "SellerId=" + SellerId +
                ", SellerName='" + SellerName + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
