package com.magellans.cardtrading.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DateTimeUtil {
    public static final String FORMAT_TIME = "HH:MM:SS";
    public static final String FORMAT_TIME_Hms = "HH:mm:ss";
    public static final String FORMAT_TIME_Hm = "HH:mm";
    public static final String FORMAT_ddMMyyyy = "dd/MM/yyyy";
    public static final String FORMAT_DDMMYYYY = "DD/MM/YYYY";
    public static final String FORMAT_yyyyMMdd = "yyyy-MM-dd";
    public static final String FORMAT_DDMMYYYYHHMMSS = "DD/MM/YYYY HH:MM:SS";
    public static final String FORMAT_ddMMyyyyHHmm = "dd/MM/yyyy HH:mm";
    public static final String FORMAT_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_yyyyMMddHHmmssfff = "yyyy-MM-dd HH:mm:ss.fff";
    public static final String FORMAT_YMDHMS = "yyyyMMddhh24muss";
    public static final String FORMAT_ddMMyyyyHHmmssSSS = "ddMMyyyyHHmmssSSS";
    public static final String FORMAT_YMD = "yyyyMMdd";
    public static final String FORMAT_YM = "yyyyMM";


    public static Date minusMonths(Date source, int month) {
        if (source == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(source);
        cal.set(Calendar.MONTH, month);
        return cal.getTime();
    }

    public static String formatStandardDuration(Duration duration) {
        if (duration == null)
            return null;

        if (duration.isNegative())
            return "-" + DurationFormatUtils.formatDuration(duration.toMillis() * -1, "HH:mm:ss");
        return DurationFormatUtils.formatDuration(duration.toMillis(), "HH:mm:ss");
    }

    public static String formatStandardDuration(Long durationMilis) {
        if (durationMilis == null)
            return null;

        Duration duration = Duration.ofMillis(durationMilis);

        return formatStandardDuration(duration);
    }

    public static Long stringHMSToMillis(String strHMS) {
        if (strHMS == null)
            return null;

        String[] arrStr = strHMS.split(":");
        if (arrStr.length == 3) {
            int h = Integer.parseInt(arrStr[0]);
            int m = Integer.parseInt(arrStr[1]);
            int s = Integer.parseInt(arrStr[2]);
            long mH = h * (60 * (60 * 1000l));
            long mM = m * (60 * 1000l);
            long mS = s * 1000l;
            return (mH + mM + mS);
        } else
            return null;
    }


    public static int convertDateAndHourToHour(int day, int hour) {
        int rs = 0;

        rs = day * 24 + hour;

        return rs;
    }

    public static String formatStringToHHmmss(int strHMS) {
        int h = strHMS / (3600);
        int m = (strHMS % (3600)) / 60;
        int s = (strHMS % (3600)) % 60;
        String strH = String.format("%02d", h);
        String strM = String.format("%02d", m);
        String strS = String.format("%02d", s);
        return strH + ":" + strM + ":" + strS;
    }

    public static String currentHMS() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    }

    public static Date timestampToDate(Timestamp stamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(stamp.getTime());
        return cal.getTime();
    }

    public static String dateToString(Date date, String strFormat) {
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormat);
            return simpleDateFormat.format(date);
        } else
            return null;
    }

    public static String longToString(Long millis, String strFormat) {
        if (millis != null && millis > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormat);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(millis);
            return simpleDateFormat.format(cal.getTime());
        } else
            return null;
    }

    public static Date stringToDate(String dateString, String strFormat) {
        try {
            if (dateString == null)
                return null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormat);
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    // //////////////////////////////////////////////////////

    /**
     * Check string format with current format locale
     *
     * @param strSource String to check
     * @return boolean true if strSource represent a date, otherwise false
     */
    // //////////////////////////////////////////////////////
    public static boolean isDate(String strSource) {
        return isDate(strSource, DateFormat.getDateInstance());
    }

    // //////////////////////////////////////////////////////

    /**
     * Check string format
     *
     * @param strSource String
     * @param strFormat Format to check
     * @return boolean true if strSource represent a date, otherwise false
     */
    // //////////////////////////////////////////////////////
    public static boolean isDate(String strSource, String strFormat) {
        SimpleDateFormat fmt = new SimpleDateFormat(strFormat);
        fmt.setLenient(false);
        return isDate(strSource, fmt);
    }

    // //////////////////////////////////////////////////////

    /**
     * Check string format
     *
     * @param strSource String
     * @param fmt       Format to check
     * @return boolean true if strSource represent a date, otherwise false
     */
    // //////////////////////////////////////////////////////
    public static boolean isDate(String strSource, DateFormat fmt) {
        try {
            if (fmt.parse(strSource) == null)
                return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // //////////////////////////////////////////////////////

    /**
     * Convert string to date using current format locale
     *
     * @param strSource String to convert
     * @return Date converted, null if conversion failure
     */
    // //////////////////////////////////////////////////////
    public static Date toDate(String strSource) {
        return toDate(strSource, DateFormat.getDateInstance());
    }

    // //////////////////////////////////////////////////////

    /**
     * Convert string to date
     *
     * @param strSource String to convert
     * @param strFormat Format to convert
     * @return Date converted, null if conversion failure
     */
    // //////////////////////////////////////////////////////
    public static Date toDate(String strSource, String strFormat) {
        SimpleDateFormat fmt = new SimpleDateFormat(strFormat);
        fmt.setLenient(false);
        return toDate(strSource, fmt);
    }

    // //////////////////////////////////////////////////////

    /**
     * Convert string to date
     *
     * @param strSource String to convert
     * @param fmt       Format to convert
     * @return Date converted, null if conversion failure
     */
    // //////////////////////////////////////////////////////
    public static Date toDate(String strSource, DateFormat fmt) {
        try {
            return fmt.parse(strSource);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    // //////////////////////////////////////////////////////

    /**
     * Add date value by second
     *
     * @param dt     Date Date to add
     * @param iValue int value to add
     * @return Date after add
     */
    // //////////////////////////////////////////////////////
    public static Date addSecond(Date dt, int iValue) {
        return add(dt, iValue, Calendar.SECOND);
    }

    // //////////////////////////////////////////////////////

    /**
     * Add date value by minute
     *
     * @param dt     Date Date to add
     * @param iValue int value to add
     * @return Date after add
     */
    // //////////////////////////////////////////////////////
    public static Date addMinute(Date dt, int iValue) {
        return add(dt, iValue, Calendar.MINUTE);
    }

    // //////////////////////////////////////////////////////

    /**
     * Add date value by hour
     *
     * @param dt     Date Date to add
     * @param iValue int value to add
     * @return Date after add
     */
    // //////////////////////////////////////////////////////
    public static Date addHour(Date dt, int iValue) {
        return add(dt, iValue, Calendar.HOUR);
    }

    // //////////////////////////////////////////////////////

    /**
     * Add date value by day
     *
     * @param dt     Date Date to add
     * @param iValue int value to add
     * @return Date after add
     */
    // //////////////////////////////////////////////////////
    public static Date addDay(Date dt, int iValue) {
        return add(dt, iValue, Calendar.DATE);
    }

    // //////////////////////////////////////////////////////

    /**
     * Add date value by month
     *
     * @param dt     Date Date to add
     * @param iValue int value to add
     * @return Date after add
     */
    // //////////////////////////////////////////////////////
    public static Date addMonth(Date dt, int iValue) {
        return add(dt, iValue, Calendar.MONTH);
    }

    // //////////////////////////////////////////////////////

    /**
     * Add date value by year
     *
     * @param dt     Date Date to add
     * @param iValue int value to add
     * @return Date after add
     */
    // //////////////////////////////////////////////////////
    public static Date addYear(Date dt, int iValue) {
        return add(dt, iValue, Calendar.YEAR);
    }

    // //////////////////////////////////////////////////////

    /**
     * Add date value
     *
     * @param dt     Date Date to add
     * @param iValue int value to add
     * @param iType  type of unit
     * @return Date after add
     */
    // //////////////////////////////////////////////////////
    public static Date add(Date dt, int iValue, int iType) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(dt);
        cld.add(iType, iValue);
        return cld.getTime();
    }

    public static int getHoursFromDate(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld.get(Calendar.HOUR_OF_DAY);
    }

    public static int getDayFromDate(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMinuteFromDate(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld.get(Calendar.MINUTE);
    }

    public static Date stringToDate(String str) {
        if (StringUtils.isEmpty(str))
            return null;
        DateFormat df = new SimpleDateFormat(FORMAT_DDMMYYYYHHMMSS);
        try {
            return df.parse(str);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static LocalDateTime stringToLocalDateTime(String str) {
        if (StringUtils.isEmpty(str))
            return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm:ss");
        return LocalDateTime.parse(str, formatter);
    }

    public static String dateToString(Date date) {
        if (date == null)
            return null;
        DateFormat df = new SimpleDateFormat(FORMAT_DDMMYYYYHHMMSS);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return df.format(cal.getTime());
    }

    // //////////////////////////////////////////////////////

    /**
     * Format date object
     *
     * @param dtImput    date to format
     * @param strPattern format pattern
     * @return formatted string
     * @author Thai Hoang Hiep
     */
    // //////////////////////////////////////////////////////
    public static String format(Date dtImput, String strPattern) {
        if (dtImput == null)
            return null;
        SimpleDateFormat fmt = new SimpleDateFormat(strPattern);
        return fmt.format(dtImput);
    }

    public static String getTimeAgo(Date now, Date past) {
        try {
            // milliseconds ago
            // long milliseconds = TimeUnit.MILLISECONDS.toMillis(now.getTime()
            // - past.getTime());
            long days = TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());
            long hours = TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
            long minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
            long seconds = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());
            if (days > 0 && hours > 0) {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(past.getTime());
                return DateTimeUtil.dateToString(cal.getTime(), DateTimeUtil.FORMAT_ddMMyyyyHHmm);
            }
            if (hours > 0 && minutes > 0) {
                return hours + " giá»� " + (minutes - (hours * 60)) + " phÃºt trÆ°á»›c";
            }

            if (minutes > 0 && seconds > 0) {
                return minutes + " phÃºt trÆ°á»›c";
            }

            if (seconds > 0) {
                return seconds + " giÃ¢y trÆ°á»›c";
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "N/A";
    }

    public static Date now() {
        return Calendar.getInstance().getTime();
    }

    public static LocalDateTime nowLocalDateTime() {
        return LocalDateTime.now();
    }

    public static LocalDateTime nowLocalDateTimeDMY() {
        return LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static LocalDateTime toLocalDateTimeDMY(LocalDateTime localDateTime) {
        return localDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static String localDatetimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    public static LocalDate nowLocalDate() {
        return LocalDate.now();
    }

    public static Date[] getDaysOfWeek(Date refDate, int firstDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        Date[] daysOfWeek = new Date[7];
        for (int i = 0; i < 7; i++) {
            daysOfWeek[i] = calendar.getTime();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return daysOfWeek;
    }

    public static Date[] getDaysOfMonth(int refMonth, int refYear) {
        Calendar calendar = Calendar.getInstance();
        int date = 1;
        calendar.set(refYear, refMonth, date, 00, 00, 00);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date[] days = new Date[maxDay];

        for (int i = date; i <= maxDay; i++) {
            calendar.set(Calendar.DAY_OF_MONTH, i);
            days[i - 1] = calendar.getTime();
        }
        return days;
    }

    public static Date[] getDaysOfMonth(int refMonth) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int date = 1;
        calendar.set(year, refMonth, date, 00, 00, 00);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date[] days = new Date[maxDay];

        for (int i = date; i <= maxDay; i++) {
            calendar.set(Calendar.DAY_OF_MONTH, i);
            days[i - 1] = calendar.getTime();
        }
        return days;
    }

    public static Date[] getFromDateToDateByType(String dayType) {
        Date[] dates = new Date[2];
        if ("d".equals(dayType)) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 00);
            cal.set(Calendar.MINUTE, 00);
            cal.set(Calendar.SECOND, 00);
            dates[0] = cal.getTime();
            cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            dates[1] = cal.getTime();
        }
        if ("w".equals(dayType)) {
            Calendar cal = Calendar.getInstance();
            Date[] dTemp = getDaysOfWeek(cal.getTime(), Calendar.MONDAY);
            dates[0] = dTemp[0];
            cal.setTime(dTemp[dTemp.length - 1]);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            dates[1] = cal.getTime();
        }
        if ("m".equals(dayType)) {
            Calendar cal = Calendar.getInstance();
            Date[] dTemp = getDaysOfMonth(cal.get(Calendar.MONTH), cal.get(Calendar.YEAR));
            dates[0] = dTemp[0];
            cal.setTime(dTemp[dTemp.length - 1]);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            dates[1] = cal.getTime();
        }
        return dates;
    }

    public static Date longToDate(String millis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(Long.parseLong(millis));
        return cal.getTime();
    }

    public static Date longToDate(Long millis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        return cal.getTime();
    }

    public static Date convertTimeZone(Date date, String fromTimeZone, String toTimeZone) {
        ZoneId fromZoneId = ZoneId.of(fromTimeZone);
        ZoneId toZoneId = ZoneId.of(toTimeZone);
        LocalDateTime fromDateTime = date.toInstant().atZone(fromZoneId).toLocalDateTime();
        ZonedDateTime fromDate = ZonedDateTime.of(fromDateTime, fromZoneId);
        ZonedDateTime toDate = fromDate.withZoneSameInstant(toZoneId);
        Calendar cal = Calendar.getInstance();
        cal.set(toDate.getYear(), toDate.getMonthValue() - 1, toDate.getDayOfMonth(), toDate.getHour(),
                toDate.getMinute(), toDate.getSecond());
        return cal.getTime();
    }

    public static Date convertToUTC(Date date) {
        ZoneId fromZoneId = ZoneId.of(TimeZone.getDefault().getID());
        ZoneId toZoneId = ZoneId.of(TimeZone.getTimeZone("UTC").getID());
        LocalDateTime fromDateTime = date.toInstant().atZone(fromZoneId).toLocalDateTime();
        ZonedDateTime fromDate = ZonedDateTime.of(fromDateTime, fromZoneId);
        ZonedDateTime toDate = fromDate.withZoneSameInstant(toZoneId);
        Calendar cal = Calendar.getInstance();
        cal.set(toDate.getYear(), toDate.getMonthValue() - 1, toDate.getDayOfMonth(), toDate.getHour(),
                toDate.getMinute(), toDate.getSecond());
        return cal.getTime();
    }

    public static Integer calculateAge(Date birthOfDate) {
        if (birthOfDate != null) {
            LocalDate lBirthOfDate = birthOfDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return Period.between(lBirthOfDate, LocalDate.now()).getYears();
        }
        return null;
    }

    public static Date toDate(Date date, int hh, int mm, int ss) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, hh);
        cal.set(Calendar.MINUTE, mm);
        cal.set(Calendar.SECOND, ss);
        return cal.getTime();
    }

    public static Date toShortDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        return cal.getTime();
    }

    public static Date[] daysOfMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int date = 1;
        calendar.set(year, month, date, 00, 00, 00);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date[] daysOfmonth = new Date[maxDay];
        for (int i = 0; i < maxDay; i++) {
            calendar.set(year, month, i + 1);
            daysOfmonth[i] = calendar.getTime();
        }
        return daysOfmonth;
    }

    public static Date[] dayOfWeek(int index) {
        LocalDate previousMonday = LocalDate.now(ZoneId.systemDefault())
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        Date mondayDate = Date.from(previousMonday.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Calendar c = Calendar.getInstance();
        c.setTime(mondayDate);
        c.add(Calendar.DAY_OF_WEEK, index * 7);
        c.set(Calendar.HOUR_OF_DAY, 00);
        c.set(Calendar.MINUTE, 00);
        c.set(Calendar.SECOND, 00);
        Date[] arrDate = new Date[7];
        arrDate[0] = c.getTime();
        for (int i = 0; i < 6; i++) {
            c.add(Calendar.DATE, 1);
            arrDate[i + 1] = c.getTime();
        }
        c.getTime();
        return arrDate;
    }

    public static long getMinDate(long[] longDate) {
        long nhonhat = longDate[0];
        long lonnhat = longDate[0];
        for (int i = 1; i < longDate.length; i++) {
            if (longDate[i] > lonnhat)
                lonnhat = longDate[i];
            if (longDate[i] < nhonhat)
                nhonhat = longDate[i];
        }
        return nhonhat;
    }

    public static long getMaxDate(long[] longDate) {
        long nhonhat = longDate[0];
        long lonnhat = longDate[0];
        for (int i = 1; i < longDate.length; i++) {
            if (longDate[i] > lonnhat)
                lonnhat = longDate[i];
            if (longDate[i] < nhonhat)
                nhonhat = longDate[i];
        }
        return lonnhat;
    }

    public static Date toDate(Date source, String hms, Integer addMinute) {
        String[] arrHms = hms.split(":");
        Calendar cal = Calendar.getInstance();
        cal.setTime(source);
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(arrHms[0]));
        cal.set(Calendar.MINUTE, Integer.parseInt(arrHms[0]));
        cal.set(Calendar.SECOND, Integer.valueOf(arrHms[0]));
        if (addMinute != null) {
            cal.add(Calendar.MINUTE, addMinute);
        }
        return cal.getTime();
    }

    public static Date toDate(Date source, Integer addMinute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(source);
        if (addMinute != null) {
            cal.add(Calendar.MINUTE, addMinute);
        }
        return cal.getTime();
    }

    public static Date localDateTimeToDate(LocalDateTime ldt) {
        if (ldt != null) {
            ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
            return Date.from(zdt.toInstant());
        }
        return null;
    }

    public static LocalDateTime dateLocalDateTime(Date d) {
        if (d != null) {
            return Instant.ofEpochMilli(d.getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        }
        return null;
    }

    public static String[] ymdToArray(Date date) {
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            String[] arr = new String[3];
            arr[0] = cal.get(Calendar.YEAR) + "";
            arr[1] = (cal.get(Calendar.MONTH) + 1) + "";
            arr[2] = cal.get(Calendar.DAY_OF_MONTH) + "";
            return arr;
        } else
            return null;
    }
    

    public static String changePatternStringDate(String strDate, String oldPattern, String newPattern) {
        return dateToString(stringToDate(strDate, oldPattern), newPattern);
    }

    public static LocalDateTime localDateToDateTime235959(LocalDate d) {
        if (d != null) {
            return d.atTime(23,59,59);
        }
        return null;
    }
}
