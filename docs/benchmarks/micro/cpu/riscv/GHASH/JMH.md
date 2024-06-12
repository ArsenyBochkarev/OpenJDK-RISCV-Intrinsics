Output for [GHASH microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/GHASH) on RISC-V cpu:

| Benchmark                      |                              (HashSubkey)  |                                                                                                                         (InputBlock)   | Mode  | Cnt |    Score |   Error   | Units  |
| ------------------------------ | --------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- | ----- | --- | -------- | --------- | ------ |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                                                                  | thrpt |  12 | 8591.295 | ±  62.688 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                         feedfacedeadbeeffeedfacedeadbeefabaddad2 | thrpt |  12 |  422.045 | ±   3.164 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                                 0388dace60b6a392f328c2b971b2fe78 | thrpt |  12 |  533.458 | ±  11.444 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e | 42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091473f5985 | thrpt |  12 |  137.838 | ±   0.706 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |         42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091 | thrpt |  12 |  164.707 | ±   0.967 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |         61353b4c2806934a777ff51fa22a4755699b2a714fcdc6f83766e5f97b6c742373806900e49f24b22b097544d4896b424989b5e1ebac0f07c23f4598 | thrpt |  12 |  164.332 | ±   0.771 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                                                                  | thrpt |  12 | 8714.194 | ±  46.133 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                         feedfacedeadbeeffeedfacedeadbeefabaddad2 | thrpt |  12 |  420.243 | ±   2.545 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                                 0388dace60b6a392f328c2b971b2fe78 | thrpt |  12 |  541.573 | ±  6.943  | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 | 42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091473f5985 | thrpt |  12 |  137.107 | ±  1.253  | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |         42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091 | thrpt |  12 |  165.335 | ±  0.312  | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |         61353b4c2806934a777ff51fa22a4755699b2a714fcdc6f83766e5f97b6c742373806900e49f24b22b097544d4896b424989b5e1ebac0f07c23f4598 | thrpt |  12 |  164.237 | ±  0.562  | ops/ms |

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
