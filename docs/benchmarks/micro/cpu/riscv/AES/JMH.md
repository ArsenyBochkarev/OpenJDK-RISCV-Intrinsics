Output for [AES microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/AES) on RISC-V cpu:

| Benchmark            |          (algorithm)  |  (dataSize) | (keyLength) | (provider) | Mode  | Cnt |    Score |  Error | Units |
| -------------------- | --------------------- | ----------- | ----------- | ---------- | ----- | --- | -------- | ------ | ----- |
| AES.AESBench.decrypt |     AES/ECB/NoPadding |      16384  |        128  |            | thrpt |  40 | 1121.960 |  2.104 | ops/s |
| AES.AESBench.decrypt |     AES/ECB/NoPadding |      16384  |        192  |            | thrpt |  40 |  960.205 |  1.630 | ops/s |
| AES.AESBench.decrypt |     AES/ECB/NoPadding |      16384  |        256  |            | thrpt |  40 |  800.197 |  2.048 | ops/s |
| AES.AESBench.decrypt |  AES/ECB/PKCS5Padding |      16384  |        128  |            | thrpt |  40 | 1111.984 |  6.288 | ops/s |
| AES.AESBench.decrypt |  AES/ECB/PKCS5Padding |      16384  |        192  |            | thrpt |  40 |  917.539 | 15.172 | ops/s |
| AES.AESBench.decrypt |  AES/ECB/PKCS5Padding |      16384  |        256  |            | thrpt |  40 |  784.091 |  1.346 | ops/s |
| AES.AESBench.decrypt |     AES/CBC/NoPadding |      16384  |        128  |            | thrpt |  40 |  999.080 |  2.162 | ops/s |
| AES.AESBench.decrypt |     AES/CBC/NoPadding |      16384  |        192  |            | thrpt |  40 |  864.191 |  1.344 | ops/s |
| AES.AESBench.decrypt |     AES/CBC/NoPadding |      16384  |        256  |            | thrpt |  40 |  704.500 | 30.160 | ops/s |
| AES.AESBench.decrypt |  AES/CBC/PKCS5Padding |      16384  |        128  |            | thrpt |  40 |  988.080 |  4.690 | ops/s |
| AES.AESBench.decrypt |  AES/CBC/PKCS5Padding |      16384  |        192  |            | thrpt |  40 |  851.250 |  3.523 | ops/s |
| AES.AESBench.decrypt |  AES/CBC/PKCS5Padding |      16384  |        256  |            | thrpt |  40 |  720.222 | 13.399 | ops/s |
| AES.AESBench.encrypt |     AES/ECB/NoPadding |      16384  |        128  |            | thrpt |  40 |  937.420 |  1.363 | ops/s |
| AES.AESBench.encrypt |     AES/ECB/NoPadding |      16384  |        192  |            | thrpt |  40 |  795.749 |  1.231 | ops/s |
| AES.AESBench.encrypt |     AES/ECB/NoPadding |      16384  |        256  |            | thrpt |  40 |  698.942 |  0.810 | ops/s |
| AES.AESBench.encrypt |  AES/ECB/PKCS5Padding |      16384  |        128  |            | thrpt |  40 |  926.348 |  2.088 | ops/s |
| AES.AESBench.encrypt |  AES/ECB/PKCS5Padding |      16384  |        192  |            | thrpt |  40 |  788.583 |  1.852 | ops/s |
| AES.AESBench.encrypt |  AES/ECB/PKCS5Padding |      16384  |        256  |            | thrpt |  40 |  676.972 |  1.209 | ops/s |
| AES.AESBench.encrypt |     AES/CBC/NoPadding |      16384  |        128  |            | thrpt |  40 |  869.604 |  1.292 | ops/s |
| AES.AESBench.encrypt |     AES/CBC/NoPadding |      16384  |        192  |            | thrpt |  40 |  745.123 |  0.966 | ops/s |
| AES.AESBench.encrypt |     AES/CBC/NoPadding |      16384  |        256  |            | thrpt |  40 |  650.811 |  1.218 | ops/s |
| AES.AESBench.encrypt |  AES/CBC/PKCS5Padding |      16384  |        128  |            | thrpt |  40 |  855.893 |  1.497 | ops/s |
| AES.AESBench.encrypt |  AES/CBC/PKCS5Padding |      16384  |        192  |            | thrpt |  40 |  734.357 |  1.277 | ops/s |
| AES.AESBench.encrypt |  AES/CBC/PKCS5Padding |      16384  |        256  |            | thrpt |  40 |  641.340 |  1.124 | ops/s |


Benchmark was run for

```
openjdk version "22" 2024-03-19
OpenJDK Runtime Environment SyntaJ-22+9-b060923-release (build 22+9-EA)
OpenJDK 64-Bit Server VM SyntaJ-22+9-b060923-release (build 22+9-EA, mixed mode)
```

without additional flags.

Full test stand overview:

```
$ uname -a
Linux thead1 5.10.4+ #1 SMP Thu Aug 18 12:19:49 MSK 2022 riscv64 GNU/Linux
```

```
$ lscpu
Architecture:          riscv64
  Byte Order:          Little Endian
CPU(s):                2
  On-line CPU(s) list: 0,1
```

```
$ cat /proc/cpuinfo
processor	: 0
hart		: 0
isa		: rv64imafdcsu
mmu		: sv39
cpu-freq	: 1.2Ghz
cpu-icache	: 64KB
cpu-dcache	: 64KB
cpu-l2cache	: 2MB
cpu-tlb		: 1024 4-ways
cpu-cacheline	: 64Bytes
cpu-vector	: 0.7.1

processor	: 1
hart		: 1
isa		: rv64imafdcsu
mmu		: sv39
cpu-freq	: 1.2Ghz
cpu-icache	: 64KB
cpu-dcache	: 64KB
cpu-l2cache	: 2MB
cpu-tlb		: 1024 4-ways
cpu-cacheline	: 64Bytes
cpu-vector	: 0.7.1
```
