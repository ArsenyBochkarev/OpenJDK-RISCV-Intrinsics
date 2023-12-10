Output for [Adler32 microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/Adler32) on RISC-V cpu:

| Benchmark                             | (count) | Mode  | Cnt |  Score  |  Error | Units  |
| ------------------------------------- | ------- | ----- | --- | ------- | ------ | ------ | 
| Adler32.TestAdler32.testAdler32Update |      64 | thrpt |  25 | 655.633 |  5.845 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     128 | thrpt |  25 | 587.418 | 10.062 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     256 | thrpt |  25 | 546.675 | 11.598 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     512 | thrpt |  25 | 432.328 | 11.517 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    1024 | thrpt |  25 | 311.771 |  4.238 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    2048 | thrpt |  25 | 202.648 |  2.486 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    5012 | thrpt |  25 | 100.246 |  1.119 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    8192 | thrpt |  25 |  65.931 |  0.546 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   16384 | thrpt |  25 |  34.570 |  0.353 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   32768 | thrpt |  25 |  17.622 |  0.190 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   65536 | thrpt |  25 |   8.895 |  0.087 | ops/ms |

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
