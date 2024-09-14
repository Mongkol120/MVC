import java.util.Random;

public class Cow {
    private String id;
    private String color; // "white" or "brown"
    private int ageYears;
    private int ageMonths;
    private boolean isBsod;
    private boolean isLemon;
    private int whiteMilk;
    private int yogurt;
    private int chocolateMilk;
    private int soyMilk;
    private int almondMilk;

    private static final Random RANDOM = new Random();

    public Cow(String id, String color, int ageYears, int ageMonths) {
        this.id = id;
        this.color = color;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.isBsod = false;
        this.isLemon = false;
        this.whiteMilk = 0;
        this.yogurt = 0;
        this.chocolateMilk = 0;
        this.soyMilk = 0;
        this.almondMilk = 0;
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public boolean isBsod() {
        return isBsod;
    }

    public String milk(boolean addLemon) {
        if (isBsod) {
            return "Cow is in BSOD state. Cannot milk.";
        }
        if(addLemon){
            isLemon = true;
        }

        String result = "";

        if (color.equals("white")) {
            if (isLemon) {
                result = "Milk Result: Yogurt";
                yogurt++;
            } else if (shouldProduceSoyMilk()) {
                result = "BSOD: Producing Soy Milk";
                soyMilk++;
                isBsod = true;
            } else {
                result = "Milk Result: Fresh Milk";
                whiteMilk++;
            }
        } else if (color.equals("brown")) {
            if (shouldProduceAlmondMilk()) {
                result = "BSOD: Producing Almond Milk";
                almondMilk++;
                isBsod = true;
            } else {
                result = "Milk Result: Chocolate Milk";
                chocolateMilk++;
            }
        }

        return result;

    }

    private boolean shouldProduceSoyMilk() {
        // 0.5% chance of producing soy milk based on age
        double chance = 0.005 * ageMonths;
        return RANDOM.nextDouble() < chance;
    }

    private boolean shouldProduceAlmondMilk() {
        // 1% chance of producing almond milk based on age
        double chance = 0.01 * ageYears;
        return RANDOM.nextDouble() < chance;
    }

    public void resetBsod() {
        isBsod = false;
    }

    public int getWhiteMilk() {
        return whiteMilk;
    }

    public int getYogurt() {
        return yogurt;
    }

    public int getChocolateMilk() {
        return chocolateMilk;
    }

    public int getSoyMilk() {
        return soyMilk;
    }

    public int getAlmondMilk() {
        return almondMilk;
    }
}
