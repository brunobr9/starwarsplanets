package com.bruno.starwars.domain;

import java.io.Serializable;

public interface IdEntity<T> extends Serializable {

	T getId();

}
