cmake_minimum_required(VERSION 3.15)
project(smart-charging)

set(CMAKE_CXX_STANDARD 14)

find_package(CURL REQUIRED)
include_directories(${CURL})
add_library()

add_executable(smart-charging_curl
        BMW-API/api.cpp)

target_link_libraries(smart-charging_curl PRIVATE CURL::libcurl)