package com.ssg.webmvc.member.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

// ModelMapper를 이용한 객체 간 매핑을 도와주는 유틸리티 클래스
public enum MapperUtil {
    INSTANCE;
    private ModelMapper modelMapper;
    MapperUtil() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public ModelMapper get(){
        return modelMapper;
    }
}
