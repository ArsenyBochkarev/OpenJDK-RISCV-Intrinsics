Overview of performance running SPECjvm2008 `crypto.aes` benchmark on board with aarch64 architecture.

*Note on benchmarks selection*: The main purpose of such runs is to see what may be implemented on RISC-V. All crypto intrinsics used in SPECjvm2008 except for AES-related ones are implemented now. So the only thing that remains to run is `crypto.aes` benchmark.

#### Absolute numbers

| Configuration                                                                                        | Score  | Units |
| ---------------------------------------------------------------------------------------------------- | ------ | ----- |
| Default intrinsics set                                                                               | 73.06  | ops/m |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsics                             | 69.34  | ops/m |
| Without `_cipherBlockChaining_decryptAESCrypt` and `_cipherBlockChaining_encryptAESCrypt` intrinsics | 78.47  | ops/m |
| Without all intrinsics together                                                                      | 71.17  | ops/m |

#### % of performance

| Configuration                                                                                        | Score        |
| ---------------------------------------------------------------------------------------------------- | ------------ |
| Default intrinsics set                                                                               | 100%         |
| Without `_aescrypt_encryptBlock` and `_aescrypt_decryptBlock` intrinsics                             | 94.9082946%  |
| Without `_cipherBlockChaining_decryptAESCrypt` and `_cipherBlockChaining_encryptAESCrypt` intrinsics | 107.4048727% |
| Without all intrinsics together                                                                      | 97.4130851%  |


All benchmarks were run on

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915)
OpenJDK 64-Bit Server VM (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915, mixed mode)
```

with additional flags `--iterations 10`.

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
