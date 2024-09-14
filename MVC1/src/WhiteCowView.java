import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WhiteCowView {
    private JFrame frame;
    private JPanel panel;
    private JLabel cowInfoLabel;
    private JButton milkButton;
    private JButton addLemonButton;
    private JLabel milkResultLabel;
    private JLabel infoLabel;

    public WhiteCowView(JFrame frame) {
        this.frame = frame;
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        cowInfoLabel = new JLabel("Cow Info: ");
        milkButton = new JButton("Milk Cow");
        addLemonButton = new JButton("Add Lemon & Milk");
        milkResultLabel = new JLabel("Milk Result: ");
        infoLabel = new JLabel("");

        panel.add(cowInfoLabel);
        panel.add(milkButton);
        panel.add(addLemonButton);
        panel.add(milkResultLabel);
        panel.add(infoLabel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setCowInfo(String info) {
        cowInfoLabel.setText(info);
    }

    public void setInfoLabel(String result) {
        infoLabel.setText(result);
    }

    public void setMilkResult(String result) {
        milkResultLabel.setText(result);
    }

    public void setMilkButtonAction(ActionListener actionListener) {
        milkButton.addActionListener(actionListener);
    }

    public void setAddLemonButtonAction(ActionListener actionListener) {
        addLemonButton.addActionListener(actionListener);
    }

    public void showView() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }
}
