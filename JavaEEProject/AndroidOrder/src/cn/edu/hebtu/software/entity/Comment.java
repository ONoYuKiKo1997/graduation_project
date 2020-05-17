package cn.edu.hebtu.software.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
    private int cId;
    private int dId;
    private String dName;
    private String uId;
    private String uNickName;
    private String cContent;
    private String cDate;

    public Comment(int dId, String dName, String uId, String uNickName, String cContent, String cDate) {
        this.dId = dId;
        this.dName = dName;
        this.uId = uId;
        this.uNickName = uNickName;
        this.cContent = cContent;
        this.cDate = cDate;
    }

    public Comment() {
    }

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_id")
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Column(name="d_id")
    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    @Column(name="d_name")
    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Column(name="u_id")
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Column(name="u_nickname")
    public String getuNickName() {
        return uNickName;
    }

    public void setuNickName(String uNickName) {
        this.uNickName = uNickName;
    }

    @Column(name="c_content")
    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    @Column(name="c_date")
    public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	@Override
    public String toString() {
        return "Comment{" +
                "cId=" + cId +
                ", dId=" + dId +
                ", dName='" + dName + '\'' +
                ", uId='" + uId + '\'' +
                ", uNickName='" + uNickName + '\'' +
                ", cContent='" + cContent + '\'' +
                '}';
    }
}
