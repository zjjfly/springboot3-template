package com.github.zjjfly.template.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatterBuilder;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
@Configuration
public class JacksonConfig {

    @Bean
    public com.fasterxml.jackson.databind.Module javaTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
        return module.addSerializer(new InstantSerializerWithMilliSecondPrecision());
    }

    public static class InstantSerializerWithMilliSecondPrecision extends InstantSerializer {
        public InstantSerializerWithMilliSecondPrecision() {
            super(InstantSerializer.INSTANCE, false, new DateTimeFormatterBuilder().appendInstant(3).toFormatter(), JsonFormat.Shape.STRING);
        }

    }
}
