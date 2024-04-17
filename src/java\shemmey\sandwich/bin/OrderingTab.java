package shemmey.sandwich.bin;

import java.io.*;
import java.awt.*;
import java.util.Queue;
import java.util.LinkedList;
import shemmey.sandwich.components.*;

public class OrderingTab {

  Queue<Order> tab;

  public OrderingTab() {
    tab = new LinkedList<Order>();
  }

  public void addOrder(Order o){
    tab.offer(o);
  }

  public Order firstOrder(){
    return tab.peek();
  }

  public void finishOrder(Order o){
  //tab.poll(o);
  }

}