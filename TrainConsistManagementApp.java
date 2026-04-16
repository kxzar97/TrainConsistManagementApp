import java.util.*;
import java.util.stream.Collectors;

// Bogie class (UC7)
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // UC1–UC2
        List<String> trainConsist = new ArrayList<>();
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        trainConsist.remove("AC Chair");

        System.out.println("\nFinal train consist:");
        System.out.println(trainConsist);

        // UC3
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101");

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIds);

        // UC4
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

        // UC5
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("\nFinal train formation:");
        System.out.println(formation);

        // UC6
        Map<String, Integer> bogieCapacityMap = new HashMap<>();
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 24);

        System.out.println("\nBogie Capacity Mapping:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // UC7
        List<Bogie> bogieList = new ArrayList<>();

        // Build from map (clean integration 🔥)
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            bogieList.add(new Bogie(entry.getKey(), entry.getValue()));
        }

        // Sort descending
        bogieList.sort((a, b) -> b.capacity - a.capacity);

        System.out.println("\nSorted Bogies (Descending Capacity):");
        bogieList.forEach(System.out::println);

        // ============================
        // ✅ UC8: Stream Filtering
        // ============================

        List<Bogie> highCapacityBogies = bogieList.stream()
                .filter(b -> b.capacity > 60)   // core UC8 condition
                .collect(Collectors.toList());

        System.out.println("\nHigh Capacity Bogies (Capacity > 60):");
        highCapacityBogies.forEach(System.out::println);

        // Proof original list unchanged
        System.out.println("\nOriginal Bogie List (Unchanged):");
        bogieList.forEach(System.out::println);

        System.out.println("\nApplication ready for next use cases...");
    }
}