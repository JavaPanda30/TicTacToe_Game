import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        //3x3 board 2D array
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = ' ';
            }
        }
        char player = 'X';
        boolean gameover = false;
        Scanner sc = new Scanner(System.in);
        while (!gameover)
        {
            if(!isFull(board))
            {
                System.out.println("Game Draw!! ");
                break;
            }
            System.out.println("Player " + player + " Enter: \n");
            int r = sc.nextInt();
            int c = sc.nextInt();
            if (board[r][c] == ' ')
            {
                board[r][c] = player;
                gameover = HaveWon(board,player);
                if (gameover)
                {
                    System.out.println("Player " + player + " Won!!!!");
                }
                else
                {
                    player = (player == 'X') ? 'O' : 'X';
                }
            }

            else
            {
                System.out.println("Invalid Move");
            }
            printboard(board);
        }
    }

    static void printboard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println("");
        }
    }

    static boolean HaveWon(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        for (int column = 0; column < board[0].length; column++) {
            if (board[0][column] == player && board[1][column] == player && board[2][column] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    static boolean isFull(char[][] board)
    {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if(board[row][column] == ' ')
                    return true;
            }
        }
        return false;
    }
}
