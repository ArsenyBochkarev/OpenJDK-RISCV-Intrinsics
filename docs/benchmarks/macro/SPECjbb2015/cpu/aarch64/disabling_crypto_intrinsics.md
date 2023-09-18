Overview of running SPECjbb2015 benchmark on board with aarch64 architecture.

TODO: max-jOPS and critical-jOPS - ?

##### Absolute numbers

| Configuration                                                           | max-jOPS | critical-jOPS |
| ----------------------------------------------------------------------- | -------- | ------------- |
| Default intrinsics set                                                  | 742      | 196           |
| Without `_updateBytesAdler32` intrinsic                                 | 710      | 185           |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsic | 717      | 198           |
| Without `_updateCRC32` and `_updateBytesCRC32` intrinsic                | 708      | 207           |
| Without all[^all-meaning] intrinsics together                           | 717      | 193           |

[^all-meaning]: by the word 'all' I mean *all unsupported in RISC-V platform crypto intrinsics which were used in this benchmark*. See [here]() for more details on which intrinsics were disabled on SPECjvm2015 benchmark : `_updateBytesAdler32`, `_aescrypt_encryptBlock`, `_aescrypt_decryptBlock`, `_updateCRC32`, `_updateBytesCRC32`.

##### % of performance

| Configuration                                                           | max-jOPS    | critical-jOPS     |
| ----------------------------------------------------------------------- | ----------- | ----------------- |
| Default intrinsics set                                                  | 100%        | 100%              |
| Without `_updateBytesAdler32` intrinsic                                 | 95,6873315% | 94,3877551%       |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsic | 96,6307278% | 101,0204082% (?!) |
| Without `_updateCRC32` and `_updateBytesCRC32` intrinsic                | 95,4177898% | 105,6122449% (?!) |
| Without all[^all-meaning] intrinsics together                           | 96,6307278% | 98,4693878%       |

all benchmarks were run on

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (fastdebug build 22-testing-builds.shipilev.net-openjdk-jdk-b552-20230909)
OpenJDK 64-Bit Server VM (fastdebug build 22-testing-builds.shipilev.net-openjdk-jdk-b552-20230909, mixed mode)
```

with additional flags (where needed): `-XX:+UnlockDiagnosticVMOptions -XX:DisableIntrinsic=<intrinsic name>`.

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