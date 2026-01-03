package template.view.formatter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class LocalDateTimeFormatter {
    // 특정 날짜와 시간으로 객체 생성
    private static LocalDateTime dateTime = LocalDateTime.of(2023, Month.APRIL, 10, 15, 30);

    private static LocalDate date = LocalDate.of(2026, Month.JANUARY, 3);
    private static LocalTime time = LocalTime.of(9, 34);
    private static LocalDateTime dateTime2 = LocalDateTime.of(date, time);

    // "----년 --월 --일 -요일 --:--:--" 포맷 문자열 반환
    public static String localDateTimeToStringFormat(LocalDateTime dateTime) {
        //String dow = LocalDateTimeToDayofWeekKorShort(dateTime); // 예: "월"
        String dow = LocalDateTimeToDayofWeekKorFull(dateTime); // 예: "월요일"

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "yyyy년 MM월 dd일 " + dow + " HH:mm:ss", // 24시 단위
                // "yyyy년 MM월 dd일 " + dow + " HH:mm:ss:SSSSSS", // 24시 단위, 밀리, 나노초까지 출력 (S개수 조절)
                // "yyyy년 MM월 dd일 " + dow + " a hh:mm:ss", // 12시 단위
                // "yyyy년 MM월 dd일 " + dow + " a hh:mm:ss", // 12시 단위 "오전"/"오후" 추가
                Locale.KOREAN
        );
        return dateTime.format(formatter);
    }

    // "09:13" ... 반환
    public static String localTimeToStringFormat(LocalTime time) {
        // return time.format(DateTimeFormatter.ofPattern("a hh:mm")); // hh 라서 12시 기준
        return time.format(DateTimeFormatter.ofPattern("HH:mm")); // HH라서 24시 기준
    }

    // "월", "화", "수" ... 반환
    public static String LocalDateTimeToDayofWeekKorShort(LocalDateTime dateTime) {
        DayOfWeek dayOfWeek = dateTime.toLocalDate().getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
    }

    // "월요일","화요일","수요일"... 반환
    public static String LocalDateTimeToDayofWeekKorFull(LocalDateTime dateTime) {
        DayOfWeek dayOfWeek = dateTime.toLocalDate().getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);
    }

    // 년_월_일_시간_변경 후 반환하는 메소드 (웬만하면 호출하지말고 with, plus, minus 메소드 쓰기)
    public static LocalDateTime changeCurrentDateTime(LocalDateTime currDateTime, int changeNum) {
        LocalDateTime changedDateTime;
        // 년도 변경
        changedDateTime = currDateTime.withYear(changeNum);
        // 월 변경
        changedDateTime = currDateTime.withMonth(changeNum);
        // 일 변경, 2027-12-10T16:40:12.561213, 해당 월에 변경하고자 하는 날이 없으면 예외 발생
        changedDateTime = currDateTime.withDayOfMonth(changeNum); // currDateTime.withDayOfMonth(1); 은 해당 월 첫날 반환
        // 시간 변경
        changedDateTime = currDateTime.withHour(changeNum);
        changedDateTime = currDateTime.withMinute(changeNum);
        changedDateTime = currDateTime.withSecond(changeNum);

        return changedDateTime;
    }

    // 이번 달 1일부터 오늘까지(포함) 일 단위로 순회
    public static void iterateFromStartOfThisMonthToToday(LocalDate today) {
        LocalDate date = today.withDayOfMonth(1);

        while (!date.isAfter(today)) { // 오늘까지 포함!!!!! !date.isAfter(today.plusDays(1))

            // 로직 구현!!!!!!!!!!!!!!!!!!!!!!!!!!

            date = date.plusDays(1);
        }
    }

    // 두 날짜 사이의 일(day) 차이
    public static long diffDays(LocalDate a, LocalDate b) {
        return Math.abs(ChronoUnit.DAYS.between(a, b));
    }

    // 두 시간 사이의 초(second) 차이
    public static long diffSeconds(LocalTime a, LocalTime b) {
        return Math.abs(ChronoUnit.SECONDS.between(a, b));
    }

    public static long diffMinutes(LocalTime a, LocalTime b) {
        return Math.abs(ChronoUnit.MINUTES.between(a, b));
    }

    public static long diffHours(LocalTime a, LocalTime b) {
        return Math.abs(ChronoUnit.HOURS.between(a, b));
    }
}
