# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.2)

# Declares and names the project.

project("tree_sitter")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.


#Use Python
add_definitions(-DTS_LANGUAGE_PYTHON=1)

include_directories(include)
include_directories(tree_sitter)
include_directories(language/python/tree_sitter)


add_library( # Sets the name of the library.
        tree_sitter

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        # Tree_sitter lib
        tree_sitter/lib.c

        # JNI connect

        ai_serenade_treesitter_Languages.cc
        ai_serenade_treesitter_Languages.h
        ai_serenade_treesitter_TreeSitter.h
        ai_serenade_treesitter_TreeSitter.cc

        #Python language
        language/python/parser.c
        language/python/scanner.cc
        )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        tree_sitter

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})