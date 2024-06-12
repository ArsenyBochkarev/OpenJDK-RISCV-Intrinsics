Overview of performance running SPECjvm2008 `crypto.aes` benchmark on board with aarch64 architecture.

*Note on benchmarks selection*: The main purpose of such runs is to see what may be implemented on RISC-V. All crypto intrinsics used in SPECjvm2008 except for AES-related ones are implemented now. So the only thing that remains to run is `crypto.aes` benchmark.

#### Absolute numbers

| Configuration                                                                                        | Score  | Units |
| ---------------------------------------------------------------------------------------------------- | ------ | ----- |
| Default intrinsics set                                                                               | 65.02  | ops/m |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsics                             | 64.76  | ops/m |
| Without `_cipherBlockChaining_decryptAESCrypt` and `_cipherBlockChaining_encryptAESCrypt` intrinsics | 57.62  | ops/m |

#### % of performance

| Configuration                                                                                        | Score        |
| ---------------------------------------------------------------------------------------------------- | ------------ |
| Default intrinsics set                                                                               | 100%         |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsics                             | 99.600123%   |
| Without `_cipherBlockChaining_decryptAESCrypt` and `_cipherBlockChaining_encryptAESCrypt` intrinsics | 88.6188865%  |

#### Runs evaluation

All benchmarks were run on

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915)
OpenJDK 64-Bit Server VM (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915, mixed mode)
```

with additional flags `--warmuptime 180s --iterationtime 300s --iterations 10`.

#### Test stand overview:

```
$ uname -a
Linux rock-5b 5.10.110-34-rockchip-gca15bbe36e6c #rockchip SMP Wed Dec 7 06:54:05 UTC 2022 aarch64 aarch64 aarch64 GNU/Linux
```

```
$ lscpu
Architecture:                    aarch64
CPU op-mode(s):                  32-bit, 64-bit
Byte Order:                      Little Endian
CPU(s):                          8
On-line CPU(s) list:             0-7
Thread(s) per core:              1
Core(s) per socket:              2
Socket(s):                       3
Vendor ID:                       ARM
Model:                           0
Model name:                      Cortex-A55
Stepping:                        r2p0
CPU max MHz:                     2400.0000
CPU min MHz:                     408.0000
BogoMIPS:                        48.00
L1d cache:                       256 KiB
L1i cache:                       256 KiB
L2 cache:                        1 MiB
L3 cache:                        3 MiB
Vulnerability Itlb multihit:     Not affected
Vulnerability L1tf:              Not affected
Vulnerability Mds:               Not affected
Vulnerability Meltdown:          Not affected
Vulnerability Spec store bypass: Mitigation; Speculative Store Bypass disabled v
                                 ia prctl
Vulnerability Spectre v1:        Mitigation; __user pointer sanitization
Vulnerability Spectre v2:        Vulnerable: Unprivileged eBPF enabled
Vulnerability Srbds:             Not affected
Vulnerability Tsx async abort:   Not affected
Flags:                           fp asimd evtstrm aes pmull sha1 sha2 crc32 atom
                                 ics fphp asimdhp cpuid asimdrdm lrcpc dcpop asi
                                 mddp
```

```
$ cat /proc/cpuinfo
processor	: 0
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x2
CPU part	: 0xd05
CPU revision	: 0

processor	: 1
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x2
CPU part	: 0xd05
CPU revision	: 0

processor	: 2
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x2
CPU part	: 0xd05
CPU revision	: 0

processor	: 3
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x2
CPU part	: 0xd05
CPU revision	: 0

processor	: 4
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x4
CPU part	: 0xd0b
CPU revision	: 0

processor	: 5
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x4
CPU part	: 0xd0b
CPU revision	: 0

processor	: 6
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x4
CPU part	: 0xd0b
CPU revision	: 0

processor	: 7
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x4
CPU part	: 0xd0b
CPU revision	: 0

Serial		: 1fa0bc2c51185a02
```

Due to possible trottling issues, the CPU frequency was lowered to minimum (408 Mhz) using `cpufreq` utility. 
Before disabling:

```
~$ cpufreq-info
cpufrequtils 008: cpufreq-info (C) Dominik Brodowski 2004-2009
Report errors and bugs to cpufreq@vger.kernel.org, please.
analyzing CPU 0:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 1.42 GHz and 1.61 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 1.42 GHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879807)
analyzing CPU 1:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 1.42 GHz and 1.61 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 1.42 GHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879807)
analyzing CPU 2:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 1.42 GHz and 1.61 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 1.42 GHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879807)
analyzing CPU 3:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 1.42 GHz and 1.61 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 1.42 GHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879807)
analyzing CPU 4:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 4 5
  CPUs which need to have their frequency coordinated by software: 4 5
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.48%, 600 MHz:0.20%, 816 MHz:0.12%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.07%, 2.21 GHz:0.26%, 2.40 GHz:2.45%  (2067300)
analyzing CPU 5:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 4 5
  CPUs which need to have their frequency coordinated by software: 4 5
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.48%, 600 MHz:0.20%, 816 MHz:0.12%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.07%, 2.21 GHz:0.26%, 2.40 GHz:2.45%  (2067300)
analyzing CPU 6:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 6 7
  CPUs which need to have their frequency coordinated by software: 6 7
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.65%, 600 MHz:0.23%, 816 MHz:0.13%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.06%, 2.21 GHz:0.22%, 2.40 GHz:2.28%  (2109260)
analyzing CPU 7:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 6 7
  CPUs which need to have their frequency coordinated by software: 6 7
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.65%, 600 MHz:0.23%, 816 MHz:0.13%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.06%, 2.21 GHz:0.22%, 2.40 GHz:2.28%  (2109260)
```

and after disabling:

```
$ cpufreq-info
cpufrequtils 008: cpufreq-info (C) Dominik Brodowski 2004-2009
Report errors and bugs to cpufreq@vger.kernel.org, please.
analyzing CPU 0:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 408 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879818)
analyzing CPU 1:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 408 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879818)
analyzing CPU 2:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 408 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879818)
analyzing CPU 3:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 408 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879818)
analyzing CPU 4:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 4 5
  CPUs which need to have their frequency coordinated by software: 4 5
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.48%, 600 MHz:0.20%, 816 MHz:0.12%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.07%, 2.21 GHz:0.26%, 2.40 GHz:2.45%  (2067300)
analyzing CPU 5:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 4 5
  CPUs which need to have their frequency coordinated by software: 4 5
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.48%, 600 MHz:0.20%, 816 MHz:0.12%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.07%, 2.21 GHz:0.26%, 2.40 GHz:2.45%  (2067300)
analyzing CPU 6:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 6 7
  CPUs which need to have their frequency coordinated by software: 6 7
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.65%, 600 MHz:0.23%, 816 MHz:0.13%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.06%, 2.21 GHz:0.22%, 2.40 GHz:2.28%  (2109260)
analyzing CPU 7:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 6 7
  CPUs which need to have their frequency coordinated by software: 6 7
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.65%, 600 MHz:0.23%, 816 MHz:0.13%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.06%, 2.21 GHz:0.22%, 2.40 GHz:2.28%  (2109260)
```
