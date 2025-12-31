package template.converter;

import template.util.ErrorMessage;

public class StringToIntConverter implements Converter<String, Integer>{
    @Override
    public Integer convert(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 정수 형식으로 입력해주세요.");
        }
    }

    public int convertPositiveInt(String value) {
        int number = convert(value);

        if (number <= 0) {
            throw new IllegalArgumentException("수량은 1 이상의 정수여야 합니다.");
        }
        return number;
    }
}
