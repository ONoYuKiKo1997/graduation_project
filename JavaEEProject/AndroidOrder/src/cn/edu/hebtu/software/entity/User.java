package cn.edu.hebtu.software.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
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

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="u_id")
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Column(name="u_nickname")
    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname;
    }

    @Column(name="u_phone")
    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    @Column(name="u_address")
    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    @Column(name="u_img")
    public String getuImageUrl() {
        return uImageUrl;
    }

    public void setuImageUrl(String uImageUrl) {
        this.uImageUrl = uImageUrl;
    }

    @Column(name="u_password")
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
