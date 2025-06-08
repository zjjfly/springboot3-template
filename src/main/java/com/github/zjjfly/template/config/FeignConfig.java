package com.github.zjjfly.template.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
@Configuration
public class FeignConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS) // 连接超时
                .readTimeout(30, TimeUnit.SECONDS)    // 读取超时
                .writeTimeout(30, TimeUnit.SECONDS)   // 写入超时
                .connectionPool(new ConnectionPool(10, 5, TimeUnit.MINUTES)) // 连接池
                .addInterceptor(chain -> {
                    // 自定义拦截器，例如添加请求头
                    return chain.proceed(
                            chain.request().newBuilder()
                                    .addHeader("Custom-Header", "Value")
                                    .build()
                    );
                })
                .build();
    }
}
