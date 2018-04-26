import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;

public class SignUpWindow extends JFrame {
	public SignUpWindow() {
		class Refresh implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new SignUpWindow();
				setVisible(false);
			}
		}
		this.setTitle("Sign in");
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		final GridBagConstraints gridBagConstraints_1a = new GridBagConstraints();
		final JLabel userID_L = new JLabel("user ID:");
		gridBagConstraints_1a.gridy = 0;
		gridBagConstraints_1a.gridx = 0;
		// gridBagConstraints_1a.weighty = 40;
		gridBagConstraints_1a.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_1a.insets = new Insets(0, 20, 5, 0);
		container.add(userID_L, gridBagConstraints_1a);

		final GridBagConstraints gridBagConstraints_1b = new GridBagConstraints();
		final JTextField userID = new JTextField();
		gridBagConstraints_1b.gridy = 0;
		gridBagConstraints_1b.gridx = 1;
		gridBagConstraints_1b.gridwidth = 2;
		gridBagConstraints_1b.weightx = 5;
		gridBagConstraints_1b.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_1b.insets = new Insets(0, 5, 5, 10);
		container.add(userID, gridBagConstraints_1b);

		final GridBagConstraints gridBagConstraints_2a = new GridBagConstraints();
		final JLabel email_L = new JLabel("Email address:");
		gridBagConstraints_2a.gridy = 1;
		gridBagConstraints_2a.gridx = 0;
		gridBagConstraints_2a.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_2a.insets = new Insets(5, 20, 5, 0);
		container.add(email_L, gridBagConstraints_2a);

		final GridBagConstraints gridBagConstraints_2b = new GridBagConstraints();
		final JTextField email = new JTextField();
		gridBagConstraints_2b.gridy = 1;
		gridBagConstraints_2b.gridx = 1;
		gridBagConstraints_2b.gridwidth = 2;
		gridBagConstraints_2b.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_2b.insets = new Insets(5, 5, 5, 10);
		container.add(email, gridBagConstraints_2b);

		final GridBagConstraints gridBagConstraints_3a = new GridBagConstraints();
		final JLabel password_L = new JLabel("Password:");
		gridBagConstraints_3a.gridy = 2;
		gridBagConstraints_3a.gridx = 0;
		gridBagConstraints_3a.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_3a.insets = new Insets(5, 20, 5, 0);
		container.add(password_L, gridBagConstraints_3a);

		final GridBagConstraints gridBagConstraints_3b = new GridBagConstraints();
		final JPasswordField password = new JPasswordField();
		gridBagConstraints_3b.gridy = 2;
		gridBagConstraints_3b.gridx = 1;
		gridBagConstraints_3b.gridwidth = 2;
		gridBagConstraints_3b.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_3b.insets = new Insets(5, 5, 5, 10);
		container.add(password, gridBagConstraints_3b);

		final GridBagConstraints gridBagConstraints_4a = new GridBagConstraints();
		final JLabel password_CL = new JLabel("Confirm password:");
		gridBagConstraints_4a.gridy = 3;
		gridBagConstraints_4a.gridx = 0;
		gridBagConstraints_4a.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_4a.insets = new Insets(5, 20, 5, 0);
		container.add(password_CL, gridBagConstraints_4a);

		final GridBagConstraints gridBagConstraints_4b = new GridBagConstraints();
		final JPasswordField password_C = new JPasswordField();
		gridBagConstraints_4b.gridy = 3;
		gridBagConstraints_4b.gridx = 1;
		gridBagConstraints_4b.gridwidth = 2;
		gridBagConstraints_4b.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_4b.insets = new Insets(5, 5, 5, 10);
		container.add(password_C, gridBagConstraints_4b);

		final GridBagConstraints gridBagConstraints_6a = new GridBagConstraints();
		final JLabel access_L = new JLabel("Access Level");
		gridBagConstraints_6a.gridy = 4;
		gridBagConstraints_6a.gridx = 2;
		gridBagConstraints_6a.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_6a.insets = new Insets(5, 5, 5, 10);
		container.add(access_L, gridBagConstraints_6a);

		final GridBagConstraints gridBagConstraints_6b = new GridBagConstraints();
		final JComboBox access = new JComboBox();
		gridBagConstraints_6b.gridy = 4;
		gridBagConstraints_6b.gridx = 2;
		gridBagConstraints_6b.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_6b.insets = new Insets(5, 5, 5, 10);
		access.addItem("1");
		access.addItem("2");
		access.addItem("3");
		container.add(access, gridBagConstraints_6b);

		final GridBagConstraints gridBagConstraints_5a = new GridBagConstraints();
		final JButton reset = new JButton("Refresh");
		gridBagConstraints_5a.gridy = 5;
		gridBagConstraints_5a.gridx = 1;
		// gridBagConstraints_5a.weightx = 5;
		// gridBagConstraints_5a.gridwidth = 2;
		gridBagConstraints_5a.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5a.insets = new Insets(20, 0, 0, 0);
		reset.addActionListener(new Refresh());
		container.add(reset, gridBagConstraints_5a);

		final GridBagConstraints gridBagConstraints_5b = new GridBagConstraints();
		final JButton submit = new JButton("Submit");
		gridBagConstraints_5b.gridy = 5;
		gridBagConstraints_5b.gridx = 2;
		gridBagConstraints_5b.gridwidth = 1;
		gridBagConstraints_5b.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5b.insets = new Insets(20, 55, 0, 10);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// regular expression match
				String content = email.getText();
				String pattern = "^([A-Z]|[a-z]|[0-9])(([A-Z]|[a-z]|[0-9])+(\\-|\\.)?)+\\@{1}(([A-Z]|[a-z]|[0-9])+(\\-|\\.)?)+$.*";
				boolean isMatch = Pattern.matches(pattern, content);
				if (isMatch) {
					System.out.println("That's valid email address");
				} else {
					System.out.println("That's invalid email address");
				}
			}
		});
		container.add(submit, gridBagConstraints_5b);

		container.setBackground(Color.white);
		setVisible(true);
		setSize(360, 280);
		setResizable(false);
		int windowWidth = getWidth();
		int windowHeight = getHeight();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
