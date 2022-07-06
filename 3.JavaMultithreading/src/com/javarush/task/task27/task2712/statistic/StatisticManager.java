package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    private StatisticManager() {
    }

    public static StatisticManager getInstance () {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    // 2. В StatisticManager создай метод (придумать самостоятельно), который из хранилища достанет все данные,
    // относящиеся к отображению рекламы, и посчитает общую прибыль за каждый день.
    //Дополнительно добавь вспомогательный метод get в класс хранилища, чтобы получить доступ к данным.
    public TreeMap<String, Long> getStatisticAD() {
        ArrayList<EventDataRow> aD = this.statisticStorage.get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        TreeMap<String, Long> profitAdvertising = new TreeMap<>();
        for (EventDataRow v : aD) {
            VideoSelectedEventDataRow vv = (VideoSelectedEventDataRow) v;
            String date = simpleDateFormat.format(vv.getDate());

            if (!profitAdvertising.containsKey(date)) profitAdvertising.put(date, 0l);

            long value = profitAdvertising.get(date);
            value += vv.getAmount();
            profitAdvertising.replace(date, value);
        }
        return profitAdvertising;
    } 

    //4. Реализуем второй пункт статистики - загрузка (рабочее время) повара, сгруппировать по дням.
    //В StatisticManager создай метод (придумать самостоятельно), который из хранилища достанет все данные,
    // относящиеся к работе повара, и посчитает общую продолжительность работы для каждого повара отдельно.
    public TreeMap<String, Map<String, Integer>> getStatisticCook() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        ArrayList<EventDataRow> aD = this.statisticStorage.get(EventType.COOKED_ORDER);
        TreeMap<String, Map<String, Integer>> cookWork = new TreeMap<>();
        for (EventDataRow row : aD) {
            CookedOrderEventDataRow coedr = (CookedOrderEventDataRow) row;
            //Если повар не работал в какой-то из дней, то с пустыми данными его НЕ выводить (см. 13-Jul-2013)
            if (coedr.getTime() > 0) {
                String data = simpleDateFormat.format(coedr.getDate());

                if (!cookWork.containsKey(data)) cookWork.put(data, new HashMap<String, Integer>());

                Map<String, Integer> map2 = cookWork.get(data);

                if (!map2.containsKey(coedr.getCookName()))  map2.put(coedr.getCookName(), 0);

                Integer cookTimeWork = map2.get(coedr.getCookName()) + coedr.getTime();
                map2.replace(coedr.getCookName(), cookTimeWork);

            }
        }
        return cookWork;
    }

    private static class StatisticStorage{
        private HashMap<EventType, ArrayList<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType eT : EventType.values()) {
                storage.put(eT, new ArrayList<>());
            }
        }
        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
        private ArrayList<EventDataRow> get(EventType eventType) {
            return storage.get(eventType);
        }
    }

}
