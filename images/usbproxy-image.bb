SUMMARY = "A console development image with some C/C++ dev tools"
HOMEPAGE = "http://www.jumpnowtek.com"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit image

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    packagegroup-core-boot \
    psplash \
    term-prompt \
    tzdata \
 "

KERNEL_EXTRA_INSTALL = " \
    kernel-modules \
    load-modules \
 "

WIFI_SUPPORT = " \
    bbgw-wireless \
    crda \
    iw \
    linux-firmware-ath9k \
    linux-firmware-ralink \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    linux-firmware-wl18xx \
    wireless-tools \
    wpa-supplicant \
 "

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    cmake \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    g++ \
    g++-symlinks \
    gcc \
    gcc-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    pkgconfig \
    python3-modules \
 "

DEV_EXTRAS = " \
    ntp \
    ntp-tickadj \
    serialecho \
    spiloop \
 "

EXTRA_TOOLS_INSTALL = " \
    bzip2 \
    cursor-blink \
    devmem2 \
    dosfstools \
    ethtool \
    findutils \
    i2c-tools \
    iperf3 \
    iptables \
    less \
    nano \
    netcat \
    procps \
    rsync \
    sysfsutils \
    tcpdump \
    tree \
    unzip \
    usbutils usbutils-dev usbutils-python \
    util-linux \
    util-linux-blkid \
    wget \
    xz \
    zip \
 "

USB_TOOLS = " \
    libpcap libpcap-dev \
    libusb1 \
    python3-pyusb \
    usbutils usbutils-dev usbutils-python \
    usbproxy \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${DEV_SDK_INSTALL} \
    ${DEV_EXTRAS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${KERNEL_EXTRA_INSTALL} \
    ${USB_TOOLS} \
    ${WIFI_SUPPORT} \
 "

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "console-image"
