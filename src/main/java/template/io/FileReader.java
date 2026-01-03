package template.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import template.converter.StringToLocalDateTimeConverter;

public class FileReader {
    private static final String FILE_NAME = "products.md";
    private static final String FILE_NAME_2 = "promotions.md";
    private static final String CSV_FILE_NAME = "attendances.csv";
    private static final String DELIMITER = ",";

    // 파일을 읽어오기
    public void CsvFileReader() {
        // inputStream은 스트림이라 한번 읽으면 내부 데이터가 소모된다. 재활용 불가
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
        if (inputStream == null) {
            throw new IllegalArgumentException(FILE_NAME + " 파일이 없습니다.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<String[]> rows = reader.lines()
                    .skip(1) // 헤더 스킵
                    .map(line -> line.split(DELIMITER))
                    .toList();

            rows.forEach(row -> System.out.println(Arrays.toString(row)));

        } catch (IOException e) {
            throw new IllegalArgumentException(FILE_NAME + " 파일을 읽는 과정에서 오류가 발생했습니다.");
        }
    }

    // 파일을 읽어서 객체로 만들기
    public void CsvFileToObject() {
        // inputStream은 스트림이라 한번 읽으면 내부 데이터가 소모된다. 재활용 불가
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
        if (inputStream == null) {
            throw new IllegalArgumentException(FILE_NAME + " 파일이 없습니다.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<Product> rows = reader.lines()
                    .skip(1) // 헤더 스킵
                    .filter(line -> !line.isBlank()) // 빈줄 건너뛰기
                    .map(line -> line.split(DELIMITER))
                    .map(row ->
                            new Product(
                                    row[0].trim(),
                                    row[1].trim(),
                                    row[2].trim(),
                                    row[3].trim()))
                    .toList();

            rows.forEach(System.out::println);

        } catch (IOException e) {
            throw new IllegalArgumentException(FILE_NAME + "파일을 읽는 과정에서 오류가 발생했습니다.");
        }
    }

    // promotion 객체 만들기, LocalDate 객체로 파싱도 포함
    public void promotionReader() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME_2);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<Promotion> rows = reader.lines()
                    .skip(1)
                    .filter(line -> !line.isBlank())
                    .map(line -> line.split(DELIMITER))
                    .map(line ->
                            new Promotion(
                                    line[0].trim(),
                                    line[1].trim(),
                                    line[2].trim(),
                                    line[3].trim(),
                                    line[4].trim()
                            ))
                    .toList();

            rows.forEach(System.out::println);

        } catch (IOException e) {
            throw new IllegalArgumentException(FILE_NAME + "파일을 읽는 과정에서 오류가 발생했습니다.");
        }
    }

    // LocalDateTime으로 파싱하는 객체
    public void makeAttendances() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CSV_FILE_NAME);
        StringToLocalDateTimeConverter LocalDateTimeConverter = new StringToLocalDateTimeConverter();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<AttendancesDto> rows = reader.lines()
                    .filter(line -> !line.isBlank())
                    .map(line -> line.split(DELIMITER))
                    .map(row ->
                            new AttendancesDto(
                                    row[0].trim(),
                                    LocalDateTimeConverter.convertToMinute(row[1].trim())
                                    // 내가 만든 parsing 메서드를 이용해서 파싱했음, 2025-02-05T10:06 이런식으로 T가 없으면 무조건 파싱해야함
                            ))
                    .toList();

            rows.forEach(System.out::println);
        } catch (IOException e) {
            throw new IllegalArgumentException(CSV_FILE_NAME + "파일을 읽는 과정에서 문제가 발생했습니다.");
        }
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.CsvFileReader();
        fileReader.CsvFileToObject();
        fileReader.promotionReader();
        fileReader.makeAttendances();
    }

    public record AttendancesDto(String name, LocalDateTime enterTime) {
        @Override
        public String toString() {
            return "AttendancesDto{" +
                    "name='" + name + '\'' +
                    ", enterTime=" + enterTime +
                    '}';
        }
    }

    public record Product(String name, String price, String quantity, String promotion) {
        // price, quantity는 int로 받아야 할거 같은데... 그건 그때 가서 생각하자.
        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price='" + price + '\'' +
                    ", quantity='" + quantity + '\'' +
                    ", promotion='" + promotion + '\'' +
                    '}';
        }
    }

    public record Promotion(String name, int buy, int get, LocalDate startDate, LocalDate endDate) {
        private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        public Promotion(String name, String buy, String get, String startDate, String endDate) {
            this(
                    name,
                    Integer.parseInt(buy),
                    Integer.parseInt(get),
                    LocalDate.parse(startDate.trim()), // 2024-12-31 이런 형식이면 기본파싱 메서드 사용, 혹시모르니 trim() 필수
                    LocalDate.parse(endDate.trim(), DATE_FORMATTER) // 2024/12/24 이런 형식이면 DATE_FORMATTER을 사용해야 함.
            );
        }

        @Override
        public String toString() {
            return "Promotion{" +
                    "name='" + name + '\'' +
                    ", buy=" + buy +
                    ", get=" + get +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    '}';
        }
    }
}
