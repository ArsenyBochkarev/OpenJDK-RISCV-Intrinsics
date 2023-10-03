Overview of crypto intrinsics performance on selected microbenchmarks on board with AArch64 architecture.

On four microbenches, the most difference in performance (ops/ms) comes from `_updateBytesCRC32` on [`CRC32` microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/CRC32), with the average percentage of score of 95.5684467. The second most influential is `_updateBytesAdler32` intrinsic on [Adler32 microbench](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/Adler32), which showed performance difference of 72.6210836%. Then there goes the `_poly1305_processBlocks` on [Poly1305 microbench](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/Poly1305), with mean % of score of 39.0863161%. And the last one is `_chacha20Block`, measured in [ChaCha20 microbench](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/ChaCha20), which showed mean performance difference of 6.0459278%.

Due to the fact that microbenchmarks were taken from OpenJDK, the most needed to be implemented on RISC-V platform intrinsic is `_updateBytesCRC32`.


All tests were run on:

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915)
OpenJDK 64-Bit Server VM (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915, mixed mode)
```

with additional flags: `-XX:+UnlockDiagnosticVMOptions -XX:DisableIntrinsic=<intrinsic name>` (where needed).

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

Due to Raspberry Pi 4 overheating issues, the CPU frequency was set to minimum (600 Mhz):

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
