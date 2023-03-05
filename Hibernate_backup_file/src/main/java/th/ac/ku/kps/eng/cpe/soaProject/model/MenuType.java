package th.ac.ku.kps.eng.cpe.soaProject.model;
// Generated Mar 5, 2023, 2:05:21 PM by Hibernate Tools 6.0.2.Final

import java.util.HashSet;
import java.util.Set;

/**
 * MenuType generated by hbm2java
 */
public class MenuType implements java.io.Serializable {

	private Integer menuTypeId;
	private String menuTypeName;
	private Set menus = new HashSet(0);

	public MenuType() {
	}

	public MenuType(String menuTypeName) {
		this.menuTypeName = menuTypeName;
	}

	public MenuType(String menuTypeName, Set menus) {
		this.menuTypeName = menuTypeName;
		this.menus = menus;
	}

	public Integer getMenuTypeId() {
		return this.menuTypeId;
	}

	public void setMenuTypeId(Integer menuTypeId) {
		this.menuTypeId = menuTypeId;
	}

	public String getMenuTypeName() {
		return this.menuTypeName;
	}

	public void setMenuTypeName(String menuTypeName) {
		this.menuTypeName = menuTypeName;
	}

	public Set getMenus() {
		return this.menus;
	}

	public void setMenus(Set menus) {
		this.menus = menus;
	}

}
