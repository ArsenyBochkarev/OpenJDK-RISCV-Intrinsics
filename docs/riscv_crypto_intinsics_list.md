Crypto domain intrinsics to-do (all are unimplemented prior to 31-oct-2024):
- `com.sun.crypto.provider.CipherBlockChaining`: `cipherBlockChaining_decryptAESCrypt`, `_cipherBlockChaining_encryptAESCrypt`
- `com.sun.crypto.provider.CounterMode`: `_counterMode_AESCrypt`
- `com.sun.crypto.provider.ElectronicCodeBook`: `_electronicCodeBook_decryptAESCrypt`, `_electronicCodeBook_encryptAESCrypt`
- `com.sun.crypto.provider.GHASH`: `_ghash_processBlocks`
- `java.util.zip.CRC32С`: `_updateBytesCRC32C`, `_updateDirectByteBufferCRC32C` (<-- not the C2 intrinsic, however, uses the `_updateBytesCRC32C` stub)
- `com.sun.crypto.provider.GaloisCounterMode`: `_galoisCounterMode_AESCrypt`
- `sun.security.provider.SHA*` : `_sha*_implCompress` (<-- Almost done in opensource: https://github.com/openjdk/jdk/pull/12208)
