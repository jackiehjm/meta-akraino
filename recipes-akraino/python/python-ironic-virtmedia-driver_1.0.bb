DESCRIPTION = "Ironic drivers for baremetal provisioning using Virtual media for Quanta Hardware and Virtual environment"
HOMEPAGE = "https://docs.openstack.org/ironic/latest/install/enabling-drivers.html"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "file://python-ironic-virtmedia-driver-1.0.tar.gz"

inherit setuptools

#DEPENDS += " \
#        python-pip \
#        "
RDEPENDS_${PN} += " \
        python-ironic \
        "
