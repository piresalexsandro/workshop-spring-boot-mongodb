package com.piresalexsandro.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg); // repassa a mensagem para a superclasse RuntimeException
	}

	
}
