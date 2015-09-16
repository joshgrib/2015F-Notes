#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

int main()
{
    GradeBook myGB;
    myGB.openBook("QF365");
    cin.get(); //linux equivalent of system("pause");
    return 0;
}
