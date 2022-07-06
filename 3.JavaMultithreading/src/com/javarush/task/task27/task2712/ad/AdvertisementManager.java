package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;

public class AdvertisementManager {
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private long maxSumMani;
    private int maxDurationStorage;
    private ArrayList<Advertisement> aDListResult;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty() || storage.list() == null) {
            throw new NoVideoAvailableException();
        } else {
            this.maxDurationStorage = 0;
            for (Advertisement a : storage.list()) {
                if (a.isHitsAlive()) {
                    this.maxDurationStorage += a.getDuration();
                }
            }
            setBastVideoList(new ArrayList<>(), timeSeconds, 0L);
            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(aDListResult, maxSumMani, timeSeconds - maxDurationStorage));
            printResult();
        }
    }

    private void setBastVideoList(ArrayList<Advertisement> currentList, int cookDishTime, long currentSumMani) {
        if (cookDishTime < 0) {
            return;
        }
        else if (currentSumMani > maxSumMani
                || currentSumMani == maxSumMani && (maxDurationStorage > cookDishTime
                || maxDurationStorage == cookDishTime && currentList.size() < aDListResult.size())) {
            this.maxDurationStorage = cookDishTime;
            this.aDListResult = currentList;
            this.maxSumMani = currentSumMani;
            if (cookDishTime == 0) {
                return;
            }
        }

        ArrayList<Advertisement> teamList = getActualStorage();
        teamList.removeAll(currentList);
        for (Advertisement a : teamList) {
            if (a.isHitsAlive()) {
                ArrayList<Advertisement> newCurrentList = new ArrayList<>(currentList);
                newCurrentList.add(a);
                setBastVideoList(newCurrentList, cookDishTime - a.getDuration(), currentSumMani + a.getAmountPerOneDisplaying());
            } else continue;
        }
    }

    private void printResult() {
        aDListResult.sort((ad1, ad2) -> {
            long l = ad2.getAmountPerOneDisplaying() - ad1.getAmountPerOneDisplaying();
            return (int) (l != 0 ? l : ad2.getDuration() - ad1.getDuration());
        });
        for (Advertisement ad : aDListResult) {
            ConsoleHelper.writeMessage(ad.getName() + " is displaying... " +
                    ad.getAmountPerOneDisplaying() + ", " + (ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
            ad.revalidate();
        }
    }

    //list где показы(hits) не выбраны
    private ArrayList<Advertisement> getActualStorage() {
        ArrayList<Advertisement> actualList = new ArrayList<>();

        for (Advertisement a : storage.list()) {
            if (a.isHitsAlive()) actualList.add(a);
        }
        return actualList;
    }
}