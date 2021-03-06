#
# Copyright (C) 2019 Wind River Systems, Inc.
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.

require mariadb.inc
inherit native

LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = " \
    http://archive.mariadb.org/${BP}/source/${BP}.tar.gz \
    file://my.cnf \
    file://mysqld.service \
    file://install_db.service \
    file://install_db \
    file://mysql-systemd-start \
    \
    file://0001-disable-ucontext-on-musl.patch \
    file://0002-fix-a-building-failure.patch \
    file://0003-support-files-CMakeLists.txt-fix-do_populate_sysroot.patch \
    \
    file://0011-configure.cmake-fix-valgrind.patch \
    file://0012-sql-CMakeLists.txt-fix-gen_lex_hash-not-found.patch \
    file://0013-c11_atomics.patch \
    file://0014-clang_version_header_conflict.patch \
"

SRC_URI[md5sum] = "623226918fd711e414ad240287284b5b"
SRC_URI[sha256sum] = "c24e83f24d674d9912319f9e9422f093c8ca6be1721a4380cbd74792b89ba0b9"

PROVIDES += "mysql5-native"
DEPENDS = "ncurses-native zlib-native bison-native"

RDEPENDS_${PN} = ""
PACKAGES = ""
EXTRA_OEMAKE = ""

do_install() {
    oe_runmake 'DESTDIR=${D}' install

    install -d ${D}${bindir}
    install -m 0755 sql/gen_lex_hash ${D}${bindir}/
    install -m 0755 sql/gen_lex_token ${D}${bindir}/
    install -m 0755 extra/comp_err ${D}${bindir}/
    install -m 0755 scripts/comp_sql ${D}${bindir}/
}

