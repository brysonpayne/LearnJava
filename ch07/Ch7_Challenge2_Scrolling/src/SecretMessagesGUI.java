import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;

public class SecretMessagesGUI extends JFrame {
    private JTextField txtKey;
    private JTextArea txtIn;
    private JTextArea txtOut;
    private JSlider slider;
    private JButton btnMoveUp;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane_1;
    public String encode( String message, int keyVal ){
        String output = "";
        char key = (char) keyVal;
        for ( int x = 0; x < message.length(); x++ ) {
            char input = message.charAt(x);
            if (input >= 'A' && input <= 'Z') 
            { 
                input += key;
                if (input > 'Z')
                    input -= 26;
                if (input < 'A')
                    input += 26;
            }
            else if (input >= 'a' && input <= 'z')
            { 
                input += key;
                if (input > 'z')
                    input -= 26;
                if (input < 'a')
                    input += 26;
            }
            else if (input >= '0' && input <= '9')
            {
                input += (keyVal % 10);
                if (input > '9')
                    input -= 10;
                if (input < '0')
                    input += 10;
            }
            output += input;
        }
        return output;
    }
    public SecretMessagesGUI() {
        getContentPane().setBackground(new Color(135, 206, 235));
        setTitle("Dr. Payne's Secret Message App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 564, 140);
        getContentPane().add(scrollPane);

        txtIn = new JTextArea();
        scrollPane.setViewportView(txtIn);
        txtIn.setWrapStyleWord(true);
        txtIn.setLineWrap(true);
        txtIn.setFont(new Font("Lucida Console", Font.PLAIN, 18));
        
        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 210, 564, 140);
        getContentPane().add(scrollPane_1);

        txtOut = new JTextArea();
        scrollPane_1.setViewportView(txtOut);
        txtOut.setWrapStyleWord(true);
        txtOut.setLineWrap(true);
        txtOut.setFont(new Font("Lucida Console", Font.PLAIN, 18));

        txtKey = new JTextField();
        txtKey.setHorizontalAlignment(SwingConstants.CENTER);
        txtKey.setText("3");
        txtKey.setBounds(258, 173, 44, 20);
        getContentPane().add(txtKey);
        txtKey.setColumns(10);

        JLabel lblKey = new JLabel("Key:");
        lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
        lblKey.setBounds(202, 176, 46, 14);
        getContentPane().add(lblKey);

        JButton btnEncodedecode = new JButton("Encode/Decode");
        btnEncodedecode.setBackground(new Color(135, 206, 235));
        btnEncodedecode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String message = txtIn.getText();
                    int key = Integer.parseInt( txtKey.getText() );
                    String output = encode( message, key );
                    txtOut.setText( output );
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, 
                "Please enter a whole number value for the encryption key.");
                    txtKey.requestFocus();
                    txtKey.selectAll();
                }
            }
        });
        btnEncodedecode.setBounds(312, 172, 144, 23);
        getContentPane().add(btnEncodedecode);

        slider = new JSlider();
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                txtKey.setText( "" + slider.getValue() );
                String message = txtIn.getText();
                int key = slider.getValue();
                String output = encode( message, key );
                txtOut.setText( output );
            } 
        });
        slider.setValue(3);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(13);
        slider.setMinorTickSpacing(1);
        slider.setMinimum(-26);
        slider.setMaximum(26);
        slider.setPaintLabels(true);
        slider.setBackground(new Color(135, 206, 235));
        slider.setBounds(10, 162, 200, 45);
        getContentPane().add(slider);
        
        btnMoveUp = new JButton("Move Up ^");
        btnMoveUp.setBackground(new Color(135, 206, 235));
        btnMoveUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String temp = txtIn.getText();
                txtIn.setText(txtOut.getText());
                slider.setValue(-slider.getValue());
            }
        });
        btnMoveUp.setBounds(466, 172, 108, 23);
        getContentPane().add(btnMoveUp);
    }

    public static void main(String[] args) {
        SecretMessagesGUI theApp = new SecretMessagesGUI();
        theApp.setSize(new Dimension(600,400));
        theApp.setVisible(true);

    }
}
