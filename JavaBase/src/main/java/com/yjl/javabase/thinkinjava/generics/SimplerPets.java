package com.yjl.javabase.thinkinjava.generics;//: generics/SimplerPets.java

import com.yjl.javabase.thinkinjava.typeinfo.pets.Person;
import com.yjl.javabase.thinkinjava.typeinfo.pets.Pet;
import com.yjl.javabase.thinkinjava.net.mindview.util.New;

import java.util.List;
import java.util.Map;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
        // Rest of the code is the same...
    }
} ///:~
