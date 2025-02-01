package com.github.Leo_Proger;

import java.util.*;

public class Game {
    private final Movement[][] playground = new Movement[3][3];
    private final Random random = new Random();

    public void start(Movement userSide) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            if (userSide.equals(Movement.ZERO)) {
                makeRandomMove(Movement.CROSS);
            }
            System.out.println(getPlayground());

            System.out.print("Enter move (B2 for example) >>> ");
            String move = sc.nextLine().toLowerCase(Locale.ROOT);

            makeMove(Character.getNumericValue(move.charAt(1)) - 1, move.charAt(0) - 97, userSide);

            if (userSide.equals(Movement.CROSS)) {
                makeRandomMove(Movement.ZERO);
            }
            // TODO: Check playground for winnings
        }
    }

    private void makeMove(int row, int col, Movement move) {
        playground[row][col] = move;
    }

    private void makeRandomMove(Movement move) {
        List<int[]> freeCells = new ArrayList<>();

        // TODO: How to improve random
        for (int row = 0; row < playground.length; row++) {
            for (int col = 0; col < playground[row].length; col++) {
                if (playground[row][col] == null) {
                    freeCells.add(new int[]{row, col});
                }
            }
        }
        int[] randomCellForMove;
        if (freeCells.size() > 1) {
            randomCellForMove = freeCells.get(random.nextInt(freeCells.size() - 1));
        } else {
            randomCellForMove = freeCells.getFirst();
        }
        makeMove(randomCellForMove[0], randomCellForMove[1], move);
    }

    public String getPlayground() {
        return """
                    A   B   C
                  -------------
                1 | %s | %s | %s |
                  -------------
                2 | %s | %s | %s |
                  -------------
                3 | %s | %s | %s |
                  -------------""".formatted(
                formatCell(playground[0][0]), formatCell(playground[0][1]), formatCell(playground[0][2]),
                formatCell(playground[1][0]), formatCell(playground[1][1]), formatCell(playground[1][2]),
                formatCell(playground[2][0]), formatCell(playground[2][1]), formatCell(playground[2][2])
        );
    }

    private String formatCell(Movement cell) {
        return cell == null ? " " : cell.getSymbol();
    }
}
