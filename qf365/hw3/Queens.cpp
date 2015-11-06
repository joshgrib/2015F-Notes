//Queens.cpp
#include <iostream>
#include <string>
#include <vector>
#include "Queens.h"
using namespace std;

//typedef <vector<int> >  boardIn;
//<vector <boardIn> > theBoard;

Queens::Queens(int n){
    rows = n;
    cols = n;
    theBoard.resize(n);
    for(int i=0; i<n; i++){
        theBoard[i].resize(n);
        for(int j=0; j<n; j++){
            theBoard[i][j] = 0;
        }
    }
    int placed = 0;
    solve();
};

string Queens::printBoard(){
    for(int k=0; k<rows; k++){
        for(int m=0; m<cols; m++){
            cout << theBoard[k][m] << " ";
        }
        cout << endl;
    }
};
bool Queens::solveHelp(int c){
    if(c >= cols){
        return true;
    }
    for(int i=0;i<cols;i++){
        if(canPlace(i, c)){
            theBoard[i][c] = 1;
            if( (c+1) > (cols) )
                return false;
            if(solveHelp(c+1) == true){
                return true;
            }
            theBoard[i][c] = 0;
        }
    }
    return false;
};
bool Queens::solve(){
    if(solveHelp(0) == false){
        cout << "Sorry no answer" << endl;
        return false;
    }
    printBoard();
    return true;
};
bool Queens::canPlace(int r, int c){
    //cout << "Checking (" << r << ", " << c << ")" << endl;
    int i, j;
    for(i=0;i<c; i++){
        if(theBoard[r][i] == 1){
            return false;
        }
    }
    for(i=r, j=c; i>=0 && j>=0; i--, j--){
        if(theBoard[i][j] == 1){
            return false;
        }
    }
    for(i=r, j=c; j>=0 && i<rows; i++, j--){
        if(theBoard[i][j] == 1){
            return false;
        }
    }
    return true;
};
