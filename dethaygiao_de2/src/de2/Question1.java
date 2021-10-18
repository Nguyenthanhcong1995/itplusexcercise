package de2;

public class Question1 {
    public static void main(String[] args) {

        int num = '9';
        int num1 = '9';
        do {
            System.out.print((char) num + " ");
            num--;
        } while (num > '0');
        System.out.println();
        while (num1 > '0') {
            System.out.print((char) num1 + " ");
            num1--;
        }
    }
}


