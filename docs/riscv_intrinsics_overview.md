### Results for intrinsics test runs on riscv:

#### Microbenchmarks

- Intrinsic statistics on [ChaCha20 test](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/blob/main/benchmarks/ChaCha20/ChaCha20-benchmark/src/main/java/ChaCha20/CipherBench.java):

```
<statistics type='intrinsic'>
Compiler intrinsic usage:
     1 ( 0,6%) _hashCode (worked,virtual)
    14 ( 8,0%) _clone (worked)
    15 ( 8,6%) _min (worked)
     5 ( 2,9%) _max (worked)
     4 ( 2,3%) _identityHashCode (worked)
     7 ( 4,0%) _arraycopy (worked)
     2 ( 1,1%) _getCallerClass (worked)
     2 ( 1,1%) _equalsB (worked)
     0 ( 0,0%) _vectorizedHashCode (disabled)
     4 ( 2,3%) _indexOfL (worked)
     1 ( 0,6%) _indexOfIL (worked)
     5 ( 2,9%) _indexOfL_char (worked)
     6 ( 3,4%) _equalsL (worked)
    38 (21,8%) _Preconditions_checkIndex (worked)
     0 ( 0,0%) _vectorizedMismatch (disabled)
     4 ( 2,3%) _Reference_get (worked)
     5 ( 2,9%) _Reference_refersTo0 (worked)
     0 ( 0,0%) _chacha20Block (disabled)
     1 ( 0,6%) _allocateInstance (worked)
     4 ( 2,3%) _isCompileConstant (worked)
    19 (10,9%) _getLong (worked)
    19 (10,9%) _putInt (worked)
     8 ( 4,6%) _putLong (worked)
     1 ( 0,6%) _putReferenceVolatile (worked)
     6 ( 3,4%) _getReferenceAcquire (worked)
     1 ( 0,6%) _putReferenceRelease (worked)
     0 ( 0,0%) _getLongUnaligned (disabled)
     0 ( 0,0%) _putIntUnaligned (disabled)
     0 ( 0,0%) _putLongUnaligned (disabled)
     1 ( 0,6%) _compareAndSetReference (worked)
     1 ( 0,6%) _compareAndSetInt (worked)
   174 (100,0%) total (worked,disabled,virtual)
</statistics>
```

- Intrinsic statistics on [Poly1305 test](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/blob/main/benchmarks/poly1305-benchmark/src/main/java/com/poly1305/Poly1305DigestBench.java):

```
<statistics type='intrinsic'>
Compiler intrinsic usage:
     1 ( 0,4%) _clone (worked)
     4 ( 1,8%) _min (worked)
     4 ( 1,8%) _max (worked)
     2 ( 0,9%) _arraycopy (worked)
     1 ( 0,4%) _isPrimitive (worked)
     1 ( 0,4%) _Class_cast (worked)
     0 ( 0,0%) _vectorizedHashCode (disabled)
     2 ( 0,9%) _equalsL (worked)
    17 ( 7,6%) _Preconditions_checkIndex (worked)
     0 ( 0,0%) _poly1305_processBlocks (disabled)
     1 ( 0,4%) _allocateUninitializedArray (worked)
     1 ( 0,4%) _isCompileConstant (worked)
    96 (42,9%) _getByte (worked)
    48 (21,4%) _getShort (worked)
    24 (10,7%) _getInt (worked)
    12 ( 5,4%) _getLong (worked)
     1 ( 0,4%) _putReferenceVolatile (worked)
     1 ( 0,4%) _getReferenceAcquire (worked)
     0 ( 0,0%) _getLongUnaligned (disabled)
     1 ( 0,4%) _compareAndSetReference (worked)
     5 ( 2,2%) _compareAndSetLong (worked)
     2 ( 0,9%) _compareAndSetInt (worked)
   224 (100,0%) total (worked,disabled)
</statistics>
```

both tests were run for

```
openjdk version "22" 2024-03-19
```

### Results for intrinsics test runs on aarch64:

- ChaCha20 test statistics for intrinsics

```
<statistics type='intrinsic'>
Compiler intrinsic usage:
     1 ( 0.5%) _hashCode (worked,virtual)
    14 ( 7.7%) _clone (worked)
    16 ( 8.7%) _min (worked)
     6 ( 3.3%) _max (worked)
     4 ( 2.2%) _identityHashCode (worked)
    10 ( 5.5%) _arraycopy (worked)
     2 ( 1.1%) _getCallerClass (worked)
     2 ( 1.1%) _equalsB (worked)
     0 ( 0.0%) _vectorizedHashCode (disabled)
     4 ( 2.2%) _indexOfL (worked)
     1 ( 0.5%) _indexOfIL (worked)
     5 ( 2.7%) _indexOfL_char (worked)
     6 ( 3.3%) _equalsL (worked)
    36 (19.7%) _Preconditions_checkIndex (worked)
     0 ( 0.0%) _vectorizedMismatch (disabled)
     4 ( 2.2%) _Reference_get (worked)
     5 ( 2.7%) _Reference_refersTo0 (worked)
     8 ( 4.4%) _chacha20Block (worked)
     1 ( 0.5%) _allocateInstance (worked)
     4 ( 2.2%) _isCompileConstant (worked)
     1 ( 0.5%) _getLong (worked)
     1 ( 0.5%) _putReferenceVolatile (worked)
     6 ( 3.3%) _getReferenceAcquire (worked)
     1 ( 0.5%) _putReferenceRelease (worked)
    18 ( 9.8%) _getLongUnaligned (worked)
    18 ( 9.8%) _putIntUnaligned (worked)
     7 ( 3.8%) _putLongUnaligned (worked)
     1 ( 0.5%) _compareAndSetReference (worked)
     1 ( 0.5%) _compareAndSetInt (worked)
   183 (100.0%) total (worked,disabled,virtual)
</statistics>
```

- Poly1305 test statistics for intrinsics:

```
Compiler intrinsic usage:
     2 ( 2.4%) _clone (worked)
     7 ( 8.2%) _min (worked)
     6 ( 7.1%) _max (worked)
     4 ( 4.7%) _arraycopy (worked)
     1 ( 1.2%) _isPrimitive (worked)
     1 ( 1.2%) _Class_cast (worked)
     0 ( 0.0%) _vectorizedHashCode (disabled)
     2 ( 2.4%) _equalsL (worked)
    19 (22.4%) _Preconditions_checkIndex (worked)
     1 ( 1.2%) _poly1305_processBlocks (worked)
     1 ( 1.2%) _allocateUninitializedArray (worked)
     1 ( 1.2%) _isCompileConstant (worked)
     8 ( 9.4%) _getByte (worked)
     4 ( 4.7%) _getShort (worked)
     2 ( 2.4%) _getInt (worked)
     1 ( 1.2%) _getLong (worked)
     1 ( 1.2%) _putReferenceVolatile (worked)
     1 ( 1.2%) _getReferenceAcquire (worked)
    13 (15.3%) _getLongUnaligned (worked)
     1 ( 1.2%) _compareAndSetReference (worked)
     7 ( 8.2%) _compareAndSetLong (worked)
     2 ( 2.4%) _compareAndSetInt (worked)
    85 (100.0%) total (worked,disabled)
```

both tests were run on

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (fastdebug build 22-testing-builds.shipilev.net-openjdk-jdk-b552-20230909)
OpenJDK 64-Bit Server VM (fastdebug build 22-testing-builds.shipilev.net-openjdk-jdk-b552-20230909, mixed mode)
```

Full comparison for both cases:

- ChaCha20:

| intrinsic                   | aarch64  | riscv        |
| --------------------------- | -------- | ------------ |
| `_hashCode`                 | worked   | worked       |
| `_clone`                    | worked   | worked       |
| `_min`                      | worked   | worked       |
| `_max`                      | worked   | worked       |
| `_identityHashCode`         | worked   | worked       |
| `_arraycopy`                | worked   | worked       |
| `_getCallerClass`           | worked   | worked       |
| `_equalsB`                  | worked   | worked       |
| `_vectorizedHashCode`       | disabled | disabled     |
| `_indexOfL`                 | worked   | worked       |
| `_indexOfIL`                | worked   | worked       |
| `_indexOfL_char`            | worked   | worked       |
| `_equalsL`                  | worked   | worked       |
| `_Preconditions_checkIndex` | worked   | worked       |
| `_vectorizedMismatch`       | disabled | disabled     |
| `_Reference_get`            | worked   | worked       |
| `_Reference_refersTo0`      | worked   | worked       |
| `_chacha20Block`            | worked   | **disabled** |
| `_allocateInstance`         | worked   | worked       |
| `_isCompileConstant`        | worked   | worked       |
| `_getLong`                  | worked   | worked       |
| `_putReferenceVolatile`     | worked   | worked       |
| `_getReferenceAcquire`      | worked   | worked       |
| `_putReferenceRelease`      | worked   | worked       |
| `_getLongUnaligned`         | worked   | **disabled** |
| `_putIntUnaligned`          | worked   | **disabled** |
| `_putLongUnaligned`         | worked   | **disabled** |
| `_compareAndSetReference`   | worked   | worked       |
| `_compareAndSetInt`         | worked   | worked       |

- Poly1305:

| intrinsic                     | aarch64  | riscv        |
| ----------------------------- | -------  | ------------ |
| `_clone`                      | worked   | worked       |
| `_max`                        | worked   | worked       |
| `_arraycopy`                  | worked   | worked       |
| `_isPrimitive`                | worked   | worked       |
| `_Class_cast`                 | worked   | worked       |
| `_vectorizedHashCode`         | disabled | disabled     |
| `_equalsL`                    | worked   | worked       |
| `_Preconditions_checkIndex`   | worked   | worked       |
| `_poly1305_processBlocks`     | worked   | **disabled** |
| `_allocateUninitializedArray` | worked   | worked       |
| `_isCompileConstant`          | worked   | worked       |
| `_getByte`                    | worked   | worked       |
| `_getShort`                   | worked   | worked       |
| `_getInt`                     | worked   | worked       |
| `_getLong`                    | worked   | worked       |
| `_putReferenceVolatile`       | worked   | worked       |
| `_getReferenceAcquire`        | worked   | worked       |
| `_getLongUnaligned`           | worked   | **disabled** |
| `_compareAndSetReference`     | worked   | worked       |
| `_compareAndSetLong`          | worked   | worked       |
| `_compareAndSetInt`           | worked   | worked       |

----------------------------------------------------------------------------------------------------

#### Macrobenchmarks

Taken from runs of SPECJbb2015 and renaissance benchmarks suite.

1. Bit manipulation (can be turned on with bitmanip extension):

```
     0 ( 0,0%) _numberOfLeadingZeros_i (disabled) ## requires UseZbb on riscv
     0 ( 0,0%) _numberOfTrailingZeros_i (disabled) ## requires UseZbb on riscv
     0 ( 0,0%) _numberOfTrailingZeros_l (disabled) ## requires UseZbb on riscv
     0 ( 0,0%) _bitCount_i (disabled) ## requires UsePopCountInstruction on riscv
```

2. SpinWait (requires special VM version)

```
     0 ( 0,0%) _onSpinWait (disabled) ## Requires VM_Version::supports_on_spin_wait() == true on all platforms
```

3. Require vector extension

```
     0 ( 0,0%) _vectorizedHashCode (disabled) ## available only on x86
     0 ( 0,0%) _countPositives (disabled)  ## require riscv vector extension
     0 ( 0,0%) _vectorizedMismatch (disabled) ## c1_LIRGenerator_riscv.cpp::803 not implemented on riscv
```

4. Unaligned access

```
     0 ( 0,0%) _getShortUnaligned (disabled) ## Unaligned access
     0 ( 0,0%) _getIntUnaligned (disabled) ## Unaligned access
     0 ( 0,0%) _getLongUnaligned (disabled) ## Unaligned access
```

5. Cryptography and control sums

```
     0 ( 0,0%) _encodeAsciiArray (disabled)
     0 ( 0,0%) _aescrypt_encryptBlock (disabled)
     0 ( 0,0%) _aescrypt_decryptBlock (disabled)
     0 ( 0,0%) _updateCRC32 (disabled)
     0 ( 0,0%) _updateBytesCRC32 (disabled)
     0 ( 0,0%) _updateBytesAdler32 (disabled)
```

All tests were run on

```
openjdk version "22" 2024-03-19
OpenJDK Runtime Environment SyntaJ-22+9-b060923-release (build 22+9-EA)
OpenJDK 64-Bit Server VM SyntaJ-22+9-b060923-release (build 22+9-EA, mixed mode)
```

with additional flags: `-XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation`.

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