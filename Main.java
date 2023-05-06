import java.awt.event.*;
import javax.swing.*;
public class Main implements ActionListener {
    JTextField modAlpha, inputText;
    JFrame f;
    JButton encode, decode;
    JLabel outputLabel, l1, l2;
    Main() {
        f = new JFrame("Encode-Decode");
        encode = new JButton("Encode");
        decode = new JButton("Decode");
        modAlpha = new JTextField();
        inputText = new JTextField();
        outputLabel = new JLabel();
        l1 = new JLabel("Input a custom alphabet 26 characters in length here:");
        l2 = new JLabel("Input the text to be encoded or decoded here:");

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = modAlpha.getText();

        if (text.length() != 26) {
            outputLabel.setText("Text length incorrect!");
            return;
        }
        char[] modifiedAlphabet = text.toCharArray();
        //char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',  'i',  'j',  'k',  'l',  'm',  'n',  'o',  'p',  'q',  'r',  's',  't',  'u',  'v',  'w',  'x',  'y',  'z'};
        char[] input = inputText.getText().toLowerCase().toCharArray();
        char[] temp = new char[input.length];
        int counter = 0;
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

                counter++;
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
