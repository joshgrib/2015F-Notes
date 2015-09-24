#include <iostream>
#include <string>
#include <unistd.h>
#include <cmath>
#include <cstdlib>
using namespace std;

int rand_n(){
    return (rand()%3)-1;
}

double mc_sim(int sims, int periods, double price){
    double total_p=0;
    for(int i=0; i<sims; i++){
        double f_price = price;
        for(int j=0; j<periods; j++){
            f_price += rand_n();
        }
        total_p += f_price;
        cout << f_price << endl;
    }
    cout << "---" << endl;
    return total_p/sims;
}

int main()
{
    cout << mc_sim(10, 10, 100) << endl;
    return 0;
}
