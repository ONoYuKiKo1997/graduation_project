package cn.edu.hebtu.software.bean;

public class OrderDetail {
    private int id = 0;
    private String oId;
    private String dId;
    private String dName;
    private String dPrice;
    private String dCount;

    public OrderDetail(String oId, String dId, String dName, String dPrice, String dCount) {
        this.oId = oId;
        this.dId = dId;
        this.dName = dName;
        this.dPrice = dPrice;
        this.dCount = dCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdPrice() {
        return dPrice;
    }

    public void setdPrice(String dPrice) {
        this.dPrice = dPrice;
    }

    public String getdCount() {
        return dCount;
    }

    public void setdCount(String dCount) {
        this.dCount = dCount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "oId='" + oId + '\'' +
                ", dId='" + dId + '\'' +
                ", dName='" + dName + '\'' +
                ", dPrice='" + dPrice + '\'' +
                ", dCount='" + dCount + '\'' +
                '}';
    }
}
