DESCRIPTION = "Legacy GNU-tar to unpack hd images on install for Zaurus spitz"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "file://gnu-tar.gz;subdir=${BPN}-${PV}"

do_compile() {
        :
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = ""

# package_stagefile_shell needs to run before populate_staging for packaged-staging
addtask deploy before do_populate_sysroot after do_compile

COMPATIBLE_MACHINE = "spitz"

inherit deploy

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0755 ${WORKDIR}/gnu-tar ${DEPLOY_DIR_IMAGE}/gnu-tar
}
