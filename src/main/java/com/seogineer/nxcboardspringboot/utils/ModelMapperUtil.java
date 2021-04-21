package com.seogineer.nxcboardspringboot.utils;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ModelMapper Util
 */
public class ModelMapperUtil {

    static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull()).setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * source 에 있는 정보를 origin 으로 옮겨서 반환
     * 이때 데이터 유형과 field 이름이 동일한 데이터만 옮겨진다.
     */
    public static <S, O> O map(S source, Class<O> origin) {
        O result = null;

        try {
            result = modelMapper.map(source, origin);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * source 에 있는 정보를 origin 으로 옮겨서 반환
     * 이때 데이터 유형과 field 이름이 동일한 데이터만 옮겨진다.
     */
    public static <S, O> O map(S source, O origin) {
        try {
            modelMapper.map(source, origin);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return origin;
    }

    /**
     * list 에 있는 정보를 origin 으로 옮겨서 목록으로 반환
     * 이때 데이터 유형과 field 이름이 동일한 데이터만 옮겨진다.
     */
    public static <S, O> List<S> map(Collection<O> list, Class<S> origin) {
        List<S> resultList = new ArrayList<>();

        try {
            resultList = list
                    .stream()
                    .map(item -> map(item, origin))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }

}
