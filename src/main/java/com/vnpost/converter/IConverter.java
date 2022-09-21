package com.vnpost.converter;

public interface IConverter<T, E> {
     T convertToDTO(E object);

     E convertToEntity(T object);

}
