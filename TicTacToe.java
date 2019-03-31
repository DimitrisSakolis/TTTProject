

package lab;
import java.util.Scanner;

public class TicTacToe 
{
    private char[][] board; 
    private char CurrentSymbol;
    
    public TicTacToe() 
    {
        board = new char[3][3];
        CurrentSymbol = 'x';
        inBoard();
    }
    public char getCurrentSymbol()
    {
        return CurrentSymbol;
    }
    public void inBoard() 
    {	
        // Loop rows
        for (int i = 0; i < 3; i++) 
        {
           // Loop columns
            for (int j = 0; j < 3; j++) 
            {
                board[i][j] = '-';
            }
        }
    }
    public void printBoard() 
    {
        System.out.println("-------------");		
        for (int i = 0; i < 3; i++) 
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) 
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    public boolean isBoardFull() 
    {
        boolean isFull = true;	
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (board[i][j] == '-') 
                {
                    isFull = false;
                }
            }
        }	
        return isFull;
    }
    public boolean checkForWin() 
    {
        return (checkRowsForWin() || checkColForWin() || checkDiagonalsForWin());
    }
    private boolean checkRowsForWin() 
    {
        for (int i = 0; i < 3; i++) 
        {
            if (checkRandC(board[i][0], board[i][1], board[i][2]) == true) 
            {
                return true;
            }
        }
        return false;
    }
    private boolean checkColForWin() 
    {
        for (int i = 0; i < 3; i++) 
        {
            if (checkRandC(board[0][i], board[1][i], board[2][i]) == true) 
            {
                return true;
            }
        }
        return false;
    }
    private boolean checkDiagonalsForWin() 
    {
        return ((checkRandC(board[0][0], board[1][1], board[2][2]) == true) || (checkRandC(board[0][2], board[1][1], board[2][0]) == true));
    }
    private boolean checkRandC(char c1, char c2, char c3) 
    {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
    public void changePlayer() 
    {
        if (CurrentSymbol == 'x') 
        {
            CurrentSymbol = 'o';
        }
        else 
        {
            CurrentSymbol = 'x';
        }
    }
    public boolean placeMark(int r, int c) 
    {	
        if ((r >= 0) && (r < 3)) 
        {
            if ((c >= 0) && (c < 3)) 
            {
                if (board[r][c] == '-') 
                {
                    board[r][c] = CurrentSymbol;
                    return true;
                }
            }
        }
		
        return false;
    }
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.inBoard();
        System.out.println("Tic-Tac-Toe!");
        do
        {
            System.out.println("Current board layout:");
            game.printBoard();
            int r;
            int c;
            do
            {
                System.out.println("Player " + game.getCurrentSymbol() + ", enter an empty row and column to place your mark: ");
                r = scan.nextInt()-1;
                c = scan.nextInt()-1;
            }
            while (!game.placeMark(r, c));
            game.changePlayer();
        }
        while(!game.checkForWin() && !game.isBoardFull());
        if (game.isBoardFull() && !game.checkForWin())
        {
            System.out.println("The game is a tie");
        }
        else
        {
            System.out.println("Current board layout: ");
            game.printBoard();
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.getCurrentSymbol()) + " Wins");
        }
    }
}    
