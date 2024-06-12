Overview of crypto intrinsics performance for SPECjbb2015 benchmark on two boards with aarch64 architecture.

Max-jOPS represents the maximum transaction throughput of a system until further requests fail, and critical-jOPS is an aggregate geomean transaction throughput within several levels of guaranteed response times.

[Link for good explanation on it](https://www.anandtech.com/show/16315/the-ampere-altra-review/7#:~:text=That's%20a%20lot%20of%20technicalities,levels%20of%20guaranteed%20response%20times%2C).

#### Absolute numbers

| Configuration                                                                             | max-jOPS | critical-jOPS |
| ----------------------------------------------------------------------------------------- | -------- | ------------- |
| Default intrinsics set                                                                    | 2702     | 0             |
| Without `_updateBytesAdler32` intrinsic                                                   | 3018     | 0             |
| Without `_updateBytesCRC32` intrinsic                                                     | 2911     | 0             |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsics                  | 2990     | 0             |
| Without `_cipherBlockChaining_encryptAESCrypt` and `_cipherBlockChaining_decryptAESCrypt` | 3108     | 0             |

#### % of performance

| Configuration                                                                             | max-jOPS     | critical-jOPS     |
| ----------------------------------------------------------------------------------------- | ------------ | ----------------- |
| Default intrinsics set                                                                    | 100%         | 100%              |
| Without `_updateBytesAdler32` intrinsic                                                   | 111.6950407% | 100%              |
| Without `_updateBytesCRC32` intrinsic                                                     | 107.7350111% | 100%              |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsics                  | 110.6587713% | 100%              |
| Without `_cipherBlockChaining_encryptAESCrypt` and `_cipherBlockChaining_decryptAESCrypt` | 115.0259067% | 100%              |


#### Runs evaluation

All benchmarks were run on

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915)
OpenJDK 64-Bit Server VM (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915, mixed mode)
```

with additional flags (where needed): `-XX:+UseParallelGC -XX:-UseAdaptiveSizePolicy -XX:SurvivorRatio=28 -XX:TargetSurvivorRatio=95 -XX:MaxTenuringThreshold=15 -Xms14G -Xmx14 -Xmn13500M -XX:DisableIntrinsic=<intrinsic name>`.

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


#### Test stand overview

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
