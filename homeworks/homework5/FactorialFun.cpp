#include <iostream>
#include <fstream>
#include <string>
#include <chrono>

using namespace std;
using namespace chrono;

int combination(int n, int r)
{
    int d = n - r;
    
    if (r != -1 && r != 0)
    {
        int ntotal = n;
        while (n != 1)
        {
            ntotal *= n - 1;
            n--;
        }
        int rtotal = r;
        while (r > 1)
        {
            rtotal *= r - 1;
            r--;
        }

        int dtotal = d;
        while (d != 1)
        {
            dtotal *= d - 1;
            d--;
        }
        int result = ntotal / (rtotal * dtotal);
        return result;
    }
    else if (r == -1)
    {
        int ntotal = n;
        if(n = 0){
            ntotal = 1;
        }
        while (n != 1 || n != 0)
        {
            ntotal *= n - 1;
            n--;
        }
        return ntotal;
    }
    else {
        
        return 1;
    }
}
void time()
{
    
}
int main()
{
    auto start = chrono::steady_clock::now();

    int num;
    int r;
    string s;
    string n;
    string t;

    try
    {
        getline(cin, s);
        n = s[0];
        num = stoi(n);

        t = s[2];
        r = stoi(t);
        
        if (r != 0)
        {
            cout << combination(num, r);
        }
        else
        {
            r = 0;
            cout << combination(num,r);
        }
    }
    catch (exception &err)
    {
        r = -1;
        cout << combination(num, r);
    }
    auto end = chrono::steady_clock::now();
    auto diff = duration_cast<microseconds>(end-start);

    cout << "\nTime for processing: " << diff.count() << " microseconds";
}

