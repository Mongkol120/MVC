import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BrownCowView {
    private JFrame frame;
    private JPanel panel;
    private JLabel cowInfoLabel;
    private JButton milkButton;
    private JLabel milkResultLabel;

    public BrownCowView(JFrame frame) {
        this.frame = frame;
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        cowInfoLabel = new JLabel("Cow Info: ");
        milkButton = new JButton("Milk Cow");
        milkResultLabel = new JLabel("Milk Result: ");

        panel.add(cowInfoLabel);
        panel.add(milkButton);
        panel.add(milkResultLabel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setCowInfo(String info) {
        cowInfoLabel.setText(info);
    }

    public void setMilkResult(String result) {
        milkResultLabel.setText(result);
    }

    public void setMilkButtonAction(ActionListener actionListener) {
        milkButton.addActionListener(actionListener);
    }

    public void showView() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }
}
