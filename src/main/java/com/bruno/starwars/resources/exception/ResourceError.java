package com.bruno.starwars.resources.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResourceError {
	private int status;
	private String message;
}
