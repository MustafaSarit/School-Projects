#include <iostream>

using namespace std;

int main()
{
    string password;
    unsigned int letter = 0, number = 0, other = 0;
    unsigned int fail = 0;
    getline(cin, password);
    if (password.size() < 5) {
        fail += 1;
    }

    for(unsigned int i = 0; i < password.size(); i++){
        if((password[i] >= 'A' && password[i] <= 'Z') ||
           (password[i] >= 'a' && password[i] <= 'z'))
           letter = 1;
        else if(password[i] >= '0' && password[i] <= '9')
            number = 1;
        else if((password[i] >= '!' && password[i] <= '/') ||
                (password[i] >= ':' && password[i] <= '@') ||
                (password[i] >= '[' && password[i] <= '`') ||
                (password[i] >= '{' && password[i] <= '~'))
                other = 1;
        else
            fail += 1;
    }

    if (fail == 0 && letter == 1 && number == 1 && other == 1)
        cout << "The password meets the requirements." << endl;
    else
        cout << "The password does not meet the requirements." << endl;

    return 0;
}
