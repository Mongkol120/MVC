import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CowDatabase {
    private List<Cow> cows;

    public CowDatabase() {
        cows = new ArrayList<>();
        int id = 10000000;

        // Sample cow data
        for(int i = 0 ; i < 5 ; i++){
            cows.add(new Cow(String.valueOf(++id), "white", (int)(Math.random() * 11), (int)(Math.random() * 12))); // Random age 0-10 and month 0-11
            cows.add(new Cow(String.valueOf(++id), "brown", (int)(Math.random() * 11), (int)(Math.random() * 12)));
        }

    }

    public Cow findCowById(String id) {
        for (Cow cow : cows) {
            if (cow.getId().equals(id)) {
                return cow;
            }
        }
        return null;
    }

    public List<Cow> getAllCows() {
        return cows;
    }

    public void resetAllBsodCows() {
        for (Cow cow : cows) {
            if (cow.isBsod()) {
                cow.resetBsod();
            }
        }
    }

    // Method to save cows to CSV
    public void saveToCsv(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // Write the CSV header
            printWriter.println("ID,Color,AgeYears,AgeMonths");

            // Write the cow data
            for (Cow cow : cows) {
                printWriter.printf("%s,%s,%d,%d,%d,%d,%d,%d,%d\n",
                        cow.getId(),
                        cow.getColor(),
                        cow.getAgeYears(),
                        cow.getAgeMonths(),
                        cow.getWhiteMilk(),
                        cow.getYogurt(),
                        cow.getChocolateMilk(),
                        cow.getSoyMilk(),
                        cow.getAlmondMilk());
            }

            System.out.println("Data has been successfully saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error occurred while writing to CSV file: " + e.getMessage());
        }
    }

    public List<int[]> readCsv(String filePath){
        List<int[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 5) {
                    int last1 = Integer.parseInt(values[values.length - 5]);
                    int last2 = Integer.parseInt(values[values.length - 4]);
                    int last3 = Integer.parseInt(values[values.length - 3]);
                    int last4 = Integer.parseInt(values[values.length - 2]);
                    int last5 = Integer.parseInt(values[values.length - 1]);

                    result.add(new int[]{last1, last2, last3, last4, last5});
                } else {
                    System.out.println("Insufficient data in row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
