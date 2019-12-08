import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JFrame;

public class test {
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
