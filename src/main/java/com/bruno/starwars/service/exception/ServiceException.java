package com.bruno.starwars.service.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException() {

	}

	public ServiceException(String mensagem) {
		super(mensagem);
	}
}
