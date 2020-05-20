package com.example.services;

public interface AccesoExternoService {
	
	/**
	 * Access to a url and bring its data
	 * 
	 * @return String
	 * @throws Exception
	 */
	abstract String  getAccesoUrl() throws Exception;
}
