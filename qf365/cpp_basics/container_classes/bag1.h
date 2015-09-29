//-----------------------------------------------------------
// File: bag.h
// Name: Michael Main, Walter Savitch
//       (adapted by Sharon M. Tuttle)
// last modified: 2-14-05
//
// Class: bag (a container class for a collection of items)
//
// VALUE SEMANTICS for the bag class:
//    Assignments and the copy constructor may be used 
//       with bag objects.
//
// DYNAMIC MEMORY USAGE by the bag:
//    If there is insufficient dynamic memory, then the
//       following functions throw bad_alloc:
//          The constructors, reserve, insert, operator +=,
//          operator +, and the assignment operator. 
//-----------------------------------------------------------

#ifndef BAG_H
#define BAG_H

#include <cstdlib>  // Provides size_t
using namespace std;

class bag
{
    public:

        /****************************************************/
        /* TYPEDEFS and MEMBER CONSTANTS for the bag class  */
        /****************************************************/

        // bag::value_type is the data type of the items in the
        //    bag. It may be any of the C++ built-in types
        //    (int, char, etc.), or a class with a default
        //    constructor, an assignment operator, and 
        //    operators to test for equality (x == y) and
        //    non-equality (x != y).
        //
        // (CHANGE to desired type...)
        //
        typedef int value_type;

        // bag::DEFAULT_CAPACITY is the initial capacity of a
        //    bag that is created by the default constructor.
        //
        static const size_t DEFAULT_CAPACITY = 30; 
        
        /****************************************************/
        /* CONSTRUCTORS and DESTRUCTOR                      */
        /****************************************************/

        // assumption regarding bag capacity:
        //    The insert member function will work efficiently
        //    (without allocating new memory) until this
        //    capacity is reached.

        // postcondition: creates an empty bag instance with an 
        //    initial capacity of DEFAULT_CAPACITY
        //
        bag();

        // postcondition: creates an empty bag instance with an 
        //    initial capacity of initial_capacity
        //
	bag(size_t initial_capacity);

        // copy constructor
        //
        bag(const bag& source);
	
        // destructor
        //
        ~bag( );

        /*************************************************************/
        /* ACCESSORS and other constant member functions (observers) */
        /*************************************************************/

        // postcondition: returns the number of items in the bag.
        // 
        size_t get_size( ) const 
        { 
            return used; 
        }

        // postcondition: returns the number of times that target 
        //    is in the bag.
        // 
	size_t get_count(const value_type& target) const;

        // postcondition: returns the current capacity of this 
        //    bag (course text doesn't include --- but should, 
        //    if it's going to have reserve() function)
        //
        size_t get_capacity() const 
	{
            return capacity;
        }

        /****************************************************/
        /* MODIFIERS and other modifying member functions   */
        /****************************************************/

        // postcondition: a new copy of entry has been inserted
        //    into the bag.
        // 
        void insert(const value_type& entry);

        // postconditions: removes all copies of target from the
        //    bag; returns number of copies so removed (which
        //    could be zero).
        //
	size_t erase(const value_type& target);

        // postconditions:
        //    *   if target was in the bag, then one copy of it
        //        has been removed; otherwise, bag is unchanged.
        //    *   returns true if one copy was removed, false
        //        otherwise.
        //
	bool erase_one(const value_type& target);

        // postconditions:
        //    *   if new_capacity < used, bag's capacity is
        //        changed to used (will not make the capacity
        //        less than the number of items already in 
        //        the bag).
        //    *   otherwise, the bag's current capacity is 
        //        changed to new_capacity.
        //
	void reserve(size_t new_capacity);

        /****************************************************/
        /* OVERLOADED OPERATORS                             */
        /****************************************************/

        // postcondition: each item in addend has been added to
        //    this bag.
        //
	void operator +=(const bag& addend);

        // postcondition: the bag that activated this function
        //    has the same items and capacity as source.
        //
	void operator =(const bag& source);
	
    private:
	    
        value_type  *data;      // Pointer to partially filled dynamic array
	size_t      used;       // How much of array is being used
	size_t      capacity;   // Current capacity of the bag

};

/*************************************************/
/* NONMEMBER FUNCTIONS for the bag class         */
/*************************************************/

// postcondition: the bag returned is the union of
//       b1 and b2.
//
bag operator +(const bag& b1, const bag& b2);

#endif
   
