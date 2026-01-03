package template.domain;

import java.util.Arrays;

public enum Menu {
    A("1"), // MENU_A를 기능 이름으로 바꾸기
    B("2"), // MENU_B 기능 이름으로 바꾸기
    C("3"), // MENU_C 기능 이름으로 바꾸기
    D("4"), // MENU_D 기능 이름으로 바꾸기
    QUIT("Q");   // QUIT이 없다면 지우기!! 그리고 Q가 아니라면 이름 바꾸기

    private final String symbol;

    Menu(String symbol) {
        this.symbol = symbol;
    }

    public static Menu findBySymbol(String symbol) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 형식을 입력하였습니다."));
    }

    public String getSymbol() {
        return this.symbol;
    }
}
