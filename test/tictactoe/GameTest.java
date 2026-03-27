/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tictactoe;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10472846
 */
public class GameTest {
    
    private Player p1;
    private Player p2;
    private Game game;
    
    public GameTest() {
    }

    @Before
    public void setUp() {
        p1 = new Player("Alice", 'X');
        p2 = new Player("Courage", 'O');
        game = new Game(p1, p2);
    }

    @Test
    public void testValidMove() {
        boolean move = game.makeMove(1, 1);
        assertTrue(move, "Valid move should return true");
    }

    @Test
    public void testInvalidMove_OutOfBounds() {
        boolean move = game.makeMove(4, 4);
        assertFalse(move, "Move outside board should return false");
    }

    @Test
    public void testInvalidMove_CellAlreadyTaken() {
        game.makeMove(1, 1);
        boolean moveAgain = game.makeMove(1, 1);
        assertFalse(moveAgain, "Cannot place symbol on an occupied cell");
    }

    @Test
    public void testCheckWinner_RowWin() {
        // Player X makes 3 moves in row 0 (known as 1 to player)
        game.makeMove(1, 1); // X
        game.makeMove(2, 1); // O
        game.makeMove(1, 2); // X
        game.makeMove(2, 2); // O
        game.makeMove(1, 3); // X -> should win

        assertTrue(game.checkWinner(), "Player X should win with a full row");
    }

    @Test
    public void testCheckWinner_ColumnWin() {
        game.makeMove(1, 1); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 1); // X
        game.makeMove(2, 2); // O
        game.makeMove(3, 1); // X -> should win

        assertTrue(game.checkWinner(), "Player X should win with a full column");
    }

    @Test
    public void testCheckWinner_DiagonalWin() {
        game.makeMove(1, 1); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 2); // X
        game.makeMove(1, 3); // O
        game.makeMove(3, 3); // X -> should win

        assertTrue(game.checkWinner(), "Player X should win with a diagonal");
    }

    @Test
    public void testIsBoardFull_DrawGame() {
        // Fill the board without a winner
        game.makeMove(1, 1);game.switchPlayer(); // X
        game.makeMove(1, 2);game.switchPlayer(); // O
        game.makeMove(1, 3);game.switchPlayer(); // X
        game.makeMove(2, 2);game.switchPlayer(); // O
        game.makeMove(2, 1);game.switchPlayer(); // X
        game.makeMove(2, 3);game.switchPlayer(); // O
        game.makeMove(3, 2);game.switchPlayer(); // X
        game.makeMove(3, 1);game.switchPlayer(); // O
        game.makeMove(3, 3); // X

        assertTrue(game.isBoardFull(), "Board should be full after 9 moves");
        assertFalse(game.checkWinner(), "There should be no winner in a draw");
    }
}

