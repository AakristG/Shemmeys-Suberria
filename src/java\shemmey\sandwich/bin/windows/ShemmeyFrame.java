import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import shemmey.sandwich.bin.Constants;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class ShemmeyFrame extends JFrame {
  public ShemmeyFrame(){
    setTitle("Shemmey's Frame");
    setSize(Constants.Frames.mainFrameWidth, Constants.Frames.mainFrameHeight);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    //background image
    ImageIcon backgroundImage = new ImageIcon("src/resources/Images/SuberiaBackground.png");

    JPanel introWindow = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    };
    introWindow.setLayout(new BorderLayout());

    //play button code
    ImageIcon playButton = new ImageIcon("src/resources/Images/PlayButton.png");
    JButton button = new JButton(playButton);
    button.setBorderPainted(false);
    button.setContentAreaFilled(false);
    button.setFocusPainted(false);
    button.setOpaque(false);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new OrderWindow().setVisible(true);
      }
    });

    //title code
    ImageIcon title = new ImageIcon("src/resources/Images/officialgamelogo.png");
    JLabel titleLabel = new JLabel(title);
    
    introWindow.add(button, BorderLayout.NORTH);
    introWindow.add(titleLabel, BorderLayout.CENTER);
    setContentPane(introWindow);
  }
}
