import javax.swing.*;
import java.awt.*;

/**
 * Java leetcode app: runs an app that does what leetcode asks you to solve.
 *
 * @author Mason Pham
 */
public class MainWindow {
	private static final String HOME = "HOME";
	private static final String PALINDROME = "PALINDROME";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("leetApp");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600, 600);
			frame.setLocationRelativeTo(null);

			CardLayout cards = new CardLayout();
			JPanel root = new JPanel(cards);

			// Create screens
			JPanel homePanel = buildHomePanel(cards, root);
			JPanel palindromePanel = buildPalindromePanel(cards, root);

			// Register screens
			root.add(homePanel, HOME);
			root.add(palindromePanel, PALINDROME);

			frame.setContentPane(root);
			frame.setVisible(true);

			cards.show(root, HOME);
		});
	}

	private static JPanel buildHomePanel(CardLayout cards, JPanel root) {
		JPanel panel = new JPanel(new BorderLayout(8, 8));

		JLabel title = new JLabel("leetApp", SwingConstants.CENTER);
		title.setFont(new Font("SansSerif", Font.BOLD, 28));
		panel.add(title, BorderLayout.NORTH);

		JPanel buttons = new JPanel(new GridLayout(0, 1, 8, 8));

		JButton palindromeBtn = new JButton("#9 Palindrome Number");
		palindromeBtn.setFont(new Font("SansSerif", Font.PLAIN, 20));
		palindromeBtn.addActionListener(e -> cards.show(root, PALINDROME));
		buttons.add(palindromeBtn);

		// Later you’ll add more buttons here:
		// buttons.add(makeNavButton("#1 Two Sum", cards, root, TWO_SUM));

		JPanel wrapper = new JPanel(new BorderLayout());
		wrapper.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
		wrapper.add(buttons, BorderLayout.NORTH);

		panel.add(wrapper, BorderLayout.CENTER);

		return panel;
	}

	private static JPanel buildPalindromePanel(CardLayout cards, JPanel root) {
		JPanel panel = new JPanel(new BorderLayout(8, 8));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel title = new JLabel("#9 Palindrome Number", SwingConstants.CENTER);
		title.setFont(new Font("SansSerif", Font.BOLD, 24));
		panel.add(title, BorderLayout.NORTH);

		JPanel center = new JPanel(new GridLayout(5, 1, 8, 8));

		JLabel instructions = new JLabel("Enter an integer, then click Check:", SwingConstants.CENTER);
		instructions.setFont(new Font("SansSerif", Font.PLAIN, 18));

		JTextField input = new JTextField();
		input.setFont(new Font("SansSerif", Font.PLAIN, 20));

		JButton check = new JButton("Check");
		check.setFont(new Font("SansSerif", Font.PLAIN, 18));

		JLabel result = new JLabel("", SwingConstants.CENTER);
		result.setFont(new Font("SansSerif", Font.PLAIN, 20));

		// Make Enter key run the check too
		input.addActionListener(e -> check.doClick());

		check.addActionListener(e -> {
			try {
				int value = Integer.parseInt(input.getText().trim());
				boolean isPal = PalindromeNumber.isPalindrome(value);
				result.setText(isPal ? "Palindrome ✅" : "Not a palindrome ❌");
			} catch (NumberFormatException ex) {
				result.setText("Please enter a valid integer");
			}
		});

		center.add(instructions);
		center.add(input);
		center.add(check);
		center.add(result);

		panel.add(center, BorderLayout.CENTER);

		JButton back = new JButton("← Back");
		back.setFont(new Font("SansSerif", Font.PLAIN, 16));
		back.addActionListener(e -> {
			input.setText("");
			result.setText("");
			cards.show(root, HOME);
		});
		panel.add(back, BorderLayout.SOUTH);

		return panel;
	}
}
