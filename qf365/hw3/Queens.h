//Queens.h
#pragma once //makes sure it's only included once
#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

#define N 6


class Queens{
public:
    explicit Queens(int);
    string printBoard(int b[][N]);
private:
    bool solve(int b[][N]);
    bool solveHelp(int b[][N], int);
    bool canPlace(int b[][N], int, int);
    int rows;
    int cols;
    //vector<vector<int> > theBoard;
    int nCount;
};
