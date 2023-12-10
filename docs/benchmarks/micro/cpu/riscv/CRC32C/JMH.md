Output for [CRC32C microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/CRC32C) on RISC-V cpu:

| Benchmark                          | (count) |  Mode | Cnt |    Score |  Error   | Units  |
| ---------------------------------- | ------- | ----- | --- | -------- | -------- | ------ |
| CRC32C.TestCRC32C.testCRC32CUpdate |      64 | thrpt |  12 | 3371.959 | � 13.079 | ops/ms |
| CRC32C.TestCRC32C.testCRC32CUpdate |     128 | thrpt |  12 | 2071.704 | � 31.708 | ops/ms |
| CRC32C.TestCRC32C.testCRC32CUpdate |     256 | thrpt |  12 | 1165.970 | � 10.569 | ops/ms |
| CRC32C.TestCRC32C.testCRC32CUpdate |     512 | thrpt |  12 |  628.368 | �  4.444 | ops/ms |
| CRC32C.TestCRC32C.testCRC32CUpdate |    2048 | thrpt |  12 |  167.586 | �  0.123 | ops/ms |
| CRC32C.TestCRC32C.testCRC32CUpdate |   16384 | thrpt |  12 |   21.055 | �  0.025 | ops/ms |
| CRC32C.TestCRC32C.testCRC32CUpdate |   65536 | thrpt |  12 |    5.077 | �  0.021 | ops/ms |

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
