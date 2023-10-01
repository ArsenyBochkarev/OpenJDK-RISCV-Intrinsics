Overview of crypto intrinsics performance on SPECjbb2015 macrobenchmark.

It seems to me that crypto intrinsics have no somewhat significant importance on SPECjbb2015 macrobenchmark performance. Despite being used, their influence is very small: the max-jOPS metric showed the lowest score of 543 with **enabled** crypto intrinsics. 

All benchmarks were run on

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915)
OpenJDK 64-Bit Server VM (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915, mixed mode)
```

with additional flags (where needed): `-XX:+UseParallelGC -XX:-UseAdaptiveSizePolicy -XX:SurvivorRatio=28 -XX:TargetSurvivorRatio=95 -XX:MaxTenuringThreshold=15 -Xms6G -Xmx6G -Xmn5500M -XX:DisableIntrinsic=<intrinsic name>`.

Flags overview:
- `UseParallelGC`: Use ParallelGC as a garbage collector;
- `-UseAdaptiveSizePolicy`: When it is turned on, changes heap generation sizes dynamically to meet the following goals sequentially:
  - Latency Goal - Reduce application pauses below a desired level;
  - Throughput Goal - Increase the ratio of application execution time over pause time above a desired level;
  - Footprint Goal - Reduce the heap size as low as possible;
- `SurvivorRatio`: The SurvivorRatio parameter controls the size of the two survivor spaces. For example, -XX:SurvivorRatio=6 sets the ratio between each survivor space and eden to be 1:6, each survivor space will be one eighth of the young generation;
- `TargetSurvivorRatio`: Sets the maximum survivor space usage percentage;
- `MaxTenuringThreshold`: MaxTenuringThreshold ensures that objects are not prematurely moved to the OldGen space. It specifies the upper age limit (tenuring threshold) after which the object would be copied (promoted) to old space;
- `Xms`: The option to specify the minimum heap size;
- `Xmx`: The option to specify the maximum heap size;
- `Xmn`: the size of the heap for the young generation;

Full test stand overview:

```
$ uname -a
Linux raspbpi4 5.15.0-1012-raspi #14-Ubuntu SMP PREEMPT Fri Jun 24 13:10:28 UTC 2022 aarch64 aarch64 aarch64 GNU/Linux
```

```
$ lscpu
Architecture:            aarch64
  CPU op-mode(s):        32-bit, 64-bit
  Byte Order:            Little Endian
CPU(s):                  4
  On-line CPU(s) list:   0-3
Vendor ID:               ARM
  Model name:            Cortex-A72
    Model:               3
    Thread(s) per core:  1
    Core(s) per cluster: 4
    Socket(s):           -
    Cluster(s):          1
    Stepping:            r0p3
    CPU max MHz:         1500.0000
    CPU min MHz:         600.0000
    BogoMIPS:            108.00
    Flags:               fp asimd evtstrm crc32 cpuid
Caches (sum of all):     
  L1d:                   128 KiB (4 instances)
  L1i:                   192 KiB (4 instances)
  L2:                    1 MiB (1 instance)
Vulnerabilities:         
  Gather data sampling:  Not affected
  Itlb multihit:         Not affected
  L1tf:                  Not affected
  Mds:                   Not affected
  Meltdown:              Not affected
  Mmio stale data:       Not affected
  Retbleed:              Not affected
  Spec store bypass:     Vulnerable
  Spectre v1:            Mitigation; __user pointer sanitization
  Spectre v2:            Vulnerable
  Srbds:                 Not affected
  Tsx async abort:       Not affected
```

```
$ cat /proc/cpuinfo
processor       : 0
BogoMIPS        : 108.00
Features        : fp asimd evtstrm crc32 cpuid
CPU implementer : 0x41
CPU architecture: 8
CPU variant     : 0x0
CPU part        : 0xd08
CPU revision    : 3

processor       : 1
BogoMIPS        : 108.00
Features        : fp asimd evtstrm crc32 cpuid
CPU implementer : 0x41
CPU architecture: 8
CPU variant     : 0x0
CPU part        : 0xd08
CPU revision    : 3

processor       : 2
BogoMIPS        : 108.00
Features        : fp asimd evtstrm crc32 cpuid
CPU implementer : 0x41
CPU architecture: 8
CPU variant     : 0x0
CPU part        : 0xd08
CPU revision    : 3

processor       : 3
BogoMIPS        : 108.00
Features        : fp asimd evtstrm crc32 cpuid
CPU implementer : 0x41
CPU architecture: 8
CPU variant     : 0x0
CPU part        : 0xd08
CPU revision    : 3

Hardware        : BCM2835
Revision        : d03114
Serial          : 1000000089722afc
Model           : Raspberry Pi 4 Model B Rev 1.4
```

Due to Raspberry Pi 4 overheating issues, the CPU frequency was set to minimum:

```
$ cpufreq-info
cpufrequtils 008: cpufreq-info (C) Dominik Brodowski 2004-2009
Report errors and bugs to cpufreq@vger.kernel.org, please.
analyzing CPU 0:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 600 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 600 MHz.
  cpufreq stats: 600 MHz:71.29%, 700 MHz:3.89%, 800 MHz:1.34%, 900 MHz:0.85%, 1000 MHz:0.78%, 1.10 GHz:0.58%, 1.20 GHz:0.42%, 1.30 GHz:0.39%, 1.40 GHz:0.28%, 1.50 GHz:20.18%  (1976771)
analyzing CPU 1:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 600 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 600 MHz.
  cpufreq stats: 600 MHz:71.29%, 700 MHz:3.89%, 800 MHz:1.34%, 900 MHz:0.85%, 1000 MHz:0.78%, 1.10 GHz:0.58%, 1.20 GHz:0.42%, 1.30 GHz:0.39%, 1.40 GHz:0.28%, 1.50 GHz:20.18%  (1976771)
analyzing CPU 2:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 600 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 600 MHz.
  cpufreq stats: 600 MHz:71.29%, 700 MHz:3.89%, 800 MHz:1.34%, 900 MHz:0.85%, 1000 MHz:0.78%, 1.10 GHz:0.58%, 1.20 GHz:0.42%, 1.30 GHz:0.39%, 1.40 GHz:0.28%, 1.50 GHz:20.18%  (1976771)
analyzing CPU 3:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 600 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 600 MHz.
  cpufreq stats: 600 MHz:71.29%, 700 MHz:3.89%, 800 MHz:1.34%, 900 MHz:0.85%, 1000 MHz:0.78%, 1.10 GHz:0.58%, 1.20 GHz:0.42%, 1.30 GHz:0.39%, 1.40 GHz:0.28%, 1.50 GHz:20.18%  (1976771)
```