#ifndef GMAILHEADERTYPE_H_
#define GMAILHEADERTYPE_H_

#include "BaseEmailHeaderType.h"

class GmailHeaderType: public BaseEmailHeaderType 
{
    public:
        GmailHeaderType();
        void getInfo();     
        virtual ~GmailHeaderType();  
};
#endif