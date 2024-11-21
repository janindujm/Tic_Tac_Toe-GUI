/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;

/**
 *
 * @author hp
 */
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class gui {
    
    private class tile extends JButton{
        int row;
        int col;
        
        public tile(int row, int col){
            this.row=row;
            this.col=col;
        }
        
        
    }
    
    int tileSize = 90;
    int rows = 3;
    int cols = 3;
    int click =1;
    int boardWidth = tileSize*cols;
    int boardHeight = tileSize*rows;
    
    
    
    JFrame frame = new JFrame("Tic Tac Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JButton resetButton = new JButton();

    
    tile[][] board = new tile[rows][cols];
    
    
    
    
    gui(){
        //frame
        frame.setSize(boardWidth, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        
        // Reset button modifications
        resetButton.setText("Resett");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Smaller font for the button
        resetButton.setFocusPainted(false); // Remove focus outline
        resetButton.setMargin(new Insets(5, 10, 5, 10)); // Add padding to make it compact
        resetButton.setBackground(Color.LIGHT_GRAY); // Optional: Change the button background color

        
        
        //text Panel
        textLabel.setText("Tic Tac Toe");
        textLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        // Set the layout of the textPanel
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.WEST); // Align name to the left
        textPanel.add(resetButton, BorderLayout.EAST); // Align reset button to the right
        frame.add(textPanel, BorderLayout.NORTH);
        
        //Game Panel
        gamePanel.setBackground(Color.red);
        gamePanel.setLayout(new GridLayout(rows,cols));
        frame.add(gamePanel, BorderLayout.CENTER);
        

        
        //Buttons
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                tile tile = new tile(r,c);
                board[r][c] = tile;
                tile.setFocusable(false);
                tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
                tile.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mousePressed(MouseEvent e){
                        
                        if(e.getButton() == MouseEvent.BUTTON3){
                            tile.setText("");
                            
                        }
                        else if(click%2==0){
                            tile.setText("O");
                            click+=1;
                        }

                        else{
                            tile.setText("X");
                            click+=1;
                        }
                      
                    }
                    
                });
                gamePanel.add(tile);
            }
        }
        
        
        
        frame.setVisible(true);
    }
}
