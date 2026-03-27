package tictactoe;

import java.util.Scanner;

/**
 *
 * @author ST10472846
 */
public class Game {

    public static Scanner sc = new Scanner(System.in);
    
    private final char[][] board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private int totalMoves;

    public Game(Player p1, Player p2) {//Get Player Names From Player Class
        board = new char[4][4];
        player1 = p1;
        player2 = p2;
        currentPlayer = player1;
        totalMoves = 0;

        // Initialize board with '-'
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                board[i][j] = '-';
            }
        }
    }

    //Display Board Method Assisted By: (ChatGPT, 2025)
    public void displayBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Make Move Method Assisted By: (ChatGPT, 2025)
    public boolean makeMove(int row, int col) {
        if (row < 1 || row > 4 || col < 1 || col > 4) {
            System.out.println("Invalid move! Try again.");
            return false;
        }
        if (board[row][col] != '-') {
            System.out.println("Cell already taken! Try again.");
            return false;
        }

        board[row][col] = currentPlayer.getSymbol();
        totalMoves++;
        return true;
    }

    //Check Winner Method Assisted By: (ChatGPT, 2025)
    public boolean checkWinner() {
        char s = currentPlayer.getSymbol();

        // Check rows & columns
        for (int i = 1; i < 4; i++) {
            if ((board[i][1] == s && board[i][2] == s && board[i][3] == s)
                    || (board[1][i] == s && board[2][i] == s && board[3][i] == s)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[1][1] == s && board[2][2] == s && board[3][3] == s)
                || (board[1][3] == s && board[2][2] == s && board[3][1] == s)) {
            return true;
        }

        return false;
    }

    //Board Full Method Assisted By: (ChatGPT, 2025)
    public boolean isBoardFull() {
        return totalMoves == 9;
    }

    //Switch Method Assisted By: Student Notes [Offline]
    public void switchPlayer() {//For Giving Each Player A Chance To Play
        
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
        
        //currentPlayer = (currentPlayer == player1) ? player2 : player1; (Another Way Of Sswitching Players)
    }

    //Start Game Method Assisted By: (ChatGPT, 2025)
    public void startGame() {
        
        boolean gameOn = true;

        while (gameOn) {//Initiates Game Play
            displayBoard();
            System.out.print(currentPlayer.getName() + "'s Turn. \nEnter Row (1-3): ");
            int row = sc.nextInt();
            System.out.print("Enter Column (1-3): ");
            int col = sc.nextInt();

            if (makeMove(row, col)) {
                if (checkWinner()) {//To Check For Winner Before Continuing With Loop
                    displayBoard();
                    System.out.println("\nTIC-TAC-TOE REPORT");
                    System.out.println("**************************");
                    System.out.println("Winner: " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")");
                    System.out.println("Total Moves: " + totalMoves);
                    System.out.println("**************************");
                    break;
                } 
                else if (isBoardFull()) {//To Check If Board Is Full Before Continuing With Loop
                    displayBoard();
                    System.out.println("\nTIC-TAC-TOE REPORT");
                    System.out.println("**************************");
                    System.out.println("Result: It's a Draw!");
                    System.out.println("Total Moves: " + totalMoves);
                    System.out.println("**************************");
                    break;
                } 
                else {//Continue Game Play
                    switchPlayer();
                }
            }
        }
        sc.close();//Closes Program After A player Wins or There's A Draw
    }
}
/*
OpenAI.2025.ChatGPT [GPT-5]. Available at 
<https://chat.openai.com/>. [Accessed 31 August 2025]

Student Notes [Offline].
[Accessed 29 August 2025]
*/
