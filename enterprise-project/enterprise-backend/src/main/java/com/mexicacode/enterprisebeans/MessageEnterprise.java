package com.mexicacode.enterprisebeans;

import javax.ejb.Stateless;

@Stateless
public class MessageEnterprise implements IMessageEnterprise{

	@Override
	public String mesage() {
		return "Hola Mundo Prros";
	}

}
