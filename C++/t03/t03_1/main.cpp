#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    double cord1x, cord1y, cord2x, cord2y, dirvec;
    cout << "Enter the coordinates of points A and B:" << endl;
    cin  >> cord1x >> cord1y ;
    cin  >> cord2x >> cord2y;

    dirvec = sqrt((cord2x - cord1x) * (cord2x - cord1x) + (cord2y - cord1y) * (cord2y - cord1y));

    cout << "The X coordinate of the central point S is: " << (cord1x + cord2x) / 2 << endl;
    cout << "The Y coordinate of the central point S is: " << (cord1y + cord2y) / 2 << endl;
    cout << "The length of the directional vector u is: " << dirvec << endl;
    cout << "The radius r of the circle is: " << dirvec/2 << endl;
    return 0;
}
