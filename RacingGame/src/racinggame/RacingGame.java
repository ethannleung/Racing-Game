package racinggame;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class RacingGame {
//Ethan Leung
    //April 2019 S2 P4
    //Racing Game

    public static void main(String[] args) throws InterruptedException {
        //Image packages throughout the code in JOptionPane
        ImageIcon host = new ImageIcon("host.PNG");
        ImageIcon intro = new ImageIcon("worldrace.png");
        ImageIcon sonicintro = new ImageIcon("sonicintro.png");
        ImageIcon rapidashintro = new ImageIcon("rapidashintro.png");
        ImageIcon mariointro = new ImageIcon("mariointro.png");
        ImageIcon flashintro = new ImageIcon("flashintro.png");
        ImageIcon sonicwin = new ImageIcon("sonicwin.png");
        ImageIcon rapidashwin = new ImageIcon("rapidashwin.png");
        ImageIcon mariowin = new ImageIcon("mariowin.png");
        ImageIcon flashwin = new ImageIcon("flashwin.jpg");
        ImageIcon chickendinner = new ImageIcon("chickendinner.png");
        ImageIcon TaketheL = new ImageIcon("TaketheL.png");

        Random random = new Random();
        String playagain;
        int bet2;

//Creating buttons through JOptionPane
        String[] choice = {"Sonic", "Rapidash", "Mario", "Flash"};
        int x = 0;

        String[] choice2 = {"YES", "NO"};
        int attemptagain = 0;
//Sound to play
        playSound1();
//Declaring character options and choice with images
        JOptionPane.showMessageDialog(null, "WELCOME to the WORLD RACE!", "Display Image", JOptionPane.INFORMATION_MESSAGE, host);
        int better = 1000; //Setting inital bet value
        do {

            //inital x coordinates and starting points
            int sonicx = 10;
            int rapidashx = 10;
            int mariox = 10;
            int flashx = 10;

            int ss = 0;
            int rr = 0;
            int mm = 0;
            int ff = 0;

            //Choosing which character will win with JOption Option buttons
            JOptionPane.showMessageDialog(null, "Bet on either the SONIC, RAPIDASH, MARIO, OR FLASH", "Display Image", JOptionPane.INFORMATION_MESSAGE, intro);
            x = JOptionPane.showOptionDialog(null, "Choose Which Character Will Win the Race!", "World Race", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choice, choice[2]);
            //if statements depending on choice of character, and betting amount, will delcare
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "You Chose SONIC!", "Display Image", JOptionPane.INFORMATION_MESSAGE, sonicintro);

            } else if (x == 1) {
                JOptionPane.showMessageDialog(null, "You Chose RAPIDASH!", "Display Image", JOptionPane.INFORMATION_MESSAGE, rapidashintro);

            } else if (x == 2) {
                JOptionPane.showMessageDialog(null, "You Chose MARIO!", "Display Image", JOptionPane.INFORMATION_MESSAGE, mariointro);

            } else {
                JOptionPane.showMessageDialog(null, "You Chose FLASH!", "Display Image", JOptionPane.INFORMATION_MESSAGE, flashintro);

            }

            bet2 = showDialog("You have $" + better + ", How much would you like to bet?", 1000);

            JOptionPane.showMessageDialog(null, "You bet $" + bet2 + " on your chosen Racer!");

// Create frame and set width and height
// Creating JLabels that are set at a certain position
// adding resized images to JLabls that are set at x y coordinates
            JFrame WorldRace = new JFrame();
            WorldRace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            WorldRace.setSize(1820, 850);
            WorldRace.setLayout(null);

            JLabel labelSonic = new JLabel();
            labelSonic.setIcon(new ImageIcon("images/sonic3.gif"));
            labelSonic.setBounds((sonicx), (45), labelSonic.getPreferredSize().width, labelSonic.getPreferredSize().height);
            WorldRace.add(labelSonic);

            JLabel labelrapidash = new JLabel();
            labelrapidash.setIcon(new ImageIcon("images/rapidash.gif"));
            labelrapidash.setBounds((rapidashx), (250), labelrapidash.getPreferredSize().width, labelrapidash.getPreferredSize().height);
            WorldRace.add(labelrapidash);

            JLabel labelmario = new JLabel();
            labelmario.setIcon(new ImageIcon("images/mario.gif"));
            labelmario.setBounds((mariox), (390), labelmario.getPreferredSize().width, labelmario.getPreferredSize().height);
            WorldRace.add(labelmario);

            JLabel labelflash = new JLabel();
            labelflash.setIcon(new ImageIcon("images/flash.gif"));
            labelflash.setBounds((flashx), (575), labelflash.getPreferredSize().width, labelflash.getPreferredSize().height);
            WorldRace.add(labelflash);

            JLabel labelcountdown3 = new JLabel();
            labelcountdown3.setVisible(false);
            labelcountdown3.setIcon(new ImageIcon("images/countdown3.png"));
            labelcountdown3.setBounds(400, (200), labelcountdown3.getPreferredSize().width, labelcountdown3.getPreferredSize().height);
            WorldRace.add(labelcountdown3);

            JLabel labelcountdown2 = new JLabel();
            labelcountdown2.setVisible(false);
            labelcountdown2.setIcon(new ImageIcon("images/countdown2.png"));
            labelcountdown2.setBounds(750, (200), labelcountdown2.getPreferredSize().width, labelcountdown2.getPreferredSize().height);
            WorldRace.add(labelcountdown2);

            JLabel labelcountdown1 = new JLabel();
            labelcountdown1.setVisible(false);
            labelcountdown1.setIcon(new ImageIcon("images/countdown1.png"));
            labelcountdown1.setBounds(1050, (200), labelcountdown1.getPreferredSize().width, labelcountdown1.getPreferredSize().height);
            WorldRace.add(labelcountdown1);

            JLabel labelstadium = new JLabel();
            labelstadium.setIcon(new ImageIcon("images/stadium.png"));
            labelstadium.setBounds((0), (0), labelstadium.getPreferredSize().width, labelstadium.getPreferredSize().height);
            WorldRace.add(labelstadium);

            WorldRace.setVisible(true);

            labelcountdown3.setVisible(true);
            Thread.sleep(1000);
            labelcountdown3.setVisible(false);
            labelcountdown2.setVisible(true);
            Thread.sleep(1000);
            labelcountdown2.setVisible(false);
            labelcountdown1.setVisible(true);
            Thread.sleep(1000);
            labelcountdown1.setVisible(false);

//MovingGraphics with Loops and Random Number generator, setting bounds and coordinates to reach
            while (sonicx < 1600 && rapidashx < 1600 && mariox < 1600 && flashx < 1600) {

                ss = random.nextInt(20) + 1;
                rr = random.nextInt(20) + 1;
                mm = random.nextInt(20) + 1;
                ff = random.nextInt(20) + 1;

                Thread.sleep(30);
// Total variable adding the inital x and random generator to move character
                sonicx = sonicx + ss;
                rapidashx = rapidashx + rr;
                mariox = mariox + mm;
                flashx = flashx + ff;
//Setting bounds for inital position
                labelSonic.setBounds((sonicx), (45), labelSonic.getPreferredSize().width, labelSonic.getPreferredSize().height);
                labelrapidash.setBounds((rapidashx), (250), labelrapidash.getPreferredSize().width, labelrapidash.getPreferredSize().height);
                labelmario.setBounds((mariox), (390), labelmario.getPreferredSize().width, labelmario.getPreferredSize().height);
                labelflash.setBounds((flashx), (575), labelflash.getPreferredSize().width, labelflash.getPreferredSize().height);
            }
//if statement declaring who has won the race, if statements inside for your choice, as well as betting money, adding or subtracting the bet amount from the inital amount
            if (sonicx >= 1600) {
                JOptionPane.showMessageDialog(null, "SONIC has won the World Race!!", "Display Image", JOptionPane.INFORMATION_MESSAGE, sonicwin);

                if (x == 0) {
                    better = better + bet2;
                    JOptionPane.showMessageDialog(null, "You chose correctly! \n SONIC won the race and you gained $" + bet2 + " \n You have $" + better, "Display Image", JOptionPane.INFORMATION_MESSAGE, chickendinner);

                } else {
                    better = better - bet2;
                    JOptionPane.showMessageDialog(null, "You chose incorrectly \n Your chosen character did not win \n You lost $" + bet2 + " \n You have $" + better, "Display Image", JOptionPane.INFORMATION_MESSAGE, TaketheL);
                }

            } else if (rapidashx >= 1600) {
                JOptionPane.showMessageDialog(null, "RAPIDASH has won the World Race!!", "Display Image", JOptionPane.INFORMATION_MESSAGE, rapidashwin);
                if (x == 1) {
                    better = better + bet2;
                    JOptionPane.showMessageDialog(null, "You chose correctly! \n RAPIDASH won the race and you gained $" + bet2 + " \n You have $" + better, "Display Image", JOptionPane.INFORMATION_MESSAGE, chickendinner);
                } else {
                    better = better - bet2;
                    JOptionPane.showMessageDialog(null, "You chose incorrectly \n Your chosen character did not win \n You lost $" + bet2 + " \n You have $" + better, "Display Image", JOptionPane.INFORMATION_MESSAGE, TaketheL);
                }

            } else if (mariox >= 1600) {
                JOptionPane.showMessageDialog(null, "MARIO has won the World Race!!", "Display Image", JOptionPane.INFORMATION_MESSAGE, mariowin);

                if (x == 2) {
                    better = better + bet2;
                    JOptionPane.showMessageDialog(null, "You chose correctly! \n MARIO won the race and you gained $" + bet2 + " \n You have $" + better, "Display Image", JOptionPane.INFORMATION_MESSAGE, chickendinner);
                } else {
                    better = better - bet2;
                    JOptionPane.showMessageDialog(null, "You chose incorrectly \n Your chosen character did not win \n You lost $" + bet2 + " \n You have $" + better, "Display Image", JOptionPane.INFORMATION_MESSAGE, TaketheL);
                }

            } else if (flashx >= 1600) {
                JOptionPane.showMessageDialog(null, "FLASH has won the World Race!!", "Display Image", JOptionPane.INFORMATION_MESSAGE, flashwin);
                if (x == 3) {
                    better = better + bet2;
                    JOptionPane.showMessageDialog(null, "You chose correctly! \n FLASH won the race and you gained $" + bet2 + " \n You have $" + better, "Display Image", JOptionPane.INFORMATION_MESSAGE, chickendinner);
                } else {
                    better = better - bet2;
                    JOptionPane.showMessageDialog(null, "You chose incorrectly \n Your chosen character did not win \n You lost $" + bet2 + " \n You have $" + better, "Display Image", JOptionPane.INFORMATION_MESSAGE, TaketheL);
                }
            }
            //Closes window once race is finished
            WorldRace.dispose();
            // Buttons for choice to retry or Not
            attemptagain = JOptionPane.showOptionDialog(null, "Would You Like to Play Again? Once You Hit $2000 You WIN! \n Hit $0, You LOSE", "World Race", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choice2, choice2[1]);
            //While loop if Yes is clicked or you have won or loss
        } while (attemptagain == 0 || better == 0 || better == 2000);

        System.exit(0);
    }
//error try/catch for the bets
//Will not let value be over 1000, be letters, or no value entered at all

    static public int showDialog(String message, int condition) {
        int bet2 = -1;
        while (true) {
            String bet = JOptionPane.showInputDialog(message);
            try {
                bet2 = Integer.parseInt(bet);
            } catch (NumberFormatException e) {
                bet = JOptionPane.showInputDialog(message);
            }
            if (bet2 >= 1 && bet2 <= condition) {
                break;
            }
        }
        return bet2;
    }

    public static void playSound1() {
        playMusic1("C:\\Users\\s241582\\Desktop\\NetBeans Assignements\\RacingGame\\Musicprojects\\ToadsFactory.wav");
    }

    public static void playMusic1(String filepath) {
        InputStream music;

        //Try and Catch for the music
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"); //Shows 'Error' if the file is not valid
        }
    }
}
