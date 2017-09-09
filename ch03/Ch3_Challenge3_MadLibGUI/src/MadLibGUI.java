import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MadLibGUI extends JFrame {
	private JTextField txtColor;
	private JTextField txtVerb;
	private JTextField txtAdjective;
	private JTextField txtNoun;
	public MadLibGUI() {
		setTitle("Dr. Payne's GUI MadLibs");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JLabel lblDrPaynesWacky = new JLabel("Dr. Payne's Wacky MadLibs App");
		lblDrPaynesWacky.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblDrPaynesWacky.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrPaynesWacky.setBounds(106, 11, 322, 29);
		getContentPane().add(lblDrPaynesWacky);
		
		JLabel lblEnterAColor = new JLabel("Enter a Color:");
		lblEnterAColor.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lblEnterAColor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterAColor.setBounds(260, 54, 146, 14);
		getContentPane().add(lblEnterAColor);
		
		JLabel lblEnterAVerb = new JLabel("Enter a Verb Ending in -ed:");
		lblEnterAVerb.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lblEnterAVerb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterAVerb.setBounds(10, 91, 180, 14);
		getContentPane().add(lblEnterAVerb);
		
		JLabel lblEnterAnAdjective = new JLabel("Enter an Adjective:");
		lblEnterAnAdjective.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lblEnterAnAdjective.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterAnAdjective.setBounds(63, 54, 125, 14);
		getContentPane().add(lblEnterAnAdjective);
		
		JLabel lblEnterANoun = new JLabel("Enter a Noun:");
		lblEnterANoun.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lblEnterANoun.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterANoun.setBounds(296, 91, 110, 14);
		getContentPane().add(lblEnterANoun);
		
		txtColor = new JTextField();
		txtColor.setForeground(new Color(46, 139, 87));
		txtColor.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtColor.setText("pink");
		txtColor.setBounds(416, 51, 86, 20);
		getContentPane().add(txtColor);
		txtColor.setColumns(10);
		
		txtVerb = new JTextField();
		txtVerb.setForeground(new Color(0, 128, 0));
		txtVerb.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtVerb.setText("burped");
		txtVerb.setColumns(10);
		txtVerb.setBounds(200, 88, 86, 20);
		getContentPane().add(txtVerb);
		
		txtAdjective = new JTextField();
		txtAdjective.setForeground(new Color(0, 128, 0));
		txtAdjective.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtAdjective.setText("silly");
		txtAdjective.setColumns(10);
		txtAdjective.setBounds(200, 51, 86, 20);
		getContentPane().add(txtAdjective);
		
		txtNoun = new JTextField();
		txtNoun.setForeground(new Color(0, 128, 0));
		txtNoun.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtNoun.setText("roller skate");
		txtNoun.setColumns(10);
		txtNoun.setBounds(416, 88, 86, 20);
		getContentPane().add(txtNoun);
		
		JTextArea txtOutput = new JTextArea();
		txtOutput.setWrapStyleWord(true);
		txtOutput.setLineWrap(true);
		txtOutput.setText("The pink dragon burped at the silly roller skate.\r\nAnd everyone lived happily ever after. \r\nThe end.");
		txtOutput.setForeground(new Color(255, 0, 51));
		txtOutput.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
		txtOutput.setBackground(new Color(255, 255, 204));
		txtOutput.setBounds(10, 162, 514, 88);
		getContentPane().add(txtOutput);
		
		JButton btnPressHereTo = new JButton("Press Here to View Your MadLib Creation!");
		btnPressHereTo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String adjective = txtAdjective.getText();
		        String color = txtColor.getText();
		        String verb = txtVerb.getText();
		        String noun = txtNoun.getText();
		        txtOutput.setText("The " + color + " dragon " + verb + " at the " + adjective + " " + noun + ".\n" + 
		                "And everyone lived happily ever after. \n" + 
		                "The end.");
		    }
		});
		btnPressHereTo.setBackground(new Color(153, 255, 204));
		btnPressHereTo.setFont(new Font("Sitka Text", Font.BOLD, 11));
		btnPressHereTo.setBounds(106, 128, 322, 23);
		getContentPane().add(btnPressHereTo);
	}

	public static void main(String[] args) {

		MadLibGUI theGame = new MadLibGUI();
		
		theGame.setSize(new Dimension(550,300));
		theGame.setVisible(true);

	}
}
