package com.github.zjjfly.template.exception;

import com.github.zjjfly.template.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author Zi JunJie <a href="https://github.com/zjjfly"/>github</a>
 */
@RestControllerAdvice
@Slf4j
public class AppExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public Response<Void> handleBizException(BizException bizException) {
        return Response.error(bizException.getErrorCode(), bizException.getMessage());
    }

}
