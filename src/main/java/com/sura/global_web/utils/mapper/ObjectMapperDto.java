package com.sura.global_web.utils.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

@Service
public class ObjectMapperDto {

    private final ObjectMapper objectMapper;

    public ObjectMapperDto(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Convierte un objeto de un tipo a otro.
     * @param source Objeto de origen.
     * @param targetClass Clase objetivo a la que se convertirá.
     * @return Objeto convertido.
     */
    public <T> T map(Object source, Class<T> targetClass) {
        return objectMapper.convertValue(source, targetClass);
    }


}
