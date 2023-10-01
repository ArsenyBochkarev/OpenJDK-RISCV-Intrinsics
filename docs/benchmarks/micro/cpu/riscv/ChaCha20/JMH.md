Output for [poly1305 microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/ChaCha20) on RISC-V cpu:

| Benchmark                                  |  (dataSize) | (keyLength) | (mode) | (padding) | (permutation) |  (provider) |  Mode  | Cnt |      Score |  Error   |  Units |
| ------------------------------------------ | ----------- | ----------- | ------ | --------- | ------------- | ----------- | ------ | --- | ---------- | -------- | ------ |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |        256  |        256  |  None  | NoPadding |  ChaCha20     |             |  thrpt |  40 | 140724.688 | 1222.527 | ops/s  |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       1024  |        256  |  None  | NoPadding |  ChaCha20     |             |  thrpt |  40 |  41133.205 |  470.279 | ops/s  |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       4096  |        256  |  None  | NoPadding |  ChaCha20     |             |  thrpt |  40 |  10371.273 |  573.699 | ops/s  |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |      16384  |        256  |  None  | NoPadding |  ChaCha20     |             |  thrpt |  40 |   2724.066 |   39.822 | ops/s  |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |        256  |        256  |  None  | NoPadding |  ChaCha20     |             |  thrpt |  40 | 136674.658 | 1162.880 | ops/s  |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       1024  |        256  |  None  | NoPadding |  ChaCha20     |             |  thrpt |  40 |  41004.909 |  235.015 | ops/s  |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       4096  |        256  |  None  | NoPadding |  ChaCha20     |             |  thrpt |  40 |  10411.245 |  485.781 | ops/s  |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |      16384  |        256  |  None  | NoPadding |  ChaCha20     |             |  thrpt |  40 |   2768.359 |   26.302 | ops/s  |

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
