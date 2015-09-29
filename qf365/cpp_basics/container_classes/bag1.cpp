//-----------------------------------------------------------
// File: bag.cpp
// Name: Michael Main, Walter Savitch
//       (adapted by Sharon M. Tuttle)
// last modified: 2-14-05
//
// Class implemented: bag 
//                    (a container clas for a
//                    collection of items)
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
//
// INVARIANT for the bag class:
//   1. The number of items in the bag is in the 
//      member variable used;
//   2. The actual items of the bag are stored in a partially 
//      filled array. The array is a dynamic array, pointed to 
//      by the member variable data;
//   3. The size of the dynamic array is in the member 
//      variable capacity.
//--------------------------------------------------------------

#include <algorithm>     // Provides copy function
#include <cassert>       // Provides assert function
#include "bag1.h"
using namespace std;

// (note that the following MAY be required for the named constant)

//const size_t bag::DEFAULT_CAPACITY;

/********************************************************/
/* CONSTRUCTORS and DESTRUCTOR                          */
/********************************************************/

// postcondition: creates an empty bag instance with an 
//    initial capacity of DEFAULT_CAPACITY
//
bag::bag()
{
    data = new value_type[DEFAULT_CAPACITY];
    capacity = DEFAULT_CAPACITY;
    used = 0;
}

// postcondition: creates an empty bag instance with an 
//    initial capacity of initial_capacity
//
bag::bag(size_t initial_capacity)
{
    data = new value_type[initial_capacity];
    capacity = initial_capacity;
    used = 0;
}

// Copy constructor
//
// Library facilities used: algorithm
//
bag::bag(const bag& source)
{
    data = new value_type[source.capacity];
    capacity = source.capacity;
    used = source.used;

    // (copy is from the algorithm library)
    copy(source.data, source.data + used, data);
}

// Destructor
//
bag::~bag( )
{
    delete [ ] data;
}

/*************************************************************/
/* ACCESSORS and other constant member functions (observers) */
/*************************************************************/

// get_size was already implemented in the bag.h file...!

// get_count
//
// postcondition: returns the number of times that target 
//    is in the bag.
// 
size_t bag::get_count(const value_type& target) const
{
    size_t answer;
    size_t i;

    answer = 0;

    // check each item of bag, counting each target instance
    for (i = 0; i < used; i++)
    {
	if (target == data[i])
        {
	    answer++;
        }
    }

    return answer;
}

// get_capacity was already implemented in the bag.h file...!

/****************************************************/
/* MODIFIERS and other modifying member functions   */
/****************************************************/

// insert
//
// postcondition: a new copy of entry has been inserted
//    into the bag.
// 
void bag::insert(const value_type& entry)
{   
    // increase bag's capacity if necessary
    if (used == capacity)
    {
        reserve(used+1);
    }

    data[used] = entry;
    used++;
}

// erase
//
// postconditions: removes all copies of target from the
//    bag; returns number of copies so removed (which
//    could be zero).
//
size_t bag::erase(const value_type& target)
{
    size_t index = 0;
    size_t num_removed = 0;

    // look for target amongst all current bag items
    while (index < used)
    {
        if (data[index] == target)
        {
            used--;

            // move the "last" item into the "hole" created
            //    by removing target
            data[index] = data[used];

            num_removed++;

            // (note that index is NOT changed in this case ---
            //    so, next time through loop, you'll check
            //    "last" item just swapped into the "hole",
            //    in case it, TOO, is target!)
            // (and THIS is why while is used instead of for!)
        }

        else
        {
            index++;
        }
    }
        
    return num_removed;
}

// erase_one
//
// postconditions:
//    *   if target was in the bag, then one copy of it
//        has been removed; otherwise, bag is unchanged.
//    *   returns true if one copy was removed, false
//        otherwise.
//
bool bag::erase_one(const value_type& target)
{
    size_t index; // The location of target in the data array    

    // First, set index to the location of target in the data 
    //    array, which could be as small as 0 or as large as used-1.
    //    If target is not in the array, then index will be set 
    //    equal to used.
    index = 0;
        
    while ((index < used) && (data[index] != target))
    {
        index++;
    }

    // if target isn't in the bag, then there's no work to do
    if (index == used) 
    {
        return false;
    }
        
    // IF execution reaches here, target is in the bag at 
    //    data[index]. So, reduce used by 1 and copy the 
    //    last item onto data[index].
    used--;
    data[index] = data[used];
    return true;
}

// reserve
//
// postconditions:
//    *   if new_capacity < used, bag's capacity is
//        changed to used (will not make the capacity
//        less than the number of items already in 
//        the bag).
//    *   otherwise, the bag's current capacity is 
//        changed to new_capacity.
//
// Library facilities used: algorithm
//
void bag::reserve(size_t new_capacity)
{
    value_type *larger_array;

    // if allocated memory is already the right size, we're done;
    if (new_capacity == capacity)
    {
        return; 
    }

    // WILL let capacity of bag be reduced, but NOT
    //    any smaller than current number of items.
    if (new_capacity < used)
    {
        // can't allocate less than we are using
        new_capacity = used;
    }

    // allocate new array and copy over bag items
    larger_array = new value_type[new_capacity];
    copy(data, data + used, larger_array); // from algorithm library

    // (notice that we are freeing the "old" array...)
    delete [ ] data;

    data = larger_array;
    capacity = new_capacity;
}

/****************************************************/
/* OVERLOADED OPERATORS                             */
/****************************************************/

// +=
//
// postcondition: each item in addend has been added to
//    this bag.
//
// Library facilities used: algorithm
//
void bag::operator +=(const bag& addend)
{
    // increase bag capacity if necessary
    if (used + addend.used > capacity)
    {
        reserve(used + addend.used);
    }
        
    // (from algorithm library)
    copy(addend.data, addend.data + addend.used, data + used);

    used += addend.used;
}

// =
//
// postcondition: the bag that activated this function
//    has the same items and capacity as source.
//
// Library facilities used: algorithm
//
void bag::operator =(const bag& source)
{
    value_type *new_data;

    // Check for possible self-assignment:
    if (this == &source)
    {
        return;
    }

    // If needed, allocate an array with a different size:
    if (capacity != source.capacity)
    { 
        new_data = new value_type[source.capacity];
        delete [ ] data;
        data = new_data;
        capacity = source.capacity;
    }

    // Copy the data from the source array:
    used = source.used;
    copy(source.data, source.data + used, data); // from algorithm lib
}

/*************************************************/
/* NONMEMBER FUNCTIONS for the bag class         */
/*************************************************/
  
//------------------------------------------  
// slick: just implement nonmember + here!
// (how can you tell it isn't a member?
//    ...no bag:: !)
//-----------------------------------------

// non-member +
//
// postcondition: the bag returned is the union of
//       b1 and b2.
//
bag operator +(const bag& b1, const bag& b2)
{
    bag answer(b1.get_size() + b2.get_size());

    answer += b1; 
    answer += b2;
    return answer;
}
   
