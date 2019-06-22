#include <iostream>

using namespace std;

int main()
{
    int visitors;
    cout << "Enter number of visitors:" << endl;
    cin  >> visitors;
    if (cin.fail() || visitors < 0) {
        cout << "Invalid input." << endl;
        return 0;
    }
    int income = visitors * 50 * 0.07;
    int salary;
    if (income < 2000) {
        salary = 70;
    }
    else if (income < 2500) {
        salary = 80;
    }
    else if (income < 3000) {
        salary = 90;
    }
    else if (income < 3500) {
        salary = 100;
    }
    else {
        salary = 110;
    }

    salary = salary * 8;
    cout << "The salary is: " << salary << " CZK" << endl;
    return 0;
}
