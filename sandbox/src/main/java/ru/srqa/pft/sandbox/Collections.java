package ru.srqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main (String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

        List<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");
        languages.add("JS");

        List<String> languages2 = Arrays.asList("Java", "C#", "Python", "PHP");

        for (int i = 0; i < langs.length; i++) {
            System.out.println("Languages: " + langs[i]);
        }

        for (String l: languages) {
            System.out.println("I want to learn (v1): " + l);
        }

        for (int i = 0; i < languages2.size(); i++) {
            System.out.println("I want to learn (v2): " + languages2.get(i));
        }
    }
}
