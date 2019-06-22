#include <iostream>

using namespace std;

int main()
{
    int num1, num2, num3;
    cout << "Enter the first number:" << endl;
    cin  >> num1;
    cout << "Enter the second number:" << endl;
    cin  >> num2;
    cout << "Enter the third number:" << endl;
    cin  >> num3;

    cout << "The sum is:" << endl << num1 + num2 + num3 << endl;
    cout << "The product is:" << endl << num1 * num2 * num3 << endl;
    cout << "The difference is:" << endl << num1 - num2 - num3 << endl;
    return 0;
}
