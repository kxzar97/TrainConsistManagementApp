import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nAfter adding passenger bogies:");
        System.out.println("Train consist: " + trainConsist);

        trainConsist.remove("AC Chair");

        System.out.println("\nAfter removing AC Chair bogie:");
        System.out.println("Train consist: " + trainConsist);

        boolean exists = trainConsist.contains("Sleeper");
        System.out.println("\nDoes Sleeper bogie exist? " + exists);

        System.out.println("\nFinal train consist:");
        System.out.println(trainConsist);

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        System.out.println("\nUnique Bogie IDs (duplicates automatically removed):");
        System.out.println(bogieIds);

        LinkedList<String> orderedConsist = new LinkedList<>();

        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");

        orderedConsist.add(2, "Pantry Car");

        orderedConsist.removeFirst();
        orderedConsist.removeLast();

        System.out.println("\nFinal ordered train consist:");
        System.out.println(orderedConsist);

        System.out.println("\nApplication ready for next use cases...");
    }
}