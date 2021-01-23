DESCRIPTION = "Linux kernel for handheld devices"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

COMPATIBLE_MACHINE = "akita|c7x0|spitz|tosa"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
           ${KERNELORG_MIRROR}/linux/kernel/v4.x/patch-${PV}.169.xz;apply=yes;name=stablepatch \
           "
SRC_URI[kernel.md5sum] = "740a90cf810c2105df8ee12e5d0bb900"
SRC_URI[kernel.sha256sum] = "0c68f5655528aed4f99dae71a5b259edc93239fa899e2df79c055275c21749a1"
SRC_URI[stablepatch.md5sum] = "4eba5ecd23c9dd04d4f442f4b091ea90"
SRC_URI[stablepatch.sha256sum] = "eb8472d8bfb30474f0977038ab93cad8eaf20b4c94bd7b51e3776a27a286ec43"

SRC_URI += "\
           "

DEPENDS += "lz4-native"

SRC_URI_append_akita = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           "
SRC_URI_append_c7x0 = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           "
SRC_URI_append_spitz = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           "
SRC_URI_append_tosa = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           file://0001-HACK-video-move-backlight-to-the-end-of-Makefile.patch \
           file://0002-tosa-bl-correct-backlight-calculations.patch \
           file://0003-tmio-call-tmiofb_set_par-in-tmiofb_probe.patch \
           "

inherit kernel

S = "${WORKDIR}/linux-${PV}"
