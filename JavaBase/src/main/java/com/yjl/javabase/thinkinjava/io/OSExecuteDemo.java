package com.yjl.javabase.thinkinjava.io;//: io/OSExecuteDemo.java
// Demonstrates standard I/O redirection.
import com.yjl.javabase.thinkinjava.net.mindview.util.*;

public class OSExecuteDemo {
  public static void main(String[] args) {
    OSExecute.command("javap OSExecuteDemo");
  }
} /* Output:
Compiled from "OSExecuteDemo.java"
public class OSExecuteDemo extends java.lang.Object{
    public OSExecuteDemo();
    public static void main(java.lang.String[]);
}
*///:~
