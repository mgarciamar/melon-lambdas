package com.sinensia.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 5500, "Europe"),
                new Melon("Bailan", 6000, "China"),
                new Melon("Watermelon", 1200, "Europe"),
                new Melon("Gac", 3400, "US"),
                new Melon("Bailan", 1300, "China")
        );

        for (int i = 0; i < melons.size(); ++i) {
            System.out.println(melons.get(i).toString());
        }

        List<Melon> bailan = Filters.filterByType(melons, "Bailan");
        System.out.println("\nLista filtrada tipo: ");
        for (int i = 0; i < bailan.size(); ++i) {
            System.out.println(bailan.get(i).toString());
        }

        List <Melon> found =Filters.filterByWeight(melons, 1200);
        System.out.println("\nLista filtrada pesos: ");
        for (Melon m: found) {
            System.out.println(m);
        }

        List <Melon> found2 =Filters.filterByWeightMore(melons, 1300);
        System.out.println("\nLista filtrada pesos mayores: ");
        for (Melon m: found2) {
            System.out.println(m);
        }

        List <Melon> found3 =Filters.filterByWeightMenor(melons, 4000);
        System.out.println("\nLista filtrada pesos menores: ");
        for (Melon m: found3) {
            System.out.println(m);
        }

        System.out.println("\nLista melones gac: ");
        //GacMelonPredicate gacMelonPredicate = new GacMelonPredicate();
        List<Melon> gac = Filters.filterMelons(melons, new GacMelonPredicate());
        for (Melon m: gac) {
            System.out.println(m);
        }

        System.out.println("\nLista melones pesados: ");
        List<Melon> heavy = Filters.filterMelons(melons, new HeavyMelonPredicate());
        for (Melon m: heavy) {
            System.out.println(m);
        }

        System.out.println("\nLista melones super-pesados: ");
        List<Melon> superheavy = Filters.filterMelons(melons, melon -> melon != null && melon.getWeight()>=6000);

        for (Melon m: superheavy) {
            System.out.println(m);
        }

        System.out.println("Lista melones europeos: ");
        for(Melon m:  Filters.filterMelons(melons, melon -> melon!=null && melon.getOrigin().equalsIgnoreCase("Europe"))) {
            System.out.println(m);
        }

        System.out.println("\nLista sandias: ");
        List<Melon> watermelons = Filters.filter(melons, (Melon m)->m.getType().equalsIgnoreCase("watermelon"));
        for(Melon m: watermelons) {
            System.out.println(m);
        }
        System.out.println("\nStream de melones:");
        melons.stream()
                .forEach(melon -> System.out.println(melon));

        System.out.println("\nStream de melones filtrado:");
        melons.stream()
                .filter(melon -> "gac".equalsIgnoreCase(melon.getType()))
                .forEach(melon -> System.out.println(melon));

        System.out.println("\nPrimer elemento del Stream:");

        //primera forma de hacerlo
        Optional<Melon> primero = melons.stream()
                .findFirst();
        if(primero.isPresent()){
            System.out.println(primero.get());
        }
        primero.ifPresent(melon -> System.out.println(melon));

        //segunda forma (mejor) de hacerlo
        melons.stream()
                .findFirst()
                .ifPresent(melon -> System.out.println(melon));

        melons.stream()
                .mapToInt(melon -> melon.getWeight())
                .average()
                .ifPresent(average -> System.out.println("\nPeso promedio: " +average));




        }

    }



