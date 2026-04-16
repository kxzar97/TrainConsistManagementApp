import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // UC1–UC2: List operations
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

        // UC3: HashSet (unique IDs)
        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("\nUnique Bogie IDs (duplicates automatically removed):");
        System.out.println(bogieIds);

        // UC4: LinkedList (ordered operations)
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

        // UC5: LinkedHashSet (order + uniqueness)
        LinkedHashSet<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate

        System.out.println("\nFinal train formation (insertion order, no duplicates):");
        System.out.println(formation);

        // ============================
        // ✅ UC6: HashMap (Bogie → Capacity)
        // ============================

        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Adding bogie-capacity mappings
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("Cargo Rectangular", 100);
        bogieCapacityMap.put("Cargo Cylindrical", 120);

        System.out.println("\nBogie Capacity Mapping:");

        // Iterating using entrySet()
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        // Example: Fast lookup
        System.out.println("\nCapacity of Sleeper bogie: "
                + bogieCapacityMap.get("Sleeper"));

        System.out.println("\nApplication ready for next use cases...");
    }
}