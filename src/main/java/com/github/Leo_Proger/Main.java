package com.github.Leo_Proger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
//        System.out.println(game.getPlayground());

        System.out.print("Enter your side (X or O) >>> ");
        String userSide = sc.nextLine();

        if (userSide.equalsIgnoreCase("X")) {
            game.start(Movement.CROSS);
        } else if (userSide.equalsIgnoreCase("O")) {
            game.start(Movement.ZERO);
        } else {
            throw new IllegalArgumentException("Invalid user side");
        }
    }
}