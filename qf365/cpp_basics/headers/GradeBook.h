//Header file name has to match class name
#include <iostream>
#include <string>
using namespace std;

class GradeBook
{
public:
    explicit GradeBook(string); //constructor
    void setCourseName(string);
    string getCourseName() const;
    void displayMessage() const;
    string checkNameLength(string);
private:
    string courseName;
};
