package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RadioTest {
    private Radio radio;

    @BeforeEach
    void setUp() {
        radio = new Radio();
    }

    @Test
    void testIncreaseVolume() {
        radio.setVolume(0);
        radio.increaseVolume();
        assertEquals(1, radio.getVolume());

        radio.setVolume(99);
        radio.increaseVolume();
        assertEquals(100, radio.getVolume());

        radio.setVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getVolume());
    }

    @Test
    void testDecreaseVolume() {
        radio.setVolume(100);
        radio.decreaseVolume();
        assertEquals(99, radio.getVolume());

        radio.setVolume(1);
        radio.decreaseVolume();
        assertEquals(0, radio.getVolume());

        radio.setVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getVolume());
    }

    @Test
    void testNextStation() {
        radio.setStation(9);
        radio.nextStation();
        assertEquals(0, radio.getStation());

        radio.setStation(5);
        radio.nextStation();
        assertEquals(6, radio.getStation());
    }

    @Test
    void testPreviousStation() {
        radio.setStation(0);
        radio.previousStation();
        assertEquals(9, radio.getStation());

        radio.setStation(5);
        radio.previousStation();
        assertEquals(4, radio.getStation());
    }

    @Test
    void testSetStation() {
        radio.setStation(3);
        assertEquals(3, radio.getStation());

        radio.setStation(10); // Invalid number
        assertEquals(3, radio.getStation()); // Should remain unchanged

        radio.setStation(-1); // Invalid number
        assertEquals(3, radio.getStation()); // Should remain unchanged
    }

    @Test
    void testSetVolume() {
        radio.setVolume(50);
        assertEquals(50, radio.getVolume());

        radio.setVolume(110); // Invalid volume
        assertEquals(50, radio.getVolume()); // Should remain unchanged

        radio.setVolume(-10); // Invalid volume
        assertEquals(50, radio.getVolume()); // Should remain unchanged
    }

    @Test
    void testCustomNumberOfStations() {
        Radio customRadio = new Radio(20);

        customRadio.setStation(19);
        customRadio.nextStation();
        assertEquals(0, customRadio.getStation());

        customRadio.setStation(0);
        customRadio.previousStation();
        assertEquals(19, customRadio.getStation());
    }

    @Test
    void testInvalidNumberOfStations() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Radio(0);
        });

        assertEquals("Number of stations must be positive", exception.getMessage());
    }
}
