import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.border.Border;

/**
 * Creates the Order Station Frame
 */
public class OrderWindow extends JFrame {
  private JButton orderButton;
  private GrillWindow grill;
  private BuildWindow build;
  private ReadyWindow ready;
  private Ticket ticket;
  
  private JPanel contentPanel;
  private JLabel ticketText;
  private JLabel customerLabel;

  //TODO: Have to layer things on top of each other
  private JLayeredPane layerPane;

  private JButton customerButton;
  private Sandwich sandwich;

  /*
   * Constructs an Order Window to appear in the game
   */
  public OrderWindow() {
    ticket = new Ticket();
    setTitle("Order Station");
    setSize(1200, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    sandwich = new Sandwich();
   /** ImageIcon ticketIcon = new ImageIcon(ticket.getUrl());
    JLabel ticketLabel = new JLabel(ticketIcon);
    newTicketLabel = ticketLabel; */
    
    contentPanel = new JPanel(new BorderLayout()) {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = new ImageIcon("src/resources/Images/NewShopBackground.png").getImage();
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
      }
    };
    contentPanel.setBounds(0,0,1200,600);
  

    ImageIcon takeOrderIcon = new ImageIcon("src/resources/Images/TakeOrder.png");
    JButton takeOrderButton = new JButton(takeOrderIcon);
    takeOrderButton.setContentAreaFilled(false);
    takeOrderButton.setBorderPainted(false);
    takeOrderButton.addActionListener(e -> handleTakeOrderButtonClick());
    contentPanel.add(takeOrderButton, BorderLayout.WEST);

    ImageIcon customerIcon = new ImageIcon("src/resources/Customers/CustomerNeutral.png");
    Image customerImage = customerIcon.getImage();
    Image newCustomerImage = customerImage.getScaledInstance(customerIcon.getIconWidth() / 3, customerIcon.getIconHeight() / 2, java.awt.Image.SCALE_SMOOTH);
    customerIcon = new ImageIcon(newCustomerImage);
    JButton customerButton = new JButton(customerIcon);
    customerButton.setContentAreaFilled(false);
    customerButton.setBorderPainted(false);
    customerButton.setFocusPainted(false);
    //Customer customer = new Customer(customerIcon);
    ticketText = null;
    finishTicket();
    
    JPanel buttonPanel = createButtonPanel();
    buttonPanel.setOpaque(false);
    contentPanel.add(buttonPanel, BorderLayout.SOUTH);
    contentPanel.add(customerButton, BorderLayout.CENTER);
    contentPanel.setOpaque(false);
    
    

    setContentPane(contentPanel);
  }

  private JPanel createButtonPanel() {
    JPanel buttonPanel = new JPanel(new GridLayout(1, 4));

    ImageIcon orderIcon = new ImageIcon("src/resources/Images/Order.png");
    orderButton = new JButton(orderIcon);
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

  private void handleTakeOrderButtonClick() {
    if (!ticket.isOrderPlaced()) {
      ticket.placeOrder();
      System.out.println(ticket.getOrder());
      updateTicket();
      //newTicketLabel.setVisible(true);
    } else
      System.out.println("Order already has been placed.");
  }
  /**
   * Shows the updated order taken by current customer
   */
  public void updateTicket(){
    if(ticketText != null)
      contentPanel.remove(ticketText);
    ticketText = new JLabel("<html>" + ticket.processOrder()+ "</html>");
      ticketText.setFont(new Font("Dialog", Font.BOLD, 20));
    Border border = BorderFactory.createEmptyBorder(0, 10, 0, 22);
    ticketText.setBorder(border);
    ticketText.setForeground(Color.RED);
    contentPanel.add(ticketText, BorderLayout.EAST);
    setContentPane(contentPanel);
    grill.updateTicket();
    build.updateTicket(); 

  }
  /**
   * Resets the text inside the ticket order
   */
  public void finishTicket(){
    if(ticketText != null)
      contentPanel.remove(ticketText);
    ticketText = new JLabel("<html> No Order Placed. </html>");
      ticketText.setFont(new Font("Dialog", Font.BOLD, 20));
      Border border = BorderFactory.createEmptyBorder(0, 20, 0, 50);
      ticketText.setBorder(border);
      ticketText.setForeground(Color.RED);
      contentPanel.add(ticketText, BorderLayout.EAST);
      setContentPane(contentPanel);
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
   * Method for accessing the current ticket object value
   *
   * @return the ticket object
   */
  public Ticket getTicket(){return ticket;}

  //Pass ticket as parameter so the same ticket can be used by other classes
  private void showOrderFrame() {
    setVisible(true);
    grill.setVisible(false);
    build.setVisible(false);
    ready.setVisible(false);
  }

  private void showGrillFrame() {
    setVisible(false);
    grill.setVisible(true);
    build.setVisible(false);
    ready.setVisible(false);
  }

  private void showBuildFrame() {
    setVisible(false);
    grill.setVisible(false);
    build.setVisible(true);
    ready.setVisible(false);
  }

  private void showReadyFrame() {
    setVisible(false);
    grill.setVisible(false);
    build.setVisible(false);
    ready.setVisible(true);
  }

  /**
   * Method that can hide or show the frame
   * 
   * @param r the ReadyWindow object that is set to reference by ready window
   * @param g the GrillWindow object that is set to reference by grill window
   * @param b the BuildWindow object that is set to reference by build window
   */
  public void setOtherFrames(ReadyWindow r, GrillWindow g, BuildWindow b) {
    ready = r;
    grill = g;
    build = b;
  }
  /**
   * Stores the current ticket inside a variable
   *
   * @param t the Ticket object
   */
  public void setTicket(Ticket t) {
    ticket = t;
  }
  
  /**
   * Stores the current sandwich inside a variable
   *
   * @param s the Sandwich object
   */
  public void setSandwich(Sandwich s){sandwich = s;}

  /**
   * Method for accessing the current sandwich
   *
   * @return the Sandwich object
   */
  public Sandwich getSandwich(){return sandwich;}

}
