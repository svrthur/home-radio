package ru.netology;

public class Radio {
    private int currentStation = 0;
    private int currentVolume = 0;
    private final int maxStations;

    // Конструктор по умолчанию
    public Radio() {
        this.maxStations = 10; // Значение по умолчанию
    }

    // Конструктор с заданием количества радиостанций
    public Radio(int maxStations) {
        if (maxStations > 0) {
            this.maxStations = maxStations;
        } else {
            this.maxStations = 10; // Значение по умолчанию при некорректном вводе
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public void nextStation() {
        if (currentStation < maxStations - 1) {
            currentStation++;
        } else {
            currentStation = 0;
        }
    }

    public void previousStation() {
        if (currentStation > 0) {
            currentStation--;
        } else {
            currentStation = maxStations - 1;
        }
    }

    public void setStation(int station) {
        if (station >= 0 && station < maxStations) {
            currentStation = station;
        }
    }

    public int getStation() {
        return currentStation;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            currentVolume = volume;
        }
    }

    public int getVolume() {
        return currentVolume;
    }
}
