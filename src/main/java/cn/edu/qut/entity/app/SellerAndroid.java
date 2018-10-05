package cn.edu.qut.entity.app;
import java.io.Serializable;
import java.util.Set;
public class SellerAndroid implements Serializable{
	
		Integer seller_id;
		String store_id;
		String seller_login_name;
		String seller_password;
		Integer role_id;
		String seller_state;
		String seller_real_name;
		String seller_img;
		String seller_phone;
		String seller_epay;
		String seller_reg_date;
		Set<String> permisssions;
		public Set<String> getPermisssions() {
			return permisssions;
		}
		public void setPermisssions(Set<String> permisssions) {
			this.permisssions = permisssions;
		}
		public Integer getRole_id() {
			return role_id;
		}
		public void setRole_id(Integer role_id) {
			this.role_id = role_id;
		}
		
		public Integer getSeller_id() {
			return seller_id;
		}
		public void setSeller_id(Integer seller_id) {
			this.seller_id = seller_id;
		}
		public String getStore_id() {
			return store_id;
		}
		public void setStore_id(String store_id) {
			this.store_id = store_id;
		}
		public String getSeller_login_name() {
			return seller_login_name;
		}
		public void setSeller_login_name(String seller_login_name) {
			this.seller_login_name = seller_login_name;
		}
		public String getSeller_password() {
			return seller_password;
		}
		public void setSeller_password(String seller_password) {
			this.seller_password = seller_password;
		}
		
		public String getSeller_state() {
			return seller_state;
		}
		public void setSeller_state(String seller_state) {
			this.seller_state = seller_state;
		}
		public String getSeller_real_name() {
			return seller_real_name;
		}
		public void setSeller_real_name(String seller_real_name) {
			this.seller_real_name = seller_real_name;
		}
		public String getSeller_img() {
			return seller_img;
		}
		public void setSeller_img(String seller_img) {
			this.seller_img = seller_img;
		}
		public String getSeller_phone() {
			return seller_phone;
		}
		public void setSeller_phone(String seller_phone) {
			this.seller_phone = seller_phone;
		}
		public String getSeller_epay() {
			return seller_epay;
		}
		public void setSeller_epay(String seller_epay) {
			this.seller_epay = seller_epay;
		}
		public String getSeller_reg_date() {
			return seller_reg_date;
		}
		public void setSeller_reg_date(String seller_reg_date) {
			this.seller_reg_date = seller_reg_date;
		}
		@Override
		public String toString() {
			return "Seller [seller_id=" + seller_id + ", store_id=" + store_id + ", seller_login_name=" + seller_login_name
					+ ", seller_password=" + seller_password + ", role_id=" + role_id + ", seller_state=" + seller_state
					+ ", seller_real_name=" + seller_real_name + ", seller_img=" + seller_img + ", seller_phone="
					+ seller_phone + ", seller_epay=" + seller_epay + ", seller_reg_date=" + seller_reg_date + "]";
		}	
	}
