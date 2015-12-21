package com.yjl.javabase.thinkinjava.exceptions;//: exceptions/Switch.java
import static com.yjl.javabase.thinkinjava.net.mindview.util.Print.*;

public class Switch {
  private boolean state = false;
  public boolean read() { return state; }
  public void on() { state = true; print(this); }
  public void off() { state = false; print(this); }
  public String toString() { return state ? "on" : "off"; }
} ///:~
