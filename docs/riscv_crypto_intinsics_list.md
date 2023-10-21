Crypto domain intrinsics to-do (all are unimplemented prior to 21-oct-2023):
- `com.sun.crypto.provider.AEScrypt`: `_aescrypt_decryptBlock`, `_aescrypt_encryptBlock`
- `com.sun.crypto.provider.CipherBlockChaining`: `cipherBlockChaining_decryptAESCrypt`, `_cipherBlockChaining_encryptAESCrypt`
- `com.sun.crypto.provider.CounterMode`: `_counterMode_AESCrypt`
- `com.sun.crypto.provider.ElectronicCodeBook`: `_electronicCodeBook_decryptAESCrypt`, `_electronicCodeBook_encryptAESCrypt`
- `com.sun.crypto.provider.GHASH`: `_ghash_processBlocks`
- `java.util.zip.Adler32`: `_updateBytesAdler32`, `_updateByteBufferAdler32` (<-- not the C2 intrinsic, however, uses the `updateBytesAdler32` stub)
- `java.util.zip.CRC32`: `_updateBytesCRC32`, `_updateByteBufferCRC32` (<-- not the C2 intrinsic, however, uses the `_updateBytesCRC32` stub), `_updateCRC32` (<-- not the C2 intrinsic, however, uses some of the same MacroAsm functions as the `_updateBytesCRC32` stub)
- `java.util.zip.CRC32С`: `_updateBytesCRC32C`, `_updateDirectByteBufferCRC32C` (<-- not the C2 intrinsic, however, uses the `_updateBytesCRC32C` stub)
- `com.sun.crypto.provider.GaloisCounterMode`: `_galoisCounterMode_AESCrypt`
- `com.sun.crypto.provider.Poly1305`: `_poly1305_processBlocks`
- `sun.security.provider.SHA*` : `_sha*_implCompress` (<-- Possible external WIP: https://github.com/openjdk/jdk/pull/12208)
- `java.util.Base64$Decoder`: `_base64_decodeBlock` (<-- Possible external WIP: https://bugs.openjdk.org/browse/JDK-8314124)
- `java.util.Base64$Encoder`: `_base64_encodeBlock` (<-- Possible external WIP: https://bugs.openjdk.org/browse/JDK-8314124)