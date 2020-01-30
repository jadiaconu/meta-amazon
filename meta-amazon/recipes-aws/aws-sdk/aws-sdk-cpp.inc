# =============================================================================
#
#   AWS SDK for CPP
#
#   @copyright  Copyright (c) 2020 HED Technologies Sarl
#
# =============================================================================

DESCRIPTION = "AWS SDK for C++"
AUTHOR = "AWS"
HOMEPAGE = "https://aws.amazon.com/fr/sdk-for-cpp/"
LICENSE="Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

SRC_URI[md5sum] = "9abc5c37411f06cd3b1432788a2268de"
SRC_URI[sha256sum] = "406c9b3eae8f0a4a0e1866328cbe3be8315532d3350edbb30adab4eddf7649d1"

SRCREV = "ad600ae26aa9a9b3b9f66a6fbc8d55a11fa98864"
SRC_URI = "git://github.com/aws/aws-sdk-cpp.git;protocol=https"

EXTRA_OECMAKE += "-DCMAKE_PREFIX_PATH=${WORKDIR}/recipe-sysroot/usr -DBUILD_SHARED_LIBS=ON -DENABLE_TESTING=OFF -DBUILD_DEPS=OFF -DCURL_HAS_H2=OFF -DCURL_HAS_TLS_PROXY=OFF -DMINIMIZE_SIZE=ON"

do_configure[depends] += " \
    aws-c-event-stream:do_populate_sysroot \
    curl:do_populate_sysroot \
    "
DEPENDS_${PN} += "curl aws-c-event-stream"
RDEPENDS_${PN} += "aws-c-event-stream"

S = "${WORKDIR}/git"

inherit cmake

do_install_append() {
    cp ${D}${libdir}/libaws-cpp-sdk-lex.so ${D}${libdir}/libaws-cpp-sdk-lex.so.${PV}
    rm ${D}${libdir}/libaws-cpp-sdk-lex.so
    cd ${D}${libdir} && ln -s libaws-cpp-sdk-lex.so.${PV} libaws-cpp-sdk-lex.so
    
    cp ${D}${libdir}/libaws-cpp-sdk-core.so ${D}${libdir}/libaws-cpp-sdk-core.so.${PV}
    rm ${D}${libdir}/libaws-cpp-sdk-core.so
    cd ${D}${libdir} && ln -s libaws-cpp-sdk-core.so.${PV} libaws-cpp-sdk-core.so
}
