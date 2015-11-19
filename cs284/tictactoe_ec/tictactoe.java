import java.util.*;
public class tictactoe {
    public static class Game{
        public String[] board = {"1","2","3","4","5","6","7","8","9"};
        private int MAX_DEPTH = 4;

        public Game(){
            System.out.println("New game started.");
            System.out.println("You are Xs and you go first, enter a number to make that move.");
        }

        public void printBoard(){
            System.out.println(
                board[0] + " " +
                board[1] + " " +
                board[2] + " ");
            System.out.println(
                board[3] + " " +
                board[4] + " " +
                board[5] + " ");
            System.out.println(
                board[6] + " " +
                board[7] + " " +
                board[8] + " ");
            System.out.println("-----");
        }

        public boolean isOver(){
            //I know this isn't pretty...
            board = this.board;
            if(
                //the horizontals
                (board[0].equals(board[1]) && board[1].equals(board[2])) ||
                (board[3].equals(board[4]) && board[4].equals(board[5])) ||
                (board[6].equals(board[7]) && board[7].equals(board[8])) ||
                //the verticals
                (board[0].equals(board[3]) && board[3].equals(board[6])) ||
                (board[1].equals(board[4]) && board[4].equals(board[7])) ||
                (board[2].equals(board[5]) && board[5].equals(board[8])) ||
                //the horizontals
                (board[0].equals(board[4]) && board[4].equals(board[8])) ||
                (board[2].equals(board[4]) && board[4].equals(board[6]))){
                return true;
            }
            return false;
        }

        public boolean addMove(int arrIndex, String team, String[] inputBoard){
            if(isOver()){
                return false;
            }
            if(board[arrIndex]!="X" || board[arrIndex]!="O"){
                this.board[arrIndex] = team;
                return true;
            }
            return false;
        }

        public void aiMove(){
            System.out.println("---AI turn---");
            int[] sums;
            sums = new int[9];
            board = this.board;
            for(int i=0; i<8; i++){
                if(board[i]!="X" && board[i]!="O"){
                    String[] fakeBoard = board.clone();
                    sums[i] = aiMoveVal(i, 0, 0, fakeBoard);
                }
            }
            int best = -1;
            for(int i=8; i>0; i--){
                if(board[i]!="X" && board[i]!="O"){
                    if(sums[i] > best){
                        best = i;
                    }
                }
            }
            System.out.println("Best AI move is " + best);
            addMove(best, "O", board);
        }

        public int simPlayerMoveVal(int arrIndex, int val, int depth, String[] fBoard){
            //System.out.println("Simulating player move at " + arrIndex);
            int sum = 0;
            fBoard[arrIndex] = "X";
            if(depth > MAX_DEPTH){
                return 0;
            }
            if(isOver()){
                return 1;//ai must have won on last turn
            }
            for(int i=0; i<8; i++){
                if(fBoard[i]!="X" && fBoard[i]!="O"){
                    sum += aiMoveVal(i, val, depth+1, fBoard);
                }
            }
            return sum;
        }

        public int aiMoveVal(int arrIndex, int val, int depth, String[] fBoard){
            //System.out.println("Simulating AI move at " + arrIndex);
            int sum = 0;
            fBoard[arrIndex] = "O";
            if(depth > MAX_DEPTH){
                return 0;
            }
            if(isOver()){
                return -1;//player must have won on last turn
            }
            for(int i=0; i<8; i++){
                if(fBoard[i]!="X" && fBoard[i]!="O"){
                    sum += simPlayerMoveVal(i, val, depth+1, fBoard);
                }
            }
            return sum;
        }

        public boolean play(){
            Scanner scanner = new Scanner(System.in);
            while(!isOver()){
                printBoard();
                System.out.println("Where do you want to go?");
                String move = scanner.next();
                int pos = Integer.parseInt(move)-1;
                addMove(pos, "X", this.board);
                if(isOver()){
                    System.out.println("You win! Game over!");
                    return true;
                }
                aiMove();
                if(isOver()){
                    System.out.println("The computer wins! Game over!");
                    return true;
                }
            }
            System.out.println("This should never happen");
            return false;

        }
    }
    public static void main(String[] args) {

        Game myGame = new Game();
        myGame.play();
    }
}
