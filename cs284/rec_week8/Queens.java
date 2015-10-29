public class Queens{
    public void Queens(int n){
        for(int i==0; i<n; i++){

        }
    }
    public void placeQueens(int n){
        /**Place n queens on the board
         * They cans be on the same row, column, or diagonal as another queens
         * Board is an 8x8 chess board
         */
        //Try with the first spot for the first queen. Then for the second queen iterate through the board and place it where it can go.

    }
    public void callPlaceQueens(){
        placeQueens(0);
    }
    public statis void main(String args[]){
        Queens Q = new Queens(8);
        Q.callPlaceQueens();
    }
}
