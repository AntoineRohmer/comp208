import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class SearchWindow extends JFrame {
	Vector<String> columnName = new Vector<String>();

	public SearchWindow(String table_name) {
		this.setTitle("Search");
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		final GridBagConstraints gridBagConstraints_1a = new GridBagConstraints();
		final JLabel table_L = new JLabel("Choose an attributes");
		gridBagConstraints_1a.gridy = 0;
		gridBagConstraints_1a.gridx = 0;
		gridBagConstraints_1a.insets = new Insets(0, 20, 5, 0);
		container.add(table_L, gridBagConstraints_1a);

		final GridBagConstraints gridBagConstraints_1b = new GridBagConstraints();
		final JComboBox attributes = new JComboBox();
		gridBagConstraints_1b.gridy = 0;
		gridBagConstraints_1b.gridx = 1;
		gridBagConstraints_1b.insets = new Insets(0, 5, 5, 10);

		try {
			columnName = DatabaseConnection.getColumn(table_name);
			int size = columnName.size();
			for (int i = 0; i < size; i++) {
				attributes.addItem(columnName.get(i));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		container.add(attributes, gridBagConstraints_1b);

		final GridBagConstraints gridBagConstraints_2a = new GridBagConstraints();
		final Label value_L = new Label("Value");
		gridBagConstraints_2a.gridy = 1;
		gridBagConstraints_2a.gridx = 0;
		gridBagConstraints_2a.insets = new Insets(10, 20, 5, 0);
		container.add(value_L, gridBagConstraints_2a);

		final GridBagConstraints gridBagConstraints_2b = new GridBagConstraints();
		final JTextField value = new JTextField();
		gridBagConstraints_2b.gridy = 1;
		gridBagConstraints_2b.gridx = 1;
		gridBagConstraints_2b.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_2b.insets = new Insets(10, 5, 5, 10);
		container.add(value, gridBagConstraints_2b);

		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		final JButton process = new JButton("Process");
		gridBagConstraints_3.gridy = 2;
		gridBagConstraints_3.gridx = 1;
		gridBagConstraints_3.insets = new Insets(30, 20, 0, 10);
		container.add(process, gridBagConstraints_3);
		process.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.MainFrameWindow.setVisible(false);
					System.out.println(attributes.getSelectedItem().toString());
					System.out.println(value.getText());
					Vector<Vector<String>> columnValue = DatabaseConnection.get(table_name, columnName,
							attributes.getSelectedItem().toString(), value.getText());
					Main.MainFrameWindow = new MainFrame(columnName, columnValue);
					setVisible(false);
					Main.MainFrameWindow.setVisible(true);
				} catch (Exception arg) {
					System.out.println(arg);
				}
			}
		});

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
