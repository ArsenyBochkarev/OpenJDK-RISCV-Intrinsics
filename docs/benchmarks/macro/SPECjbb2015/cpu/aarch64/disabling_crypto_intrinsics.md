Overview of running SPECjbb2015 benchmark on board with aarch64 architecture.

Max-jOPS represents the maximum transaction throughput of a system until further requests fail, and critical-jOPS is an aggregate geomean transaction throughput within several levels of guaranteed response times.

[Link for good explanation on it](https://www.anandtech.com/show/16315/the-ampere-altra-review/7#:~:text=That's%20a%20lot%20of%20technicalities,levels%20of%20guaranteed%20response%20times%2C).

##### Absolute numbers

| Configuration                                                            | max-jOPS | critical-jOPS |
| ------------------------------------------------------------------------ | -------- | ------------- |
| Default intrinsics set                                                   | 1111     | 268           |
| Without `_updateBytesAdler32` intrinsic                                  | 1088     | 270           |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsics | 1071     | 269           |
| Without `_updateCRC32` and `_updateBytesCRC32` intrinsic                 | 1062     | 271           |
| Without all[^all-meaning] intrinsics together                            | 1052     | 265           |

[^all-meaning]: by the word 'all' I mean *all unsupported in RISC-V platform crypto intrinsics which were used in this benchmark*. See [here](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/blob/main/docs/riscv_intrinsics_overview.md) for more details on which intrinsics were disabled on SPECjbb2015 benchmark : `_updateBytesAdler32`, `_aescrypt_encryptBlock`, `_aescrypt_decryptBlock`, `_updateCRC32`, `_updateBytesCRC32`.

##### % of performance

| Configuration                                                            | max-jOPS    | critical-jOPS     |
| ------------------------------------------------------------------------ | ----------- | ----------------- |
| Default intrinsics set                                                   | 100%        | 100%              |
| Without `_updateBytesAdler32` intrinsic                                  | 97.929793%  | 100.7462687%      |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsics | 96.39964%   | 100.3731343%      |
| Without `_updateCRC32` and `_updateBytesCRC32` intrinsic                 | 95.58956%   | 101.119403%       |
| Without all[^all-meaning] intrinsics together                            | 94.6894689% | 98.880597%        |

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