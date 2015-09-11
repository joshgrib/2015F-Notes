#include <iostream>
#include <string>
#include "GradeBook.h"
#include "GradeBook.cpp"
using namespace std;

int main()
{
    GradeBook gradeBook("QF 365");
    gradeBook.setCourseName("QF465");
    cout << gradeBook.getCourseName() << endl;
    return 0;
}
