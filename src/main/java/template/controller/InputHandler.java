package template.controller;

import template.view.InputView;

/**
 * [InputHandler 역할] - InputView로부터 "원시 문자열"을 입력받고, - 입력값을 도메인 타입(LocalDate, LocalDateTime, Crew 등)으로 변환/파싱하며, - 도메인
 * 정책(예: 미래 날짜 수정 불가, 등교일/캠퍼스 운영시간 검증 등)을 검증한다.
 * <p>
 * [입력 재시도 정책] - 모든 입력 메서드는 InputTemplate.execute(...)를 사용한다. - 변환/검증 과정에서 IllegalArgumentException이 발생하면 InputTemplate이
 * 에러 메시지를 출력하고 같은 입력을 재요청한다.
 * <p>
 * [예외 설계 규칙] - 이 클래스 내부에서는 파싱/변환 관련 예외(NumberFormatException, DateTimeException 등)를 IllegalArgumentException으로 변환하여
 * InputTemplate의 재시도 흐름에 통일한다.
 * <p>
 * [설계 의도] - 컨트롤러/서비스 계층이 "유효한 값만 전달받는다"는 전제 하에 비즈니스 흐름에 집중하도록, 입력 형식 검증 및 도메인 정책 검증을 입력 단계에서 강제한다.
 */
public class InputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate inputTemplate;

    public InputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.inputTemplate = iteratorInputTemplate;
    }

    // 메서드 템플릿 설명
//    private X InputView안의 메서드이름과 통일(/* 필요한 파라미터 (LocalDate currentDate)같은거 */) {
//        return inputTemplate.execute(
//                inputView::InputView안의 메서드,  // 1) InputView에서 원시 문자열을 입력받는 메서드 참조
//                value -> {                     // 2) 입력 문자열(value)을 X로 변환/생성하는 로직
//                    // 2-1) (선택) 공백/형식 전처리
//                    // value = value.trim();
//
//                    // 2-2) 변환/생성 (예: new Crew(value), Menu.from(value), parse(value) 등)
//                    // X result = // 변환/생성 로직
//
//                    // 2-3) (선택) 추가 검증 (실패 시 IllegalArgumentException 던지기: 예시는 아래 try catch문 참조!!)
//                    // validate(result);
//
//                    // 2-4) 유효한 결과 반환
//                    // return result;
//                }
//        );
//    }

    // Menu 메서드 템플릿 사용예시
//    public Menu inputMenu() {
//        StringToMenuConverter converter = new StringToMenuConverter();
//        return inputTemplate.execute(
//                inputView::inputMenu,
//                value -> {
//                    value = value.trim();
////                    if (value.equals(Menu.INSERT_ATTENDANCE.getSymbol())) {
////                        validateIsTodayAttendingDay(DateTimes.now().toLocalDate());
////                    }
//                    return converter.convert(value);
//                }
//        );
//    }

    // LocalDateTime 메서드 템플릿 사용예시
//    private LocalDate inputAttendanceUpdateDayInMonth(LocalDate currentDate) {
//        return inputTemplate.execute(
//                inputView::inputAttendanceUpdateDayInMonth,
//                value -> {
//                    try {
//                        int day = Integer.parseInt(value);
//                        LocalDate updateDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), day);
//                        if (updateDate.isAfter(currentDate)) {
//                            throw new IllegalArgumentException("아직 수정할 수 없습니다.");
//                        }
//                        return updateDate;
//                    } catch (NumberFormatException | DateTimeException exception) {
//                        throw new IllegalArgumentException("잘못된 형식을 입력하였습니다.");
//                    }
//                }
//        );
//    }
}