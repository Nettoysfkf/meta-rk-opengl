# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   debian/copyright
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b7b867e0242b12e3ca931020e1a08345 \
                    file://debian/copyright;md5=5024e60a7ad4c14478c04aed0a01d702"

SRC_URI = "git://github.com/ptitSeb/gl4es.git;protocol=https;branch=master"

# Modify these as desired
PV = "1.0+git"
SRCREV = "a744af14d4afbda77bf472bc53f43b9ceba39cc0"

S = "${WORKDIR}/git"
PROVIDES = "virtual/libgl virtual/mesa"

# NOTE: the following library dependencies are unknown, ignoring: log
#       (this is based on recipes that have previously been built and packaged)
inherit cmake pkgconfig

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
DEPENDS = " libx11"
EXTRA_OECMAKE = ""

