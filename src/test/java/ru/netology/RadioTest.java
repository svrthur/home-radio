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
        assertEquals(100, radio.getVolume()); // Проверка, что не превышает максимум
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
        assertEquals(0, radio.getVolume()); // Проверка, что не опускается ниже минимума
    }

    @Test
    void testNextStation() {
        radio.setStation(9);
        radio.nextStation();
        assertEquals(0, radio.getStation()); // Проверка перехода на первую станцию

        radio.setStation(5);
        radio.nextStation();
        assertEquals(6, radio.getStation());
    }

    @Test
    void testPreviousStation() {
        radio.setStation(0);
        radio.previousStation();
        assertEquals(9, radio.getStation()); // Проверка перехода на последнюю станцию

        radio.setStation(5);
        radio.previousStation();
        assertEquals(4, radio.getStation());
    }

    @Test
    void testSetStation() {
        radio.setStation(3);
        assertEquals(3, radio.getStation());

        radio.setStation(10); // Не допустимый номер
        assertEquals(3, radio.getStation()); // Не должно измениться

        radio.setStation(-1); // Не допустимый номер
        assertEquals(3, radio.getStation()); // Не должно измениться
    }

    @Test
    void testSetVolume() {
        radio.setVolume(50);
        assertEquals(50, radio.getVolume());

        radio.setVolume(110); // Не допустимое значение
        assertEquals(50, radio.getVolume()); // Не должно измениться

        radio.setVolume(-10); // Не допустимое значение
        assertEquals(50, radio.getVolume()); // Не должно измениться
    }
}
