LICENSE="Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCREV = "32713d30b479690d199b3f02163a832b09b309a5"
SRC_URI = "git://github.com/awslabs/aws-c-event-stream;protocol=https"

do_configure[depends] += " \
    aws-c-common:do_populate_sysroot \
    aws-checksums:do_populate_sysroot \
    "
S = "${WORKDIR}/git"

DEPENDS_${PN} += "aws-checksums aws-c-common"
RDEPENDS_${PN} += "aws-checksums aws-c-common"

EXTRA_OECMAKE += "-DCMAKE_PREFIX_PATH=${WORKDIR}/recipe-sysroot/usr -DBUILD_SHARED_LIBS=ON"

inherit cmake
