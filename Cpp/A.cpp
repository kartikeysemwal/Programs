#include <iostream>
#include <array>
#include <vector>
#include <deque>
#include <queue>
#include <map>

using namespace std;

int main()
{
    array<int, 4> arr = {1, 2, 3, 4};

    int size = arr.size();

    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;

    cout << size << endl;
    cout << arr.front() << endl;
    cout << arr.back() << endl;
    cout << arr.empty() << endl;
    cout << arr.at(2) << endl;

    vector<int> vec;

    vec.push_back(1);
    cout << "Capacity is " << vec.capacity() << " size is " << vec.size() << endl;

    vec.push_back(2);
    cout << "Capacity is " << vec.capacity() << " size is " << vec.size() << endl;

    vec.push_back(3);
    cout << "Capacity is " << vec.capacity() << " size is " << vec.size() << endl;

    vec.push_back(4);
    cout << "Capacity is " << vec.capacity() << " size is " << vec.size() << endl;

    vec.push_back(4);
    cout << "Capacity is " << vec.capacity() << " size is " << vec.size() << endl;

    deque<int> deque;

    deque.push_back(3);
    deque.push_front(2);
    deque.push_front(1);

    for (int a : deque)
    {
        cout << a << " ";
    }

    cout << endl;

    deque.erase(deque.begin(), deque.begin() + 1);

    for (int a : deque)
    {
        cout << a << " ";
    }

    cout << endl;

    priority_queue<int> max_heap;
    priority_queue<int, vector<int>, greater<int>> min_heap;

    map<int, string> map;

    map.insert({1, "first"});
    map.insert({2, "second"});

    for (auto i : map)
    {
        cout << i.first << " " << i.second << " "
             << endl;
    }

    auto it = map.find(2);

    cout << (*it).first << endl;
}