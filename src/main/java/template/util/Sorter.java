package template.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Sorter {
    private Sorter() {
    }

    // 객체 리스트: “int 필드” 기준 오름차순 정렬 (1,2,3 ...)
    public static <T> List<T> sortByIntFieldAsc(List<T> list) {
        List<T> copy = new ArrayList<>(list);

        // 정렬 로직 구현 (int 필드 오름차순)
        copy.sort((o1, o2) -> {
            int a = /* o1에서 int 필드 꺼내기 */;
            int b = /* o2에서 int 필드 꺼내기 */;
            return Integer.compare(a, b);
        });

        return copy;
    }

    // 객체 리스트: “int 필드” 기준 내림차순 정렬 (6,5,4,3 ...)
    public static <T> List<T> sortByIntFieldDesc(List<T> list) {
        List<T> copy = new ArrayList<>(list);

        // 정렬 로직 구현 (int 필드 내림차순)
        copy.sort((o1, o2) -> {
            int a = /* o1에서 int 필드 꺼내기 */;
            int b = /* o2에서 int 필드 꺼내기 */;
            return Integer.compare(b, a);
        });

        return copy;
    }

    // 객체 리스트: “String 필드” 기준 가나다/알파벳 오름차순 (가나다순, abc 순)
    public static <T> List<T> sortByStringFieldAsc(List<T> list) {
        List<T> copy = new ArrayList<>(list);

        // 정렬 로직 구현 (String 필드 오름차순: 가나다/알파벳)
        copy.sort((o1, o2) -> {
            String a = /* o1에서 String 필드 꺼내기 */;
            String b = /* o2에서 String 필드 꺼내기 */;
            return a.compareTo(b);
        });

        return copy;
    }

    // 객체 리스트: “String 필드” 기준 가나다/알파벳 내림차순 (가나다 역순, abc 역순)
    public static <T> List<T> sortByStringFieldDesc(List<T> list) {
        List<T> copy = new ArrayList<>(list);

        // 정렬 로직 구현 (String 필드 내림차순)
        copy.sort((o1, o2) -> {
            String a = /* o1에서 String 필드 꺼내기 */;
            String b = /* o2에서 String 필드 꺼내기 */;
            return b.compareTo(a);
        });

        return copy;
    }

    // 객체 리스트: LocalDate 필드 기준 오름차순 정렬 (날짜 순서대로)
    public static <T> List<T> sortByDateFieldAsc(List<T> list) {
        List<T> copy = new ArrayList<>(list);

        // 정렬 로직 구현 (LocalDate 필드 오름차순)
        copy.sort((o1, o2) -> {
            LocalDate d1 = /* o1에서 LocalDate 필드 꺼내기 */;
            LocalDate d2 = /* o2에서 LocalDate 필드 꺼내기 */;
            return d1.compareTo(d2);
        });

        return copy;
    }

    // 객체 리스트: LocalDate 필드 기준 내림차순 정렬 (날짜 역 순서대로)
    public static <T> List<T> sortByDateFieldDesc(List<T> list) {
        List<T> copy = new ArrayList<>(list);

        // 정렬 로직 구현 (LocalDate 필드 내림차순)
        copy.sort((o1, o2) -> {
            LocalDate d1 = /* o1에서 LocalDate 필드 꺼내기 */;
            LocalDate d2 = /* o2에서 LocalDate 필드 꺼내기 */;
            return d2.compareTo(d1);
        });

        return copy;
    }

    // 1차 기준 + 동률이면 2차 기준 !!!
    public static <T> List<T> sortByScoreDescThenNameAsc(List<T> list) {
        List<T> copy = new ArrayList<>(list);

        // 정렬 로직 구현
        copy.sort((o1, o2) -> {
            int num1 = /* o1 숫자 꺼냄 */;
            int num2 = /* o2 숫자 꺼냄 */;

            // 1차: 점수 내림차순
            int cmp = Integer.compare(num2, num1);
            if (cmp != 0) {
                return cmp;
            }

            // 2차: 이름 오름차순
            String string1 = /* o1 문자열 필드 꺼냄 */;
            String string2 = /* o2 문자열 필드 꺼냄 */;
            return string1.compareTo(string2);
        });

        return copy;
    }




    // 아래 4개 : 정수 리스트 받는 템플릿
    // 정수 리스트를 오름차순(1,2,3...)으로 정렬 후 반환 (원본 유지)
    public static List<Integer> sortIntsAsc(List<Integer> numberList) {
        List<Integer> copy = new ArrayList<>(numberList);

        // 정렬 로직 구현 (오름차순)
        copy.sort((a, b) -> a.compareTo(b));
        // 또는: Collections.sort(copy);

        return copy;
    }

    // 정수 리스트를 내림차순(3,2,1...)으로 정렬 후 반환 (원본 유지)
    public static List<Integer> sortIntsDesc(List<Integer> numberList) {
        List<Integer> copy = new ArrayList<>(numberList);

        // 정렬 로직 구현 (내림차순)
        copy.sort((a, b) -> b.compareTo(a));
        // 또는: copy.sort(Collections.reverseOrder());

        return copy;
    }

    // 정수 리스트를 오름차순으로 정렬 (원본 수정)
    public static void sortIntsAscInPlace(List<Integer> numbers) {
        // 정렬 로직 구현
        Collections.sort(numbers);
    }

    // 정수 리스트를 내림차순으로 정렬 (원본 수정)
    public static void sortIntsDescInPlace(List<Integer> numbers) {
        // 정렬 로직 구현
        numbers.sort(Collections.reverseOrder());
    }

}
