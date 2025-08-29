FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
DESCRIPTION = "A XFCE desktop image with opengl, glx, ros and panthor support on rk3588."

IMAGE_INSTALL = "packagegroup-core-boot \
    packagegroup-core-x11 \
    packagegroup-xfce-base \
    kernel-modules \
"

inherit features_check
REQUIRED_DISTRO_FEATURES = "x11"

IMAGE_LINGUAS ?= " "

LICENSE = "MIT"

export IMAGE_BASENAME = "rk-opengl-xfce"

inherit core-image

SYSTEMD_DEFAULT_TARGET = "graphical.target"

inherit rockchip-image

IMAGE_INSTALL:append = " glmark2"
PACKAGECONFIG:pn-glmark2 = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'x11-gles2', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland opengl', 'wayland-gles2', '', d)} \
    drm-gles2 \
"

IMAGE_INSTALL:append = " \
    packagegroup-core-full-cmdline rockchip-librga  \
    packagegroup-core-buildessential xserver-xorg-extension-glx \
    packagegroup-core-ssh-openssh \
    ros-core packagegroup-ros-turtlebot3-core \
    ogre \
    moveit navigation2 nav2-bringup ros2cli packagegroup-ros2-demos urdf urdf-parser-plugin \
    packagegroup-fonts-truetype \
    fontconfig ttf-dejavu-common ttf-dejavu-mathtexgyre ttf-dejavu-sans \
    ttf-dejavu-sans-condensed ttf-dejavu-sans-mono ttf-dejavu-serif ttf-dejavu-serif-condensed \
    liberation-fonts cantarell-fonts font-util xorg-minimal-fonts \
    qtbase-doc qtbase qtbase-mkspecs qtbase-plugins qtbase-dev qtbase-qmlplugins qtbase-tools \
    qt5ledscreen qt5nmapper qt5-opengles2-test qtsmarthome \
    cmake meson ninja python3-colcon-ros \
    ament-cmake-python ament-cmake-ros ament-package ament-lint ament-lint-auto ament-cmake ament-cmake-auto \
    ament-cmake-core ament-cmake-export-definitions ament-cmake-export-dependencies ament-cmake-export-include-directories \
    ament-cmake-export-interfaces ament-cmake-export-libraries ament-cmake-export-link-flags ament-cmake-export-targets \
    ament-cmake-gen-version-h ament-cmake-gmock ament-cmake-gtest ament-cmake-include-directories ament-cmake-libraries \
    ament-cmake-pytest ament-cmake-python ament-cmake-target-dependencies ament-cmake-test ament-cmake-vendor-package \
    ament-cmake-version foonathan-memory-staticdev rclcpp rclcpp-lifecycle rclcpp-action rclcpp-components builtin-interfaces \
    common-interfaces fastrtps-cmake-module rosidl-default-generators rosidl-generator-c rosidl-generator-cpp rosidl-cmake \
    ros-environment ros-workspace pluginlib \
    linux-firmware \
    htop pciutils mesa-demos htop \
    gazebo11 \
    turtlesim \
    nav2-bringup \
    ceres-solver-dev ceres-solver-staticdev \
    xfce4-screenshooter \
    turtlebot3-description turtlebot3-node turtlebot3-bringup turtlebot3-navigation2 turtlebot3-cartographer turtlebot3-example turtlebot3-teleop \
    turtlebot3 turtlebot3-gazebo turtlebot3-simulations turtlebot3-manipulation-gazebo turtlebot3-fake-node turtlebot3-autorace-camera \
    turtlebot3-autorace turtlebot3-autorace-mission turtlebot3-autorace-detect turtlebot3-manipulation-moveit-config turtlebot3-manipulation-teleop \
    turtlebot3-manipulation turtlebot3-manipulation-navigation2 turtlebot3-manipulation-cartographer turtlebot3-manipulation-bringup turtlebot3-manipulation-hardware \
    turtlebot3-manipulation-description turtlebot3-applications-msgs turtlebot3-msgs \
    v4l-utils v4l-utils-dev libv4l libv4l-dev \
    simplescreenrecorder \
    x11vnc \
"
# chromium-x11
