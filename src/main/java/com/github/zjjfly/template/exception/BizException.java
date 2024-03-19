package com.github.zjjfly.template.exception;

import lombok.Getter;

import java.io.Serial;

/**
 * @author Zi JunJie <a href="https://github.com/zjjfly"/>github</a>
 */
@Getter
public class BizException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String errorCode;

    public BizException(String errorCode, Object... args) {
        super(MessageHelper.getMessage(errorCode, args));
        this.errorCode = errorCode;
    }

}
