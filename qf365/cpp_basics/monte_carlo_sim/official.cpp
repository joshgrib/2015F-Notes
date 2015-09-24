#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <random>
#include <math.h>

using namespace std;

double gaussian_box_muller() {
    double x = 0.0;
    double y = 0.0;
    double euclid_sq = 0.0;

    // Continue generating two uniform random variables
    // until the square of their "euclidean distance"
    // is less than unity
    do {
        x = 2.0 * rand() / static_cast<double>(RAND_MAX)-1;
        y = 2.0 * rand() / static_cast<double>(RAND_MAX)-1;
        euclid_sq = x*x + y*y;
    } while (euclid_sq >= 1.0);

    return x*sqrt(-2*log(euclid_sq)/euclid_sq);
}

//dSt = µSdt + σSdWt
int main()
{
    int seed = 0;
    srand(time(NULL));

    double deltaP = 0.0;
    double price = 0.0;
    double u = .01;
    double sig = .10;
    double S = 1;
    double dt = .2;
    int steps = 1/dt;
    int numSims = 10000000;

    double storePrice = 0.0;
    double total = 0.0;
    for(int i = 0; i < numSims; i++)
    {
        storePrice = 0.0;
        price = S;
        for(int j = 0; j < steps; j++)
        {
            deltaP = u*price*dt + sig*price*gaussian_box_muller();
            price = deltaP + price;
            //cout << price << endl;
        }
        storePrice = storePrice + price;
        total += storePrice;
        //cout << "The price is: " << storePrice << endl;
    }

    cout << "The security price is: " << total/numSims << endl;
/*
    double myTest = gaussian_box_muller();

    int numSims = 0;
    double initPrice = 0.0;
    double finalPrice = initPrice;
    unsigned int seed = 0;

    cout << "Enter seed: ";
    cin >> seed;
    srand(seed); //sets the seed which determines the random sequence
    cout << "Please enter the number of simulations: " << endl;
    cin >> numSims;
    cout << "Please enter in the beginning price :" << endl;
    cin >> initPrice;

    //price = price + randmon number over number of loops
    //r = ((double(rand()) / double(RAND_MAX)) * (1 - -1)) + -1;

    double r = 0.0;

    double gauss_bm = 0.0;

    double tracker = 0.0;
    for(int i = 0; i < 100; i++)
    {
        gauss_bm = gaussian_box_muller();
        for(unsigned int counter = 1; counter <= numSims; ++counter)
        {
            srand(i+counter);
            r =  initPrice + initPrice*gauss_bm;
            finalPrice = finalPrice + r;
        }
            tracker = tracker + finalPrice;
        }
    cout << "Our simulated price after " << numSims << " simulations is: " << tracker/100 << endl;
*/
    return 0;
}
