//Queens.h
#pragma once //makes sure it's only included once
#include <iostream>
#include <string>
#include <stack>
#include <vector>
using namespace std;

class Queens{
public:
    explicit Queens(int);
    string printBoard();
private:
    stack<int> queens;
    bool solve();
    bool solveHelp(int);
    bool canPlace(int, int);
    int rows;
    int cols;
    vector<vector<int> > theBoard;
    int placed;
};
