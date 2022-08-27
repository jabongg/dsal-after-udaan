package com.java.basics.lambdas.aquatic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AquaDriver {
    public static void main(String[] args) {
        List<AquaticAnimals> aquaticAnimals = new ArrayList<>();
        aquaticAnimals.add(AquaticAnimals.TURTLE);
        aquaticAnimals.add(AquaticAnimals.OCTOPUS);
        aquaticAnimals.add(AquaticAnimals.DOLPHIN);
        aquaticAnimals.add(AquaticAnimals.HIPPOCAMPUS);
        aquaticAnimals.add(AquaticAnimals.LOBSTER);
        aquaticAnimals.add(AquaticAnimals.SEAL);

        aquaticAnimals.add(AquaticAnimals.TURTLE);
        aquaticAnimals.add(AquaticAnimals.OCTOPUS);
        aquaticAnimals.add(AquaticAnimals.DOLPHIN);
        aquaticAnimals.add(AquaticAnimals.HIPPOCAMPUS);
        aquaticAnimals.add(AquaticAnimals.LOBSTER);
        aquaticAnimals.add(AquaticAnimals.SEAL);

        aquaticAnimals.add(AquaticAnimals.TURTLE);
        aquaticAnimals.add(AquaticAnimals.OCTOPUS);
        aquaticAnimals.add(AquaticAnimals.DOLPHIN);
        aquaticAnimals.add(AquaticAnimals.HIPPOCAMPUS);
        aquaticAnimals.add(AquaticAnimals.LOBSTER);
        aquaticAnimals.add(AquaticAnimals.SEAL);

        aquaticAnimals.add(AquaticAnimals.TURTLE);
        aquaticAnimals.add(AquaticAnimals.OCTOPUS);
        aquaticAnimals.add(AquaticAnimals.DOLPHIN);
        aquaticAnimals.add(AquaticAnimals.HIPPOCAMPUS);
        aquaticAnimals.add(AquaticAnimals.LOBSTER);
        aquaticAnimals.add(AquaticAnimals.SEAL);

        System.out.println(aquaticAnimals);


        List<AquaticAnimals> turtles = aquaticAnimals.stream().filter(aquaticAnimal -> aquaticAnimal.name().equals(AquaticAnimals.TURTLE.name())).collect(Collectors.toList());
        List<AquaticAnimals> octopuses = aquaticAnimals.stream().filter(aquaticAnimal -> aquaticAnimal.name().equals(AquaticAnimals.OCTOPUS.name())).collect(Collectors.toList());
        List<AquaticAnimals> dolphins = aquaticAnimals.stream().filter(aquaticAnimal -> aquaticAnimal.name().equals(AquaticAnimals.DOLPHIN.name())).collect(Collectors.toList());
        List<AquaticAnimals> hippocampuses = aquaticAnimals.stream().filter(aquaticAnimal -> aquaticAnimal.name().equals(AquaticAnimals.HIPPOCAMPUS.name())).collect(Collectors.toList());
        List<AquaticAnimals> lobsters = aquaticAnimals.stream().filter(aquaticAnimal -> aquaticAnimal.name().equals(AquaticAnimals.LOBSTER.name())).collect(Collectors.toList());
        List<AquaticAnimals> seals = aquaticAnimals.stream().filter(aquaticAnimal -> aquaticAnimal.name().equals(AquaticAnimals.SEAL.name())).collect(Collectors.toList());


        System.out.println(turtles);
        System.out.println(octopuses);
        System.out.println(dolphins);
        System.out.println(hippocampuses);
        System.out.println(lobsters);
        System.out.println(seals);

    }
}
