package com.yjl.javabase.thinkinjava.generics;//: generics/ExplicitTypeSpecification.java
import com.yjl.javabase.thinkinjava.typeinfo.pets.*;
import java.util.*;
import net.mindview.util.*;

public class ExplicitTypeSpecification {
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());
  }
} ///:~
