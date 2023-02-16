package com.magellans.cardtrading.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.regex.Pattern;

@Slf4j
public class ConvertUtil {
    public static String removingUnicodeAccents(String str) {
        try {
            if (StringUtils.isEmpty(str))
                return null;
            String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static String removingUnicodeAccentsAndSpace(String str) {
        try {
            if (StringUtils.isEmpty(str))
                return null;
            String temp = removingUnicodeAccents(str);
            return temp != null ? temp.replace(" ", "") : temp;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static String contentBase64ToString(String val) {
        byte[] decodedBytes = Base64.getDecoder().decode(val);
        return new String(decodedBytes);
    }

    public static LocalDate getTradingDatetFromReq(LocalDate tradingDate) {
        if (tradingDate == null) {
            tradingDate = DateTimeUtil.nowLocalDate();
        }
        return tradingDate;
    }

    public static LocalDate getTradingDatetFromReq(String tradingDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateTimeUtil.FORMAT_yyyyMMdd);
        if (tradingDate == null) {
            return DateTimeUtil.nowLocalDate();
        }
        return LocalDate.parse(tradingDate, formatter);
    }

    public static String objToStringJson(Object obj){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e){
            log.error(e.getMessage(), e);
        }
        return "objToStringJson writeValueAsString error";
    }
}
