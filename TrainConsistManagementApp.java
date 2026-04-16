import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Bogie class from previous use cases
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
        System.out.println("==========================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("==========================================");

        Scanner scanner = new Scanner(System.in);

        // --- NEW UC11 LOGIC: REGEX VALIDATION ---

        // 1. Accept Input [cite: 24]
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // 2. Define Regex Rules [cite: 31, 38, 39]
        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // 3. Compile Patterns and Create Matchers [cite: 32, 33, 40, 41]
        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);
        Matcher trainIdMatcher = trainIdPattern.matcher(trainId);
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);

        // 4. Validate and Display Result [cite: 34, 42, 43]
        boolean isTrainIdValid = trainIdMatcher.matches();
        boolean isCargoCodeValid = cargoCodeMatcher.matches();

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);

        // --- PREVIOUS FUNCTIONS (Logic from your current code) ---

        if (isTrainIdValid && isCargoCodeValid) {
            System.out.println("\nProcessing data for Train: " + trainId);

            // Re-introducing your existing Bogie Management logic
            Map<String, Integer> bogieCapacityMap = new HashMap<>();
            bogieCapacityMap.put("Sleeper", 72);
            bogieCapacityMap.put("AC Chair", 60);
            bogieCapacityMap.put("First Class", 24);

            List<Bogie> bogieList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
                bogieList.add(new Bogie(entry.getKey(), entry.getValue()));
            }

            // Calculate total capacity using Streams (from your previous code)
            int totalCapacity = bogieList.stream()
                    .map(b -> b.capacity)
                    .reduce(0, Integer::sum);

            System.out.println("Total Seating Capacity verified: " + totalCapacity);
        } else {
            System.out.println("\n[ERROR] Downstream processing failed due to invalid data format."); [cite: 16, 46]
        }

        System.out.println("\nUC11 validation completed...");
        scanner.close();
    }
}