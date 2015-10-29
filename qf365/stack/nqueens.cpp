#include <iostream>
#include <string>
#include <stack>
using namespace std;

class Queens{
public:
    explicit Queens(int n){
        int Queens = n;
        int rows = n;
        int cols = n;
        int taken[rows][cols];
        int illegal[rows][cols];
    }

    bool isSafe(int x, int y){
        if(illegal[x][y]){
            return false;
        }
        return true;
    }

    bool placeQueen(int x, int y){
        if(isSafe(x, y)){
            taken[x][y] = true;
            for(int i=0; i<rows; i++){
                taken[i][y] = true;
                for(int j=0; j<cols; j++){
                    taken[x][j] = true;
                    taken[
            return true;
        }
        return false;
    }

    void printSol(){
        cout << "Not done yet" << endl;
    }
};

int main(){
    cout << "Ready to go!" << endl;
    return 0;
}
