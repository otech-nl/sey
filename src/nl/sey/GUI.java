package nl.sey;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	
	private JTextField achternaam, voornaam;
	private JLabel naam;

	public GUI() {
		// create and configure frame
		JFrame frame = new JFrame("SEY GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		
		// get and configure content pane
        Container content = frame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        // add fields
        content.add(new JLabel("Achternaam:"));
		achternaam = new JTextField(30);
		content.add(achternaam);
		
        content.add(new JLabel("Voornaam:"));
		voornaam = new JTextField(30);
		content.add(voornaam);
		
		JButton button = new JButton("OK");
		button.addActionListener(this);
		content.add(button);
		
		naam = new JLabel("-naam-");
		content.add(naam);

		// show frame
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		naam.setText(voornaam.getText() + " " + achternaam.getText());
	}
	
	public static void main(String[] args) {
		new GUI();
	}
}
