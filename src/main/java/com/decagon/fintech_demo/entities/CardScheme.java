package com.decagon.fintech_demo.entities;

import java.util.regex.Pattern;

public enum CardScheme {

    // regex patterns for cards - source: http://stackoverflow.com/questions/72768/how-do-you-detect-credit-card-type-based-on-number
    INVALID,
    VISA("^4[0-9]{12}(?:[0-9]{3}){0,2}$"),
    MASTERCARD("^(?:5[1-5]|2(?!2([01]|20)|7(2[1-9]|3))[2-7])\\d{14}$"),
    VERVE("^((506(0|1))|(507(8|9))|(6500))[0-9]{12,15}$");

    private Pattern pattern;

    CardScheme() {
        this.pattern = null;
    }

    CardScheme(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public static CardScheme detect(String cardNumber) {

        for (CardScheme cardScheme : CardScheme.values()) {
            if (null == cardScheme.pattern) continue;
            if (cardScheme.pattern.matcher(cardNumber).matches()) return cardScheme;
        }

        return INVALID;
    }
}