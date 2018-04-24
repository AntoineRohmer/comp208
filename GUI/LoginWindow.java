import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginWindow extends JFrame{
	String access_LV;
	public LoginWindow() {
		class SignUp implements ActionListener{
			public void actionPerformed(ActionEvent e){
				new SignUpWindow();
				setVisible(false);
			}
		}
		this.setTitle("Login");
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		final JTextField username = new JTextField();
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridx = 2;
		gridBagConstraints.insets = new Insets(0,0,0,50);
		gridBagConstraints.weightx = 15;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		//gridBagConstraints.anchor = GridBagConstraints.NORTH;
		container.add(username, gridBagConstraints);
		
		final JLabel usernameLabel = new JLabel("username");
		final GridBagConstraints LabelgridBagConstraints = new GridBagConstraints();
		LabelgridBagConstraints.gridy = 0;
		LabelgridBagConstraints.gridx = 1;
		LabelgridBagConstraints.insets = new Insets(0,50,0,0);
		LabelgridBagConstraints.weightx = 1;
		LabelgridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		//LabelgridBagConstraints.anchor = GridBagConstraints.NORTH;
		container.add(usernameLabel, LabelgridBagConstraints);
		
		final JLabel passwordLabel = new JLabel("password");
		final GridBagConstraints LabelgridBagConstraints_1 = new GridBagConstraints();
		LabelgridBagConstraints_1.gridy = 1;
		LabelgridBagConstraints_1.gridx = 1;
		LabelgridBagConstraints_1.insets = new Insets(15,50,0,0);
		LabelgridBagConstraints_1.weightx = 1;
		LabelgridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		container.add(passwordLabel, LabelgridBagConstraints_1);
		
		final JPasswordField password = new JPasswordField();
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy = 1;
		gridBagConstraints_1.gridx = 2;
		gridBagConstraints_1.insets = new Insets(15,0,0,50);
		gridBagConstraints_1.weightx = 15;
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		container.add(password, gridBagConstraints_1);
		
		final JButton login_in = new JButton("Login in");
		final GridBagConstraints gridBagConstraints_2 =new GridBagConstraints();
		gridBagConstraints_2.gridy = 2;
		gridBagConstraints_2.gridx = 2;
		gridBagConstraints_2.insets = new Insets(30,35,0,125);
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		login_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You have input: "+username.getText());
				access_LV = username.getText();
				new MainFrame(access_LV);
				setVisible(false);
			}
		});
		container.add(login_in, gridBagConstraints_2);
		
		/**
		final JLabel sign_in_1 = new JLabel("Havn't get a account yet?");
		final GridBagConstraints LabelgridBagConstraints_2 = new GridBagConstraints();
		LabelgridBagConstraints_2.gridy = 3;
		LabelgridBagConstraints_2.gridx = 2;
		LabelgridBagConstraints_2.insets = new Insets(10,0,0,0);
		LabelgridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		container.add(sign_in_1, LabelgridBagConstraints_2);
		**/
		
		/**
		final JButton sign = new JButton("Sign in");
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy = 4;
		gridBagConstraints_3.gridx = 2;
		gridBagConstraints_3.insets = new Insets(0,50,0,150);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		sign.addActionListener(new SignUp());
		container.add(sign, gridBagConstraints_3);
		**/
		
		container.setBackground(Color.white);
		setVisible(true);
		setSize(400, 300);
		int windowWidth = getWidth(); 
		int windowHeight = getHeight(); 
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenWidth = screenSize.width; 
		int screenHeight = screenSize.height; 
		setResizable(false);
		setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception {
		new LoginWindow();
	}
}
