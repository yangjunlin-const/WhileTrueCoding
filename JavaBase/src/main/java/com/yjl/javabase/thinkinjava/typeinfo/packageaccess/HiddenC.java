//: typeinfo/packageaccess/HiddenC.java
package com.yjl.javabase.thinkinjava.typeinfo.packageaccess;
import com.yjl.javabase.thinkinjava.typeinfo.interfacea.*;
import static com.yjl.javabase.thinkinjava.net.mindview.util.Print.*;

class C implements A {
  public void f() { print("public C.f()"); }
  public void g() { print("public C.g()"); }
  void u() { print("package C.u()"); }
  protected void v() { print("protected C.v()"); }
  private void w() { print("private C.w()"); }
}

public class HiddenC {
  public static A makeA() { return new C(); }
} ///:~
