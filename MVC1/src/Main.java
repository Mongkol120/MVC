import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cow Milk Production");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create the model and views
            CowDatabase model = new CowDatabase();
            CowView mainView = new CowView(frame);
            WhiteCowView whiteCowView = new WhiteCowView(frame);
            BrownCowView brownCowView = new BrownCowView(frame);
            StatsView statsView = new StatsView(frame);


            // Create the controller
            CowController controller = new CowController(mainView, whiteCowView, brownCowView, statsView,model);

            // Show the initial view
            mainView.showView();

            frame.setVisible(true);
        });
    }
}
