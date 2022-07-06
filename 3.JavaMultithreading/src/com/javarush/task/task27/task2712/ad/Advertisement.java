package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    // начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private long initialAmount;
    // количество оплаченных показов
    private int hits;
    // продолжительность
    private int duration;
    //стоимость одного показа
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = (hits != 0) ? initialAmount / hits : 0;
    }

    public String getName() {
        return name;
    }

    public boolean isHitsAlive() {
        return hits > 0;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getHits() {
        return hits;
    }

    public void revalidate() {
        if (hits <= 0) throw new UnsupportedOperationException();
        hits --;
    }
}
