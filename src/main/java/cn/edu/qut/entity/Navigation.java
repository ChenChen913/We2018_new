package cn.edu.qut.entity;

import java.util.List;

public class Navigation {
	private String navigationName;
	private List<Permission> childNavigations;
	
	public String getNavigationName() {
		return navigationName;
	}
	public void setNavigationName(String navigationName) {
		this.navigationName = navigationName;
	}
	public List<Permission> getChildNavigations() {
		return childNavigations;
	}
	public void setChildNavigations(List<Permission> childNavigations) {
		this.childNavigations = childNavigations;
	}
	@Override
	public String toString() {
		return "Navigation [navigationName=" + navigationName + ", childNavigations=" + childNavigations.toString() + "]";
	}
	
	
	
	
	
	
}
