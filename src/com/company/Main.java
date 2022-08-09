package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int amountOfTries = 6;

    private static String[] dictionary = new String[]{
            "arroz","pao","leite","manteiga","carne","ovo",
            "queijo", "berinjela", "batata", "banana","cebola",
            "alface", "tomate"
    };

    public static void main(String[] args) {
	    int leftTries = amountOfTries;
        String word = getRandomWord();
        boolean[] wordMask = new boolean[word.length()];
        List<String> usedLetters = new ArrayList<>();
        boolean hasWinned = false;

        while(true){
            if(leftTries == 0){
                break;

            }
            displayGame(word, wordMask, leftTries, usedLetters);

           String userInput = getUserInput();

           if(userInput.length() > 1){
               //palavra
               if(userInput.equals(word)){
                    hasWinned = true;
               }else{
                   leftTries--;
               }
           } else{
               usedLetters.add(userInput);
               if(word.contains(userInput)){
                   for (int i = 0; i < word.length(); i++){
                       Character currentChar = word.charAt(i);

                       if(currentChar.toString().equals(userInput)){
                           wordMask[i] = true;
                       }
                   }
               }else{
                   leftTries--;
               }
           }
           if (hasWinned){
               break;
           }
        }
        if (hasWinned) {
            System.out.println("GANHOU");
        }else{
            System.out.println("PERDEU");
        }

    }

    private static String getRandomWord(){
        Random random = new Random();
        int randomIndex = random.nextInt(dictionary.length);

        return dictionary[randomIndex];
    }

    private static void displayGame(String word, boolean[] wordMask, int leftTries, List<String> usedLetters){
        System.out.println("*** Alimentos ***");
        System.out.println("\n Números de tentativas: " + leftTries);
        System.out.print("Letras usadas:");
        for(String letter: usedLetters){
            System.out.print(letter+ " - ");
        }
        System.out.println(" ");
        for(int i = 0; i < wordMask.length; i++){
            if(wordMask[i]){
                System.out.print(word.charAt(i) + " ");
            }else{
                System.out.print("_ ");
            }
        }

    }
    private static String getUserInput(){
        System.out.print("\nLetra: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
