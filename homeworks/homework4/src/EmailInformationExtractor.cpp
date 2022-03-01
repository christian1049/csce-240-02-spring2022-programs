#include <iostream>
#include <fstream>
#include <string>

#include "cppfiles/OutlookHeaderType.cpp"
#include "cppfiles/GmailHeaderType.cpp"
#include "cppfiles/BaseEmailHeaderType.cpp"

using namespace std;

int main()
{
    BaseEmailHeaderType B;
    GmailHeaderType G;
    OutlookHeaderType O;

    string out_file = "C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\homeworks\\homework4\\data\\GeneralOutput.txt";
    string type;
    string line;
    ifstream in_stream;
    ofstream out_stream(out_file);
    in_stream.open("C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\homeworks\\homework4\\data\\input.txt");

    if (in_stream.is_open())
    {
        if (out_stream.is_open())
        {
            try
            {
                while (getline(in_stream, line, '\n'))
                {
                    out_stream << line << "\n";
                    int pos = line.find(":");
                    if (line.substr(0, pos).compare("X-Google-Smtp-Source") == 0 || line.substr(0, pos).compare("MIME-Version") == 0)
                    {
                        G.getInfo();
                    }
                    else if (line.substr(0, pos).compare("Authentication-Results") == 0 || line.substr(0, pos).compare("Thread-Topic") == 0 || line.substr(0, pos).compare("Thread-Index") == 0 || line.substr(0, pos).compare("Message-ID") == 0 || line.substr(0, pos).compare("References") == 0 || line.substr(0, pos).compare("In-Reply-To") == 0 || line.substr(0, pos).compare("Accept-Language") == 0 || line.substr(0, pos).compare("Content-Language") == 0 || line.substr(0, pos).compare("X-MS-Has-Attach") == 0 || line.substr(0, pos).compare("X-MS-Exchange-Organization") == 0)
                    {
                        O.getInfo();
                    }
                }
            }
            catch (exception &err)
            {
                cout << "Error";
                exit(0);
            }
        }
    }
}