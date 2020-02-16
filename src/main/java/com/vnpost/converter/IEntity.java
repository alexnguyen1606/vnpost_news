package com.vnpost.converter;

public interface IEntity<T> {
    T convertToEntity(Object object);
}
