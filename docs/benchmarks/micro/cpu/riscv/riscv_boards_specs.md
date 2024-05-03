### Full RISC-V test stands overview

#### T-Head

Full board name: "Alibaba T-head RVB-ICE".

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

#### VisionFive

Full board name: "Starfive VisionFive 2".


```
$ lscpu
Architecture:          riscv64
  Byte Order:          Little Endian
CPU(s):                4
  On-line CPU(s) list: 0-3
```

```$ cat /proc/cpuinfo 
processor	: 0
hart		: 1
isa		: rv64imafdc
mmu		: sv39
isa-ext		: 
uarch		: sifive,u74-mc

processor	: 1
hart		: 2
isa		: rv64imafdc
mmu		: sv39
isa-ext		: 
uarch		: sifive,u74-mc

processor	: 2
hart		: 3
isa		: rv64imafdc
mmu		: sv39
isa-ext		: 
uarch		: sifive,u74-mc

processor	: 3
hart		: 4
isa		: rv64imafdc
mmu		: sv39
isa-ext		: 
uarch		: sifive,u74-mc
```

```
$ uname -a
Linux starfive 5.15.0-starfive #1 SMP Wed Aug 23 11:18:20 CST 2023 riscv64 GNU/Linux
```
