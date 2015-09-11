/*
    Lecture 4
    9/10/15
    Splitting files up into main and header files
*/
/*
    NOTES
    Access specifiers
        public
            Can be called by other functions, can be called by member functions of other classes
        private
            Can only be accessed in the same class and not outside
        protected
            Can not be accessed from outside the class, but can be accessed from within a derived class
    UML class diagrams - MIDTERM QUESTION
        Three levels - show class name, attributes, and operations
        AKA Class name, data members, member functions
    Member functions:
        function in a class
        setter - stores a variable
        getter - obtains a variables
    5 Pillars of OOP
        Abstraction
        Encapsulation
        Modularity
        Hierarchy
        Polymorphism
    Data members
        Variables declared in a funcion body are known as local variables
    Header files
        .h
        Contain inputs, outputs, etc as a class
        Does not contain `main` so it cannot be used as a complete program
        Header is interface, main is implementation
*/
#include <iostream>
#include <string>
using namespace std;

class GradeBook
{
/*
    Class for basic gradebook functionality
*/
public:
    explicit GradeBook(string name) //constructor
    : courseName(name) //variable initialization
    {
        cout << "Gradebook created" << endl;
    }
    void setCourseName(string name)
    {
        courseName = name;
    }
    string getCourseName() const
    {
        return courseName;
    }
    void displayMessage() const
    {
        cout << "Welcome to gradebook for " << getCourseName() << "!" << endl;
    }
private:
    string courseName;
};

int main()
{
    string nameOfCourse;
    GradeBook myGradeBook("QF 365");

    cout << endl;
    myGradeBook.displayMessage();

    return 0;
}
