//: interfaces/interfaceprocessor/Apply.java
package com.yjl.javabase.thinkinjava.interfaces.interfaceprocessor;
import static com.yjl.javabase.thinkinjava.net.mindview.util.Print.*;

public class Apply {
  public static void process(Processor p, Object s) {
    print("Using Processor " + p.name());
    print(p.process(s));
  }
} ///:~
