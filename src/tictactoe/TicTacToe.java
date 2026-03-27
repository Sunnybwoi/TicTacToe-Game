package tictactoe;
import java.util.*;

/**
 * Simple TicTacToe Game To Demonstrate arrays, loops, constructors,
 * encapsulation
 *
 * @author ST10472846
 */
public class TicTacToe {

    public static Scanner sc = new Scanner(System.in);

    //Assisted By: Student Notes [Offline]
    public static void main(String[] args) {
        

        System.out.print("Enter Player 1 name: ");//Prompt For PLayer1 Name
        String name1 = sc.nextLine();
        Player p1 = new Player(name1, 'X');//Saves Player1 Name With A Character X

        System.out.print("Enter Player 2 name: ");//Prompt For PLayer2 Name
        String name2 = sc.nextLine();
        Player p2 = new Player(name2, 'O');//Saves Player1 Name With A Character O

        Game game = new Game(p1, p2);
        game.startGame();//Initiates Game Play

        sc.close();//Closes Program
    }
}
/*
Student Notes [offline]
[Accessed 1 September 2025]
*/
