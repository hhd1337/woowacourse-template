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

    }
}
