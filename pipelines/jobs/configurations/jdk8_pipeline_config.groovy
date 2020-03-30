class Config8 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac        : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: [
                        hotspot : 'build-macstadium-macos1010-1',
                        corretto: 'build-macstadium-macos1010-1',
                        openj9  : 'build-macstadium-macos1010-2'
                ],
                test                : ['sanity.openjdk', 'sanity.system', 'extended.system', 'special.openjdk']
        ],

        x64MacXL      : [
                os                   : 'mac',
                arch                 : 'x64',
                additionalNodeLabels : 'build-macstadium-macos1010-2',
                test                 : ['sanity.openjdk', 'sanity.system', 'extended.system', 'sanity.perf', 'special.openjdk'],
                additionalFileNameTag: "macosXL",
                configureArgs        : '--with-noncompressedrefs'
        ],

        x64Linux      : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels: 'centos6',
                test                : ['sanity.openjdk', 'sanity.system', 'extended.system', 'sanity.perf', 'sanity.external', 'special.functional', 'special.openjdk'],
                configureArgs       : [
                        "hotspot-jfr" : '--enable-jfr',
                        "openj9"      : '--enable-jitserver'
                ]
        ],

        // Currently we have to be quite specific about which windows to use as not all of them have freetype installed
        x64Windows    : [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        hotspot : 'win2008',
                        corretto: 'win2008',
                        openj9  : 'win2012&&mingw-cygwin'
                ],
                test                : ['sanity.openjdk', 'sanity.system', 'extended.system', 'special.openjdk']
        ],

        x64WindowsXL    : [
                os                   : 'windows',
                arch                 : 'x64',
                additionalNodeLabels : 'win2012&&mingw-cygwin',
                test                 : ['sanity.openjdk', 'sanity.system', 'extended.system', 'special.openjdk'],
                additionalFileNameTag: "windowsXL",
                configureArgs        : '--with-noncompressedrefs'
        ],

        x32Windows    : [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: [
                        hotspot : 'win2008',
                        corretto: 'win2008',
                        openj9  : 'win2012&&mingw-cygwin'
                ],
                buildArgs : [
                        hotspot : '--jvm-variant client,server'
                ],
                test                : ['sanity.openjdk', 'special.openjdk']
        ],

        ppc64Aix      : [
                os  : 'aix',
                arch: 'ppc64',
                additionalNodeLabels: 'xlc13',
                test: [
                        nightly: ['sanity.openjdk'],
                        release: ['sanity.openjdk', 'sanity.system', 'extended.system', 'special.openjdk']
                ]
        ],

        s390xLinux    : [
                os  : 'linux',
                arch: 's390x',
                test: ['sanity.openjdk', 'sanity.system', 'extended.system', 'special.openjdk']
        ],

        sparcv9Solaris: [
                os  : 'solaris',
                arch: 'sparcv9',
                test: false
        ],

        x64Solaris    : [
                os                  : 'solaris',
                arch                : 'x64',
                test                : false
        ],

        ppc64leLinux  : [
                os  : 'linux',
                arch: 'ppc64le',
                test: ['sanity.openjdk', 'sanity.system', 'extended.system', 'special.openjdk'],
                configureArgs       : [
                        "openj9"      : '--enable-jitserver'
                ]
        ],

        arm32Linux    : [
                os  : 'linux',
                arch: 'arm',
                // TODO Temporarily remove the ARM tests because we don't have fast enough hardware
                //test                : ['sanity.openjdk']
                test: false
        ],

        aarch64Linux  : [
                os                  : 'linux',
                arch                : 'aarch64',
                additionalNodeLabels: 'centos7',
                test                : ['sanity.openjdk', 'sanity.system', 'extended.system', 'special.openjdk']
        ],

        x64LinuxXL       : [
                os                   : 'linux',
                additionalNodeLabels : 'centos6',
                arch                 : 'x64',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-jitserver',
                test                 : ['sanity.openjdk', 'sanity.system', 'extended.system', 'special.openjdk'],
        ],
        s390xLinuxXL       : [
                os                   : 'linux',
                arch                 : 's390x',
                additionalFileNameTag: "linuxXL",
                test                 : ['sanity.openjdk', 'sanity.system', 'extended.system', 'special.openjdk'],
                configureArgs        : '--with-noncompressedrefs'
        ],
        ppc64leLinuxXL       : [
                os                   : 'linux',
                arch                 : 'ppc64le',
                additionalFileNameTag: "linuxXL",
                test                 : ['sanity.openjdk', 'sanity.system', 'extended.system', 'special.openjdk'],
                configureArgs        : '--with-noncompressedrefs --enable-jitserver'
        ],
  ]

}

Config8 config = new Config8()
return config.buildConfigurations