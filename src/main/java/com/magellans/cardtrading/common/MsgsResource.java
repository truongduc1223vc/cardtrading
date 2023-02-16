package com.magellans.cardtrading.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Component
@Slf4j
public class MsgsResource {

    private static MsgsResource instance;
    private static MessageSource messageSource;
    @Autowired
    private ApplicationContext applicationContext;

    public static String getI18N(String key) {
        try {
            if (instance != null) {
                if (messageSource == null)
                    messageSource = instance.applicationContext.getBean(MessageSource.class);
                Locale locale = LocaleContextHolder.getLocale();
                return messageSource.getMessage(key, null, locale);
            } else {
                return key;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return key;
        }
    }

    public static String getI18N(String key, Object... params) {
        try {
            if (instance != null) {
                if (messageSource == null)
                    messageSource = instance.applicationContext.getBean(MessageSource.class);
                Locale locale = LocaleContextHolder.getLocale();
                return messageSource.getMessage(key, params, locale);
            } else {
                return key;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return key;
        }
    }

    @PostConstruct
    public void registerInstance() {
        instance = this;
    }

    public String getMessage(String key) {
        try {
            Locale locale = LocaleContextHolder.getLocale();
            return messageSource.getMessage(key, null, locale);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return key;
        }
    }

    public String getMessage(String key, Object[] params) {
        try {
            Locale locale = LocaleContextHolder.getLocale();
            return messageSource.getMessage(key, params, locale);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return key;
        }
    }
}
