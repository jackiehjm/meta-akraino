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

LIC_FILES_CHKSUM = "file://COPYING;md5=b1becf0cfa3366e0f4d854d1d264f311"

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
    file://0015-fix-arm-atomic.patch \
"

SRC_URI[md5sum] = "11220d0b94c5c24caa2e1e9eaba38e31"
SRC_URI[sha256sum] = "39e9723eaf620afd99b0925b2c2a5a50a89110ba50040adf14cce7cf89e5e21b"

EXTRA_OECMAKE += "-DSTACK_DIRECTION=-1"

DEPENDS += "mariadb-native bison-native openssl ncurses zlib readline libaio libevent libxml2"

PROVIDES += "mysql5 libmysqlclient"

RPROVIDES_${PN} += "mysql5"
RREPLACES_${PN} += "mysql5"
RCONFLICTS_${PN} += "mysql5"

RPROVIDES_${PN}-dbg += "mysql5-dbg"
RREPLACES_${PN}-dbg += "mysql5-dbg"
RCONFLICTS_${PN}-dbg += "mysql5-dbg"

RPROVIDES_${PN}-leftovers += "mysql5-leftovers"
RREPLACES_${PN}-leftovers += "mysql5-leftovers"
RCONFLICTS_${PN}-leftovers += "mysql5-leftovers"

RPROVIDES_${PN}-client += "mysql5-client"
RREPLACES_${PN}-client += "mysql5-client"
RCONFLICTS_${PN}-client += "mysql5-client"

RPROVIDES_${PN}-server += "mysql5-server"
RREPLACES_${PN}-server += "mysql5-server"
RCONFLICTS_${PN}-server += "mysql5-server"
