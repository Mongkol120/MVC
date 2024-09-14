import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StatsView {
    private JFrame frame;
    private JPanel panel;
    private JLabel whiteMilkInfo;
    private JLabel yogurtInfo;
    private JLabel chocolateMilkInfo;
    private JLabel soyMilkInfo;
    private JLabel almondMilkInfo;
    private JButton resetButton;
    private JButton backButton;

    public StatsView(JFrame frame) {
        this.frame = frame;
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        whiteMilkInfo = new JLabel("White Milk Count:");
        yogurtInfo = new JLabel("Yogurt Count:");
        chocolateMilkInfo = new JLabel("Chocolate Milk Count:");
        soyMilkInfo = new JLabel("Soy Milk Count:");
        almondMilkInfo = new JLabel("Almond Milk Count:");
        resetButton = new JButton("Reset");
        backButton = new JButton("Back");

        panel.add(whiteMilkInfo);
        panel.add(yogurtInfo);
        panel.add(chocolateMilkInfo);
        panel.add(soyMilkInfo);
        panel.add(almondMilkInfo);
        panel.add(resetButton);
        panel.add(backButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setResetButtonAction(ActionListener actionListener) {
        resetButton.addActionListener(actionListener);
    }

    public void setBackButtonAction(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void setWhiteMilkInfo(int milk){
        whiteMilkInfo.setText("White Milk Count: " + milk);
    }

    public void setYogurtInfo(int milk) {
        yogurtInfo.setText("Yogurt Count: " + milk);
    }

    public void setChocolateMilkInfo(int milk) {
        chocolateMilkInfo.setText("Chocolate Milk Count: " + milk);
    }

    public void setSoyMilkInfo(int milk) {
        soyMilkInfo.setText("Soy Milk Count: " + milk);
    }

    public void setAlmondMilkInfo(int milk) {
        almondMilkInfo.setText("Almond Milk Count: " + milk);
    }

    public void showView() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }
}