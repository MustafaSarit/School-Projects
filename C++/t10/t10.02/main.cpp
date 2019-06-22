#include <iostream>
#include <cstdlib>
#include <math.h>

using namespace std;

void error_msg(string message = "Invalid input."){
    cout << message << endl;
    exit(1);
}

int main()
{
    unsigned int length;
    double skaler = 0, meas1 = 0, meas2 = 0;
    cin >> length;
    if(cin.fail() || length < 0){
        error_msg();
    }

    double *vec1 = new double[length];
    double *vec2 = new double[length];
    for (unsigned int i = 0; i < length; i++){
        cin >> vec1[i];
        if(cin.fail()){
            error_msg();
        }
    }
    for (unsigned int i = 0; i < length; i++){
        cin >> vec2[i];
        if(cin.fail()){
            error_msg();
        }
    }


    for(unsigned int i = 0; i < length; i++){
        skaler += vec1[i] * vec2[i];
        meas1 += pow(vec1[i], 2);
        meas2 += pow(vec2[i], 2);
    }
    delete vec1, vec2;
    meas1 = sqrt(meas1);
    meas2 = sqrt(meas2);

    cout << "CSM: " << skaler / (meas1 * meas2) << endl;

    return 0;
}
