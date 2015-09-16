#include <iostream>
#include <string>
#define Included_GradeBook_H
using namespace std;

int MAX_NAME_LENGTH = 25;

string GradeBook::checkNameLength(string name)
{
    if(name.size() <= 25){
        courseName = name;
    }
    else{
        cout << "Enter another name, that was too long!" << endl;
        string newName;
        getline(cin,newName);
        checkNameLength(newName);
    }
    return courseName;
}

GradeBook::GradeBook(string name) //constructor
{
    courseName = checkNameLength(name);
    cout << "Grade book created for " << courseName << "!" <<endl;
}

void GradeBook::setCourseName(string name)
{
    courseName = checkNameLength(name);
    cout << "Course name changed to: " << courseName <<endl;
}

string GradeBook::getCourseName() const
{
    return courseName;
}

void GradeBook::displayMessage() const
{
    cout << "Welcome to the grade book for\n" << getCourseName() << "!" <<endl;
}
