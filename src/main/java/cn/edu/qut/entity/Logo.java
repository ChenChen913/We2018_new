package cn.edu.qut.entity;

public class Logo {
	String img;
	String jid;
	Integer seller_id;
	
	//补充字段
	String logoName;
	
	
	
	
	public String getLogoName() {
		return logoName;
	}
	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}
	public Integer getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	@Override
	public String toString() {
		return "Logo [img=" + img + ", jid=" + jid + ", seller_id=" + seller_id + "]";
	}
	

	
}
