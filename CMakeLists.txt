cmake_minimum_required(VERSION 3.21.1)
project(smart-charging)

set(CMAKE_CXX_STANDARD 14)
set(CURL_INCLUDE_DIR ${CURL_SOURCE_DIR}/include)
set(CURL_LIBRARY ${CURL_SOURCE_DIR}/lib/libcurl_a_debug.lib)

find_package(CURL REQUIRED)
find_package(JSONCPP REQUIRED)
get_target_property(JSON_INC_PATH jsoncpp_lib INTERFACE_INCLUDE_DIRECTORIES)
include_directories(${JSON_INC_PATH})
include_directories(${CURL_INCLUDE_DIR})

add_executable(smart-charging_curl
        BMW-API/api.cpp)

target_link_libraries(smart-charging_curl PRIVATE ${CURL_LIBRARY})
target_link_libraries(smart-charging_curl PRIVATE jsoncpp_lib)