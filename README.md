# Yocto Layer meta-amazon
Yocto repository for AWS 

# Add recipe for one or more services
```
require aws-sdk-cpp.inc

EXTRA_OECMAKE += "-DBUILD_ONLY=s3,lex"
```
