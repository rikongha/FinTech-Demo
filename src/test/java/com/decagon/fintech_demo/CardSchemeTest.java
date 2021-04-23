package com.decagon.fintech_demo;

import com.decagon.fintech_demo.entities.CardScheme;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardSchemeTest {
    @Test
    public void issuerTest() {
        assertEquals(CardScheme.VISA, CardScheme.detect("4035501000000008"));
        assertEquals(CardScheme.VISA, CardScheme.detect("4154210000000001"));

        assertEquals(CardScheme.MASTERCARD, CardScheme.detect("5206830000000001"));
        assertEquals(CardScheme.MASTERCARD, CardScheme.detect("5156230000000004"));

        assertEquals(CardScheme.VERVE, CardScheme.detect("506100112345678902"));

        assertEquals(CardScheme.INVALID, CardScheme.detect("0000000000000000"));
    }
}
