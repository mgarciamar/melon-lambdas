package com.sinensia.lambdas;

import java.util.ArrayList;
import java.util.List;

public final class Filters {

    public Filters() {
        throw new AssertionError("Utility class can not be instantied");
    }

    public static List<Melon> filterByType(List<Melon> melons, String bailan) {

        if (melons == null || bailan == null) {
            throw new IllegalArgumentException("Melons cannot null");
        }

        if (melons.isEmpty()) {
            return melons;
        }
        List<Melon> tipos = new ArrayList<>();
        /*

        for (Melon melon: melons){
        if (type.equalsIgnorecase(melon.getType())) {
        result.add(melon);
         */

        for  (int i = 0; i < melons.size(); ++i) {
            if (melons.get(i).getType().contentEquals(bailan)) {
                tipos.add(melons.get(i));
            }
        }
        return tipos;
    }

    public static List<Melon> filterByWeight(List<Melon> melons, int i) {
        if (melons == null || i <= 0) {
            throw new IllegalArgumentException("Melons cannot null");
        }

        if (melons.isEmpty()) {
            return melons;
        }
        List<Melon> pesos = new ArrayList<>();

        for (Melon melon: melons){
            if (melon.getWeight()==i) {
                pesos.add(melon);
            }
        }
        return pesos;
    }

    public static List<Melon> filterByWeightMore(List<Melon> melons, int i) {
        if (melons == null || i <= 0) {
            throw new IllegalArgumentException("Melons cannot null");
        }

        if (melons.isEmpty()) {
            return melons;
        }
        List<Melon> pesos = new ArrayList<>();

        for (Melon melon: melons){
            if (melon.getWeight()>i) {
                pesos.add(melon);
            }
        }
        return pesos;
    }

    public static List<Melon> filterByWeightMenor (List<Melon> melons, int i) {
        if (melons == null || i <= 0) {
            throw new IllegalArgumentException("Melons cannot null");
        }

        if (melons.isEmpty()) {
            return melons;
        }
        List<Melon> pesos = new ArrayList<>();

        for (Melon melon: melons){
            if (melon.getWeight()<i) {
                pesos.add(melon);
            }
        }
        return pesos;
    }

    public static List<Melon> filterMelons(List<Melon> melons, MelonPredicate predicate) {

        if(melons==null) {
            //peto
        }

        List<Melon> result = new ArrayList<>();
        for (Melon melon: melons){
            if(melon!=null && predicate.test(melon)) {
                result.add(melon);
            }
        }
        return result;
    }

}
