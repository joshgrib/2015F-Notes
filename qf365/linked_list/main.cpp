#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

struct node
{
    int data;
    node* next; //node pointer called next
};
struct node* h;

void Print()
{
    node* temp = h;
    while(temp!=NULL)
    {
        printf("%d",temp->data);
        temp = temp->next;
        printf("\n");
    }
}
void Insert(int data, int n)
{
    node* temp1 = new node;
    temp1->data = data;
    temp1->next=NULL;
    if (n==1)
    {
        temp1->next=h;
        h = temp1;
        return;
    }
    node* temp2 = h;
    for(int i=0;i<n-2;i++)
    {
        temp2 = temp2->next;
    }
    temp1->next = temp2 -> next;
    temp2->next = temp1;
}

template <class Item>
Item myMax(Item a, Item b){
    if (a > b)
        return a;
    else
        return b;
}

template <class Item>
void swap(Item& x, Item& y){
    Item temp = x;
    x = y;
    y = temp;
}

//#define ARRAY_SIZE(array) (sizeof((array))/sizeof((array[0])))

template <class Item>
size_t i_of_max(const Item& data){
    size_t ans;
    size_t i;

    int n = sizeof(*data);
    //cout << n << endl;
    //assert(n > 0);
    ans = 0;

    for(int i = 0; i<n; ++i){
        if(data[ans] < data[i])
            ans = i;
    }
    return ans;
}

int main(){
    //cout << "Hey" << endl;
    /*//linked list
        Insert(10, 1);
        Insert(12, 2);
        Insert(14, 3);
        Insert(16, 4);
        Insert(18, 5);
        Print();
    */
    /*//template classes
        double ans = myMax(2.4, 7.3);
        cout << ans << endl;
        int ans2 = myMax(12, 8);
        cout << ans2 << endl;
        float ans3 = myMax( 2.34234, 9.24123);
        cout << ans3 << endl;
        cout << myMax("Josh", "Liam") << endl;
    */
    /*//another template class
        string me = "Josh";
        string l = "Lindsey";
        swap(me, l);
        cout << "I am " << me << endl;
        cout << "Lindsey is " << l << endl;
    */
    //in class exercise
        const size_t SIZE = 5;
        double myArr[SIZE] = {1, 3, 7, 60, 2};
        int myAns = i_of_max(myArr);

        cout << myAns << endl;
        cout << myArr[myAns] << endl;
        return 0;
}
