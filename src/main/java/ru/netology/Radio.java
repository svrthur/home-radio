package ru.netology;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int maxStations;

    // Конструктор по умолчанию
    public Radio() {
        this.maxStations = 10;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    // Конструктор с параметром
    public Radio(int maxStations) {
        if (maxStations > 0) {
            this.maxStations = maxStations;
        } else {
            throw new IllegalArgumentException("Number of stations must be positive");
        }
        this.currentStation = 0;
        this.currentVolume = 0;
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
