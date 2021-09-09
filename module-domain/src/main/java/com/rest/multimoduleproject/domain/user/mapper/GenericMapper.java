package com.rest.multimoduleproject.domain.user.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface GenericMapper<D, E> {

    D toDto(E e);
    E toEntity(D d);
    List<D> toDto(List<E> e);
    List<E> toEntity(List<D> d);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(D dto, @MappingTarget E entity);

}
