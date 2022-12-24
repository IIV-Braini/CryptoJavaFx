package com.example.domain.cryptojavafx.domain.utils;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    private static final List<Character> ALPHABET = new ArrayList<>();

     static {
        ALPHABET.add('a');
        ALPHABET.add('b');
        ALPHABET.add('c');
        ALPHABET.add('d');
        ALPHABET.add('e');
        ALPHABET.add('f');
        ALPHABET.add('g');
        ALPHABET.add('h');
        ALPHABET.add('i');
        ALPHABET.add('j');
        ALPHABET.add('k');
        ALPHABET.add('l');
        ALPHABET.add('m');
        ALPHABET.add('n');
        ALPHABET.add('o');
        ALPHABET.add('p');
        ALPHABET.add('q');
        ALPHABET.add('r');
        ALPHABET.add('s');
        ALPHABET.add('t');
        ALPHABET.add('u');
        ALPHABET.add('v');
        ALPHABET.add('w');
        ALPHABET.add('x');
        ALPHABET.add('y');
        ALPHABET.add('z');
        ALPHABET.add('A');
        ALPHABET.add('B');
        ALPHABET.add('C');
        ALPHABET.add('D');
        ALPHABET.add('E');
        ALPHABET.add('F');
        ALPHABET.add('G');
        ALPHABET.add('H');
        ALPHABET.add('I');
        ALPHABET.add('J');
        ALPHABET.add('K');
        ALPHABET.add('L');
        ALPHABET.add('M');
        ALPHABET.add('N');
        ALPHABET.add('O');
        ALPHABET.add('P');
        ALPHABET.add('Q');
        ALPHABET.add('R');
        ALPHABET.add('S');
        ALPHABET.add('T');
        ALPHABET.add('U');
        ALPHABET.add('V');
        ALPHABET.add('E');
        ALPHABET.add('X');
        ALPHABET.add('Y');
        ALPHABET.add('Z');
    }


    public static Character getChar(int index) {
        return ALPHABET.get(index);
    }

    public static Integer getIndex(char c) {
        return ALPHABET.indexOf(c);
    }

    public static boolean isContain(char c) {
        return ALPHABET.contains(c);
    }

}
