### План введения
Java -- популярная, RISC-V -- набирает обороты, Syntacore занимается RISC-V и с недавних пор джавой. Возникла необходимость ускорить. Syntacore в первую очередь интересует криптография. В данной работе рассматривается реализация Java интринсиков для ускорения работы компилятора C2 для RISC-V.

### Постановка задачи
Расширение поддержки intrinsic-функций (в первую очередь -- криптографических) для микропроцессорной архитектуры RISC-V.

### Обзор существующих на данный момент криптографических интринсиков
Разбиение по группам ещё не имплементированных интринсиков. По ссылкам -- реализация на других платформах (на момент 06-ноябрь-2023):
- `com.sun.crypto.provider.AEScrypt`: [`_aescrypt_decryptBlock`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L2710), [`_aescrypt_encryptBlock`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L2678).
- `com.sun.crypto.provider.CipherBlockChaining`: [`cipherBlockChaining_decryptAESCrypt`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L2852), [`_cipherBlockChaining_encryptAESCrypt`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L2748)
- `com.sun.crypto.provider.CounterMode`: [`_counterMode_AESCrypt`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L2980)
- `com.sun.crypto.provider.ElectronicCodeBook`: [`_electronicCodeBook_decryptAESCrypt`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/x86/stubGenerator_x86_64_aes.cpp#1533), [`_electronicCodeBook_encryptAESCrypt`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/x86/stubGenerator_x86_64_aes.cpp#1513)
- `com.sun.crypto.provider.GHASH`: [`_ghash_processBlocks`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L6164)
- `java.util.zip.Adler32`: [`_updateBytesAdler32`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#4415), `_updateByteBufferAdler32` (<-- not the C2 intrinsic, however, uses the `updateBytesAdler32` stub)
- `java.util.zip.CRC32`: [`_updateBytesCRC32`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L4208), `_updateByteBufferCRC32` (<-- not the C2 intrinsic, however, uses the `_updateBytesCRC32` stub), `_updateCRC32` (<-- not the C2 intrinsic, however, uses some of the same MacroAsm functions as the `_updateBytesCRC32` stub)
- `java.util.zip.CRC32С`: [`_updateBytesCRC32C`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L4375), `_updateDirectByteBufferCRC32C` (<-- not the C2 intrinsic, however, uses the `_updateBytesCRC32C` stub)
- `com.sun.crypto.provider.GaloisCounterMode`: [`_galoisCounterMode_AESCrypt`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L3241)
- `com.sun.crypto.provider.Poly1305`: [`_poly1305_processBlocks`](https://github.com/openjdk/jdk/blob/master/src/hotspot/cpu/aarch64/stubGenerator_aarch64.cpp#L7123)
- `sun.security.provider.SHA*` : `_sha*_implCompress` (<-- External WIP: https://github.com/openjdk/jdk/pull/12208)
- `java.util.Base64$Decoder`: `_base64_decodeBlock` (<-- External WIP: https://bugs.openjdk.org/browse/JDK-8314124)
- `java.util.Base64$Encoder`: `_base64_encodeBlock` (<-- External WIP: https://bugs.openjdk.org/browse/JDK-8314124)

По каждому из нереализованных интринсиков кратко описать алгоритм и где применяется: TBD.

### Примерный план реализации 
Поскольку на данный момент (06-ноябрь-2023) криптографическое расширение для RISC-V, в котором введены инструкции, использующиеся в алгоритмах семейства AES, было ратифицировано относительно [недавно](https://wiki.riscv.org/display/HOME/Recently+Ratified+Extensions) (сентябрь 2023), было принято решение приоретизировать их ниже остальных, за неимением возможности измерить их производительность прямо сейчас (отсутствие произведённых процессоров).

Дальнейшая расстановка приоритетов идёт согласно результатам, полученным в ходе [исследований производительности на архитектуре AArch64](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/blob/main/docs/benchmarks/micro/cpu/aarch64/crypto_intrinsics_performance_overview.md), а также использованию в этих реализациях векторных инструкций (для реализации необходимо использовать расширение RVV для RISC-V):

1. Poly1305 (`_poly1305_processBlocks`):
    - Интринсик реализован, внутреннее ревью пройдено, ревью в OpenJDK идёт на данный момент;

2. CRC32-related (`_updateBytesCRC32`, `_updateBytesCRC32C`):
    - Оба реализованы, внутреннее ревью пройдено. PR в OpenJDK -- TBD;

3. Adler32 (`_updateBytesAdler32`):
    - Используется RVV;
    - TBD.

4. GHASH (`_ghash_processBlocks`):
    - Используется RVV;
    - TBD.

5. AES-related:
    - Полный список интринсиков: `_electronicCodeBook_decryptAESCrypt`, `_electronicCodeBook_encryptAESCrypt`, `_counterMode_AESCrypt`, `cipherBlockChaining_decryptAESCrypt`, `_cipherBlockChaining_encryptAESCrypt`, `_aescrypt_decryptBlock`, `_aescrypt_encryptBlock`, _galoisCounterMode_AESCrypt;
    - Приоритет самый низкий, поскольку на данный момент невозможно измерить производительность на RISC-V.

Для каждого из реализованных интринсиков:
1. Гарантируется корректность работы путём запуска соответствующего ему jtreg-теста;
2. Измеряется перформанс на соответствующем ему JMH микробенчмарке.
    - В случае отсутствия необходимого JMH микробенчмарка таковой создаётся;
3. Используется опция `-prof perfasm` при запуске микробенчмарка для отслеживания наиболее "горячих" мест реализованных интринсиков, чтобы, при наличии такой возможности, оптимизировать.
