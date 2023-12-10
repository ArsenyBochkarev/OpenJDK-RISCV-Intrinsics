Output for [CRC32 microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/CRC32) on RISC-V cpu:

| Benchmark                       | (count) |  Mode | Cnt |   Score | Error  | Units  |
| ------------------------------- | ------- | ----- | --- | ------- | ------ | ------ |
| CRC32.TestCRC32.testCRC32Update |      64 | thrpt |  12 | 510.563 | 13.453 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     128 | thrpt |  12 | 451.312 | 25.248 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     256 | thrpt |  12 | 361.418 |  6.908 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     512 | thrpt |  12 | 281.294 | 10.744 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |    2048 | thrpt |  12 | 110.825 |  3.068 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |   16384 | thrpt |  12 |  16.312 |  0.792 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |   65536 | thrpt |  12 |   4.070 |  0.209 | ops/ms |

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
