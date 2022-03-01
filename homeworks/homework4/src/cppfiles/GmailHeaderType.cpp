#include "../headers/GmailHeaderType.h"
#include <string>
#include <iostream>
#include <fstream>

GmailHeaderType::GmailHeaderType()
{
}
void GmailHeaderType::getInfo()
{
    ifstream in_stream;
    string out_file = "C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\homeworks\\homework4\\data\\output.txt";
    ofstream out_stream(out_file);
    string line;
    in_stream.open("C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\homeworks\\homework4\\data\\input.txt");
    if (in_stream.is_open())
    {
        if (out_stream.is_open())
        {
            while (getline(in_stream, line, '\n'))
            {
                // int pos = line.find(":");
                // string text = line.substr(pos + 1);
                // out_stream << text << "\n";

                int pos = line.find(":");
                if (line.substr(0, pos).compare("X-Google-Smtp-Source") == 0 || line.substr(0, pos).compare("MIME-Version") == 0)
                {
                    string text = line.substr(pos + 1);
                    out_stream << "Specific Gmail Information: " << text << "\n";
                    // out_stream << "Specific Gmail Information: \n";
                    // out_stream << line << "\n";
                }
                if (line.substr(0, pos).compare("X-Google-Smtp-Source") != 0 && line.substr(0, pos).compare("MIME-Version") != 0)
                {
                    // out_stream << "General Information: \n";
                    // out_stream << line << "\n";
                    string text = line.substr(pos + 1);
                    out_stream << "General Information: " << text << "\n";
                }
            }
        }
    }
}
GmailHeaderType::~GmailHeaderType()
{
}
