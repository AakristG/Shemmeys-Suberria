import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Creates the Start Menu Frame
 */
public class ShemmeyFrame extends JFrame {
    private JButton button;
    private JButton instructionButton;
    private Instructions instructionFrame;
    private Customer firstCustomer;
  
    private OrderWindow order;
    /*
     * Constructs the Start Menu Window to appear at launch
     */
    public ShemmeyFrame() {
        setTitle("Shemmey's Suberia");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("src/resources/Images/SuberiaBackground.png").getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());
        ImageIcon logoIcon = new ImageIcon("src/resources/Images/officialgamelogo.png");
        Image logoImage = logoIcon.getImage();
        Image newLogoImage = logoImage.getScaledInstance((int)(logoIcon.getIconWidth() / 1.5), (int)(logoIcon.getIconHeight() / 1.5),  java.awt.Image.SCALE_SMOOTH); 
        logoIcon = new ImageIcon(newLogoImage);
        JLabel logoLabel = new JLabel(logoIcon);

        ImageIcon buttonIcon = new ImageIcon("src/resources/Images/PlayButton.png");
        Image buttonImage = buttonIcon.getImage();
        Image newButtonImage = buttonImage.getScaledInstance(buttonIcon.getIconWidth() / 3, buttonIcon.getIconHeight() / 3,  java.awt.Image.SCALE_SMOOTH);
        buttonIcon = new ImageIcon(newButtonImage);

      ImageIcon instructionIcon = new ImageIcon("src/resources/Images/infoIcon.png");
      Image instructionImage = instructionIcon.getImage();
      Image newInstructionImage = instructionImage.getScaledInstance(instructionIcon.getIconWidth() / 4, instructionIcon.getIconHeight() / 4, java.awt.Image.SCALE_SMOOTH);
      instructionIcon = new ImageIcon(newInstructionImage);

        button = new JButton(buttonIcon);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(e -> buttonClick());

        instructionButton = new JButton(instructionIcon);
        instructionButton.setContentAreaFilled(false);
        instructionButton.setBorderPainted(false);
        instructionButton.setFocusPainted(false);
        instructionButton.addActionListener(e -> instructionClick());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        backgroundPanel.add(logoLabel, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(250, 0, 0, 0); 
        backgroundPanel.add(button, gbc);
        gbc.gridx = 1;
        gbc.insets = new Insets(250, 10, 0, 0);
        backgroundPanel.add(instructionButton, gbc);

        instructionFrame = new Instructions(this);

        setContentPane(backgroundPanel);

        setVisible(true);
        instructionFrame.setVisible(false);
    }

    private void buttonClick() {
      order.setVisible(true);
      instructionFrame.setVisible(false);
      setVisible(false);
    }

    private void instructionClick(){
      instructionFrame.setVisible(true);
      setVisible(false);
    }
  /*
   * References the order window to an order object generated when playing
   * 
   * @param o the object to be referenced
   */
  public void setOrderFrame(OrderWindow o){
    order = o;
  }
}

