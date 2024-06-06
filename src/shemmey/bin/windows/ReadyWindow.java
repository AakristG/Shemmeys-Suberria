import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Creates the Ready Station Frame
 */
class ReadyWindow extends JFrame {
  private GrillWindow grill;
  private BuildWindow build;
  private OrderWindow order;
  private Sandwich sandwich;
  private Ticket ticket;
  private JButton customerButton;
  private JButton otherCustomerButton;
  private JButton forwardButton;
  private JPanel contentPanel;
  private JLabel tipSum;
  private JButton newBreadButton;
  private JButton breadButtonTwo;
  private JButton newGrilledBreadButton;
  private JButton grilledBreadButtonTwo;
    /*
     * Constructs a Ready Window to appear in the game
     */
    public ReadyWindow() {
        setTitle("Ready Station");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      sandwich = null;
      ticket = null;
      otherCustomerButton = null;
      contentPanel = new JPanel(new BorderLayout()) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image backgroundImage = new ImageIcon("src/resources/Images/ShopBackground.png").getImage();
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
      };
      
      customerButton = getCustomer(0);
      customerButton.addActionListener(e -> handleCustomerButtonClick());
      contentPanel.add(customerButton, BorderLayout.WEST);
      Image image, newImage;
      
      
      ImageIcon forwardButtonIcon = new ImageIcon("src/resources/Buttons/ForwardButton.png");
      image = forwardButtonIcon.getImage();
      newImage = image.getScaledInstance(forwardButtonIcon.getIconWidth()/2, forwardButtonIcon.getIconHeight()/2, java.awt.Image.SCALE_SMOOTH);
      forwardButtonIcon = new ImageIcon(newImage);
      forwardButton = new JButton(forwardButtonIcon);
      forwardButton.setContentAreaFilled(false);
      forwardButton.setBorderPainted(false);
      forwardButton.setVisible(false);
      forwardButton.addActionListener(e -> nextRound());
      contentPanel.add(forwardButton,BorderLayout.EAST);
      
        JPanel buttonPanel = createButtonPanel();
      buttonPanel.setOpaque(false);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

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
  /**
   * Method that can hide or show the frame 
   * 
   * @param b the variable that decides if the window shows
   */
  public void setFrameVisible(boolean b)
  {
    setVisible(b);
    
  }

  /**
   * Stores the current ticket inside a variable
   *
   * @param t the Ticket object
   */
  public void setTicket(Ticket t){
    ticket = t;
  }

    private void showOrderFrame() {
      setVisible(false);
      grill.setVisible(false);
      build.setVisible(false);
      order.setVisible(true);
    }

    private void showGrillFrame() {
      setVisible(false);
      grill.setVisible(true);
      build.setVisible(false);
      order.setVisible(false);
    }

    private void showBuildFrame() {
      setVisible(false);
      grill.setVisible(false);
      build.setVisible(true);
      order.setVisible(false);
    }

    private void showReadyFrame() {
      setVisible(true);
      grill.setVisible(false);
      build.setVisible(false);
      order.setVisible(false);
    }
  private void handleCustomerButtonClick() {
    if(ticket.isOrderPlaced())
    {
    Image image, newImage;
      System.out.println("Ticket: \n" +ticket);
      System.out.println("Sandwich: \n" +sandwich);
    int score = ticket.checkSandwich(sandwich);
    System.out.println("Score: "+score);
    ticket = new Ticket();
    sandwich = new Sandwich();
    grill.setTicket(ticket);
    build.setTicket(ticket);
    order.setTicket(ticket);
    grill.setSandwich(sandwich);
    build.setSandwich(sandwich);
    order.setSandwich(sandwich);
    grill.finishTicket();
    order.finishTicket();
    build.finishTicket();
    customerButton.setVisible(false);
    if(score>75){
        otherCustomerButton = getCustomer(1);
      otherCustomerButton.setVisible(true);
      contentPanel.add(otherCustomerButton, BorderLayout.CENTER);
    }
    else if(score>50){
      otherCustomerButton = getCustomer(2);
      otherCustomerButton.setVisible(true);
      contentPanel.add(otherCustomerButton, BorderLayout.CENTER);
    }
    else{
      otherCustomerButton = getCustomer(3);
      otherCustomerButton.setVisible(true);
      contentPanel.add(otherCustomerButton, BorderLayout.CENTER);
    }
    double currentTip = 10;
    if(score > 0)
      currentTip *= (score/100.0);
    else
      currentTip = 0;
    Constants.Frames.tips += currentTip;
    tipSum = new JLabel("<html>Current Tip: $" + currentTip + "<br><br>" + "Total: $" + Constants.Frames.tips + "<html>");
    tipSum.setFont(new Font("Dialog", Font.BOLD, 20));
    contentPanel.add(tipSum, BorderLayout.NORTH);
    forwardButton.setVisible(true);
    }
    else
      System.out.println("No order placed yet.");
    
  }
  private void nextRound(){
    order.setVisible(true);
    grill.setVisible(false);
    build.setVisible(false);
    setVisible(false);
    build.setIngredsInvis();
    contentPanel.remove(otherCustomerButton);
    customerButton.setVisible(true);
    forwardButton.setVisible(false);
    grill.newBreadButton.setVisible(true);
    grill.breadButtonTwo.setVisible(false);
    grill.newGrilledBreadButton.setVisible(false);
    grill.grilledBreadButtonTwo.setVisible(false);
    contentPanel.remove(tipSum);
  }

  private JButton getCustomer(int i)
  {
    Image image, newImage;
    ImageIcon customerIcon = null;
    if(i == 0)
      customerIcon = new ImageIcon("src/resources/Customers/CustomerNeutral.png");
    else if(i == 1)
      customerIcon = new ImageIcon("src/resources/Customers/CustomerHappy.png");
    else if(i == 2)
      customerIcon = new ImageIcon("src/resources/Customers/CustomerSad.png");
    else
      customerIcon = new ImageIcon("src/resources/Customers/CustomerMad.png");
    image = customerIcon.getImage();
    newImage = image.getScaledInstance(customerIcon.getIconWidth() / 2, customerIcon.getIconHeight() / 2, java.awt.Image.SCALE_SMOOTH);
    customerIcon = new ImageIcon(newImage);
     JButton customerButton = new JButton(customerIcon);
      customerButton.setContentAreaFilled(false);
      customerButton.setBorderPainted(false);
    return customerButton;
  }

  

  
  /**
   * Method that can hide or show the frame 
   * 
   * @param o the OrderWindow object that is set to reference by order window
   * @param g the GrillWindow object that is set to reference by grill window
   * @param b the BuildWindow object that is set to reference by build window
   */
  public void setOtherFrames(OrderWindow o, GrillWindow g,  BuildWindow b){
    order = o;
    grill = g;
    build = b;
  }

  /**
   * Stores the current sandwich inside a variable
   *
   * @param s the Sandwich object
   */
  public void setSandwich(Sandwich s) {sandwich = s;}
}