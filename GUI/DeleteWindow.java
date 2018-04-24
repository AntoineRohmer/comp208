import java.awt.*;
import javax.swing.*;

public class DeleteWindow extends JFrame{
	public DeleteWindow(String table_name) {
		this.setTitle("Delete");
		Container container = getContentPane();
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
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
