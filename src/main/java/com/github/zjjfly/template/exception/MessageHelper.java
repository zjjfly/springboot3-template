package com.github.zjjfly.template.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author Zi JunJie <a href="https://github.com/zjjfly"/>github</a>
 */
@Component
@Slf4j
public class MessageHelper {

    static MessageSource messageSource;

    private MessageHelper(MessageSource messageSource) {
        MessageHelper.messageSource = messageSource;
    }

    public static String getMessage(String key) {
        return getMessage(key, null);
    }

    public static String getMessage(String key, Object[] params) {
        try {
            return messageSource == null ? Strings.EMPTY
                    : messageSource.getMessage(key, params, Locale.getDefault());
        } catch (NoSuchMessageException e) {
            log.error(e.getMessage(), e);
        }
        return Strings.EMPTY;
    }

}
