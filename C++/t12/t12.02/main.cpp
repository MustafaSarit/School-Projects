#include <iostream>
#include <cstring>

using namespace std;

struct patient {
    string surname;
    string name;
    string birthnumber;
    string disease;
    int company;
};
patient hospital [5];

int main()
{
    for(int i = 0; i < 5; i++){
        cout << "Enter the surname, name, birth number, disease, insurance company of the patient:" << endl;
        cin >> hospital[i].surname >> hospital[i].name
            >> hospital[i].birthnumber >> hospital[i].disease >> hospital[i].company;
    }
    for(int i = 0; i < 5 ; i++){
        if(hospital[i].disease == "tbc"){
            cout << "The name and surname of patients with tbc:" << endl << hospital[i].name
                 << " " << hospital[i].surname << endl;
        }
            if(hospital[i].company == 211)
                cout << "The name and surname of patients with the insurance company 211 is:" << endl << hospital[i].name
                 << " " << hospital[i].surname << endl;

    }
    cout << "The surnames of all patients are:" << endl;
    for(int i = 0; i < 5; i++){
        cout << hospital[i].surname << endl;
    }
    return 0;
}
