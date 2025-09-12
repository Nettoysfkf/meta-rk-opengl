# Copyright (C) 2024, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-yocto.inc
require recipes-kernel/linux/linux-rockchip.inc

inherit local-git

SRCREV = "2c4864e0448acbf0cadaba476fcd41b13ce743f5"
SRC_URI = " \
        git://github.com/dudengke/radxa-kernel.git;protocol=https;nobranch=1;branch=linux-6.1-stan-rkr5.1 \
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
