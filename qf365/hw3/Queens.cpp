//Queens.cpp
#include <iostream>
#include <string>
#include <vector>
#include "Queens.h"
using namespace std;

#define N 6

Queens::Queens(int n){
    rows = n;
    cols = N;
    nCount = n;
    int theBoard[rows][N] = {0};
    solve(theBoard);
    printBoard(theBoard);
};
string Queens::printBoard(int board[][N]){
    for(int k=0; k<rows; k++){
        for(int m=0; m<cols; m++){
            cout << board[k][m] << " ";
        }
        cout << endl;
    }
};
bool Queens::solveHelp(int board[][N], int c){
    if(c >= cols){
        return true;
    }
    for(int i=0;i<cols;i++){
        if(canPlace(board, i, c)){
            board[i][c] = 1;
            if(solveHelp(board, c+1) == true){
                return true;
            }
            board[i][c] = 0;
        }
    }
    return false;
};
bool Queens::solve(int board[][N]){
    if(solveHelp(board, 0) == false){
        cout << "Sorry no answer" << endl;
        return false;
    }
    printBoard(board);
    return true;
};
bool Queens::canPlace(int board[][N], int r, int c){
    //cout << "Checking (" << r << ", " << c << ")" << endl;
    if(r > rows || c > cols){
        cout << "Something was out of index" << endl;
        return false;
    }
    int i, j;
    for(i=0;i<c; i++){
        if(board[r][i] == 1){
            return false;
        }
    }
    for(i=r, j=c; i>=0 && j>=0; i--, j--){
        if(board[i][j] == 1){
            return false;
        }
    }
    for(i=r, j=c; j>=0 && i<rows; i++, j--){
        if(board[i][j] == 1){
            return false;
        }
    }
    return true;
};
