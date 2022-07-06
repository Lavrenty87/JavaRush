package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StatisticAdvertisementManager {
    private static volatile StatisticAdvertisementManager SADM;
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (SADM == null) {
            synchronized (StatisticAdvertisementManager.class) {
                if (SADM == null) {
                    SADM = new StatisticAdvertisementManager();
                    ;
                }
            }
        }
        return SADM;
    }

    public List<Advertisement> getVideoSet(boolean b) {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement a : advertisementStorage.list()) {
            if (!b ^ a.isHitsAlive()) {
                list.add(a);
            }
        }
        return list;
    }
}
