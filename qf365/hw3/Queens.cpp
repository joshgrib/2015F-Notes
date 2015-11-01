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
};

string Queens::printBoard(){
    for(int k=0; k<rows; k++){
        for(int m=0; m<cols; m++){
            cout << theBoard[k][m] << " ";
        }
        cout << endl;
    }
};
bool Queens::solve(){
    return true;
};
bool Queens::canPlace(int r, int c){
    return true;
};
