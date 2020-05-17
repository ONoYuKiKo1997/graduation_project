package cn.edu.hebtu.software.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detail_order")
public class OrderDetail {
	private int id;
    private String oId;
    private String dId;
    private String dName;
    private String dPrice;
    private String dCount;

    public OrderDetail() {
    	super();
    }
    
    public OrderDetail(String oId, String dId, String dName, String dPrice, String dCount) {
        this.oId = oId;
        this.dId = dId;
        this.dName = dName;
        this.dPrice = dPrice;
        this.dCount = dCount;
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

    @Column(name="d_id")
    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    @Column(name="d_name")
    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Column(name="d_price")
    public String getdPrice() {
        return dPrice;
    }

    public void setdPrice(String dPrice) {
        this.dPrice = dPrice;
    }

    @Column(name="d_count")
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
