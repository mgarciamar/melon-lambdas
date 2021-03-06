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

    /*Este m??todo est?? creado en concreto para trabajar con objetos de la clase Melon.
    Recibe  la lista de melones, y un objeto de la Interface MelonPredicate.
    Comprueba que la lista de melones no sea null y llama al m??todo test() para comprobar lo que
    se quiera comprobar, dependiendo del tipo de objeto que sea llama a una funcion test u otra (por ejemplo
    en este caso podr??a llamar al m??todo test de la clase "GacMelonPredicate" o al de la clase "heavyMelonPredicate)
    dependiendo del tipo de objeto predicate que se le pase al llamar al m??todo
    */
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

    /*Este m??todo est?? creadode manera gen??rica, para cualquier tipo de objeto de distintas clases.
    Recibe  la lista del objeto, y un objeto de la Interface Predicate (Esta est?? implementada de manera
    gen??rica tambi??n).
    Comprueba que la lista de objetos no sea null y llama al m??todo test() para comprobar lo que
    se quiera comprobar, el m??todo test depender?? lo que se haya implementado en el Predicate
    */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if(list==null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        List<T> result = new ArrayList<>();
        for(T t: list) {
            if(t!=null && predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

}
