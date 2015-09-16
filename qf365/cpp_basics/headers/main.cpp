#include <iostream>
#include <string>
#include "GradeBook.h"
#include "GradeBook.cpp"
using namespace std;

int main()
{
    GradeBook gradeBook("QF 365");
    gradeBook.setCourseName("Wow this is such a long name good thing it gets trimmed...");
    cout << gradeBook.getCourseName() << endl;
    return 0;
}
