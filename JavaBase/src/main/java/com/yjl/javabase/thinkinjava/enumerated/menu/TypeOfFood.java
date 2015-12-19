//: enumerated/menu/TypeOfFood.java
package com.yjl.javabase.thinkinjava.enumerated.menu;
import static com.yjl.javabase.thinkinjava.enumerated.menu.Food.*;

public class TypeOfFood {
  public static void main(String[] args) {
    Food food = Appetizer.SALAD;
    food = MainCourse.LASAGNE;
    food = Dessert.GELATO;
    food = Coffee.CAPPUCCINO;
  }
} ///:~
