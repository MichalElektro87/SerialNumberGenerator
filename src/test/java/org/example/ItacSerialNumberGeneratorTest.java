package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItacSerialNumberGeneratorTest {

    private ItacSerialNumberGenerator itacSerialNumberGenerator = null;
    public ItacSerialNumberGeneratorTest() {
        itacSerialNumberGenerator = new ItacSerialNumberGenerator("A00U0Z", 10);
        itacSerialNumberGenerator.generateSerialNumbers();
    }

    @Test
    public void verifierSerialNumber() {
        assertEquals("A00U0Z", itacSerialNumberGenerator.getSerialNumbers().get(0));
    }

    @Test
    public void verifierOverflowNumber() {
        assertEquals(1, itacSerialNumberGenerator.getOverflowCounter());
    }

}