package com.userManagementexample.demoOnUserManagement.DTO;

import java.io.Serializable;

public class UserEntitlementsDTO implements Serializable{
	
	private UserDTO userdto;
	private boolean bankerOutreach;
	
	public UserEntitlementsDTO() {

	}

	

	

	public UserEntitlementsDTO(boolean bankerOutreach) {
		super();
		this.bankerOutreach = bankerOutreach;
	}





	public UserDTO getUserdto() {
		return userdto;
	}

	public void setUserdto(UserDTO userdto) {
		this.userdto = userdto;
	}





	public boolean isBankerOutreach() {
		return bankerOutreach;
	}





	public void setBankerOutreach(boolean bankerOutreach) {
		this.bankerOutreach = bankerOutreach;
	}


	@Override
	public String toString() {
		return "UserEntitlementsDTO [userdto=" + userdto + ", bankerOutreach=" + bankerOutreach + "]";
	}

	

}
