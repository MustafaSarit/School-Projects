#include <iostream>
#include <math.h>

using namespace std;

int main()
{   double a, b, c, s, area ;
    cout << "Enter the triangle side lengths a, b, c:" << endl;
    cin  >> a;
    cin  >> b;
    cin  >> c;
    if (a <= 0 || b <= 0 || c <= 0) {
        cout << "This is not a valid triangle." << endl;
        return 0;
    }
    s = ( a + b + c ) / 2;
    area = sqrt(s * (s - a) * (s - b) * (s - c)) ;
    if (area > 0) {
        cout << "The area of the triangle is " << area << endl;
    }else {
        cout << "This is not a valid triangle." << endl;
    }
    return 0;
}
