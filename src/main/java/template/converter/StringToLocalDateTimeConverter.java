package template.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter HOUR_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
    private static final DateTimeFormatter MINUTE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter SECOND_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter TIME_SECOND_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter TIME_MINUTE_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    // 만약 /로 구분자가 되어있다면 yyyy-MM-dd HH:mm:ss 를 yyyy/MM/dd HH:mm:ss 로 변경!!

    @Override
    public LocalDateTime convert(String value) {
        // 기본 convert는 "분"까지로 가정 (가장 많이 쓰는 케이스)
        return convertToMinute(value);
    }

    public LocalDate convertToDate(String value) {
        String trimmed = validateAndTrim(value);
        try {
            return LocalDate.parse(trimmed, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("날짜 형식이 올바르지 않습니다. 예) 2025-01-10");
        }
    }

    public LocalDateTime convertToHour(String value) {
        String trimmed = validateAndTrim(value);
        try {
            return LocalDateTime.parse(trimmed, HOUR_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("날짜/시간(시) 형식이 올바르지 않습니다. 예) 2025-01-10 10");
        }
    }

    public LocalDateTime convertToMinute(String value) {
        String trimmed = validateAndTrim(value);
        try {
            return LocalDateTime.parse(trimmed, MINUTE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("날짜/시간(분) 형식이 올바르지 않습니다. 예) 2025-01-10 10:06");
        }
    }

    public LocalDateTime convertToSecond(String value) {
        String trimmed = validateAndTrim(value);
        try {
            return LocalDateTime.parse(trimmed, SECOND_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("날짜/시간(초) 형식이 올바르지 않습니다. 예) 2025-01-10 10:06:30");
        }
    }

    public LocalTime convertToTimeSecond(String value) {
        String trimmed = validateAndTrim(value);
        try {
            return LocalTime.parse(trimmed, TIME_SECOND_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("시간(초) 형식이 올바르지 않습니다. 예) 09:30:15");
        }
    }

    public LocalTime convertToTimeMinute(String value) {
        String trimmed = validateAndTrim(value);
        try {
            return LocalTime.parse(trimmed, TIME_MINUTE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("시간(분) 형식이 올바르지 않습니다. 예) 09:59");
        }
    }
    
    private String validateAndTrim(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("날짜/시간 입력이 비어있습니다.");
        }
        return value.trim();
    }
}
