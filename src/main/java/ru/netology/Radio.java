package ru.netology;

public class Radio {
    private int currentStation = 0;
    private int currentVolume = 0;

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
        if (currentStation < 9) {
            currentStation++;
        } else {
            currentStation = 0;
        }
    }

    public void previousStation() {
        if (currentStation > 0) {
            currentStation--;
        } else {
            currentStation = 9;
        }
    }

    public void setStation(int station) {
        if (station >= 0 && station <= 9) {
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
