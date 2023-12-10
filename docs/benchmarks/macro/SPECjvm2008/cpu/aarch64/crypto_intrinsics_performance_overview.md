Overview of crypto intrinsics performance on SPECjvm2008 `crypto.aes` benchmark.

AES-related crypto intrinsics have some influence on importance of SPECjvm2008 `crypto.aes` benchmark. Disabling two groups of connected AES-related intrinsics showed performance difference of 64.76 and 57.62 respectively, which is **lower** than performance on default intrinsics set: the first ones to implement should be the `cipherBlockChaining` group. However, due to unability of testing performance on real RISC-V CPUs, the priority for AES-related intrinsics remains low.

For full run evaluation see [`disabling_crypto_intrinsics.md`](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/blob/main/docs/benchmarks/macro/SPECjbb2015/cpu/aarch64/disabling_crypto_intrinsics.md) file.
