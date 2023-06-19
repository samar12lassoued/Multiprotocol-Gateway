
SUMMARY = "A fully featured modbus protocol stack in python"
HOMEPAGE = "https://github.com/riptideio/pymodbus/"

LICENSE = "GPLv2 & BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c2223d66c7e674b40527b5a4c35bd76 \
                    file://examples/tools/nullmodem/linux/COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://examples/tools/reference/LICENSE_FREE;md5=05018d6237f3f611b1b4be0f65fb2a59"

SRC_URI = "git://github.com/riptideio/pymodbus;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "de3955e46087f5cdcd77184da9a681d7ad20c032"

S = "${WORKDIR}/git"

inherit setuptools3

PACKAGECONFIG[quality] = ",,,python3-coverage python3-mock python3-nose python3-pep8"
PACKAGECONFIG[twisted] = ",,,python3-pyasn1 python3-twisted"
PACKAGECONFIG[repl] = ",,,python3-click python3-prompt-toolkit python3-pygments"
PACKAGECONFIG[documents] = ",,,python3-humanfriendly python3-sphinx python3-sphinx_rtd_theme"
PACKAGECONFIG[tornado] = ",,,python3-tornado"


DEPENDS = "python3-six-native"

RDEPENDS_${PN} += "python3-pyserial"
RDEPENDS_${PN} += "python3-six"
RDEPENDS_${PN} += "python3-2to3"
RDEPENDS_${PN} += "python3-asyncio"
RDEPENDS_${PN} += "python3-core"
RDEPENDS_${PN} += "python3-crypt"
RDEPENDS_${PN} += "python3-distutils"
RDEPENDS_${PN} += "python3-io"
RDEPENDS_${PN} += "python3-json"
RDEPENDS_${PN} += "python3-logging"
RDEPENDS_${PN} += "python3-math"
RDEPENDS_${PN} += "python3-netclient"
RDEPENDS_${PN} += "python3-netserver"
RDEPENDS_${PN} += "python3-pkg-resources"
RDEPENDS_${PN} += "python3-setuptools"
RDEPENDS_${PN} += "python3-shell"
RDEPENDS_${PN} += "python3-unittest"
