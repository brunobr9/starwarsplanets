package com.bruno.starwars.dto;

import java.io.Serializable;

public interface IdEntityDTO<T> extends Serializable {

	T getId();

}
