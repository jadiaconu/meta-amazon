LICENSE="Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

SRCREV = "519d6d9093819b6cf89ffff589a27ef8f83d0f65"
SRC_URI = "git://github.com/awslabs/aws-checksums.git;protocol=https"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"

inherit cmake

do_install_append() {
    cp ${D}${libdir}/libaws-checksums.so ${D}${libdir}/libaws-checksums.so.${PV}
    rm ${D}${libdir}/libaws-checksums.so
    cd ${D}${libdir} && ln -s libaws-checksums.so.${PV} libaws-checksums.so
}
