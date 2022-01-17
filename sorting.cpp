#include <iostream>
using namespace std;

    

    void switching(int *i,int *j)
    {
        int temp = *i;
        *i = *j;
        *j = temp;
    }
    
    void bubbleSort(int array[], int n)
    {
        int i,j;

        for(int i=0;i<n-2;i++){
            for (int j=0;j<n-i-1;j++){
                if(array[j]>array[j+1]){
                    switching(&array[j],&array[j+1]);
                }
            }
        }
    }
    
    
    void print(int array[], int size)
    {
        int k;
        for(int k=0;k<size;k++){
            cout << " " << array[k];
        }
        cout << "\n";
    }
int main()
{
    int array [] = {15,10,5,20,17,12};
    int n = sizeof(array)/sizeof(array[0]);
    print(array, n);
    bubbleSort(array, n);
    print(array, n);
}