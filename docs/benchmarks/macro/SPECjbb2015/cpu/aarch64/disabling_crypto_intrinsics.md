Overview of crypto intrinsics performance for SPECjbb2015 benchmark on two boards with aarch64 architecture.

Max-jOPS represents the maximum transaction throughput of a system until further requests fail, and critical-jOPS is an aggregate geomean transaction throughput within several levels of guaranteed response times.

[Link for good explanation on it](https://www.anandtech.com/show/16315/the-ampere-altra-review/7#:~:text=That's%20a%20lot%20of%20technicalities,levels%20of%20guaranteed%20response%20times%2C).

##### Absolute numbers

| Configuration                                                                             | max-jOPS | critical-jOPS |
| ----------------------------------------------------------------------------------------- | -------- | ------------- |
| Default intrinsics set                                                                    | 4665     | 1602          |
| Without `_updateBytesAdler32` intrinsic                                                   | 4732     | 1682          |
| Without `_updateBytesCRC32` intrinsic                                                     | 4946     | 1663          |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsics                  | 4665     | 1638          |
| Without `_cipherBlockChaining_encryptAESCrypt` and `_cipherBlockChaining_decryptAESCrypt` | 4834     | 1591          |

##### % of performance

| Configuration                                                                             | max-jOPS     | critical-jOPS     |
| ----------------------------------------------------------------------------------------- | ------------ | ----------------- |
| Default intrinsics set                                                                    | 100%         | 100%              |
| Without `_updateBytesAdler32` intrinsic                                                   | 101.4362272% | 104.9937578%      |
| Without `_updateBytesCRC32` intrinsic                                                     | 106.0235798% | 103.8077403%      |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsics                  | 100%         | 102.247191%       |
| Without `_cipherBlockChaining_encryptAESCrypt` and `_cipherBlockChaining_decryptAESCrypt` | 103.6227224% | 99.3133583%       |


##### Test stand overview

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

#### Runs evaluation

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
