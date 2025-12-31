package template.view;

import template.util.ErrorMessage;

public class OutputView {

    public void printErrorMessage(Exception exception) {
        System.out.println(ErrorMessage.PREFIX + exception.getMessage());
    }
}
