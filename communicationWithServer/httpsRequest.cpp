//
// Created by Stefan on 18.07.2022.
//

// Edit : rewritten for cURLpp 0.7.3
// Note : namespace changed, was cURLpp in 0.7.2 ...

#include <curlpp/cURLpp.hpp>
#include <curlpp/Options.hpp>

// RAII cleanup

curlpp::Cleanup myCleanup;

// Send request and get a result.
// Here I use a shortcut to get it in a string stream ...

std::ostringstream os;
os << curlpp::options::Url(std::string("https://[serverhost]/jdev/sps/io/[nameDesEingangs]/[wert]"));

string asAskedInQuestion = os.str();

#include "httpsRequest.h"
