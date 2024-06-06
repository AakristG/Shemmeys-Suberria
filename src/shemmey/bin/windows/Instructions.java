import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Handles the Instruction Tab
 */
class Instructions extends JFrame {
  private JButton backButton;
  private ShemmeyFrame shemmeyFrame;
  /**
   * Constructs an instruction frame with the text as an image
   * 
   * @param shemmeyFrame the Start Menu window
   */
    public Instructions(ShemmeyFrame shemmeyFrame) {
        this.shemmeyFrame = shemmeyFrame;
        setTitle("Instruction");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 
        JPanel contentPanel = new JPanel() {
          @Override
          protected void paintComponent(Graphics g) {
            super.paintComponent(g);
          }
        };
      contentPanel.setLayout(new GridBagLayout());
        JLabel label = new JLabel("Instruction frame", SwingConstants.CENTER);
        
      ImageIcon instructionIcon = new ImageIcon("src/resources/Images/Instructions.png");
      Image instructionImage = instructionIcon.getImage();
      Image newInstructionImage = instructionImage.getScaledInstance((int)(instructionIcon.getIconWidth() / 2.9), (int)(instructionIcon.getIconHeight() / 2.9), java.awt.Image.SCALE_SMOOTH);
      instructionIcon = new ImageIcon(newInstructionImage);
      JLabel insLabel = new JLabel(instructionIcon);
      
      ImageIcon backIcon = new ImageIcon("src/resources/Buttons/BackButton.png");
      Image backImage = backIcon.getImage();
      Image newBackImage = backImage.getScaledInstance((int)(backIcon.getIconWidth() /9), (int)(backIcon.getIconHeight() /9),  java.awt.Image.SCALE_SMOOTH); 
      backIcon = new ImageIcon(newBackImage);

      backButton = new JButton(backIcon);
      backButton.setContentAreaFilled(false);
      backButton.setBorderPainted(false);
      backButton.setFocusPainted(false);
      backButton.addActionListener(e -> backButtonClick());

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.insets = new Insets(0, -400, 0, 0);
      contentPanel.add(insLabel, gbc);
      gbc.gridx = 1;
      gbc.insets = new Insets(300,100,0,0);
      contentPanel.add(backButton, gbc);
      
      
      setContentPane(contentPanel);

      setVisible(true);
    }
  
  private void backButtonClick() {
      shemmeyFrame.setVisible(true);
      setVisible(false);
  }


  private void showReadyFrame() {
      setVisible(true);
  }

} 