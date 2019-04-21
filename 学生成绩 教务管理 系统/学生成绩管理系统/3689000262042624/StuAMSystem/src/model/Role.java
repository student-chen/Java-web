package model;

public class Role {
	private int roleID;
	private String roleName;
	private String roleInfo;
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}
	public Role() {
		super();
		
	}
	public Role(int roleID, String roleName, String roleInfo) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.roleInfo = roleInfo;
	}
	public Role(String roleName, String roleInfo) {
		super();
		this.roleName = roleName;
		this.roleInfo = roleInfo;
	}
	
	

}
