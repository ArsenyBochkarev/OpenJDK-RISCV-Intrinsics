Results on enabling/disabling intrinsics for AArch64 platform:

### [ChaCha20 microbench](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/ChaCha20)

Intrinsic name: `_chacha20Block`.

- disabled:

| Benchmark                                  | (dataSize) |  (keyLength) | (mode) | (padding)  | (permutation) | (provider) | Mode  | Cnt |  Score     | Error     | Units |
| ------------------------------------------ | ---------- | ------------ | ------ | ---------- | ------------- | ---------- | ----- | --- | ---------- | --------- | ----- |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |        256 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 | 207844.048 | ± 400.550 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       1024 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  58724.011 | ±  63.746 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       4096 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  15210.577 | ±  15.263 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |      16384 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |   3766.839 | ±   8.088 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |        256 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 | 196321.074 | ± 846.428 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       1024 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  57332.821 | ± 147.301 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       4096 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  14866.561 | ± 108.740 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |      16384 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |   3766.459 | ±  14.210 | ops/s |

- enabled:

| Benchmark                                  | (dataSize) |  (keyLength) | (mode) | (padding)  | (permutation) | (provider) | Mode  | Cnt |  Score     | Error     | Units |
| ------------------------------------------ | ---------- | ------------ | ------ | ---------- | ------------- | ---------- | ----- | --- | ---------- | --------- | ----- |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |        256 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 | 216811.202 | ± 337.503 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       1024 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  62062.530 | ±  93.727 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       4096 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  16076.071 | ±  11.911 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |      16384 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |   4053.652 | ±   4.951 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |        256 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 | 207112.833 | ± 632.957 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       1024 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  61341.314 | ± 117.296 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       4096 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  16108.575 | ±  40.331 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |      16384 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |   4047.235 | ±   6.854 | ops/s |

- final results:

| Benchmark                                  | (dataSize) | Score difference (enabled - disabled)    | Error (enabled + disabled) | % of score (100% * difference / enabled) | Units |
| ------------------------------------------ | ---------- |  --------------------------------------- | -------------------------- | ---------------------------------------- | ----- |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |        256 |                                 8967,154 |                  ± 738,053 |                               4.1359274% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       1024 |                                 3338,519 |                  ± 157,473 |                               5.3792828% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       4096 |                                  865,494 |                   ± 27,174 |                               5.3837408% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |      16384 |                                  286,813 |                   ± 13,039 |                               7.0754224% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |        256 |                                10791,759 |                 ± 1479,385 |                               5.2105699% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       1024 |                                 4008,493 |                  ± 254,597 |                               6.5347361% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       4096 |                                 1242,014 |                  ± 149,071 |                               7.7102661% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |      16384 |                                  280,776 |                   ± 21,064 |                               6.9374771% | ops/s |

Average % of score: 6.0459278%.


### [Poly1305 microbench](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/Poly1305)

Intrinsic name: `_poly1305_processBlocks`.

- disabled:

| Benchmark                        | (dataSize) | (provider) |  Mode | Cnt |     Score  |    Error   | Units |
| -------------------------------- | ---------- | ---------- | ----- | --- | ---------- | ---------- | ----- |
| Poly1305DigestBench.digestBuffer |         64 |            | thrpt |   3 | 281064.215 | ± 1318.459 | ops/s |
| Poly1305DigestBench.digestBuffer |        256 |            | thrpt |   3 | 154231.261 | ± 2217.037 | ops/s |
| Poly1305DigestBench.digestBuffer |       1024 |            | thrpt |   3 |  55310.686 | ±  516.674 | ops/s |
| Poly1305DigestBench.digestBuffer |      16384 |            | thrpt |   3 |   4080.668 | ±  621.513 | ops/s |
| Poly1305DigestBench.digestBuffer |    1048576 |            | thrpt |   3 |     63.693 | ±    9.474 | ops/s |
| Poly1305DigestBench.digestBytes  |         64 |            | thrpt |   3 | 290928.953 | ± 3683.603 | ops/s |
| Poly1305DigestBench.digestBytes  |        256 |            | thrpt |   3 | 153211.589 | ± 2081.486 | ops/s |
| Poly1305DigestBench.digestBytes  |       1024 |            | thrpt |   3 |  53064.797 | ±  662.738 | ops/s |
| Poly1305DigestBench.digestBytes  |      16384 |            | thrpt |   3 |   3941.354 | ±  688.379 | ops/s |
| Poly1305DigestBench.digestBytes  |    1048576 |            | thrpt |   3 |     63.029 | ±    0.333 | ops/s |
| Poly1305DigestBench.updateBytes  |         64 |            | thrpt |   3 | 856629.062 | ± 1904.423 | ops/s |
| Poly1305DigestBench.updateBytes  |        256 |            | thrpt |   3 | 239486.480 | ± 3314.851 | ops/s |
| Poly1305DigestBench.updateBytes  |       1024 |            | thrpt |   3 |  61899.262 | ±  335.888 | ops/s |
| Poly1305DigestBench.updateBytes  |      16384 |            | thrpt |   3 |   3998.056 | ±   20.554 | ops/s |
| Poly1305DigestBench.updateBytes  |    1048576 |            | thrpt |   3 |     64.996 | ±    0.320 | ops/s |

- enabled:

| Benchmark                        | (dataSize) | (provider) |  Mode | Cnt |     Score  |    Error     | Units |
| -------------------------------- | ---------- | ---------- | ----- | --- | ---------- | ------------ | ----- |
| Poly1305DigestBench.digestBuffer |        64  |            | thrpt |   3 |  340785.132 | ±  5508.393 | ops/s |
| Poly1305DigestBench.digestBuffer |       256  |            | thrpt |   3 |  246629.143 | ±  3376.868 | ops/s |
| Poly1305DigestBench.digestBuffer |      1024  |            | thrpt |   3 |  116994.983 | ±  1824.698 | ops/s |
| Poly1305DigestBench.digestBuffer |     16384  |            | thrpt |   3 |   10297.458 | ±   146.412 | ops/s |
| Poly1305DigestBench.digestBuffer |   1048576  |            | thrpt |   3 |      63.115 | ±     9.404 | ops/s |
| Poly1305DigestBench.digestBytes  |        64  |            | thrpt |   3 |  350730.719 | ±  3805.447 | ops/s |
| Poly1305DigestBench.digestBytes  |       256  |            | thrpt |   3 |  257465.040 | ±  2351.775 | ops/s |
| Poly1305DigestBench.digestBytes  |      1024  |            | thrpt |   3 |  119890.053 | ±  1058.474 | ops/s |
| Poly1305DigestBench.digestBytes  |     16384  |            | thrpt |   3 |   10299.219 | ±   127.025 | ops/s |
| Poly1305DigestBench.digestBytes  |   1048576  |            | thrpt |   3 |      62.935 | ±     0.586 | ops/s |
| Poly1305DigestBench.updateBytes  |        64  |            | thrpt |   3 | 1885416.619 | ±   659.328 | ops/s |
| Poly1305DigestBench.updateBytes  |       256  |            | thrpt |   3 |  617181.610 | ± 54328.199 | ops/s |
| Poly1305DigestBench.updateBytes  |      1024  |            | thrpt |   3 |  167064.978 | ±  1115.382 | ops/s |
| Poly1305DigestBench.updateBytes  |     16384  |            | thrpt |   3 |   10720.591 | ±   154.944 | ops/s |
| Poly1305DigestBench.updateBytes  |   1048576  |            | thrpt |   3 |      64.533 | ±     0.324 | ops/s |

- final results:

| Benchmark                        | (dataSize) |      Score difference (enabled - disabled)    | Error (enabled + disabled) | % of score (100% * difference / enabled) | Units |
| -------------------------------- | ---------- |  -------------------------------------------- | -------------------------- | ---------------------------------------- | ----- |
| Poly1305DigestBench.digestBuffer |         64 |                                     59720,917 |                 ± 6826,852 |                              17.5245078% | ops/s |
| Poly1305DigestBench.digestBuffer |        256 |                                     92397,882 |                 ± 5593,905 |                                 37.4643% | ops/s |
| Poly1305DigestBench.digestBuffer |       1024 |                                     61684,297 |                 ± 2341,372 |                                   52.72% | ops/s |
| Poly1305DigestBench.digestBuffer |      16384 |                                       6216,79 |                  ± 767,925 |                              60.3720841% | ops/s |
| Poly1305DigestBench.digestBuffer |    1048576 |                                        -0,578 |                   ± 18,878 |                               0.9157886% | ops/s |
| Poly1305DigestBench.digestBytes  |         64 |                                     59801,766 |                  ± 7489,05 |                              17.0506211% | ops/s |
| Poly1305DigestBench.digestBytes  |        256 |                                    104253,451 |                 ± 4433,261 |                              40.4922746% | ops/s |
| Poly1305DigestBench.digestBytes  |       1024 |                                     66825,256 |                 ± 1721,212 |                              55.7387826% | ops/s |
| Poly1305DigestBench.digestBytes  |      16384 |                                      6357,865 |                  ± 815,404 |                              61.7315255% | ops/s |
| Poly1305DigestBench.digestBytes  |    1048576 |                                        -0,094 |                    ± 0,919 |                               0.1493605% | ops/s |
| Poly1305DigestBench.updateBytes  |         64 |                                   1028787,557 |                 ± 2563,751 |                              54.5655293% | ops/s |
| Poly1305DigestBench.updateBytes  |        256 |                                     377695,13 |                 ± 57643,05 |                               61.196757% | ops/s |
| Poly1305DigestBench.updateBytes  |       1024 |                                    105165,716 |                  ± 1451,27 |                              62.9489898% | ops/s |
| Poly1305DigestBench.updateBytes  |      16384 |                                      6722,535 |                  ± 175,498 |                              62.7067575% | ops/s |
| Poly1305DigestBench.updateBytes  |    1048576 |                                        -0,463 |                    ± 0.644 |                               0.7174624% | ops/s |

Average % of score: 39.0863161%.


### [Adler32 microbench](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/Adler32)

Intrinsic name: `_updateBytesAdler32`.

- disabled:

| Benchmark                             | (count) |  Mode | Cnt |  Score   |   Error  |  Units |
| ------------------------------------- | ------- | ----- | --- | -------- | -------- | ------ |
| Adler32.TestAdler32.testAdler32Update |      64 | thrpt |  25 | 1163.050 | ± 11.864 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     128 | thrpt |  25 |  984.862 | ±  3.504 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     256 | thrpt |  25 |  756.202 | ±  2.216 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     512 | thrpt |  25 |  499.796 | ±  4.852 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    1024 | thrpt |  25 |  308.620 | ±  0.784 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    2048 | thrpt |  25 |  174.030 | ±  0.621 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    5012 | thrpt |  25 |   76.251 | ±  0.624 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    8192 | thrpt |  25 |   47.451 | ±  0.147 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   16384 | thrpt |  25 |   24.003 | ±  0.261 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   32768 | thrpt |  25 |   11.931 | ±  0.023 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   65536 | thrpt |  25 |    5.993 | ±  0.003 | ops/ms |

- enabled:

| Benchmark                             | (count) |  Mode | Cnt |  Score   |   Error  |  Units |
| ------------------------------------- | ------- | ----- | --- | -------- | -------- | ------ |
| Adler32.TestAdler32.testAdler32Update |      64 | thrpt |  25 | 9337.691 | ± 17.912 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     128 | thrpt |  25 | 6291.627 | ±  3.518 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     256 | thrpt |  25 | 3730.021 | ±  1.099 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     512 | thrpt |  25 | 1988.418 | ±  0.736 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    1024 | thrpt |  25 | 1071.351 | ±  0.441 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    2048 | thrpt |  25 |  557.045 | ±  0.174 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    5012 | thrpt |  25 |  231.960 | ±  1.015 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    8192 | thrpt |  25 |  143.712 | ±  0.054 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   16384 | thrpt |  25 |   71.134 | ±  1.273 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   32768 | thrpt |  25 |   35.153 | ±  0.173 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   65536 | thrpt |  25 |   17.612 | ±  0.045 | ops/ms |

- final results:

| Benchmark                             | (dataSize) |      Score difference (enabled - disabled)    | Error (enabled + disabled) | % of score (100% * difference / enabled) | Units  |
| ------------------------------------- | ---------- |  -------------------------------------------- | -------------------------- | ---------------------------------------- | ------ |
| Adler32.TestAdler32.testAdler32Update |         64 |                                      8174,641 |                   ± 29,776 |                              87.5445654% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |        128 |                                      5306,765 |                    ± 7,022 |                              84.3464655% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |        256 |                                      2973,819 |                    ± 3,315 |                              79.7266021% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |        512 |                                      1488,622 |                    ± 5,588 |                              74.8646411% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |       1024 |                                       762,731 |                    ± 1,225 |                              71.1933811% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |       2048 |                                       383,015 |                    ± 0,795 |                              68.7583588% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |       5012 |                                       155,709 |                    ± 1,639 |                               67.127522% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |       8192 |                                        96,261 |                    ± 0,201 |                              66.9818804% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |      16384 |                                        47,131 |                    ± 1,534 |                              66.2566424% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |      32768 |                                        23,222 |                    ± 0,196 |                              66.0597958% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |      65536 |                                        11,619 |                    ± 0,048 |                              65.9720645% | ops/ms |

Average % of score: 72.6210836%.


### [CRC32 microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/CRC32)

Intrinsic name: `_updateBytesCRC32`.

- disabled:

| Benchmark                       | (count) |  Mode | Cnt |  Score  |   Error  |  Units |
| ------------------------------- | ------- | ----- | --- | ------- | -------- | ------ |
| CRC32.TestCRC32.testCRC32Update |      64 | thrpt |  12 | 949.473 | ±  5.545 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     128 | thrpt |  12 | 697.527 | ± 45.435 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     256 | thrpt |  12 | 497.446 | ± 11.271 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     512 | thrpt |  12 | 301.212 | ±  7.627 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |    2048 | thrpt |  12 |  91.046 | ±  0.352 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |   16384 | thrpt |  12 |  12.053 | ±  0.021 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |   65536 | thrpt |  12 |   3.031 | ±  0.004 | ops/ms |

- enabled:

| Benchmark                       | (count) |  Mode | Cnt |  Score    |   Error  |  Units |
| ------------------------------- | ------- | ----- | --- | --------- | -------- | ------ |
| CRC32.TestCRC32.testCRC32Update |      64 | thrpt |  12 | 21993.774 | ± 48.986 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     128 | thrpt |  12 | 16522.129 | ± 24.198 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     256 | thrpt |  12 | 11431.032 | ± 13.857 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     512 | thrpt |  12 |  7080.695 | ± 10.079 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |    2048 | thrpt |  12 |  2154.875 | ±  3.130 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |   16384 | thrpt |  12 |   274.886 | ±  7.459 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |   65536 | thrpt |  12 |    57.552 | ±  0.594 | ops/ms |

- final results:

| Benchmark                       | (dataSize) |      Score difference (enabled - disabled)    | Error (enabled + disabled) | % of score (100% * difference / enabled) | Units  |
| ------------------------------- | ---------- |  -------------------------------------------- | -------------------------- | ---------------------------------------- | ------ |
| CRC32.TestCRC32.testCRC32Update |         64 |                                     21044.301 |                   ± 54.531 |                              95.6829919% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |        128 |                                     15824.602 |                   ± 69.633 |                              95.7782257% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |        256 |                                     10933.586 |                   ± 25.128 |                              95.6482844% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |        512 |                                      6779.483 |                   ± 17.706 |                              95.7460108% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |       2048 |                                      2063.829 |                    ± 3.482 |                              95.7748825% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |      16384 |                                       262.833 |                     ± 7.48 |                              95.6152732% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |      65536 |                                        54.521 |                    ± 0.598 |                              94.7334584% | ops/ms |

Average % of score: 95.5684467%.


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
