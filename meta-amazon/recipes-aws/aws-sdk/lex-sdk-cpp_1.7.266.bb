require aws-sdk-cpp.inc

DESCRIPTION = "LEX SDK for C++"
AUTHOR = "AWS"
HOMEPAGE = "https://aws.amazon.com/fr/sdk-for-cpp/"

EXTRA_OECMAKE += "-DBUILD_ONLY=lex"
