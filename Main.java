import java.awt.event.*;
import javax.swing.*;

/**
 * This class allows a user to give a string of 26 characters as a custom alphabet and some text.
 * The text can then be encoded or decoded based off of the button pressed.
 * The output is then displayed in a label.
 */
public class Main implements ActionListener {
    private JTextField modAlpha, inputText;
    private JFrame f;
    private JButton encode, decode;
    private JLabel outputLabel, l1, l2;

    /**
     * Creates a new window to allow the user to encode or decode text
     */
    private Main() {
        f = new JFrame("Encode-Decode"); //The window containing the program
        encode = new JButton("Encode"); //The button to be pressed to encode the text
        decode = new JButton("Decode"); //The button to be pressed to decode the text
        modAlpha = new JTextField(); //The textbox to receive the modified alphabet
        inputText = new JTextField(); //The textbox to receive the text to be encoded or decoded
        outputLabel = new JLabel(); //The output label
        l1 = new JLabel("Input a custom alphabet 26 characters in length here:"); //A label to indicate where to input the modified alphabet
        l2 = new JLabel("Input the text to be encoded or decoded here:"); //A label to indicate where to input the text

        f.setSize(400,400);
        encode.setBounds(200, 200, 100, 30);
        decode.setBounds(50, 200, 100, 30);
        modAlpha.setBounds(50,50, 150,20);
        inputText.setBounds(50,150, 150,20);
        outputLabel.setBounds(50,300, 300,30);
        l1.setBounds(10,10, 300, 30);
        l2.setBounds(10,100, 300,30);


        encode.addActionListener(this);
        decode.addActionListener(this);

        f.add(encode);
        f.add(decode);
        f.add(modAlpha);
        f.add(inputText);
        f.add(outputLabel);
        f.add(l1);
        f.add(l2);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method will run when either of the buttons are pressed.
     * Depending on the button pressed it will then either encode or decode the text in the inputText TextField
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = modAlpha.getText();

        if (text.length() != 26) {
            outputLabel.setText("Text length incorrect!");
            return;
        }
        char[] modifiedAlphabet = text.toCharArray();
        char[] input = inputText.getText().toLowerCase().toCharArray();
        char[] temp = new char[input.length];


        String output = "";
        for (char c:
             input) {
            if(c != ' ') {
                if(e.getSource() == encode) {
                    output = output+  modifiedAlphabet[c - 97];
                }
                else {
                    for (int i = 0; i < 26; i++) {
                        if (modifiedAlphabet[i] == c) {
                            char tempChar = (char) (i + 97);
                            output = output + tempChar;
                        }
                    }
                }
            }
            else {
                output = output + " ";
            }
        }


        outputLabel.setText(output);
    }

    public static void main(String[] args) {
        new Main();
    }
}
