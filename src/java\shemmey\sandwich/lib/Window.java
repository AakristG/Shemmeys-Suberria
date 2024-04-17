package shemmey.sandwich.lib;

import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.Color;

public class Window
{
  private static final int WIDTH = 1600;
  private static final int HEIGHT = 900;
  private JFrame window;

  public Window(String title)
    {
      window = new JFrame(title);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      window.pack();
      window.setVisible(false);
    }

  public void setVis()
  {window.setVisible(true);}

  public void setInvis()
  {window.setVisible(false);}

  public void setBack()
  {window.getContentPane().setBackground(Color.BLUE);}

}


