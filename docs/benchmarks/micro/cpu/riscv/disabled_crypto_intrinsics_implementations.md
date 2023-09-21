Note on `*Unaligned` intrinsics:
There's option in VM for disabling unaligned access operations: `AvoidUnalignedAccesses` (see [`globals_riscv.hpp`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/riscv/globals_riscv.hpp#L99)). The main fact about misaligned `put`/`get`/etc is that if it is emulated by software, the performance degradation occurs, so enabling this feature should depend on whether it is supported on particular CPU.

Collected some additional information on various crypto intrinsics implementations:
- `_encodeAsciiArray`: no architecture-specific implementation;
- `_aescrypt_encryptBlock`: [AArch64](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L2678), [Arm](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/arm/stubRoutinesCrypto_arm.cpp#L120), [ppc](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/ppc/stubGenerator_ppc.cpp#L2630), [s390](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/s390/stubGenerator_s390.cpp#L1775), [x86_32](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/x86/stubGenerator_x86_32.cpp#L2356), [x86_64](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/x86/stubGenerator_x86_64_aes.cpp)
    - `_aescrypt_decryptBlock`: all the same files
- `_updateCRC32`: [AArch64](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/c1_LIRGenerator_aarch64.cpp#L920), [s390](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/s390/c1_LIRGenerator_s390.cpp#L1023), [x86](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/x86/c1_LIRGenerator_x86.cpp#L1054), [ppc](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/ppc/c1_LIRGenerator_ppc.cpp#L1218)
    - `_updateBytesCRC32`: all the same files
- `_updateBytesAdler32`: [AArch64](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#4415), [x86_64](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/x86/stubGenerator_x86_64_adler.cpp#L66)
- `ChaCha20`: [RVV version](https://github.com/edre/rvv-chacha-poly), [AArch64](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L4244), [x86_64](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/x86/stubGenerator_x86_64_chacha.cpp)
    - `Poly1305`: same link for RVV, [AArch64](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L7121), [x86_64](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/x86/stubGenerator_x86_64_poly.cpp)