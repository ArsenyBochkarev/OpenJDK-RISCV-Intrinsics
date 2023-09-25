Output for [poly1305 microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/poly1305-benchmark) on RISC-V cpu:

| Benchmark                        | (dataSize) | (provider) | Mode  | Cnt |       Score |  Error    | Units |
| -------------------------------- | ---------- | ---------- | ----- | --- | ----------- | --------- | ----- |
| Poly1305DigestBench.digestBuffer |         64 |            | thrpt |   3 |  197055.384 | 13184.731 | ops/s |
| Poly1305DigestBench.digestBuffer |        256 |            | thrpt |   3 |  156241.007 |  5163.810 | ops/s |
| Poly1305DigestBench.digestBuffer |       1024 |            | thrpt |   3 |   81124.922 |  2279.179 | ops/s |
| Poly1305DigestBench.digestBuffer |      16384 |            | thrpt |   3 |    7472.027 |   244.110 | ops/s |
| Poly1305DigestBench.digestBuffer |    1048576 |            | thrpt |   3 |     124.127 |    33.203 | ops/s |
| Poly1305DigestBench.digestBytes  |         64 |            | thrpt |   3 |  219302.471 | 11652.431 | ops/s |
| Poly1305DigestBench.digestBytes  |        256 |            | thrpt |   3 |  161582.890 |  2807.634 | ops/s |
| Poly1305DigestBench.digestBytes  |       1024 |            | thrpt |   3 |   82212.665 |  3060.746 | ops/s |
| Poly1305DigestBench.digestBytes  |      16384 |            | thrpt |   3 |    7558.604 |   208.192 | ops/s |
| Poly1305DigestBench.digestBytes  |    1048576 |            | thrpt |   3 |     120.287 |    54.422 | ops/s |
| Poly1305DigestBench.updateBytes  |         64 |            | thrpt |   3 | 1542497.845 |  5468.344 | ops/s |
| Poly1305DigestBench.updateBytes  |        256 |            | thrpt |   3 |  470091.271 |  1351.793 | ops/s |
| Poly1305DigestBench.updateBytes  |       1024 |            | thrpt |   3 |  122511.243 |   393.365 | ops/s |
| Poly1305DigestBench.updateBytes  |      16384 |            | thrpt |   3 |    7938.676 |   106.270 | ops/s |
| Poly1305DigestBench.updateBytes  |    1048576 |            | thrpt |   3 |     126.713 |    45.480 | ops/s |

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
