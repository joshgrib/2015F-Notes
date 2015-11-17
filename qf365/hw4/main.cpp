#include <iostream>
#include <string>
#include <fstream>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <cstdlib>
#include <tchar.h>
#include <urlmon.h>
#include <queue>
#include <iostream>
#pragma comment(lib, "urlmon.lib")

using namespace std;

int main()
{
    string theStock = "";
    string startDate = "";
    string endDate = "";

    cout << "Please enter a stock symbol: " << endl;
    getline(cin, theStock);
    cout << "Please enter start date yyyymmdd: " << endl;
    getline(cin, startDate);
    cout << "Please enter end date yyyymmdd: " << endl;
    getline(cin, endDate);
    string linkTic = string("http://ichart.finance.yahoo.com/table.csv?s=") + theStock + string("&a=") + startDate.substr(4,2) +
        string("&b=") + startDate.substr(6,2) + string("&c=") + startDate.substr(0,4) + string("&d=") + endDate.substr(4,2) +
        string("&e=") + endDate.substr(6,2) + string("&f=") + endDate.substr(0,4) + string("&g=d&ignore=.csv");

    cout << linkTic << endl;

    string fileName = string("C:/Users/patrick/Classes/QF365/F2015/myTest/") + theStock + string("_") + startDate + string("_") + endDate + string(".csv");

    HRESULT hr = URLDownloadToFile ( NULL,linkTic.c_str(), fileName.c_str(), 0, NULL );

    cout << (hr) << endl;

    system("pause");
    return 0;
}
