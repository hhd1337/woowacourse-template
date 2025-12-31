package template.controller;

import template.view.InputView;

public class IteratorInputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate iteratorInputTemplate;

    public IteratorInputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.iteratorInputTemplate = iteratorInputTemplate;
    }
}