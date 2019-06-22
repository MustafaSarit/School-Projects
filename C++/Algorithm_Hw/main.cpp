#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <chrono>

using namespace std;

struct LinkedList {                                         //Linked list bu
   string data;                                             //Linked listin içeriði
   struct LinkedList *next;
};

struct LinkedList* head = NULL;                             //Linkedlistin en üstteki node'u

void save(string new_data) {                                //Linkedlist e yeni veri girilmesini saðlar
   struct LinkedList* new_node = new LinkedList;            //Oluþturulacak yeni veri için hafýzada yer açýlýr
   new_node->data = new_data;                               //Hafýzada açýlan yeni yerin içeriði doldurulur
   new_node->next = head;                                   //yeni en üst artýk bu node oldu
   head = new_node;
}

bool compare(string name) {                                 // gönderilen name parametresinin linked listde olup olmadýðýna bakar varsa true gönderir yoksa false
   struct LinkedList* ptr;
   ptr = head;
   while (ptr != NULL) {
      if(name == ptr->data){
        return true;
      };
      ptr = ptr->next;
   }
   return false;
}

int main()
{
    auto start = chrono::steady_clock::now( );                          // Kodun baþlangýç zamaný
    ifstream inp1;                                                      // Input file stream bir dosyadan veri bu parametreyle alýnýr
    map<string, int> list1;                                             // Hash map 1. input dosyasý buna kaydeddiliyor
    string line;


    inp1.open("Input1.txt");
    for(int i = 1; getline(inp1, line); i++){                           // Açýlan dosyadaki satýrlarý sýra sýra line parametresiyle eþler
        list1[line] = i;                                                // Line parametresini hashmap map "i" deðerli key olarak ekler
    }
    inp1.close();

    inp1.open("Input2.txt");
    while(getline(inp1, line)){
        save(line);                                                     //Linkedlist oluþturup line parametresini save fonksiyonuna gönderir "yukarýdaki save fonksiyonuna bak"
    }
    inp1.close();

    for(map<string, int>::iterator it = list1.begin(); it != list1.end(); ++it){            //Hashmaple linked list karþýlaþtýrýlýr bu döngüde
        string key = it->first;
        int value  = it->second ;
        if(!(compare(key))){                                            // yukarýdaki compare fonksiyonuna bak
            cout << key << " in first file at line " << value << " is missing in second file!" << endl;
        }
    }
    auto elapsed = chrono::duration_cast<chrono::milliseconds>(chrono::steady_clock::now( ) - start );
    cout << elapsed.count() << " ms" << endl;

    system("Pause");
    return 0;
}
