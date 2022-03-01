#include "../headers/OutlookHeaderType.h"
#include <string>
#include <iostream>
#include <fstream>

OutlookHeaderType::OutlookHeaderType()
{
}
void OutlookHeaderType::getInfo()
{
    ifstream in_stream;
    string out_file = "C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\homeworks\\homework4\\data\\output.txt";
    ofstream out_stream(out_file);
    string line;
    in_stream.open("C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\homeworks\\homework4\\data\\input.txt");
    while (getline(in_stream, line, '\n'))
    {
        // int pos = line.find(":");
        // string text = line.substr(pos + 1);
        // out_stream << text << "\n";
        int pos = line.find(":");
        if (line.substr(0, pos).compare("Authentication-Results") == 0 || line.substr(0, pos).compare("Thread-Topic") == 0 || line.substr(0, pos).compare("Thread-Index") == 0 || line.substr(0, pos).compare("Message-ID") == 0 || line.substr(0, pos).compare("References") == 0 || line.substr(0, pos).compare("In-Reply-To") == 0 || line.substr(0, pos).compare("Accept-Language") == 0 || line.substr(0, pos).compare("Content-Language") == 0 || line.substr(0, pos).compare("X-MS-Has-Attach") == 0 || line.substr(0, pos).compare("X-MS-Exchange-Organization") == 0)
        {
            string text = line.substr(pos + 1);
            out_stream << "Specific Outlook Information: " << text << "\n";
            // out_stream << "Specific Gmail Information: \n";
            // out_stream << line << "\n";
        }
        if (line.substr(0, pos).compare("Authentication-Results") != 0 && line.substr(0, pos).compare("Thread-Topic") != 0 && line.substr(0, pos).compare("Thread-Index") != 0 && line.substr(0, pos).compare("Message-ID") != 0 && line.substr(0, pos).compare("References") != 0 && line.substr(0, pos).compare("In-Reply-To") != 0 && line.substr(0, pos).compare("Accept-Language") != 0 && line.substr(0, pos).compare("Content-Language") != 0 && line.substr(0, pos).compare("X-MS-Has-Attach") != 0 && line.substr(0, pos).compare("X-MS-Exchange-Organization") != 0)
        {
            // out_stream << "General Information: \n";
            // out_stream << line << "\n";
            string text = line.substr(pos + 1);
            out_stream << "General Information: " << text << "\n";
        }
    }
}
OutlookHeaderType::~OutlookHeaderType()
{
}
