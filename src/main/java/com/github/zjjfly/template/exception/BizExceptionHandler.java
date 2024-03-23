package com.github.zjjfly.template.exception;

import io.github.wimdeblauwe.errorhandlingspringbootstarter.ApiErrorResponse;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ApiExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


/**
 * @author Zi JunJie <a href="https://github.com/zjjfly"/>github</a>
 */
@Component
public class BizExceptionHandler implements ApiExceptionHandler {

    @Override
    public boolean canHandle(Throwable exception) {
        return exception instanceof BizException;
    }

    @Override
    public ApiErrorResponse handle(Throwable exception) {
        BizException bizException = (BizException) exception;
        return new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                bizException.getErrorCode(),
                bizException.getMessage());
    }
}
