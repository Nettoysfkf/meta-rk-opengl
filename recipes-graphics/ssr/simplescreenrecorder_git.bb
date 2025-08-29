# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

inherit cmake_qt5
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/MaartenBaert/ssr.git;protocol=https;branch=master"

PV = "1.0+git"
SRCREV = "232eac75c56821b4baf025b7dfd7ce737e73f420"

S = "${WORKDIR}/git"

DEPENDS = "libx11 virtual/libgl alsa-lib pkgconfig-native ffmpeg v4l-utils pipewire qtbase qtx11extras qttools qttools-native libxinerama"

inherit cmake

EXTRA_OECMAKE = "-DWITH_QT5=TRUE"

FILES:${PN}:append = " \
    /usr/share/icons/* \
    /usr/share/metainfo/* \
"
ERROR_QA:remove = "file-rdeps dev-elf"
