#include <iostream>
using namespace std;
int main()
{
    int arr[100], arr1[100], n, max = 0;
    cout << "Enter the number of elements in the array" << endl;
    cin >> n;
    cout << "Enter the elements" << endl;
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    max = arr[0];
    for (int i = 0; i < n; i++) {
        if (max < arr[i])
            max = arr[i];
        arr1[i] = arr[i];
    }
    while (max>0)
    {
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < (n - i - 1); j++)
            {
                int a = arr1[j] % 10;
                int b = arr1[j + 1] % 10;
                if (a > b)
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }
            }
        for (int i = 0; i < n; i++) {
            arr1[i] = arr1[i] / 10;
        }
        max = max / 10;
    }
    for (int i = 0; i < n; i++)
        cout << arr[i] << endl;
}
