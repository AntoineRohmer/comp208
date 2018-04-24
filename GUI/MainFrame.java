import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

public class MainFrame extends JFrame{
	int d = 1;
	public String table_name = "";
	Container container = getContentPane();
	final JScrollPane scrollPane = new JScrollPane();
	
	public MainFrame(String access_LV) {
		if(access_LV.equals("1")) {
			this.setTitle("Main");
			final JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			final JMenu file = new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F);
			final JMenu help = new JMenu("Help");
			help.setMnemonic(KeyEvent.VK_H);
			menuBar.add(file);
			menuBar.add(help);
			final JMenuItem tutorial = new JMenuItem("Tutorial");
			tutorial.addActionListener(new menuItemListener());
			tutorial.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
			tutorial.setMnemonic(KeyEvent.VK_T);
			final JMenuItem contact = new JMenuItem("Contact us");
			contact.addActionListener(new menuItemListener());
			contact.setMnemonic(KeyEvent.VK_C);
			
			final JMenu open = new JMenu("Open");
			//open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
			open.setMnemonic(KeyEvent.VK_O);
			final JMenuItem appointments = new JMenuItem("appointments");
			appointments.addActionListener(new table());
			final JMenuItem customers = new JMenuItem("customers");
			customers.addActionListener(new table());
			final JMenuItem invoice = new JMenuItem("invoice");
			invoice.addActionListener(new table());
			final JMenuItem parts = new JMenuItem("parts");
			parts.addActionListener(new table());
			final JMenuItem repairs = new JMenuItem("repairs");
			repairs.addActionListener(new table());
			final JMenuItem staff = new JMenuItem("staff");
			staff.addActionListener(new table());
			final JMenuItem vehicles = new JMenuItem("vehicles");
			vehicles.addActionListener(new table());
			open.add(appointments);
			open.add(customers);
			open.add(invoice);
			open.add(parts);
			open.add(repairs);
			open.add(staff);
			open.add(vehicles);
			final JMenuItem aborts = new JMenuItem("Aborts");
			aborts.addActionListener(new menuItemListener());
			aborts.setMnemonic(KeyEvent.VK_A);
			final JMenuItem save = new JMenuItem("Save");
			save.addActionListener(new menuItemListener());
			save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			save.setMnemonic(KeyEvent.VK_S);
			final JMenuItem undo = new JMenuItem("Undo");
			undo.addActionListener(new menuItemListener());
			undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
			undo.setMnemonic(KeyEvent.VK_U);
			final JMenuItem redo = new JMenuItem("Redo");
			redo.addActionListener(new menuItemListener());
			redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
			redo.setMnemonic(KeyEvent.VK_R);
			final JMenuItem close = new JMenuItem("Close");
			close.addActionListener(new menuItemListener());
			close.setMnemonic(KeyEvent.VK_C);
			final JMenuItem  toolbar_menu = new JMenuItem("Toolbar");
			toolbar_menu.setMnemonic(KeyEvent.VK_T);
			toolbar_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
			
			//add all menu items to menus
			file.add(open);
			file.addSeparator();
			file.add(save);
			file.add(aborts);
			file.addSeparator();
			file.add(undo);
			file.add(redo);
			file.addSeparator();
			file.add(toolbar_menu);
			file.addSeparator();
			file.add(close);
			help.add(tutorial);
			help.addSeparator();
			help.add(contact);
			
			final JToolBar toolBar = new JToolBar("ToolBar");
			toolBar.setFloatable(false);
			container.add(toolBar, BorderLayout.SOUTH);
			toolbar_menu.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(d==1) {
						toolBar.setVisible(false);
						d = 0;
					}else {
						toolBar.setVisible(true);
						d = 1;
					}
				}
			});
			
			final JButton search = new JButton("Search");
			toolBar.add(search);
			toolBar.addSeparator();
			search.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new SearchWindow(table_name);
				}
			});
			final JButton delete = new JButton("Delete");
			toolBar.add(delete);
			toolBar.addSeparator();
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DeleteWindow(table_name);
				}
			});
			
			final JButton createUser = new JButton("Create user");
			toolBar.add(createUser);
			toolBar.addSeparator();
			createUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SignUpWindow();
				}
			});
			
			final JButton query = new JButton("Custom queries");
			toolBar.add(query);
			toolBar.addSeparator();
			query.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new QueryWindow();
				}
			});
			
			Vector<String> columnName = new Vector();
			Vector<Vector<String>> columnValue = new Vector();
			JTable table= new MyTable(columnValue, columnName);
			table.setRowHeight(30);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			container.add(table, BorderLayout.CENTER);
			JTableHeader tableHeader = table.getTableHeader();
			container.add(tableHeader, BorderLayout.NORTH);
			scrollPane.setViewportView(table);
			// default border layout
			container.add(scrollPane, BorderLayout.CENTER); 
			
			container.setBackground(Color.white);
			setVisible(true);
			setSize(640, 480);
			int windowWidth = getWidth(); 
			int windowHeight = getHeight(); 
			Toolkit kit = Toolkit.getDefaultToolkit(); 
			Dimension screenSize = kit.getScreenSize(); 
			int screenWidth = screenSize.width; 
			int screenHeight = screenSize.height; 
			setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}else if(access_LV.equals("2")) {
			this.setTitle("Main");
			final JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			final JMenu file = new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F);
			final JMenu help = new JMenu("Help");
			help.setMnemonic(KeyEvent.VK_H);
			menuBar.add(file);
			menuBar.add(help);
			final JMenuItem tutorial = new JMenuItem("Tutorial");
			tutorial.addActionListener(new menuItemListener());
			tutorial.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
			tutorial.setMnemonic(KeyEvent.VK_T);
			final JMenuItem contact = new JMenuItem("Contact us");
			contact.addActionListener(new menuItemListener());
			contact.setMnemonic(KeyEvent.VK_C);
			
			final JMenu open = new JMenu("Open");
			//open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
			open.setMnemonic(KeyEvent.VK_O);
			final JMenuItem appointments = new JMenuItem("appointments");
			appointments.addActionListener(new table());
			final JMenuItem customers = new JMenuItem("customers");
			customers.addActionListener(new table());
			final JMenuItem invoice = new JMenuItem("invoice");
			invoice.addActionListener(new table());
			final JMenuItem parts = new JMenuItem("parts");
			parts.addActionListener(new table());
			final JMenuItem repairs = new JMenuItem("repairs");
			repairs.addActionListener(new table());
			final JMenuItem staff = new JMenuItem("staff");
			staff.addActionListener(new table());
			final JMenuItem vehicles = new JMenuItem("vehicles");
			vehicles.addActionListener(new table());
			open.add(appointments);
			open.add(customers);
			open.add(invoice);
			open.add(parts);
			open.add(repairs);
			open.add(staff);
			open.add(vehicles);
			final JMenuItem aborts = new JMenuItem("Aborts");
			aborts.addActionListener(new menuItemListener());
			aborts.setMnemonic(KeyEvent.VK_A);
			final JMenuItem save = new JMenuItem("Save");
			save.addActionListener(new menuItemListener());
			save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			save.setMnemonic(KeyEvent.VK_S);
			final JMenuItem undo = new JMenuItem("Undo");
			undo.addActionListener(new menuItemListener());
			undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
			undo.setMnemonic(KeyEvent.VK_U);
			final JMenuItem redo = new JMenuItem("Redo");
			redo.addActionListener(new menuItemListener());
			redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
			redo.setMnemonic(KeyEvent.VK_R);
			final JMenuItem close = new JMenuItem("Close");
			close.addActionListener(new menuItemListener());
			close.setMnemonic(KeyEvent.VK_C);
			final JMenuItem  toolbar_menu = new JMenuItem("Toolbar");
			toolbar_menu.setMnemonic(KeyEvent.VK_T);
			toolbar_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
			
			//add all menu items to menus
			file.add(open);
			file.addSeparator();
			file.add(save);
			file.add(aborts);
			file.addSeparator();
			file.add(undo);
			file.add(redo);
			file.addSeparator();
			file.add(toolbar_menu);
			file.addSeparator();
			file.add(close);
			help.add(tutorial);
			help.addSeparator();
			help.add(contact);
			
			final JToolBar toolBar = new JToolBar("ToolBar");
			toolBar.setFloatable(false);
			container.add(toolBar, BorderLayout.SOUTH);
			toolbar_menu.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(d==1) {
						toolBar.setVisible(false);
						d = 0;
					}else {
						toolBar.setVisible(true);
						d = 1;
					}
				}
			});
			
			final JButton search = new JButton("Search");
			toolBar.add(search);
			toolBar.addSeparator();
			search.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new SearchWindow(table_name);
				}
			});
			final JButton delete = new JButton("Delete");
			toolBar.add(delete);
			toolBar.addSeparator();
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DeleteWindow(table_name);
				}
			});
			
			Vector<String> columnName = new Vector();
			Vector<Vector<String>> columnValue = new Vector();
			JTable table= new MyTable(columnValue, columnName);
			table.setRowHeight(30);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			container.add(table, BorderLayout.CENTER);
			JTableHeader tableHeader = table.getTableHeader();
			container.add(tableHeader, BorderLayout.NORTH);
			scrollPane.setViewportView(table);
			// default border layout
			container.add(scrollPane, BorderLayout.CENTER); 
			
			container.setBackground(Color.white);
			setVisible(true);
			setSize(640, 480);
			int windowWidth = getWidth(); 
			int windowHeight = getHeight(); 
			Toolkit kit = Toolkit.getDefaultToolkit(); 
			Dimension screenSize = kit.getScreenSize(); 
			int screenWidth = screenSize.width; 
			int screenHeight = screenSize.height; 
			setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}else if(access_LV.equals("3")) {
			this.setTitle("Main");
			final JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			final JMenu file = new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F);
			final JMenu help = new JMenu("Help");
			help.setMnemonic(KeyEvent.VK_H);
			menuBar.add(file);
			menuBar.add(help);
			final JMenuItem tutorial = new JMenuItem("Tutorial");
			tutorial.addActionListener(new menuItemListener());
			tutorial.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
			tutorial.setMnemonic(KeyEvent.VK_T);
			final JMenuItem contact = new JMenuItem("Contact us");
			contact.addActionListener(new menuItemListener());
			contact.setMnemonic(KeyEvent.VK_C);
			
			final JMenu open = new JMenu("Open");
			//open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
			open.setMnemonic(KeyEvent.VK_O);
			final JMenuItem appointments = new JMenuItem("appointments");
			appointments.addActionListener(new table());
			final JMenuItem customers = new JMenuItem("customers");
			customers.addActionListener(new table());
			final JMenuItem invoice = new JMenuItem("invoice");
			invoice.addActionListener(new table());
			final JMenuItem parts = new JMenuItem("parts");
			parts.addActionListener(new table());
			final JMenuItem repairs = new JMenuItem("repairs");
			repairs.addActionListener(new table());
			final JMenuItem staff = new JMenuItem("staff");
			staff.addActionListener(new table());
			final JMenuItem vehicles = new JMenuItem("vehicles");
			vehicles.addActionListener(new table());
			open.add(appointments);
			open.add(customers);
			open.add(invoice);
			open.add(parts);
			open.add(repairs);
			open.add(staff);
			open.add(vehicles);
			final JMenuItem aborts = new JMenuItem("Aborts");
			aborts.addActionListener(new menuItemListener());
			aborts.setMnemonic(KeyEvent.VK_A);
			final JMenuItem save = new JMenuItem("Save");
			save.addActionListener(new menuItemListener());
			save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			save.setMnemonic(KeyEvent.VK_S);
			final JMenuItem undo = new JMenuItem("Undo");
			undo.addActionListener(new menuItemListener());
			undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
			undo.setMnemonic(KeyEvent.VK_U);
			final JMenuItem redo = new JMenuItem("Redo");
			redo.addActionListener(new menuItemListener());
			redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
			redo.setMnemonic(KeyEvent.VK_R);
			final JMenuItem close = new JMenuItem("Close");
			close.addActionListener(new menuItemListener());
			close.setMnemonic(KeyEvent.VK_C);
			final JMenuItem  toolbar_menu = new JMenuItem("Toolbar");
			toolbar_menu.setMnemonic(KeyEvent.VK_T);
			toolbar_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
			
			//add all menu items to menus
			file.add(open);
			file.addSeparator();
			file.add(save);
			file.add(aborts);
			file.addSeparator();
			file.add(undo);
			file.add(redo);
			file.addSeparator();
			file.add(toolbar_menu);
			file.addSeparator();
			file.add(close);
			help.add(tutorial);
			help.addSeparator();
			help.add(contact);
			
			final JToolBar toolBar = new JToolBar("ToolBar");
			toolBar.setFloatable(false);
			container.add(toolBar, BorderLayout.SOUTH);
			toolbar_menu.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(d==1) {
						toolBar.setVisible(false);
						d = 0;
					}else {
						toolBar.setVisible(true);
						d = 1;
					}
				}
			});
			
			final JButton search = new JButton("Search");
			toolBar.add(search);
			toolBar.addSeparator();
			search.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new SearchWindow(table_name);
				}
			});
			final JButton delete = new JButton("Delete");
			toolBar.add(delete);
			toolBar.addSeparator();
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DeleteWindow(table_name);
				}
			});
			
			Vector<String> columnName = new Vector();
			Vector<Vector<String>> columnValue = new Vector();
			JTable table= new MyTable(columnValue, columnName);
			table.setRowHeight(30);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			container.add(table, BorderLayout.CENTER);
			JTableHeader tableHeader = table.getTableHeader();
			container.add(tableHeader, BorderLayout.NORTH);
			scrollPane.setViewportView(table);
			// default border layout
			container.add(scrollPane, BorderLayout.CENTER); 
			
			container.setBackground(Color.white);
			setVisible(true);
			setSize(640, 480);
			int windowWidth = getWidth(); 
			int windowHeight = getHeight(); 
			Toolkit kit = Toolkit.getDefaultToolkit(); 
			Dimension screenSize = kit.getScreenSize(); 
			int screenWidth = screenSize.width; 
			int screenHeight = screenSize.height; 
			setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}else {
			
		}
		
	}
	
	
	private class menuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem menuItem = (JMenuItem)e.getSource();//get the source menu item
			System.out.println("You have clicked: " + menuItem.getText());
		}
	}
	
	private class table implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem menuItem = (JMenuItem)e.getSource();
			table_name = menuItem.getText();
			try {
				Vector<String> columnName = DatabaseConnection.getColumn(table_name);
				Vector<Vector<String>> columnValue = DatabaseConnection.get(table_name, columnName);
				JTable table= new MyTable(columnValue, columnName);
				table.setRowHeight(30);
				//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				container.add(table, BorderLayout.CENTER);
				JTableHeader tableHeader = table.getTableHeader();
				container.add(tableHeader, BorderLayout.NORTH);
				scrollPane.setViewportView(table);
				// default border layout
				container.add(scrollPane, BorderLayout.CENTER);
			}catch(Exception exception) {
				System.out.println(exception);
			}
		}
	}
	
	private class MyTable extends JTable{
		public MyTable(Vector<Vector<String>> rowData, Vector<String> columnNames) {
			super(rowData, columnNames);
		}
		
		public JTableHeader getTableHeader(){
			JTableHeader tableHeader = super.getTableHeader();
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return tableHeader;
		}
		
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super.getDefaultRenderer(columnClass);
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return cr;
		}
	}
}
