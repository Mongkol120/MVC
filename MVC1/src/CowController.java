import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CowController {
    private CowView cowView;
    private WhiteCowView whiteCowView;
    private BrownCowView brownCowView;
    private StatsView statsView;
    private CowDatabase model;
    private Cow currentCow;

    public CowController(CowView cowView, WhiteCowView whiteCowView, BrownCowView brownCowView, StatsView statsView, CowDatabase model) {
        this.cowView = cowView;
        this.whiteCowView = whiteCowView;
        this.brownCowView = brownCowView;
        this.statsView = statsView;
        this.model = model;
        model.saveToCsv("cow_data.csv");

        cowView.setCheckCowButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkCow();
            }
        });

        whiteCowView.setMilkButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milkCow(false);
            }
        });

        whiteCowView.setAddLemonButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milkCow(true);
            }
        });

        brownCowView.setMilkButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milkCow(false);
            }
        });

        statsView.setBackButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cowView.showView();
            }
        });

        statsView.setBackButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetCow();
            }
        });
    }

    private void checkCow() {
        String cowId = cowView.getCowIdInput();
        if (!cowId.matches("[1-9][0-9]{7}")) {
            cowView.setInfo("Invalid Cow ID.");
            return;
        }

        currentCow = model.findCowById(cowId);
        if (currentCow == null) {
            cowView.setInfo("Cow not found.");
        } else {
            String cowInfo = "Cow ID: " + currentCow.getId() + ", Color: " + currentCow.getColor() + ", Age: " + currentCow.getAgeYears() + " years " + currentCow.getAgeMonths() + " months.";
            if (currentCow.getColor().equals("white")) {
                whiteCowView.setCowInfo(cowInfo);
                whiteCowView.showView();
            } else if (currentCow.getColor().equals("brown")) {
                brownCowView.setCowInfo(cowInfo);
                brownCowView.showView();
            }
        }
    }

    private void milkCow(boolean addLemon) {
        if (currentCow == null || currentCow.isBsod()) {
            if (currentCow.getColor().equals("white")) {
                whiteCowView.setMilkResult("Cannot milk. Cow is not found or in BSOD state.");
            } else {
                brownCowView.setMilkResult("Cannot milk. Cow is not found or in BSOD state.");
            }
            return;
        }

        String result = currentCow.milk(addLemon);
        if (currentCow.getColor().equals("white")) {
            whiteCowView.setMilkResult(result);
            whiteCowView.setInfoLabel("");
        } else if (currentCow.getColor().equals("brown")) {
            brownCowView.setMilkResult(result);
        }

        model.saveToCsv("cow_data.csv");
        showStats();
    }

    private void resetCow() {
        List<Cow> cows = model.getAllCows();
        for(Cow cow : cows){
            cow.resetBsod();
        }
    }

    private void showStats(){
        List<int[]> list = model.readCsv("cow_data.csv");
        int[] arrayOfMilk = new int[5];
        for(int[] array : list){
            arrayOfMilk[0] += array[0];
            arrayOfMilk[1] += array[1];
            arrayOfMilk[2] += array[2];
            arrayOfMilk[3] += array[3];
            arrayOfMilk[4] += array[4];
        }
        statsView.setWhiteMilkInfo(arrayOfMilk[0]);
        statsView.setYogurtInfo(arrayOfMilk[1]);
        statsView.setChocolateMilkInfo(arrayOfMilk[2]);
        statsView.setSoyMilkInfo(arrayOfMilk[3]);
        statsView.setAlmondMilkInfo(arrayOfMilk[4]);
        statsView.showView();
    }
}