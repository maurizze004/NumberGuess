import tgi.TGI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public static int attempt = 0;
    public static int rn;
    public static int maximum = 5;

    public static void main(String[] args) {

        //Setting up all
        JFrame frame = new JFrame();
        JButton submit = new JButton("Guess it now");
        JLabel command = new JLabel("Type in your number");
        JLabel info = new JLabel("The number is ");
        JPanel panel = new JPanel();
        JTextField numberGuess = new JTextField();


        //Setting JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setBackground(Color.DARK_GRAY);
        frame.setResizable(false);
        frame.setTitle("Guess the Number between 0 and 50");

        //Adding and setting Components
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);

        command.setBounds(55, 50, 200, 25);
        command.setForeground(Color.white);
        command.setFont(command.getFont().deriveFont((float) 15));

        info.setBounds(55, 90, 400, 40);
        info.setForeground(Color.white);
        info.setFont(info.getFont().deriveFont((float) 15));

        numberGuess.setBounds(215, 50, 100, 25);

        submit.setBounds(45, 150, 200, 25);
        submit.setBackground(Color.green);

        //Program code

        rn = TGI.erzeugeZufallsZahlZwischen(0, 50);
        System.out.println(rn);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String g = numberGuess.getText();
                int guess = Integer.parseInt(g);

                if(attempt < maximum){

                    if (guess > 50){
                        JOptionPane.showMessageDialog(null, "Are you stupid? Number must be under 50. Due to dis activity you get 2 points on top.", "Dude, please!", JOptionPane.INFORMATION_MESSAGE);
                        attempt +=2;
                    }
                    if (guess < rn){
                        info.setText("The number is higher");
                        attempt +=1;
                        System.out.println("higher");
                    }
                    if (guess > rn){
                        info.setText("The number is lower");
                        attempt +=1;
                        System.out.println("lower");
                    }
                    if (guess == rn){
                        JOptionPane.showMessageDialog(null, "You guessed " + rn + " in just " + attempt + " attempts! If you want you can easily play again, just with another number", "You won! Congrats", JOptionPane.INFORMATION_MESSAGE);
                        numberGuess.setText("");
                        attempt = 0;
                        rn = TGI.erzeugeZufallsZahlZwischen(0, 50);
                        System.out.println(rn);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry. Game is over 'cause you're stupid. Number was " + rn + "But you can play easily again, just with another number", "Game over! All attempts used", JOptionPane.INFORMATION_MESSAGE);
                    attempt = 0;
                    numberGuess.setText("");
                    rn = TGI.erzeugeZufallsZahlZwischen(0, 50);
                    System.out.println(rn);
                }
            }
        });

        //init view
        panel.add(info);
        panel.add(command);
        panel.add(numberGuess);
        panel.add(submit);
        frame.add(panel);
        frame.setVisible(true);
    }
}