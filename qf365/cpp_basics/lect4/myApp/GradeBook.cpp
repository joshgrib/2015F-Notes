#include <iostream>
#include <string>
#define Included_GradeBook_H
using namespace std;

GradeBook::GradeBook(string name) //constructor
{
    courseName = name;
}

void GradeBook::setCourseName(string name)
{
    courseName = name;
}

string GradeBook::getCourseName() const
{
    return courseName;
}

void GradeBook::displayMessage() const
{
    cout << "Welcome to the grade book for\n" << getCourseName() << "!" <<endl;
}


