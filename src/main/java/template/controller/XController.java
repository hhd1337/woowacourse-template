package template.controller;

import template.view.OutputView;

public class XController {

    private final InputHandler inputHandler;
    private final OutputView outputView;

    public XController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void process() {
        // 만약 메뉴가 있고 Q를 입력받기 전까지 반복되어야 한다면 추가 (1/2)
//        Menu menu;
//        do {
//            outputView.printHelloAndMenu(DateTimes.now());
//            menu = inputHandler.inputMenu();
//            run(menu, crewCatalog, crewAttendances, DateTimes.now());
//        } while (menu != Menu.QUIT);
    }

    // 메뉴가 있고 Q를 입력받기 전까지 반복되어야 한다면 추가 (2/2)
//    private void run(Menu menu) {
//        if (menu == Menu.A) {
//            // runA();
//        }
//        if (menu == Menu.B) {
//            // runB();
//        }
//        if (menu == Menu.C) {
//            // runC();
//        }
//        if (menu == Menu.D) {
//            // runD();
//        }
//    }
}
