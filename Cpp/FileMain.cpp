#include "FileHeader.h"

using namespace std;

class Test
{
public:
    int a = 10;

    int get_a()
    {
        return a;
    }
};

int FileHeader::get_a()
{
    cout << FileHeader::b << " here no " << endl;
    return FileHeader::a;
}

int FileHeader::get_b()
{
    return FileHeader::b;
}

int main()
{
    FileHeader::get_a;
    cout << FileHeader::get_a << " hello this " << endl;

    Test test;

    cout << test.Test::a << endl;
    cout << test.Test::get_a() << endl;
}