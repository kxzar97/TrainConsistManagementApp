import java.util.*;

// ✅ UC7: Custom Bogie class
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

        // UC3: HashSet
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIds);

        // UC4: LinkedList
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

        // UC5: LinkedHashSet
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("\nFinal train formation:");
        System.out.println(formation);

        // UC6: HashMap
        Map<String, Integer> bogieCapacityMap = new HashMap<>();
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 24);

        System.out.println("\nBogie Capacity Mapping:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ============================
        // ✅ UC7: Sorting using Comparator
        // ============================

        List<Bogie> bogieList = new ArrayList<>();

        // Creating Bogie objects
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 24));

        System.out.println("\nBefore Sorting:");
        System.out.println(bogieList);

        // Sorting by capacity (ascending)
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity (Ascending):");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        // Optional: Descending sort (more realistic for planning)
        bogieList.sort((a, b) -> b.capacity - a.capacity);

        System.out.println("\nAfter Sorting by Capacity (Descending):");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        System.out.println("\nApplication ready for next use cases...");
    }
}