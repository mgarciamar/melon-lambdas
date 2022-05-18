package com.sinensia.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    }


}
