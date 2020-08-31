package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BaseballKeyListener;
import model.BaseballGame;



public class BaseballGamePanel {

    private JFrame window;
    private BaseballCanvas canvas;

    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();
    private JButton[] digitButtons;
    private JButton playButton = new JButton("Play Ball~~");
    private JButton exitButton = new JButton("Exit");

    private BaseballGame baseball;

    public BaseballGamePanel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();

        BaseballKeyListener keyListener = new BaseballKeyListener(this);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(new JLabel("Secret Game Key: "));
        northPanel.add(gameKeyField);
        gameKeyField.setEditable(false);
        northPanel.add(new JLabel("Your guess: "));
        northPanel.add(guessField);
        guessField.setEditable(false);
        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new BaseballCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 3));
        digitButtons = new JButton[10];
        for(int i = 0; i < 10; i++){
            digitButtons[i] = new JButton("" + i);
            southPanel.add(digitButtons[i]);
            digitButtons[i].addActionListener(keyListener);
        }
        for(var b: digitButtons){
            b.setEnabled(false);
        }
        southPanel.add(playButton);
        playButton.addActionListener(keyListener);
        southPanel.add(exitButton);
        exitButton.addActionListener(keyListener);
        cp.add(BorderLayout.SOUTH, southPanel);

        

    }

    public BaseballGame getBaseballGame(){
        return baseball;
    }

    public JFrame getWindow(){
        return window;
    }

    public BaseballCanvas getCanvas(){
        return canvas;
    }

    public JTextField getGameKey(){
        return gameKeyField;
    }

    public JTextField getGuessField(){
        return guessField;
    }

    public JButton[] getDigitButtons(){
        return digitButtons;
    }

    public JButton getPlayButton(){
        return playButton;
    }

    public JButton getExitButton(){
        return exitButton;
    }
    
}