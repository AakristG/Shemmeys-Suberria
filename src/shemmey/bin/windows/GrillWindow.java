import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.border.Border;

/**
 * Creates the Grill Station Frame
 */
class GrillWindow extends JFrame {
  private OrderWindow order;
  private BuildWindow build;
  private ReadyWindow ready;
  private Ticket ticket;
  private JLabel ticketText;
  private JPanel contentPanel;
  private GridBagConstraints gbc;
  
  private JLayeredPane layerPane;


  public JButton newBreadButton;
  public JButton breadButtonTwo;
  public JButton newGrilledBreadButton;
  public JButton grilledBreadButtonTwo;
  private Border border;
  private int count;
  private Sandwich sandwich;
  private boolean isGrilled;

  /**
   * Constructs a Grill Window to appear in the game
   */
  public GrillWindow() {
    ticket = null;
    ticketText = null;
    setTitle("Grill Station");
    setSize(Constants.Frames.mainFrameWidth, Constants.Frames.mainFrameHeight);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    sandwich = null;
  
    count = 0;


    contentPanel = new JPanel(new BorderLayout()) {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = new ImageIcon("src/resources/Images/GrillBackground.png").getImage();
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
      }
    };

    //contentPanel.setLayout(new GridBagLayout());
  
     JPanel buttonPanel = createButtonPanel();

     JPanel breadPanel = createBreadPanel();
     breadPanel.setOpaque(false);

    isGrilled = false;
      
    finishTicket();
    ticketText.setOpaque(false);
    
    contentPanel.add(breadPanel, BorderLayout.WEST);
    contentPanel.add(buttonPanel, BorderLayout.SOUTH);
    //contentPanel.add(buttonPanel);
    setContentPane(contentPanel);

  }

  private JPanel createButtonPanel() {
    JPanel buttonPanel = new JPanel(new GridLayout(1, 4));

    ImageIcon orderIcon = new ImageIcon("src/resources/Images/Order.png");
    JButton orderButton = new JButton(orderIcon);
    orderButton.setContentAreaFilled(false);
    orderButton.setBorderPainted(false);
    orderButton.addActionListener(e -> showOrderFrame());
    buttonPanel.add(orderButton);

    ImageIcon grillIcon = new ImageIcon("src/resources/Images/Grill.png");
    JButton grillButton = new JButton(grillIcon);
    grillButton.setContentAreaFilled(false);
    grillButton.setBorderPainted(false);
    grillButton.addActionListener(e -> showGrillFrame());
    buttonPanel.add(grillButton);

    ImageIcon buildIcon = new ImageIcon("src/resources/Images/Build.png");
    JButton buildButton = new JButton(buildIcon);
    buildButton.setContentAreaFilled(false);
    buildButton.setBorderPainted(false);
    buildButton.addActionListener(e -> showBuildFrame());
    buttonPanel.add(buildButton);

    ImageIcon readyIcon = new ImageIcon("src/resources/Images/Ready.png");
    JButton readyButton = new JButton(readyIcon);
    readyButton.setContentAreaFilled(false);
    readyButton.setBorderPainted(false);
    readyButton.addActionListener(e -> showReadyFrame());
    buttonPanel.add(readyButton);

    return buttonPanel;
  }

  private JPanel createTicketPanel(){
    JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
    finishTicket();
    buttonPanel.setOpaque(false);

    buttonPanel.add(ticketText);

    return buttonPanel;
  }

  private JPanel createBreadPanel(){
    JPanel buttonPanel = new JPanel(new GridBagLayout());
    ImageIcon breadIcon = new ImageIcon("src/resources/Buttons/BreadButton.png");
     Image bread = breadIcon.getImage();
     Image newBread = bread.getScaledInstance(breadIcon.getIconWidth() / 2, breadIcon.getIconHeight() / 2,
         java.awt.Image.SCALE_SMOOTH);
     breadIcon = new ImageIcon(newBread);

     JButton breadButton = new JButton(breadIcon);
     breadButton.setContentAreaFilled(false);
     breadButton.setBorderPainted(false);
     breadButton.addActionListener(e -> grillBread());

     breadButton.setOpaque(false);

    ImageIcon breadIconTwo = new ImageIcon("src/resources/Buttons/BreadButton.png");
     Image breadTwo = breadIconTwo.getImage();
     Image newBreadTwo = breadTwo.getScaledInstance(breadIconTwo.getIconWidth() / 2, breadIconTwo.getIconHeight() / 2,
         java.awt.Image.SCALE_SMOOTH);
     breadIconTwo = new ImageIcon(newBreadTwo);

     JButton breadButtonTwo = new JButton(breadIcon);
     breadButtonTwo.setContentAreaFilled(false);
     breadButtonTwo.setBorderPainted(false);

     breadButtonTwo.setOpaque(false);

    this.breadButtonTwo = breadButtonTwo;

    ImageIcon grilledBreadIcon = new ImageIcon("src/resources/Buttons/BreadGrilledButton.png");
     Image grillBread = grilledBreadIcon.getImage();
     Image newGrilledBread = grillBread.getScaledInstance(breadIcon.getIconWidth(), breadIcon.getIconHeight(),
         java.awt.Image.SCALE_SMOOTH);
     grilledBreadIcon = new ImageIcon(newGrilledBread);

     JButton grilledBreadButton = new JButton(grilledBreadIcon);
       grilledBreadButton.setContentAreaFilled(false);
       grilledBreadButton.setBorderPainted(false);
       grilledBreadButton.addActionListener(e -> finishBread());
    grilledBreadButton.setOpaque(false);

    ImageIcon grilledBreadIconTwo = new ImageIcon("src/resources/Buttons/BreadGrilledButton.png");
     Image grillBreadTwo = grilledBreadIconTwo.getImage();
     Image newGrilledBreadTwo = grillBreadTwo.getScaledInstance(breadIconTwo.getIconWidth(), breadIconTwo.getIconHeight(),
         java.awt.Image.SCALE_SMOOTH);
     grilledBreadIconTwo = new ImageIcon(newGrilledBreadTwo);

     JButton grilledBreadButtonTwo = new JButton(grilledBreadIcon);
       grilledBreadButtonTwo.setContentAreaFilled(false);
       grilledBreadButtonTwo.setBorderPainted(false);
    grilledBreadButtonTwo.setOpaque(false);

    this.grilledBreadButtonTwo = grilledBreadButtonTwo;

    JLabel message = new JLabel("Click the button before the bread is burnt");

    newBreadButton = breadButton;
    
    newGrilledBreadButton = grilledBreadButton;
    newGrilledBreadButton.setVisible(false);
    breadButtonTwo.setVisible(false);
    grilledBreadButtonTwo.setVisible(false);
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(0,490,0,0);
    buttonPanel.add(breadButtonTwo, gbc);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(0,490,0,0);
    buttonPanel.add(grilledBreadButton, gbc);
    gbc.gridy = 1;
    gbc.insets = new Insets(340,490,0,0);
    buttonPanel.add(breadButton, gbc);
    
    

    
    return buttonPanel;
  }


  


  /**
   * Method that can hide or show the frame
   * 
   * @param b the variable that decides if the window shows
   */
  public void setFrameVisible(boolean b) {
    setVisible(b);
  }
  /**
   * Stores the current ticket order in a ticket variable
   * @param t the Ticket object 
   */
  public void setTicket(Ticket t) {
    ticket = t;
  }
  /**
   * Checks the boolean value of the bread to check if it was grilled or not
   * @return whether the bread is grilled or not
   */
  public boolean isGrilled(){
    return isGrilled;
  }

  private void showOrderFrame() {
    setVisible(false);
    order.setVisible(true);
    build.setVisible(false);
    ready.setVisible(false);
  }

  private void showGrillFrame() {
    setVisible(true);
    order.setVisible(false);
    build.setVisible(false);
    ready.setVisible(false);
  }

  private void showBuildFrame() {
    setVisible(false);
    order.setVisible(false);
    build.setVisible(true);
    ready.setVisible(false);
  }

  private void showReadyFrame() {
    setVisible(false);
    order.setVisible(false);
    build.setVisible(false);
    ready.setVisible(true);
  }
  /**
   * Shows the updated order taken by current customer
   */
  public void updateTicket() {
    if (ticketText != null)
      contentPanel.remove(ticketText);
    ticketText = new JLabel("<html>" + ticket.processOrder() + "</html>");
    ticketText.setFont(new Font("Dialog", Font.BOLD, 20));
    Border border = BorderFactory.createEmptyBorder(0, 10, 0, 22);
    ticketText.setBorder(border);
    ticketText.setForeground(Color.RED);
    contentPanel.add(ticketText, BorderLayout.EAST);
    setContentPane(contentPanel);

  }
  /**
   * Resets the text inside the ticket order
   */
  public void finishTicket() {
    if (ticketText != null)
      contentPanel.remove(ticketText);
    ticketText = new JLabel("<html> No Order Placed. </html>");
    ticketText.setFont(new Font("Dialog", Font.BOLD, 20));
    Border border = BorderFactory.createEmptyBorder(0, 20, 0, 50);
    ticketText.setBorder(border);
    ticketText.setForeground(Color.RED);
    contentPanel.add(ticketText, BorderLayout.EAST);
    setContentPane(contentPanel);
  }

  private void grillBread() {
    count++;
    newBreadButton.setVisible(false);
    breadButtonTwo.setVisible(true);
    isGrilled = true;
    Timer timer = new Timer();
    timer.schedule(new TimerTask(){
      @Override
        public void run(){
        breadButtonTwo.setVisible(false);
        newGrilledBreadButton.setVisible(true);
        breadButtonTwo.addActionListener(e -> finishBread());
        }
      }, 5000);
    sandwich.grillSandwich();
    }
   
  private void finishBread() {
    isGrilled = true;
    setVisible(false);
    build.setVisible(true);
  }

  /**
   * Method that can hide or show the frame
   * 
   * @param o the OrderWindow object that is set to reference by order window
   * @param b the BuildWindow object that is set to reference by build window
   * @param r the ReadyWindow object that is set to reference by ready window
   */
  public void setOtherFrames(OrderWindow o, BuildWindow b, ReadyWindow r) {
    order = o;
    build = b;
    ready = r;
  }

  /**
   * Stores the current sandwich inside a variable
   *
   * @param s the Sandwich object
   */
  public void setSandwich(Sandwich s) {sandwich = s;}
}