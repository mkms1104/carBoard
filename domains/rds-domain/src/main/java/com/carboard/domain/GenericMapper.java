package com.carboard.domain;

public interface GenericMapper<D, E> {
    D toDto(E e);
    E toEntity(D d);
}