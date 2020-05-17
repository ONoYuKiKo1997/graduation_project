package cn.edu.hebtu.software.bean;

public class Dish {
    private String dId;
    private String dName;
    private String dHunSu;
    private String dKouWei;
    private String dPrice;
    private String dImageUrl;

    public Dish(){}

    public Dish(String dId, String dName, String dHunSu, String dKouWei, String dPrice, String dImageUrl) {
        this.dId = dId;
        this.dName = dName;
        this.dPrice = dPrice;
        this.dHunSu = dHunSu;
        this.dKouWei = dKouWei;
        this.dImageUrl = dImageUrl;
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

    public String getdHunSu() {
        return dHunSu;
    }

    public void setdHunSu(String dHunSu) {
        this.dHunSu = dHunSu;
    }

    public String getdKouWei() {
        return dKouWei;
    }

    public void setdKouWei(String dKouWei) {
        this.dKouWei = dKouWei;
    }

    public String getDImageUrl() {
        return dImageUrl;
    }

    public void setDImageUrl(String dImageUrl) {
        this.dImageUrl = dImageUrl;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dId='" + dId + '\'' +
                ", dName='" + dName + '\'' +
                ", dHunSu='" + dHunSu + '\'' +
                ", dKouWei='" + dKouWei + '\'' +
                ", dPrice='" + dPrice + '\'' +
                ", dImageUrl='" + dImageUrl + '\'' +
                '}';
    }
}
