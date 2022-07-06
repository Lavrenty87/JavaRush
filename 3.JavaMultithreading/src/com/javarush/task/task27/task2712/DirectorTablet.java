package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        Double total = 0.00;
        TreeMap<String, Long> mapProfit = StatisticManager.getInstance().getStatisticAD();
        ArrayList<String> rez = new ArrayList<>();
        for (Map.Entry<String, Long> map : mapProfit.entrySet()) {
            String key = map.getKey();
            Double value = (double) (1.0 * map.getValue() / 100);
            total += value;
            rez.add(key  + " - " + String.format(Locale.ENGLISH, "%.2f", value));
        }
        Collections.sort(rez);
        for (String s : rez) System.out.println(s);
        System.out.println("Total - " + total.toString());
    }
    public void printCookWorkloading() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        TreeMap<String, Map<String, Integer>> mapCook = StatisticManager.getInstance().getStatisticCook();
        for (Map.Entry<String, Map<String, Integer>> map: mapCook.entrySet()) {
            String key = map.getKey();
            Map<String, Integer> value = map.getValue();
            System.out.println(key);
            for (Map.Entry<String, Integer> m : value.entrySet()) {
                String cookName = m.getKey();
                Integer cookWorkToDay = m.getValue();
                System.out.println(cookName + " - " + cookWorkToDay / 60 + " min");
            }
            System.out.println();
        }
    }
    public void printActiveVideoSet() {
        List<Advertisement> video = StatisticAdvertisementManager.getInstance().getVideoSet(true);
        Collections.sort(video, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
    for (Advertisement a : video) {
            System.out.println(a.getName() + " - " + a.getHits());
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> video = StatisticAdvertisementManager.getInstance().getVideoSet(false);
        Collections.sort(video, Comparator.comparing(o -> o.getName().toLowerCase()));
        for (Advertisement a : video) {
            System.out.println(a.getName());
        }

    }
}
