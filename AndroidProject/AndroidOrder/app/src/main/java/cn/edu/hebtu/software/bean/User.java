package cn.edu.hebtu.software.bean;

public class User {

    private String uId;
    private String uNickname;
    private String uPhone;
    private String uAddress;
    private String uImageUrl;
    private String uPassword;

    public User(String uId, String uNickname, String uPhone, String uAddress, String uImageUrl, String uPassword) {
        this.uId = uId;
        this.uNickname = uNickname;
        this.uPhone = uPhone;
        this.uAddress = uAddress;
        this.uImageUrl = uImageUrl;
        this.uPassword = uPassword;
    }

    public User() {

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

    public String getuImageUrl() {
        return uImageUrl;
    }

    public void setuImageUrl(String uImageUrl) {
        this.uImageUrl = uImageUrl;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId='" + uId + '\'' +
                ", uNickname='" + uNickname + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uAddress='" + uAddress + '\'' +
                ", uImageUrl='" + uImageUrl + '\'' +
                ", uPassword='" + uPassword + '\'' +
                '}';
    }
}
