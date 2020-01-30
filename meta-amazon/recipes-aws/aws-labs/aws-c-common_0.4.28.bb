LICENSE="Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCREV = "b0ea9f35df8934f9e03fc3bab3919d55efd69b88"
SRC_URI = "git://github.com/awslabs/aws-c-common.git;protocol=https"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"

inherit cmake
