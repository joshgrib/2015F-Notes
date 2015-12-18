#pragma once
#include <iostream>
#include <string>
using namespace std;

class StockStat{
public:
    void run();
private:
    int get_data();
    string make_url(string, string, string);
    void download_data(string, string, string);
    int run_stats();
    int calc_stats(int, int);
};
