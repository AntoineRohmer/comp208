import java.awt.*;
import javax.swing.*;

public class SearchWindow extends JFrame{
	public SearchWindow(String table_name) {
		if(table_name == "") {
			this.setTitle("Search");
			Container container = getContentPane();
			container.setLayout(new GridBagLayout());
			final GridBagConstraints gridBagConstraints_1a = new GridBagConstraints();
			final JLabel table_L = new JLabel("Choose an attributes");
			gridBagConstraints_1a.gridy = 0;
			gridBagConstraints_1a.gridx = 0;
			container.add(table_L, gridBagConstraints_1a);
		
			final GridBagConstraints gridBagConstraints_1b = new GridBagConstraints();
			final JComboBox attributes = new JComboBox();
			gridBagConstraints_1b.gridy = 0;
			gridBagConstraints_1b.gridx = 1;
			attributes.addItem("Appoinment ID");
			attributes.addItem("Vehicle ID");
			attributes.addItem("Date time");
			attributes.addItem("User ID");
			container.add(attributes, gridBagConstraints_1b);
			
			final GridBagConstraints gridBagConstraints_2a = new GridBagConstraints();
			final Label value_L = new Label("Value");
			gridBagConstraints_2a.gridy = 1;
			gridBagConstraints_2a.gridx = 0;
			container.add(value_L, gridBagConstraints_2a);
			
			final GridBagConstraints gridBagConstraints_2b = new GridBagConstraints();
			final JTextField value = new JTextField();
			gridBagConstraints_2b.gridy = 1;
			gridBagConstraints_2b.gridx = 1;
			container.add(value, gridBagConstraints_2b);
		
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
			setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
	}
}
