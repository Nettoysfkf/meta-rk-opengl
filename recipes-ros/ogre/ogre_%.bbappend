FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = " file://v1.79.tar.gz"
SRC_URI:append = " file://0001-imgui-local-fix.patch"
do_configure:prepend () {
 	cp -r ${WORKDIR}/imgui-1.79 ${WORKDIR}/build/
}

# EXTRA_OECMAKE += " -Dhttp_proxy=http://192.168.77.161:7897 -Dhttps_proxy=http://192.168.77.161:7897 "
