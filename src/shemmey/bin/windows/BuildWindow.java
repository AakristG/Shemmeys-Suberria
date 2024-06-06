import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.*;
import java.util.*;
import javax.swing.border.Border;
import java.awt.geom.AffineTransform;

/**
 * Creates the Build Station Frame
 */
class BuildWindow extends JFrame {
  private GrillWindow grill;
  private OrderWindow order;
  private ReadyWindow ready;
  private Ticket ticket;
  private JLabel ticketText;
  private JPanel contentPanel;
  private Sandwich sandwich;

  private boolean isGrilled;

  private JButton ham, turkey, beef, cheese, lettuce, tomato, onion, mayo, secretSauce, topLid, bottomLid, grilledTopLid, grilledBottomLid;
  private boolean hamBoo, turkeyBoo, beefBoo, cheeseBoo, lettuceBoo, tomatoBoo, onionBoo, mayoBoo, secretSauceBoo;

  /**
   * Constructs a Build Window to appear in the game
   */
  public BuildWindow() {
    ticket = null;
    ticketText = null;
    sandwich = null;
    hamBoo = false;
    turkeyBoo = false;
    beefBoo = false;
    cheeseBoo = false;
    lettuceBoo = false;
    tomatoBoo = false;
    onionBoo = false;
    mayoBoo = false;
    secretSauceBoo = false;
    setTitle("Build Station");
    setSize(1200, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    contentPanel = new JPanel(new BorderLayout()) {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = new ImageIcon("src/resources/Images/BuildBackground.png").getImage();
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
      }
    };
  
    JPanel buttonPanel = createButtonPanel();
    // buttonPanel.setOpaque(false);
    contentPanel.add(buttonPanel, BorderLayout.SOUTH);
    finishTicket();

    JPanel ingButtonPanel = createButtonPanelIng();
    contentPanel.add(ingButtonPanel, BorderLayout.WEST);

    
    setContentPane(contentPanel);
  }

  private JPanel createButtonPanel() {
    JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
    buttonPanel.setBounds(1200,150,100,600);
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
  
  private JPanel createButtonPanelIng() {
    JPanel buttonPanel = new JPanel(new GridBagLayout());

    buttonPanel.setOpaque(false);
    Image image, newImage;

    //Ingredients on container
    ImageIcon hamTubIcon = new ImageIcon("src/resources/Buttons/HamTub.png");
    image = hamTubIcon.getImage();
    newImage = image.getScaledInstance((int)(hamTubIcon.getIconWidth() / 1.5), (int)(hamTubIcon.getIconHeight() / 1.5), java.awt.Image.SCALE_SMOOTH);
    hamTubIcon = new ImageIcon(newImage);
    JButton hamTubButton = new JButton(hamTubIcon);
    hamTubButton.setContentAreaFilled(false);
    hamTubButton.setBorderPainted(false);
    hamTubButton.addActionListener(e -> showHam());
    

    ImageIcon turkeyTubIcon = new ImageIcon("src/resources/Buttons/TurkeyTub.png");
    image = turkeyTubIcon.getImage();
    newImage = image.getScaledInstance((int)(turkeyTubIcon.getIconWidth() / 1.5), (int) (turkeyTubIcon.getIconHeight() / 1.5), java.awt.Image.SCALE_SMOOTH);
    turkeyTubIcon = new ImageIcon(newImage);
    JButton turkeyTubButton = new JButton(turkeyTubIcon);
    turkeyTubButton.setContentAreaFilled(false);
    turkeyTubButton.setBorderPainted(false);
    turkeyTubButton.addActionListener(e -> showTurkey());
   

    ImageIcon beefTubIcon = new ImageIcon("src/resources/Buttons/RoastBeefTub.png");
    image  = beefTubIcon.getImage();
    newImage = image.getScaledInstance((int)(beefTubIcon.getIconWidth() / 1.5),(int)(beefTubIcon.getIconHeight() / 1.5), java.awt.Image.SCALE_SMOOTH);
    beefTubIcon = new ImageIcon(newImage);
    JButton beefTubButton = new JButton(beefTubIcon);
    beefTubButton.setContentAreaFilled(false);
    beefTubButton.setBorderPainted(false);
    beefTubButton.addActionListener(e -> showBeef());

    ImageIcon onionTubIcon = new ImageIcon("src/resources/Buttons/OnionTub.png");
    image = onionTubIcon.getImage();
    newImage = image.getScaledInstance((int)(onionTubIcon.getIconWidth() / 1.5), (int)(onionTubIcon.getIconHeight() / 1.5), java.awt.Image.SCALE_SMOOTH);
    onionTubIcon = new ImageIcon(newImage);
    JButton onionTubButton = new JButton(onionTubIcon);
    onionTubButton.setContentAreaFilled(false);
    onionTubButton.setBorderPainted(false);
    onionTubButton.addActionListener(e -> showOnion());

    ImageIcon cheeseTubIcon = new ImageIcon("src/resources/Buttons/CheeseTub.png");
    image = cheeseTubIcon.getImage();
    newImage = image.getScaledInstance((int)(cheeseTubIcon.getIconWidth() / 1.5), (int)(cheeseTubIcon.getIconHeight() / 1.5), java.awt.Image.SCALE_SMOOTH);
    cheeseTubIcon = new ImageIcon(newImage);
    JButton cheeseTubButton = new JButton(cheeseTubIcon);
    cheeseTubButton.setContentAreaFilled(false);
    cheeseTubButton.setBorderPainted(false);
    cheeseTubButton.addActionListener(e -> showCheese());

    ImageIcon lettuceTubIcon = new ImageIcon("src/resources/Buttons/LettuceTub.png");
    image = lettuceTubIcon.getImage();
    newImage = image.getScaledInstance((int)(lettuceTubIcon.getIconWidth() / 1.5 ),(int)(lettuceTubIcon.getIconHeight() / 1.5), java.awt.Image.SCALE_SMOOTH);
    lettuceTubIcon= new ImageIcon(newImage);
    JButton lettuceTubButton = new JButton(lettuceTubIcon);
    lettuceTubButton.setContentAreaFilled(false);
    lettuceTubButton.setBorderPainted(false);
    lettuceTubButton.addActionListener(e -> showLettuce());
  
    
    ImageIcon tomatoTubIcon = new ImageIcon("src/resources/Buttons/TomatoTub.png");
    image = tomatoTubIcon.getImage();
    newImage = image.getScaledInstance((int)(tomatoTubIcon.getIconWidth() / 1.5), (int)(tomatoTubIcon.getIconHeight() / 1.5), java.awt.Image.SCALE_SMOOTH);
    tomatoTubIcon = new ImageIcon(newImage);
    JButton tomatoTubButton = new JButton(tomatoTubIcon);
    tomatoTubButton.setContentAreaFilled(false);
    tomatoTubButton.setBorderPainted(false);
    tomatoTubButton.addActionListener(e -> showTomato());
   

    ImageIcon mayoTubIcon = new ImageIcon("src/resources/Buttons/MayoTub.png");
    image = mayoTubIcon.getImage();
    newImage = image.getScaledInstance((int)(mayoTubIcon.getIconWidth() / 1.7), (int)(mayoTubIcon.getIconHeight() / 1.7), java.awt.Image.SCALE_SMOOTH);
    mayoTubIcon = new ImageIcon(newImage);
    JButton mayoTubButton = new JButton(mayoTubIcon);
    mayoTubButton.setContentAreaFilled(false);
    mayoTubButton.setBorderPainted(false);
    mayoTubButton.addActionListener(e -> showMayo());
    

    ImageIcon secretSauceTubIcon = new ImageIcon("src/resources/Buttons/SecretSauceTub.png");
    image = secretSauceTubIcon.getImage();
    newImage = image.getScaledInstance((int)(secretSauceTubIcon.getIconWidth() / 1.7), (int)(secretSauceTubIcon.getIconHeight() / 1.7), java.awt.Image.SCALE_SMOOTH);
    secretSauceTubIcon = new ImageIcon(newImage);
    JButton secretSauceTubButton = new JButton(secretSauceTubIcon);
    secretSauceTubButton.setContentAreaFilled(false);
    secretSauceTubButton.setBorderPainted(false);
    secretSauceTubButton.addActionListener(e -> showSecretSauce());


    createSandwich();
    ham.setVisible(false);
    turkey.setVisible(false);
    beef.setVisible(false);
    cheese.setVisible(false);
    lettuce.setVisible(false);
    onion.setVisible(false);
    tomato.setVisible(false);
    mayo.setVisible(false);
    secretSauce.setVisible(false);
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.insets = new Insets(-40,0,0,-50);
    buttonPanel.add(hamTubButton, gbc);
    gbc.gridx = 1;
    gbc.insets = new Insets(-40,0,0,-20);
    buttonPanel.add(turkeyTubButton, gbc);
    gbc.gridx = 2;
    gbc.insets = new Insets(-40,-20,0,0);
    buttonPanel.add(beefTubButton, gbc);
    gbc.gridx = 3;
    gbc.insets = new Insets(-40,-30,0, 0);
    buttonPanel.add(cheeseTubButton, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.insets = new Insets(0,-50,0,-40);
    buttonPanel.add(onionTubButton, gbc);
    gbc.gridx = 1;
    gbc.insets = new Insets(0,-80,0,-100);
    buttonPanel.add(tomatoTubButton, gbc);
    gbc.gridx = 2;
    gbc.insets = new Insets(0,-70,0,-35);
    buttonPanel.add(lettuceTubButton, gbc);
    gbc.gridx = 3;
    gbc.insets = new Insets(0,-95,0,0);
    buttonPanel.add(mayoTubButton, gbc);
    gbc.gridx = 4;
    gbc.insets = new Insets(0,-90,0,0);
    buttonPanel.add(secretSauceTubButton, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.insets = new Insets(-30,0,0, -700);
    if(isTicketGrilled()){
      buttonPanel.add(grilledTopLid, gbc);
      grilledTopLid.setVisible(true);
      topLid.setVisible(false);
    }
    else{
      buttonPanel.add(topLid, gbc);
      grilledTopLid.setVisible(false);
      topLid.setVisible(true);
    }
    gbc.insets = new Insets(0,0,-15, -700);
    buttonPanel.add(mayo, gbc);
    buttonPanel.add(secretSauce, gbc);
    gbc.insets = new Insets(0,0,-20, -700);
    buttonPanel.add(tomato, gbc);
    gbc.insets = new Insets(0,0,-25, -700);
    buttonPanel.add(lettuce, gbc);
    gbc.insets = new Insets(0,0,-30, -700);
    buttonPanel.add(onion, gbc);
    gbc.insets = new Insets(0,0,-35, -700);
    buttonPanel.add(turkey, gbc);
    buttonPanel.add(ham, gbc);
    buttonPanel.add(beef, gbc);
    gbc.insets = new Insets(0,0,-40,-700);
    buttonPanel.add(cheese, gbc);
    gbc.insets = new Insets(0,0,-50,-700);
    if(isTicketGrilled())
      buttonPanel.add(grilledBottomLid, gbc);
    else
      buttonPanel.add(bottomLid, gbc);
    
 
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
   * Draws the ingredients onto sandwich including both lids
   */
  public void createSandwich(){
    Image image, newImage;
    //Ingredients on sandwich
    ImageIcon topBreadIcon = new ImageIcon("src/resources/SandwichComponents/toplid.png");
    image = topBreadIcon.getImage();
    newImage = image.getScaledInstance((int)(topBreadIcon.getIconWidth() / 4), (int)(topBreadIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    topBreadIcon = new ImageIcon(newImage);
    topLid = new JButton(topBreadIcon);
    topLid.setContentAreaFilled(false);
    topLid.setBorderPainted(false);

    ImageIcon bottomBreadIcon = new ImageIcon("src/resources/SandwichComponents/bottomlid.png");
    image = bottomBreadIcon.getImage();
    newImage = image.getScaledInstance((int)(bottomBreadIcon.getIconWidth() / 4), (int)(bottomBreadIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    bottomBreadIcon = new ImageIcon(newImage);
    bottomLid = new JButton(bottomBreadIcon);
    bottomLid.setContentAreaFilled(false);
    bottomLid.setBorderPainted(false);

    ImageIcon grilledTopBreadIcon = new ImageIcon("src/resources/SandwichComponents/toplidgrilled.png");
    image = grilledTopBreadIcon.getImage();
    newImage = image.getScaledInstance((int)(grilledTopBreadIcon.getIconWidth() / 4), (int)(grilledTopBreadIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    grilledTopBreadIcon = new ImageIcon(newImage);
    grilledTopLid = new JButton(grilledTopBreadIcon);
    grilledTopLid.setContentAreaFilled(false);
    grilledTopLid.setBorderPainted(false);

    ImageIcon grilledBottomBreadIcon = new ImageIcon("src/resources/SandwichComponents/bottomlidgrilled.png");
    image = grilledBottomBreadIcon.getImage();
    newImage = image.getScaledInstance((int)(grilledBottomBreadIcon.getIconWidth() / 4), (int)(grilledBottomBreadIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    grilledBottomBreadIcon = new ImageIcon(newImage);
    grilledBottomLid = new JButton(grilledBottomBreadIcon);
    grilledBottomLid.setContentAreaFilled(false);
    grilledBottomLid.setBorderPainted(false);
    
    ImageIcon hamIcon = new ImageIcon("src/resources/SandwichComponents/Ham.png");
    image = hamIcon.getImage();
    newImage = image.getScaledInstance((int)(hamIcon.getIconWidth() / 4), (int)(hamIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    hamIcon = new ImageIcon(newImage);
    ham = new JButton(hamIcon);
    ham.setContentAreaFilled(false);
    ham.setBorderPainted(false);

    ImageIcon turkeyIcon = new ImageIcon("src/resources/SandwichComponents/Turkey.png");
    image = turkeyIcon.getImage();
    newImage = image.getScaledInstance((int)(turkeyIcon.getIconWidth() / 4), (int)(turkeyIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    turkeyIcon = new ImageIcon(newImage);
    turkey = new JButton(turkeyIcon);
    turkey.setContentAreaFilled(false);
    turkey.setBorderPainted(false);
    
    ImageIcon beefIcon = new ImageIcon("src/resources/SandwichComponents/RoastBeef.png");
    image = beefIcon.getImage();
    newImage = image.getScaledInstance((int)(beefIcon.getIconWidth() / 4), (int)(beefIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    beefIcon = new ImageIcon(newImage);
    beef = new JButton(beefIcon);
    beef.setContentAreaFilled(false);
    beef.setBorderPainted(false);

    ImageIcon cheeseIcon = new ImageIcon("src/resources/SandwichComponents/Cheeses.png");
    image = cheeseIcon.getImage();
    newImage = image.getScaledInstance((int)(cheeseIcon.getIconWidth() / 3), (int)(cheeseIcon.getIconHeight() / 3), java.awt.Image.SCALE_SMOOTH);
    cheeseIcon = new ImageIcon(newImage);
    cheese = new JButton(cheeseIcon);
    cheese.setContentAreaFilled(false);
    cheese.setBorderPainted(false);

    ImageIcon lettuceIcon = new ImageIcon("src/resources/SandwichComponents/Lettuce.png");
    image = lettuceIcon.getImage();
    newImage = image.getScaledInstance((int)(lettuceIcon.getIconWidth() / 4), (int)(lettuceIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    lettuceIcon = new ImageIcon(newImage);
    lettuce = new JButton(lettuceIcon);
    lettuce.setContentAreaFilled(false);
    lettuce.setBorderPainted(false);

    ImageIcon onionIcon = new ImageIcon("src/resources/SandwichComponents/Onions.png");
    image = onionIcon.getImage();
    newImage = image.getScaledInstance((int)(onionIcon.getIconWidth() / 4), (int)(onionIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    onionIcon = new ImageIcon(newImage);
    onion = new JButton(onionIcon);
    onion.setContentAreaFilled(false);
    onion.setBorderPainted(false);
    

    ImageIcon tomatoIcon = new ImageIcon("src/resources/SandwichComponents/Tomatos.png");
    image = tomatoIcon.getImage();
    newImage = image.getScaledInstance((int)(tomatoIcon.getIconWidth() / 4), (int)(tomatoIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    tomatoIcon = new ImageIcon(newImage);
    tomato = new JButton(tomatoIcon);
    tomato.setContentAreaFilled(false);
    tomato.setBorderPainted(false);

    ImageIcon mayoIcon = new ImageIcon("src/resources/SandwichComponents/Mayo.png");
    image = mayoIcon.getImage();
    newImage = image.getScaledInstance((int)(mayoIcon.getIconWidth() / 4), (int)(mayoIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    mayoIcon = new ImageIcon(newImage);
    mayo = new JButton(mayoIcon);
    mayo.setContentAreaFilled(false);
    mayo.setBorderPainted(false);

    ImageIcon ssIcon = new ImageIcon("src/resources/SandwichComponents/SecretSauce.png");
    image = ssIcon.getImage();
    newImage = image.getScaledInstance((int)(ssIcon.getIconWidth() / 4), (int)(ssIcon.getIconHeight() / 4), java.awt.Image.SCALE_SMOOTH);
    ssIcon = new ImageIcon(newImage);
    secretSauce = new JButton(ssIcon);
    secretSauce.setOpaque(false);
    secretSauce.setContentAreaFilled(false);
    secretSauce.setBorderPainted(false);
    
  }
  /**
   * Stores the current ticket order in a ticket variable
   * @param t the Ticket object 
   */
  public void setTicket(Ticket t) {
    ticket = t;
  }

  private boolean isTicketGrilled(){
    if(ticket != null) {
      return ticket.isGrilled();
    }
    else{
      return false;
    }
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

  private void showOrderFrame() {
    setVisible(false);
    order.setVisible(true);
    grill.setVisible(false);
    ready.setVisible(false);
  }

  private void showGrillFrame() {
    setVisible(false);
    order.setVisible(false);
    grill.setVisible(true);
    ready.setVisible(false);
    isGrilled = grill.isGrilled();
  }

  private void showBuildFrame() {
    setVisible(true);
    order.setVisible(false);
    grill.setVisible(false);
    ready.setVisible(false);
  }

  private void showReadyFrame() {
    setVisible(false);
    order.setVisible(false);
    grill.setVisible(false);
    ready.setVisible(true);
  }

  private void showHam() {
    if(!hamBoo)
    {
    ham.setVisible(true);
    Ham ham = new Ham();
    sandwich.addIngredient(ham);
    hamBoo = true;
    }
    //System.out.println(sandwich.toString());
  }

  private void showTurkey() {
    if(!turkeyBoo)
    {
    turkey.setVisible(true);
    Turkey turkey = new Turkey();
    sandwich.addIngredient(turkey);
    turkeyBoo = true;
    }
    //System.out.println(sandwich.toString());
  }

  private void showBeef() {
    if(!beefBoo)
      {
    beef.setVisible(true);
    RoastBeef roastbeef = new RoastBeef();
    sandwich.addIngredient(roastbeef);
        beefBoo = true;
      }
    //System.out.println(sandwich.toString());
  }

  private void showOnion() {
    if(!onionBoo)
      {
    onion.setVisible(true);
    Onion onions = new Onion();
    sandwich.addIngredient(onions);
        onionBoo = true;
      }
  //  System.out.println(sandwich.toString());
  }

  private void showLettuce() {
    if(!lettuceBoo)
      {
    lettuce.setVisible(true);
    Lettuce lettuce = new Lettuce();
    sandwich.addIngredient(lettuce);
        lettuceBoo = true;
      }
    //System.out.println(sandwich.toString());
  }

  private void showTomato() {
    if(!tomatoBoo)
      {
    tomato.setVisible(true);
    Tomato ing = new Tomato();
    sandwich.addIngredient(ing);
        tomatoBoo = true;
      }
  //  System.out.println(sandwich.toString());
  }

  private void showCheese() {
    if(!cheeseBoo)
      {
    cheese.setVisible(true);
    Cheese cheese = new Cheese();
    sandwich.addIngredient(cheese);
        cheeseBoo = true;
      }
   // System.out.println(sandwich.toString());
  }

  private void showMayo() {
    if(!mayoBoo)
      {
    mayo.setVisible(true);
    Mayo mayo = new Mayo();
    sandwich.addIngredient(mayo);
        mayoBoo = true;
      }
    //System.out.println(sandwich.toString());
  }

  private void showSecretSauce() {
    if(!secretSauceBoo)
      {
    secretSauce.setVisible(true);
    ShemmeysSauce shemmeysSauce = new ShemmeysSauce();
    sandwich.addIngredient(shemmeysSauce);
        secretSauceBoo = false;
      }
  //  System.out.println(sandwich.toString());
  }
  
  /**
   * Hides all the ingredients to allow for reconstruction of a new sandwich
   */
  public void setIngredsInvis(){
    ham.setVisible(false);
    beef.setVisible(false);
    turkey.setVisible(false);
    mayo.setVisible(false);
    secretSauce.setVisible(false);
    cheese.setVisible(false);
    lettuce.setVisible(false);
    onion.setVisible(false);
    tomato.setVisible(false);
    hamBoo = false;
    turkeyBoo = false;
    beefBoo = false;
    cheeseBoo = false;
    lettuceBoo = false;
    tomatoBoo = false;
    onionBoo = false;
    mayoBoo = false;
    secretSauceBoo = false;
  }

  /**
   * Method that can hide or show the frame
   * 
   * @param o the OrderWindow object that is set to reference by order window
   * @param g the GrillWindow object that is set to reference by grill window
   * @param r the ReadyWindow object that is set to reference by ready window
   */
  public void setOtherFrames(OrderWindow o, GrillWindow g, ReadyWindow r) {
    order = o;
    grill = g;
    ready = r;
  }
  /**
   * Stores the current sandwich inside a variable
   *
   * @param s the Sandwich object
   */
  public void setSandwich(Sandwich s) {sandwich = s;}
}