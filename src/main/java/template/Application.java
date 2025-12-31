package template;

import template.controller.XController;

public class Application {
    public static void main(String[] args) {
        XConfig xConfig = new XConfig();
        XController xController = xConfig.xController();
        xController.process();
    }
}
