#include <iostream>
#include <cstring>

using namespace std;

struct book {
    string bookname;
    string surname;
    string name;
    string genre;
    int year;
    int price;
    int id;
};
book library [5];

int main()
{
    for(int i = 0; i < 5; i++){
        cout << "Enter the book name, author surname, name, genre, year, price and id:" << endl;
        cin >> library[i].bookname >> library[i].surname >> library[i].name >> library[i].genre >> library[i].year >> library[i].price >> library[i].id;

    }
    cout << "Novels are:" << endl;
    for(int i=0; i<5; i++){
        if(library[i].genre=="roman")
            cout << library[i].bookname << endl;
    }
       cout << endl << "Books with price lower than 300,- Kc are:" << endl;
    for(int i=0; i<5; i++){
        if(library[i].price<300)
            cout << library[i].bookname << endl;
    }
           cout << endl << "Surnames of all authors are:" << endl;
    for(int i=0; i<5; i++){
            cout << library[i].surname << endl;
    }
    return 0;
}
