import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CowView {
    private JFrame frame;
    private JPanel panel;
    private JTextField cowIdField;
    private JButton checkCowButton;
    private JLabel infoLabel;

    public CowView(JFrame frame) {
        this.frame = frame;
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        cowIdField = new JTextField(10);
        checkCowButton = new JButton("Check Cow");
        infoLabel = new JLabel("");

        panel.add(new JLabel("Enter Cow ID:"));
        panel.add(cowIdField);
        panel.add(checkCowButton);
        panel.add(infoLabel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getCowIdInput() {
        return cowIdField.getText();
    }

    public void setInfo(String info) {
        infoLabel.setText(info);
    }

    public void setCheckCowButtonAction(ActionListener actionListener) {
        checkCowButton.addActionListener(actionListener);
    }

    public void showView() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }
}
