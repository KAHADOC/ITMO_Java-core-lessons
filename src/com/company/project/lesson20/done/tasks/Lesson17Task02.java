package com.company.project.lesson20.done.tasks;


import com.company.project.lesson14.properties.vehicle.Repaintable;
import com.company.project.lesson14.properties.vehicle.Vehicle;

import java.util.*;

public class Lesson17Task02 {
    private <T extends Vehicle> List<T> vehiclesByLevelOfWare(Map<String, T> map, int wearLevel) {
        ArrayList<T> result = new ArrayList<>();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            T vehicle = entry.getValue();
            if (vehicle.getLevelOfWare() > wearLevel) result.add(vehicle);
        }
        return result;
    }


    public void putColored(List<Repaintable> list, Map<Repaintable.Color, List<Repaintable>> map) {
        for (Repaintable repaintable : list) {
            Repaintable.Color colorKey = repaintable.getColor();
            if (map.containsKey(colorKey)) {
                map.get(colorKey).add(repaintable);
            } else {
                List<Repaintable> newList = new ArrayList<>();
                newList.add(repaintable);
                map.put(colorKey, newList);
            }
        }
    }

    public static <T extends Vehicle> Map<String, T> repaired(ArrayList<T> list) {
        Map<String, T> repaired = new HashMap<>();
        for (T t : list) {
            if (t == null) continue;
            t.repair();
            repaired.put(t.getNumber(), t);
        }
        return repaired;
    }


}
