package com.goldenCollar.InMyHouse.mapper;

public interface EntityDtoMapper<E, D> {
    E dtoToEntity (D dto);
    D entityToDto (E entity);

}
