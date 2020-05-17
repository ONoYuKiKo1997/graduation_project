package cn.edu.hebtu.software.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="total_order")
public class OrderTotal {
	private int id;
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

    public OrderTotal() {
    	
    }
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id")
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	@Column(name="o_id")
    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

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

    @Column(name="o_total")
    public String getoTotal() {
        return oTotal;
    }

    public void setoTotal(String oTotal) {
        this.oTotal = oTotal;
    }

    @Column(name="o_state")
    public String getoState() {
        return oState;
    }

    public void setoState(String oState) {
        this.oState = oState;
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
