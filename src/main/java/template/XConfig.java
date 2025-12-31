package template;

import template.controller.IteratorInputHandler;
import template.controller.IteratorInputTemplate;
import template.controller.XController;
import template.view.InputView;
import template.view.OutputView;

public class XConfig {

    private InputView inputView;
    private OutputView outputView;
    private IteratorInputTemplate iteratorInputTemplate;
    private IteratorInputHandler iteratorInputHandler;
    private XController xController;

    public InputView inputView() {
        if(inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if(outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public IteratorInputTemplate iteratorInputTemplate() {
        if(iteratorInputTemplate == null) {
            iteratorInputTemplate = new IteratorInputTemplate(outputView());
        }
        return iteratorInputTemplate;
    }

    public IteratorInputHandler iteratorInputHandler() {
        if(iteratorInputHandler == null) {
            iteratorInputHandler = new IteratorInputHandler(inputView(), iteratorInputTemplate());
        }
        return iteratorInputHandler;
    }

    public XController xController() {
        if(xController == null) {
            xController = new XController(iteratorInputHandler(), outputView());
        }
        return xController;
    }
}
