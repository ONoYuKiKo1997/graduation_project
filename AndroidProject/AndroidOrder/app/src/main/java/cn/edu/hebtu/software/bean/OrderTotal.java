package cn.edu.hebtu.software.bean;

public class OrderTotal {
    private int id = 0;
    private String oId;
    private String uId;
    private String uNickname;
    private String oTotal;
    private String oState;
    private String uPhone;
    private String uAddress;

    public OrderTotal(String oId, String uId, String uNickname, String oTotal, String oState, String uPhone, String uAddress) {
        this.oId = oId;
        this.uId = uId;
        this.uNickname = uNickname;
        this.oTotal = oTotal;
        this.oState = oState;
        this.uPhone = uPhone;
        this.uAddress = uAddress;
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

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname;
    }

    public String getoTotal() {
        return oTotal;
    }

    public void setoTotal(String oTotal) {
        this.oTotal = oTotal;
    }

    public String getoState() {
        return oState;
    }

    public void setoState(String oState) {
        this.oState = oState;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    @Override
    public String toString() {
        return "OrderTotal{" +
                "oId='" + oId + '\'' +
                ", uId='" + uId + '\'' +
                ", uNickname='" + uNickname + '\'' +
                ", oTotal='" + oTotal + '\'' +
                ", oState='" + oState + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uAddress='" + uAddress + '\'' +
                '}';
    }
}
