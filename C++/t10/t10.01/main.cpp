#include <iostream>
#include <cstdlib>


using namespace std;

void error_msg(string message = "Invalid input."){
    cout << message << endl;
    exit(1);
}

void failfinder(int input[], int i){
    for(int a = 0; a < i; a++)
        for(int b = a + 1; b < i; b++)
            if(input[a] == input[b])
                error_msg();
}


int main()
{
    int aSize, bSize;

    cout << "Enter size of set A:" << endl;
    cin  >> aSize ;
    if((aSize < 0) || cin.fail()){
        error_msg();
    }

    cout << "Enter members of set A:" << endl;
    int *array1 = new int[aSize];
    int element;
    for(int i = 0; i < aSize; i++){
        cin >> element;
        if(cin.fail())
            error_msg();
        array1[i] = element;
    }
    failfinder(array1, aSize);

    cout << "Enter size of set B:" << endl;
    cin  >> bSize;
    if((aSize < 0) || cin.fail()){
        error_msg();
    }

    cout << "Enter members of set B:" << endl;
    int *array2 = new int[bSize];
    for(int i = 0; i < bSize; i++){
        cin >> element;
        if(cin.fail())
            error_msg();
        array2[i] = element;
    }
    failfinder(array2, bSize);

    int cSize, counter = 0;
    if(aSize > bSize)
        cSize = bSize;
    else
        cSize = aSize;

    int *arrayt = new int[cSize];

    for(int i = 0; i < aSize; i++) {
        for(int n = 0; n < bSize; n++){
            if(array1[i] == array2[n]){
                arrayt[counter] = array1[i];
                counter += 1;
            }
        }
    }
    cout << "Set intersection:" << endl << "{";
    for(int i = 0; i < counter; i++){
        if(i == counter - 1)
            cout << arrayt[i];
        else
            cout << arrayt[i] << ", ";
    }

    cout << "}" << endl;


    return 0;
}
