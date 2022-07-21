cmake_minimum_required(VERSION 3.21.1)
project(smart-charging)

set(CMAKE_CXX_STANDARD 14)

include(FetchContent)
FetchContent_Declare(
        curl
        GIT_REPOSITORY https://github.com/curl/curl.git
        GIT_TAG        master
)
FetchContent_Declare(
        jsoncpp
        GIT_REPOSITORY https://github.com/open-source-parsers/jsoncpp.git
        GIT_TAG        master
)

FetchContent_GetProperties(jsoncpp)
if(NOT jsoncpp_POPULATED)
    FetchContent_Populate(jsoncpp)
    add_subdirectory(${jsoncpp_SOURCE_DIR} ${jsoncpp_BINARY_DIR})
endif()

FetchContent_MakeAvailable(curl)

add_executable(
        smart-charging_BMW
        BMW-API/api.cpp
)
add_executable(
        smart-charging_loxone
        communicationWithServer/httpsRequest.cpp
)