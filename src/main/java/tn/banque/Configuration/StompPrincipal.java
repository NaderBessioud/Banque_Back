package tn.banque.Configuration;

import java.security.Principal;

public class StompPrincipal implements Principal {

	  String name;

	    StompPrincipal(String name) {
	        this.name = name;
	    }
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	

}
