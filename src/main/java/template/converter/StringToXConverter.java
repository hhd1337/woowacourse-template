package template.converter;

import template.domain.X;

public class StringToXConverter implements Converter<String, X> {
    @Override
    public X convert(String source) {
        return new X(source);
    }
    // Menu enum 으로 이렇게도 사용가능!
//    @Override
//    public Menu convert(String source) {
//        Menu menu = Menu.findBySymbol(source.trim());
//        return menu;
//    }

}