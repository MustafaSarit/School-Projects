#ifndef __PROGTEST__
#include <iostream>
#include <cstdlib>
#include <fstream>
#endif /* __PROGTEST__ */

using namespace std;

/* Your supplementary functions (if needed) */

int evenOdd ( const char * srcFileName, const char * dstFileName )
 {
    ifstream input;
    ofstream output;
    input.open(srcFileName);
    output.open(dstFileName);
    int inp = 0, eve = 0, od = 0;
    int even[50];
    int odd[50];
    while(input.eof() == false){
        input >> inp;
        if(input.fail()){
            input.close();
            output.close();
            return 0;
        }
        if (inp % 2 == 0){
            even[eve] = inp;
            eve += 1;
        }else{
            odd[od] = inp;
            od += 1;
        }
    }
    for(int i = 0; i < eve; i++){
        output << even[i] << endl;
    }
    for(int i = 0; i < od; i++){
        output << odd[i] << endl;
    }
    input.close();
    output.close();
    return 1;
 }

#ifndef __PROGTEST__
int main ( int argc, char * argv [] )
 {
   return evenOdd("example.txt", "output.txt");
 }
#endif /* __PROGTEST__ */
