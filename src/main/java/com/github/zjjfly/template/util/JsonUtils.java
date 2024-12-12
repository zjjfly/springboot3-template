package com.github.zjjfly.template.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.zjjfly.template.config.JacksonConfig;
import lombok.SneakyThrows;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule().addSerializer(new JacksonConfig.InstantSerializerWithMilliSecondPrecision()));

    @SneakyThrows
    public static String toJson(Object obj) {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    @SneakyThrows
    public static <T> T fromJson(String json, Class<T> clazz) {
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    @SneakyThrows
    public static <T> T fromJson(String json, TypeReference<T> tTypeReference) {
        return OBJECT_MAPPER.readValue(json, tTypeReference);
    }

    @SneakyThrows
    public static <T, R> R convertValue(T t, TypeReference<R> tTypeReference) {
        return OBJECT_MAPPER.convertValue(t, tTypeReference);
    }

}
