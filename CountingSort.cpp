#include <iostream>
using namespace std;
int main()
{
    int arr[100] = { 0 }, arr1[100] = { 0 }, arr2[100] = { 0 }, n, max = 0;
    cout << "Enter the number of elements in the array" << endl;
    cin >> n;
    cout << "Enter the elements of the array" << endl;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    max = arr[0];
    for (int i = 0; i < n; i++) {
        arr1[arr[i]]++;
        if (i > 0) {
            if (max < arr[i])
                max = arr[i];
        }
    }
    for (int i = 0; i < max + 1; i++) {
        cout << arr1[i] << endl;
    }
    static int k = 0;
    for (int i = 0; i < max + 1; i++) {
        int a = arr1[i];
        if (a == 0)
            continue;
        else {
            for (int j = 0; j < a; j++) {
                arr2[k] = i;
                k++;
            }
        }
    }
    cout << "Elements in the counting sort" << endl;
    for (int i = 0; i < n; i++) {
        cout << arr2[i] << endl;
    }
}
