package cn.edu.hebtu.software.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dishes")
public class Dish {
	private String dId;
    private String dName;
    private String dHunSu;
    private String dKouWei;
    private int dPrice;
    private String dImageUrl;
    
    
    
    public Dish() {
		super();
	}

	public Dish(String dId, String dName, String dHunSu, String dKouWei, int dPrice, String dImageUrl) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dHunSu = dHunSu;
		this.dKouWei = dKouWei;
		this.dPrice = dPrice;
		this.dImageUrl = dImageUrl;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@Column(name="d_hunsu")
	public String getdHunSu() {
		return dHunSu;
	}
	public void setdHunSu(String dHunSu) {
		this.dHunSu = dHunSu;
	}
	
	@Column(name="d_taste")
	public String getdKouWei() {
		return dKouWei;
	}
	public void setdKouWei(String dKouWei) {
		this.dKouWei = dKouWei;
	}
	
	@Column(name="d_price")
	public int getdPrice() {
		return dPrice;
	}
	public void setdPrice(int dPrice) {
		this.dPrice = dPrice;
	}
	
	@Column(name="d_img")
	public String getDmageUrl() {
		return dImageUrl;
	}
	public void setDmageUrl(String dImageUrl) {
		this.dImageUrl = dImageUrl;
	}
	
	
	@Override
	public String toString() {
		return "Dish [dId=" + dId + ", dName=" + dName + ", dHunSu=" + dHunSu + ", dKouWei=" + dKouWei + ", dPrice="
				+ dPrice + ", dImageUrl=" + dImageUrl + "]";
	}
    
    
}
