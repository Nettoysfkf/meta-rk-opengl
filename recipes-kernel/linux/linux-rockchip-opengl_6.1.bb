# Copyright (C) 2024, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-yocto.inc
require recipes-kernel/linux/linux-rockchip.inc

inherit local-git

SRCREV = "a10570bf276c8cb6a6a9c5a11d964d2843376ddd"
SRC_URI = " \
	git://git@gitlab.ucas.com.cn:22222/wanghuo-scarthgap/linux-rockchip-6.1-panthor.git;protocol=ssh;nobranch=1;branch=master; \
	file://${THISDIR}/files/cgroups.cfg \
"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KERNEL_VERSION_SANITY_SKIP = "1"
LINUX_VERSION ?= "6.1"

SRC_URI:append = " ${@bb.utils.contains('IMAGE_FSTYPES', 'ext4', \
		   'file://${THISDIR}/files/ext4.cfg', \
		   '', \
		   d)}"
