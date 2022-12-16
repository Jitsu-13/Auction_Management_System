package model;

public class Buyer {
    private int buyerId;
    private String buyerName;
    private String email;
    private String password;
    private String location;

    public Buyer() {
    }

    public Buyer(int buyerId, String buyerName, String password, String email, String location) {
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.password =password ;
        this.email = email;
        this.location = location;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Buyer{" +
                "byerId=" + buyerId +
                ", byerName='" + buyerName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
