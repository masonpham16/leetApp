import javax.swing.*;

public class mainWindow {
    public static void main(String[] args) {
        // Always start Swing on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hello");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel label = new JLabel("Hello", SwingConstants.CENTER);
            frame.add(label);

            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null); // center on screen
            frame.setVisible(true);
        });
    }
}
