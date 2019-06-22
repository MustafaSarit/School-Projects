#include <iostream>
#include <iomanip>
#include <math.h>

using namespace std;

int main()
{
    char shape;
    cout << "Enter a 2D shape to compute area and perimeter: a - square, b - rectangle, c -circle" << endl;
    cin  >> shape;
    switch (shape) {
        case 'a' :
            double side;
            cout << "Enter the side of the square:" << endl;
            cin  >> side ;
            if (side <= 0 || cin.fail())
                cout << "Invalid input." << endl;
            else {
                cout << "Square area is: " << setprecision(4) << fixed << side * side << endl;
                cout << "Square perimeter is " << setprecision(4) << fixed << side * 4 << endl;
            }
            break;

        case 'b' :
            double side1, side2;
            cout << "Enter the sides of the rectangle:" << endl;
            cin  >> side1 ;
            cin  >> side2 ;
            if (side1 <= 0 || side2 <= 0 || cin.fail())
                cout << "Invalid input." << endl;
            else {
                cout << "Rectangle area is: " << setprecision(4) << fixed << side1 * side2 << endl;
                cout << "Rectangle perimeter is: " << setprecision(4) << fixed << (side1 + side2) * 2 << endl;
            }
            break ;

        case 'c' :

            double radius;
            cout << "Enter the radius of the circle:" << endl;
            cin  >> radius ;
            if (radius <= 0 || cin.fail())
                cout << "Invalid input." << endl;
            else {
                cout << "Circle area is: " << setprecision(4) << fixed << radius * radius * M_PI  << endl;
                cout << "Circumference is: " << setprecision(4) << fixed << 2 * radius * M_PI << endl;
            }
            break;

        default :
            cout << "Invalid input." << endl;
            break;
    }

    return 0;
}
