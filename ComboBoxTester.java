package project;

import javax.swing.JFrame;

public class ComboBoxTester {
	public static void main(String args[]) {
		JFrame frame = new JFrame("FlightScanner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		ComboBox newContentPane = new ComboBox();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.add(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
		
		
	}
}
