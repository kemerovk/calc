import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
        static JPanel panelOut;
        static JTextArea textArea;
        static JPanel panelIn;
        Frame(String text){
            super(text);

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(350,  50, 800, 600);

            panelOut = new JPanel();
            panelOut.setBackground(Color.DARK_GRAY);
            panelOut.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 70));

            textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
            textArea.addKeyListener(new Key() );


            panelOut.add(textArea);
            add(panelOut, BorderLayout.NORTH);
            setVisible(true);


            panelIn = new JPanel();
            panelIn.setLayout(new GridLayout(5, 4, 20, 20));


            char[] buttons = {'c', '.', '%', '√',
                    '7', '8', '9', '/',
                    '4', '5', '6', '*',
                    '1', '2', '3', '-',
                    '0', 'e', '=', '+'};

            for (char c: buttons){
                JButton button = new JButton("" + c);
                button.setBackground(Color.ORANGE);
                button.setFont(new Font("Times New Roman", Font.BOLD, 20));
                button.addActionListener(new Action());
                panelIn.add(button);
            }


            add(panelIn, BorderLayout.CENTER);
            setVisible(true);
        }

    }

