# Copyright (C) 2024, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-yocto.inc
require recipes-kernel/linux/linux-rockchip.inc

inherit local-git

SRCREV = "7f2ef6573cc6c5479d20dbb33be394b78baa6432"
SRC_URI = " \
        git:///workdir/ddk/2025-project/yocto-5.0.7/kernel-common/linux;protocol=file;nobranch=1;branch=v6.16; \
	file://${THISDIR}/files/cgroups.cfg \
	file://${THISDIR}/files/panthor.cfg \
"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KERNEL_VERSION_SANITY_SKIP = "1"
LINUX_VERSION ?= "6.1"

SRC_URI:append = " ${@bb.utils.contains('IMAGE_FSTYPES', 'ext4', \
		   'file://${THISDIR}/files/ext4.cfg', \
		   '', \
		   d)}"
