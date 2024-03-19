package com.github.zjjfly.template.dto;


import com.github.zjjfly.template.exception.MessageHelper;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.github.zjjfly.template.exception.ExceptionCode.Common.SUCCESS;

/**
 * @author Zi JunJie <a href="https://github.com/zjjfly"/>github</a>
 */
@Data
@NoArgsConstructor
public class Response<T> {

    String code;

    String message;

    T data;

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success() {
        return new Response<>(SUCCESS, MessageHelper.getMessage(SUCCESS), null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(SUCCESS, MessageHelper.getMessage(SUCCESS), data);
    }

    public static Response<Void> error(String code, String message) {
        return new Response<>(code, message);
    }

}
