package com.example.yuanyuanlai.notebook.utils;

public class CheckUtils {

    public static void checkNull(Object object, String message) {
        if (object == null) throw new IllegalStateException(message);
    }

    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

}
