SPECjbb2015 crypto benchmarks overview on intrinsics.

The list of crypto intrinsics used in SPECjbb2015 benchmark:
- `_digestBase_implCompressMB`
- `_updateCRC32`
- `_updateBytesCRC32`
- `_updateBytesAdler32`
- `_aescrypt_encryptBlock`
- `_aescrypt_decryptBlock`
- `_cipherBlockChaining_encryptAESCrypt`
- `_cipherBlockChaining_decryptAESCrypt`
- `_sha_implCompress`

On Rocks5 board all intrinsics from the list above are enabled.

Benchmarks was run on

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (fastdebug build 22-testing-builds.shipilev.net-openjdk-jdk-b552-20230909)
OpenJDK 64-Bit Server VM (fastdebug build 22-testing-builds.shipilev.net-openjdk-jdk-b552-20230909, mixed mode)
```

with additional flags: `-XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation`.

For full run evaluation see [`disabling_crypto_intrinsics.md`](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/blob/main/docs/benchmarks/macro/SPECjbb2015/cpu/aarch64/disabling_crypto_intrinsics.md) file.
