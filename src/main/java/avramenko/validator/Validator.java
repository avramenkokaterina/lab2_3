package main.java.avramenko.validator;

public class Validator {
    private final static String CHOICE_EXCEPTION_MENU = "There is no such menu item. Enter number from 1 to 3.";
    private final static String BAD_LENGTH = "Bad length. Input length between 3 to 20.";

    public String checkMenuChoice(int number) {
        if (number < 1 || number > 3) {
            return CHOICE_EXCEPTION_MENU;
        }
        return "";
    }

    public String checkLength(int number) {
        if (number < 3 || number > 20) {
            return BAD_LENGTH;
        }
        return "";
    }
}
