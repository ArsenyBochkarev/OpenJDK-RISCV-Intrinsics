SPECjvm2008 crypto benchmarks overview on intrinsics.

List of crypto intrinsics used in `crypto` benchmarks (`crypto.aes`, `crypto.rsa`, `crypto.signverify`) of SPECjvm2008 benchmark:
- `_aescrypt_encryptBlock` (`crypto.aes`)
- `_aescrypt_decryptBlock` (`crypto.aes`)
- `_cipherBlockChaining_encryptAESCrypt` (`crypto.aes`)
- `_cipherBlockChaining_decryptAESCrypt` (`crypto.aes`)
- `_sha_implCompress` (`crypto.rsa`, `crypto.signverify`)
- `_sha2_implCompress` (`crypto.signverify`)
- `_md5_implCompress` (`crypto.signverfiy`)

On Rocks5 board all intrinsics from the list above are enabled.


All benchmarks were run on

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (fastdebug build 22-testing-builds.shipilev.net-openjdk-jdk-b552-20230909)
OpenJDK 64-Bit Server VM (fastdebug build 22-testing-builds.shipilev.net-openjdk-jdk-b552-20230909, mixed mode)
```

with additional flags: `-XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation`.

For full run evaluation, see [`disabling_crypto_intrinsics.md`](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/blob/main/docs/benchmarks/macro/SPECjvm2008/cpu/aarch64/disabling_crypto_intrinsics.md) file.
