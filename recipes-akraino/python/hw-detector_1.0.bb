DESCRIPTION = "Hardware detector for different hardware types"
HOMEPAGE = "https://gerrit.akraino.org/r/ta/hw-detector"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

STABLE = "master"
PROTOCOL = "https"
BRANCH = "master"
SRCREV = "a181302dc30122e649ccb19cb735239ee96f632b"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git/src"

SRC_URI = "git://gerrit.akraino.org/r/ta/hw-detector.git;protocol=${PROTOCOL};rev=${SRCREV};branch=${BRANCH}"

inherit setuptools

RDEPENDS_${PN} += " \
        python-lang \
        "
