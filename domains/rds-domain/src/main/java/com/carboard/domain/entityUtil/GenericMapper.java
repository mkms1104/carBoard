package com.carboard.domain.entityUtil;

public interface GenericMapper<D, E> {
    D toDto(E e);
    E toEntity(D d);
}