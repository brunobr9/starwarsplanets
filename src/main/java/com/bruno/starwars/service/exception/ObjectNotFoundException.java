package com.bruno.starwars.service.exception;

public class ObjectNotFoundException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String param, String className) {
		super("Objeto não encontrado." + " [" + param + ", " + className + "]");
	}
}
