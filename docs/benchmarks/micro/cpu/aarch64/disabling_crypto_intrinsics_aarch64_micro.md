Results on enabling/disabling intrinsics for AArch64 platform:


### [Poly1305 microbench](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/Poly1305)

Intrinsic name: `_poly1305_processBlocks`.

- disabled:

| Benchmark                        | (dataSize) | (provider) |  Mode | Cnt |     Score  |    Error   | Units |
| -------------------------------- | ---------- | ---------- | ----- | --- | ---------- | ---------- | ----- |
| Poly1305DigestBench.digestBuffer |         64 |            | thrpt |   3 | 281064.215 | ± 1318.459 | ops/s |
| Poly1305DigestBench.digestBuffer |        256 |            | thrpt |   3 | 154231.261 | ± 2217.037 | ops/s |
| Poly1305DigestBench.digestBuffer |       1024 |            | thrpt |   3 |  55310.686 | ±  516.674 | ops/s |
| Poly1305DigestBench.digestBuffer |      16384 |            | thrpt |   3 |   4080.668 | ±  621.513 | ops/s |
| Poly1305DigestBench.digestBuffer |    1048576 |            | thrpt |   3 |     63.693 | ±    9.474 | ops/s |
| Poly1305DigestBench.digestBytes  |         64 |            | thrpt |   3 | 290928.953 | ± 3683.603 | ops/s |
| Poly1305DigestBench.digestBytes  |        256 |            | thrpt |   3 | 153211.589 | ± 2081.486 | ops/s |
| Poly1305DigestBench.digestBytes  |       1024 |            | thrpt |   3 |  53064.797 | ±  662.738 | ops/s |
| Poly1305DigestBench.digestBytes  |      16384 |            | thrpt |   3 |   3941.354 | ±  688.379 | ops/s |
| Poly1305DigestBench.digestBytes  |    1048576 |            | thrpt |   3 |     63.029 | ±    0.333 | ops/s |
| Poly1305DigestBench.updateBytes  |         64 |            | thrpt |   3 | 856629.062 | ± 1904.423 | ops/s |
| Poly1305DigestBench.updateBytes  |        256 |            | thrpt |   3 | 239486.480 | ± 3314.851 | ops/s |
| Poly1305DigestBench.updateBytes  |       1024 |            | thrpt |   3 |  61899.262 | ±  335.888 | ops/s |
| Poly1305DigestBench.updateBytes  |      16384 |            | thrpt |   3 |   3998.056 | ±   20.554 | ops/s |
| Poly1305DigestBench.updateBytes  |    1048576 |            | thrpt |   3 |     64.996 | ±    0.320 | ops/s |

- enabled:

| Benchmark                        | (dataSize) | (provider) |  Mode | Cnt |     Score  |    Error     | Units |
| -------------------------------- | ---------- | ---------- | ----- | --- | ---------- | ------------ | ----- |
| Poly1305DigestBench.digestBuffer |        64  |            | thrpt |   3 |  340785.132 | ±  5508.393 | ops/s |
| Poly1305DigestBench.digestBuffer |       256  |            | thrpt |   3 |  246629.143 | ±  3376.868 | ops/s |
| Poly1305DigestBench.digestBuffer |      1024  |            | thrpt |   3 |  116994.983 | ±  1824.698 | ops/s |
| Poly1305DigestBench.digestBuffer |     16384  |            | thrpt |   3 |   10297.458 | ±   146.412 | ops/s |
| Poly1305DigestBench.digestBuffer |   1048576  |            | thrpt |   3 |      63.115 | ±     9.404 | ops/s |
| Poly1305DigestBench.digestBytes  |        64  |            | thrpt |   3 |  350730.719 | ±  3805.447 | ops/s |
| Poly1305DigestBench.digestBytes  |       256  |            | thrpt |   3 |  257465.040 | ±  2351.775 | ops/s |
| Poly1305DigestBench.digestBytes  |      1024  |            | thrpt |   3 |  119890.053 | ±  1058.474 | ops/s |
| Poly1305DigestBench.digestBytes  |     16384  |            | thrpt |   3 |   10299.219 | ±   127.025 | ops/s |
| Poly1305DigestBench.digestBytes  |   1048576  |            | thrpt |   3 |      62.935 | ±     0.586 | ops/s |
| Poly1305DigestBench.updateBytes  |        64  |            | thrpt |   3 | 1885416.619 | ±   659.328 | ops/s |
| Poly1305DigestBench.updateBytes  |       256  |            | thrpt |   3 |  617181.610 | ± 54328.199 | ops/s |
| Poly1305DigestBench.updateBytes  |      1024  |            | thrpt |   3 |  167064.978 | ±  1115.382 | ops/s |
| Poly1305DigestBench.updateBytes  |     16384  |            | thrpt |   3 |   10720.591 | ±   154.944 | ops/s |
| Poly1305DigestBench.updateBytes  |   1048576  |            | thrpt |   3 |      64.533 | ±     0.324 | ops/s |

- final results:

| Benchmark                        | (dataSize) |      Score difference (enabled - disabled)    | Error (enabled + disabled) | % of score (100% * difference / enabled) | Units |
| -------------------------------- | ---------- |  -------------------------------------------- | -------------------------- | ---------------------------------------- | ----- |
| Poly1305DigestBench.digestBuffer |         64 |                                     59720,917 |                 ± 6826,852 |                              17.5245078% | ops/s |
| Poly1305DigestBench.digestBuffer |        256 |                                     92397,882 |                 ± 5593,905 |                                 37.4643% | ops/s |
| Poly1305DigestBench.digestBuffer |       1024 |                                     61684,297 |                 ± 2341,372 |                                   52.72% | ops/s |
| Poly1305DigestBench.digestBuffer |      16384 |                                       6216,79 |                  ± 767,925 |                              60.3720841% | ops/s |
| Poly1305DigestBench.digestBuffer |    1048576 |                                        -0,578 |                   ± 18,878 |                               0.9157886% | ops/s |
| Poly1305DigestBench.digestBytes  |         64 |                                     59801,766 |                  ± 7489,05 |                              17.0506211% | ops/s |
| Poly1305DigestBench.digestBytes  |        256 |                                    104253,451 |                 ± 4433,261 |                              40.4922746% | ops/s |
| Poly1305DigestBench.digestBytes  |       1024 |                                     66825,256 |                 ± 1721,212 |                              55.7387826% | ops/s |
| Poly1305DigestBench.digestBytes  |      16384 |                                      6357,865 |                  ± 815,404 |                              61.7315255% | ops/s |
| Poly1305DigestBench.digestBytes  |    1048576 |                                        -0,094 |                    ± 0,919 |                               0.1493605% | ops/s |
| Poly1305DigestBench.updateBytes  |         64 |                                   1028787,557 |                 ± 2563,751 |                              54.5655293% | ops/s |
| Poly1305DigestBench.updateBytes  |        256 |                                     377695,13 |                 ± 57643,05 |                               61.196757% | ops/s |
| Poly1305DigestBench.updateBytes  |       1024 |                                    105165,716 |                  ± 1451,27 |                              62.9489898% | ops/s |
| Poly1305DigestBench.updateBytes  |      16384 |                                      6722,535 |                  ± 175,498 |                              62.7067575% | ops/s |
| Poly1305DigestBench.updateBytes  |    1048576 |                                        -0,463 |                    ± 0.644 |                               0.7174624% | ops/s |

Average % of score: 39.0863161%.


### [Adler32 microbench](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/Adler32)

Intrinsic name: `_updateBytesAdler32`.

- disabled:

| Benchmark                             | (count) |  Mode | Cnt |  Score   |   Error  |  Units |
| ------------------------------------- | ------- | ----- | --- | -------- | -------- | ------ |
| Adler32.TestAdler32.testAdler32Update |      64 | thrpt |  25 | 1163.050 | ± 11.864 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     128 | thrpt |  25 |  984.862 | ±  3.504 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     256 | thrpt |  25 |  756.202 | ±  2.216 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     512 | thrpt |  25 |  499.796 | ±  4.852 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    1024 | thrpt |  25 |  308.620 | ±  0.784 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    2048 | thrpt |  25 |  174.030 | ±  0.621 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    5012 | thrpt |  25 |   76.251 | ±  0.624 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    8192 | thrpt |  25 |   47.451 | ±  0.147 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   16384 | thrpt |  25 |   24.003 | ±  0.261 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   32768 | thrpt |  25 |   11.931 | ±  0.023 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   65536 | thrpt |  25 |    5.993 | ±  0.003 | ops/ms |

- enabled:

| Benchmark                             | (count) |  Mode | Cnt |  Score   |   Error  |  Units |
| ------------------------------------- | ------- | ----- | --- | -------- | -------- | ------ |
| Adler32.TestAdler32.testAdler32Update |      64 | thrpt |  25 | 9337.691 | ± 17.912 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     128 | thrpt |  25 | 6291.627 | ±  3.518 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     256 | thrpt |  25 | 3730.021 | ±  1.099 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |     512 | thrpt |  25 | 1988.418 | ±  0.736 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    1024 | thrpt |  25 | 1071.351 | ±  0.441 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    2048 | thrpt |  25 |  557.045 | ±  0.174 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    5012 | thrpt |  25 |  231.960 | ±  1.015 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |    8192 | thrpt |  25 |  143.712 | ±  0.054 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   16384 | thrpt |  25 |   71.134 | ±  1.273 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   32768 | thrpt |  25 |   35.153 | ±  0.173 | ops/ms |
| Adler32.TestAdler32.testAdler32Update |   65536 | thrpt |  25 |   17.612 | ±  0.045 | ops/ms |

- final results:

| Benchmark                             | (dataSize) |      Score difference (enabled - disabled)    | Error (enabled + disabled) | % of score (100% * difference / enabled) | Units  |
| ------------------------------------- | ---------- |  -------------------------------------------- | -------------------------- | ---------------------------------------- | ------ |
| Adler32.TestAdler32.testAdler32Update |         64 |                                      8174,641 |                   ± 29,776 |                              87.5445654% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |        128 |                                      5306,765 |                    ± 7,022 |                              84.3464655% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |        256 |                                      2973,819 |                    ± 3,315 |                              79.7266021% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |        512 |                                      1488,622 |                    ± 5,588 |                              74.8646411% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |       1024 |                                       762,731 |                    ± 1,225 |                              71.1933811% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |       2048 |                                       383,015 |                    ± 0,795 |                              68.7583588% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |       5012 |                                       155,709 |                    ± 1,639 |                               67.127522% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |       8192 |                                        96,261 |                    ± 0,201 |                              66.9818804% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |      16384 |                                        47,131 |                    ± 1,534 |                              66.2566424% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |      32768 |                                        23,222 |                    ± 0,196 |                              66.0597958% | ops/ms |
| Adler32.TestAdler32.testAdler32Update |      65536 |                                        11,619 |                    ± 0,048 |                              65.9720645% | ops/ms |

Average % of score: 72.6210836%.


### [CRC32 microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/CRC32)

Intrinsic name: `_updateBytesCRC32`. The non-vector version was tested. Additional flags to achieve this result: `-XX:-UseCRC32 -XX:-UseCryptoPmullForCRC32 -XX:-UseNeon`. The test stand was [Radxa Rock5 Model B](#radxa-rock5-model-b).

- disabled:

| Benchmark                       | (count) |  Mode | Cnt |  Score   |   Error   |  Units |
| ------------------------------- | ------- | ----- | --- | -------- | --------- | ------ |
| CRC32.TestCRC32.testCRC32Update |      64 | thrpt |  12 | 6122.115 | ± 622.044 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     128 | thrpt |  12 | 4304.847 | ±  9.480  | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     256 | thrpt |  12 | 2579.762 | ± 4.931   | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     512 | thrpt |  12 | 1429.514 | ±  6.330  | ops/ms |
| CRC32.TestCRC32.testCRC32Update |    2048 | thrpt |  12 |  389.934 | ±  0.722  | ops/ms |
| CRC32.TestCRC32.testCRC32Update |   16384 | thrpt |  12 |  50.083  | ±  0.061  | ops/ms |
| CRC32.TestCRC32.testCRC32Update |   65536 | thrpt |  12 |  12.499  | ±  0.049  | ops/ms |

- enabled:

| Benchmark                       | (count) |  Mode | Cnt |  Score    |   Error  |  Units |
| ------------------------------- | ------- | ----- | --- | --------- | -------- | ------ |
| CRC32.TestCRC32.testCRC32Update |      64 | thrpt |  12 | 13878.551 | ± 48.986 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     128 | thrpt |  12 | 7041.324  | ± 24.198 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     256 | thrpt |  12 | 3547.291  | ± 13.857 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |     512 | thrpt |  12 |  1777.514 | ± 10.079 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |    2048 | thrpt |  12 |  446.086  | ±  3.130 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |   16384 | thrpt |  12 |   55.441  | ±  7.459 | ops/ms |
| CRC32.TestCRC32.testCRC32Update |   65536 | thrpt |  12 |    13.866 | ±  0.594 | ops/ms |

- final results:

| Benchmark                       | (dataSize) |      Score difference (enabled - disabled)    | Error (enabled + disabled) | % of score (100% * difference / enabled) | Units  |
| ------------------------------- | ---------- |  -------------------------------------------- | -------------------------- | ---------------------------------------- | ------ |
| CRC32.TestCRC32.testCRC32Update |         64 |                                     7756,436  |                   ± 671,03 |                              55.8879382% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |        128 |                                     2736,477  |                   ± 33,678 |                               38.863103% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |        256 |                                     967,529   |                   ± 25.128 |                              27.2751517% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |        512 |                                      348      |                   ± 20,187 |                              19.5779049% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |       2048 |                                      56,152   |                    ± 3,852 |                              12.5877073% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |      16384 |                                       5,358   |                     ± 7,52 |                               9.6643278% | ops/ms |
| CRC32.TestCRC32.testCRC32Update |      65536 |                                       1,367   |                    ± 0,643 |                               9.8586471% | ops/ms |

Average % of score: 24.8163971%.

### [GHASH microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/GHASH)

- disabled:

| Benchmark                      |                     (HashSubkey)  |                                                                                                                   (InputBlocks)  | Mode  | Cnt |   Score   |  Error    | Units  |
| ------------------------------ | --------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- | ----- | --- | --------- | --------- | ------ |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                                                                  | thrpt |  12 | 50281.723 | ± 601.487 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                         feedfacedeadbeeffeedfacedeadbeefabaddad2 | thrpt |  12 |  1941.870 | ±   7.376 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                                 0388dace60b6a392f328c2b971b2fe78 | thrpt |  12 |  2259.776 | ±  22.900 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e | 42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091473f5985 | thrpt |  12 |   603.967 | ±   4.983 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |         42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091 | thrpt |  12 |   735.614 | ±   4.613 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |         61353b4c2806934a777ff51fa22a4755699b2a714fcdc6f83766e5f97b6c742373806900e49f24b22b097544d4896b424989b5e1ebac0f07c23f4598 | thrpt |  12 |   739.100 | ±   4.419 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                                                                  | thrpt |  12 | 50318.175 | ± 661.485 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                         feedfacedeadbeeffeedfacedeadbeefabaddad2 | thrpt |  12 |  1935.131 | ±   9.423 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                                 0388dace60b6a392f328c2b971b2fe78 | thrpt |  12 |  2275.138 | ±   5.639 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 | 42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091473f5985 | thrpt |  12 |   602.985 | ±   5.286 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |         42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091 | thrpt |  12 |   735.850 | ±   6.383 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |         61353b4c2806934a777ff51fa22a4755699b2a714fcdc6f83766e5f97b6c742373806900e49f24b22b097544d4896b424989b5e1ebac0f07c23f4598 | thrpt |  12 |   737.908 | ±   4.919 | ops/ms |

- enabled:

| Benchmark                      |                    (HashSubkey)   |                                                                                                                 (InputBlocks)    | Mode  | Cnt |  Score    | Error     | Units  |
| ------------------------------ | --------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- | ----- | --- | --------- | --------- | ------ |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                                                                  | thrpt |  12 | 50710.765 | ± 350.944 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                         feedfacedeadbeeffeedfacedeadbeefabaddad2 | thrpt |  12 |  3861.183 | ± 105.308 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                                 0388dace60b6a392f328c2b971b2fe78 | thrpt |  12 |  5451.588 | ±  55.204 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e | 42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091473f5985 | thrpt |  12 |  1553.891 | ±  26.349 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |         42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091 | thrpt |  12 |  1671.687 | ±  28.528 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |         61353b4c2806934a777ff51fa22a4755699b2a714fcdc6f83766e5f97b6c742373806900e49f24b22b097544d4896b424989b5e1ebac0f07c23f4598 | thrpt |  12 |  1674.842 | ±  17.281 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                                                                  | thrpt |  12 | 50160.262 | ± 466.134 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                         feedfacedeadbeeffeedfacedeadbeefabaddad2 | thrpt |  12 |  3849.996 | ±  25.854 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                                 0388dace60b6a392f328c2b971b2fe78 | thrpt |  12 |  5435.584 | ±  62.083 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 | 42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091473f5985 | thrpt |  12 |  1539.089 | ±  23.680 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |         42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091 | thrpt |  12 |  1677.438 | ±  14.646 | ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |         61353b4c2806934a777ff51fa22a4755699b2a714fcdc6f83766e5f97b6c742373806900e49f24b22b097544d4896b424989b5e1ebac0f07c23f4598 | thrpt |  12 |  1675.274 | ±   8.727 | ops/ms |

- final results:

| Benchmark                      |                    (HashSubkey)   |                                                                                                                 (InputBlocks)    | Mode  | Cnt |  Score difference (enabled - disabled)    | Error (enabled + disabled)   | % of score (100% * difference / enabled)  | Units   |
| ------------------------------ | --------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- | ----- | --- | ----------------------------------------- | ---------------------------- | ----------------------------------------  | ------- |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                                                                  | thrpt |  12 |                                   429,042 |                   ± 952,431  |                              0,846057%    |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                         feedfacedeadbeeffeedfacedeadbeefabaddad2 | thrpt |  12 |                                 1919,313  |                   ± 112,684  |                            49,7079004%    |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |                                                                                                 0388dace60b6a392f328c2b971b2fe78 | thrpt |  12 |                                 3191,812  |                   ±  78,104  |                            58,5482982%    |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e | 42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091473f5985 | thrpt |  12 |                                  949,924  |                   ± 31,332   |                            61,1319584%    |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |         42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091 | thrpt |  12 |                                  936,073  |                   ± 33,141   |                            55,9957097%    |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  66e94bd4ef8a2c3b884cfa59ca342b2e |         61353b4c2806934a777ff51fa22a4755699b2a714fcdc6f83766e5f97b6c742373806900e49f24b22b097544d4896b424989b5e1ebac0f07c23f4598 | thrpt |  12 |                                  935,742  |                   ±    21,7  |                             55,8704642%   |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                                                                  | thrpt |  12 |                                   157,913 |                   ± 1127,619 |                            0,3148169%     |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                         feedfacedeadbeeffeedfacedeadbeefabaddad2 | thrpt |  12 |                                  1914,865 |                   ±  35,277  |                            49,7368049%    |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |                                                                                                 0388dace60b6a392f328c2b971b2fe78 | thrpt |  12 |                                 3160,446  |                   ± 67,722   |                            58,1436328%    |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 | 42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091473f5985 | thrpt |  12 |                                   936,104 |                   ± 28,966   |                            60,8219538%    |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |         42831ec2217774244b7221b784d0d49ce3aa212f2c02a4e035c17e2329aca12e21d514b25466931c7d8f6a5aac84aa051ba30b396a0aac973d58e091 | thrpt |  12 |                                  941,588  |                   ± 21,029   |                            56,1325068%    |  ops/ms |
| GHASH.TestGHASH.updateGHASHStr |  b83b533708bf535d0aa6e52980d53b78 |         61353b4c2806934a777ff51fa22a4755699b2a714fcdc6f83766e5f97b6c742373806900e49f24b22b097544d4896b424989b5e1ebac0f07c23f4598 | thrpt |  12 |                                  937,366  |                   ± 13,646   |                            55,9529963%    |  ops/ms |

Average % of score: 46,933591617%.

### [ChaCha20 microbench](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/ChaCha20)

Intrinsic name: `_chacha20Block`.

- disabled:

| Benchmark                                  | (dataSize) |  (keyLength) | (mode) | (padding)  | (permutation) | (provider) | Mode  | Cnt |  Score     | Error     | Units |
| ------------------------------------------ | ---------- | ------------ | ------ | ---------- | ------------- | ---------- | ----- | --- | ---------- | --------- | ----- |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |        256 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 | 207844.048 | ± 400.550 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       1024 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  58724.011 | ±  63.746 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       4096 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  15210.577 | ±  15.263 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |      16384 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |   3766.839 | ±   8.088 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |        256 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 | 196321.074 | ± 846.428 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       1024 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  57332.821 | ± 147.301 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       4096 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  14866.561 | ± 108.740 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |      16384 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |   3766.459 | ±  14.210 | ops/s |

- enabled:

| Benchmark                                  | (dataSize) |  (keyLength) | (mode) | (padding)  | (permutation) | (provider) | Mode  | Cnt |  Score     | Error     | Units |
| ------------------------------------------ | ---------- | ------------ | ------ | ---------- | ------------- | ---------- | ----- | --- | ---------- | --------- | ----- |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |        256 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 | 216811.202 | ± 337.503 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       1024 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  62062.530 | ±  93.727 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       4096 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  16076.071 | ±  11.911 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |      16384 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |   4053.652 | ±   4.951 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |        256 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 | 207112.833 | ± 632.957 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       1024 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  61341.314 | ± 117.296 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       4096 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |  16108.575 | ±  40.331 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |      16384 |         256  |  None  | NoPadding  |     ChaCha20  |            | thrpt |  40 |   4047.235 | ±   6.854 | ops/s |

- final results:

| Benchmark                                  | (dataSize) | Score difference (enabled - disabled)    | Error (enabled + disabled) | % of score (100% * difference / enabled) | Units |
| ------------------------------------------ | ---------- |  --------------------------------------- | -------------------------- | ---------------------------------------- | ----- |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |        256 |                                 8967,154 |                  ± 738,053 |                               4.1359274% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       1024 |                                 3338,519 |                  ± 157,473 |                               5.3792828% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |       4096 |                                  865,494 |                   ± 27,174 |                               5.3837408% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt |      16384 |                                  286,813 |                   ± 13,039 |                               7.0754224% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |        256 |                                10791,759 |                 ± 1479,385 |                               5.2105699% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       1024 |                                 4008,493 |                  ± 254,597 |                               6.5347361% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |       4096 |                                 1242,014 |                  ± 149,071 |                               7.7102661% | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt |      16384 |                                  280,776 |                   ± 21,064 |                               6.9374771% | ops/s |

Average % of score: 6.0459278%.

### [AES microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/AES)

Intrinsics name: `_aescrypt_encryptBlock`, `_aescrypt_decryptBlock`.

- Both disabled:

| Benchmark            |          (algorithm) | (dataSize) | (keyLength) | (provider) | Mode  | Cnt |      Score |      Error | Units |
| -------------------- | -------------------- | ---------- | ----------- | ---------- | ----- | --- | ---------- | ---------- | ----- |
| AES.AESBench.decrypt |    AES/ECB/NoPadding |      16384 |         128 |            | thrpt |  40 |   5812.169 | ±   24.470 | ops/s |
| AES.AESBench.decrypt |    AES/ECB/NoPadding |      16384 |         192 |            | thrpt |  40 |   4605.663 | ±    9.460 | ops/s |
| AES.AESBench.decrypt |    AES/ECB/NoPadding |      16384 |         256 |            | thrpt |  40 |   3975.306 | ±    8.243 | ops/s |
| AES.AESBench.decrypt | AES/ECB/PKCS5Padding |      16384 |         128 |            | thrpt |  40 |   5560.733 | ±   17.044 | ops/s |
| AES.AESBench.decrypt | AES/ECB/PKCS5Padding |      16384 |         192 |            | thrpt |  40 |   4412.294 | ±    8.244 | ops/s |
| AES.AESBench.decrypt | AES/ECB/PKCS5Padding |      16384 |         256 |            | thrpt |  40 |   3838.535 | ±    3.853 | ops/s |
| AES.AESBench.decrypt |    AES/CBC/NoPadding |      16384 |         128 |            | thrpt |  40 |  95030.039 | ± 1397.866 | ops/s |
| AES.AESBench.decrypt |    AES/CBC/NoPadding |      16384 |         192 |            | thrpt |  40 |  84698.599 | ±  747.762 | ops/s |
| AES.AESBench.decrypt |    AES/CBC/NoPadding |      16384 |         256 |            | thrpt |  40 |  78549.749 | ± 3637.798 | ops/s |
| AES.AESBench.decrypt | AES/CBC/PKCS5Padding |      16384 |         128 |            | thrpt |  40 |  63699.390 | ±  752.751 | ops/s |
| AES.AESBench.decrypt | AES/CBC/PKCS5Padding |      16384 |         192 |            | thrpt |  40 |  60784.155 | ±  530.777 | ops/s |
| AES.AESBench.decrypt | AES/CBC/PKCS5Padding |      16384 |         256 |            | thrpt |  40 |  54477.348 | ±  510.683 | ops/s |
| AES.AESBench.encrypt |    AES/ECB/NoPadding |      16384 |         128 |            | thrpt |  40 |   5296.348 | ±   21.457 | ops/s |
| AES.AESBench.encrypt |    AES/ECB/NoPadding |      16384 |         192 |            | thrpt |  40 |   4446.341 | ±    7.930 | ops/s |
| AES.AESBench.encrypt |    AES/ECB/NoPadding |      16384 |         256 |            | thrpt |  40 |   3981.547 | ±    5.300 | ops/s |
| AES.AESBench.encrypt | AES/ECB/PKCS5Padding |      16384 |         128 |            | thrpt |  40 |    5116.05 | ±    9.138 | ops/s |
| AES.AESBench.encrypt | AES/ECB/PKCS5Padding |      16384 |         192 |            | thrpt |  40 |   4346.175 | ±    7.473 | ops/s |
| AES.AESBench.encrypt | AES/ECB/PKCS5Padding |      16384 |         256 |            | thrpt |  40 |   3893.182 | ±    6.340 | ops/s |
| AES.AESBench.encrypt |    AES/CBC/NoPadding |      16384 |         128 |            | thrpt |  40 |  58489.877 | ±  376.367 | ops/s |
| AES.AESBench.encrypt |    AES/CBC/NoPadding |      16384 |         192 |            | thrpt |  40 |  53254.766 | ±  318.089 | ops/s |
| AES.AESBench.encrypt |    AES/CBC/NoPadding |      16384 |         256 |            | thrpt |  40 |  48750.947 | ±  250.975 | ops/s |
| AES.AESBench.encrypt | AES/CBC/PKCS5Padding |      16384 |         128 |            | thrpt |  40 |  35505.850 | ± 2454.107 | ops/s |
| AES.AESBench.encrypt | AES/CBC/PKCS5Padding |      16384 |         192 |            | thrpt |  40 |  33397.509 | ±  238.474 | ops/s |
| AES.AESBench.encrypt | AES/CBC/PKCS5Padding |      16384 |         256 |            | thrpt |  40 |  31405.066 | ±  159.094 | ops/s |

- Both enabled:

| Benchmark            |          (algorithm)  | (dataSize) | (keyLength) | (provider) | Mode  | Cnt |   Score    |    Error   | Units |
| -------------------- | --------------------- | ---------- | ----------- | ---------- | ----- | --- | ---------- | ---------- | ----- |
| AES.AESBench.decrypt |    AES/ECB/NoPadding  |     16384  |        128  |            | thrpt |  40 |  52335.609 | ±  905.229 | ops/s |
| AES.AESBench.decrypt |    AES/ECB/NoPadding  |     16384  |        192  |            | thrpt |  40 |  46720.021 | ±  348.721 | ops/s |
| AES.AESBench.decrypt |    AES/ECB/NoPadding  |     16384  |        256  |            | thrpt |  40 |  44423.724 | ±  811.524 | ops/s |
| AES.AESBench.decrypt | AES/ECB/PKCS5Padding  |     16384  |        128  |            | thrpt |  40 |  41376.741 | ± 2816.881 | ops/s |
| AES.AESBench.decrypt | AES/ECB/PKCS5Padding  |     16384  |        192  |            | thrpt |  40 |  36832.130 | ± 1062.863 | ops/s |
| AES.AESBench.decrypt | AES/ECB/PKCS5Padding  |     16384  |        256  |            | thrpt |  40 |  35960.606 | ±  747.582 | ops/s |
| AES.AESBench.decrypt |    AES/CBC/NoPadding  |     16384  |        128  |            | thrpt |  40 |  94281.506 | ±  906.098 | ops/s |
| AES.AESBench.decrypt |    AES/CBC/NoPadding  |     16384  |        192  |            | thrpt |  40 |  85267.275 | ± 1083.228 | ops/s |
| AES.AESBench.decrypt |    AES/CBC/NoPadding  |     16384  |        256  |            | thrpt |  40 |  78683.574 | ± 3656.519 | ops/s |
| AES.AESBench.decrypt | AES/CBC/PKCS5Padding  |     16384  |        128  |            | thrpt |  40 |  63955.424 | ±  531.947 | ops/s |
| AES.AESBench.decrypt | AES/CBC/PKCS5Padding  |     16384  |        192  |            | thrpt |  40 |  60262.148 | ±  595.572 | ops/s |
| AES.AESBench.decrypt | AES/CBC/PKCS5Padding  |     16384  |        256  |            | thrpt |  40 |  56188.187 | ±  733.131 | ops/s |
| AES.AESBench.encrypt |    AES/ECB/NoPadding  |     16384  |        128  |            | thrpt |  40 |  47505.660 | ± 1311.024 | ops/s |
| AES.AESBench.encrypt |    AES/ECB/NoPadding  |     16384  |        192  |            | thrpt |  40 |  42901.098 | ±  852.342 | ops/s |
| AES.AESBench.encrypt |    AES/ECB/NoPadding  |     16384  |        256  |            | thrpt |  40 |  42840.861 | ± 1370.698 | ops/s |
| AES.AESBench.encrypt | AES/ECB/PKCS5Padding  |     16384  |        128  |            | thrpt |  40 |  33631.211 | ±  218.274 | ops/s |
| AES.AESBench.encrypt | AES/ECB/PKCS5Padding  |     16384  |        192  |            | thrpt |  40 |  32185.563 | ±  816.398 | ops/s |
| AES.AESBench.encrypt | AES/ECB/PKCS5Padding  |     16384  |        256  |            | thrpt |  40 |  29275.762 | ±  653.653 | ops/s |
| AES.AESBench.encrypt |    AES/CBC/NoPadding  |     16384  |        128  |            | thrpt |  40 |  58633.413 | ±  444.196 | ops/s |
| AES.AESBench.encrypt |    AES/CBC/NoPadding  |     16384  |        192  |            | thrpt |  40 |  53315.779 | ±  327.415 | ops/s |
| AES.AESBench.encrypt |    AES/CBC/NoPadding  |     16384  |        256  |            | thrpt |  40 |  48617.177 | ±  340.470 | ops/s |
| AES.AESBench.encrypt | AES/CBC/PKCS5Padding  |     16384  |        128  |            | thrpt |  40 |  35704.127 | ± 1544.239 | ops/s |
| AES.AESBench.encrypt | AES/CBC/PKCS5Padding  |     16384  |        192  |            | thrpt |  40 |  33408.501 | ±  223.982 | ops/s |
| AES.AESBench.encrypt | AES/CBC/PKCS5Padding  |     16384  |        256  |            | thrpt |  40 |  31455.608 | ±  217.757 | ops/s |

- Final results:

| Benchmark            |          (algorithm)  | (dataSize) | (keyLength) |      Score difference (enabled - disabled) | Error (enabled + disabled) | % of score (100% * difference / enabled) | Units |
| -------------------- | --------------------- | ---------- | ----------- | ------------------------------------------ | -------------------------- | ---------------------------------------- | ----- |
| AES.AESBench.decrypt |    AES/ECB/NoPadding  |     16384  |        128  |                                  46523.440 |                 ± 1594.854 |                              88.8944264% | ops/s |
| AES.AESBench.decrypt |    AES/ECB/NoPadding  |     16384  |        192  |                                  42114.358 |                 ±  861.467 |                              90.1419924% | ops/s |
| AES.AESBench.decrypt |    AES/ECB/NoPadding  |     16384  |        256  |                                  40448.418 |                 ±  269.797 |                              91.0513885% | ops/s |
| AES.AESBench.decrypt | AES/ECB/PKCS5Padding  |     16384  |        128  |                                  35816.008 |                 ±  534.284 |                              86.5607256% | ops/s |
| AES.AESBench.decrypt | AES/ECB/PKCS5Padding  |     16384  |        192  |                                  32419.836 |                 ±  574.952 |                              88.0205283% | ops/s |
| AES.AESBench.decrypt | AES/ECB/PKCS5Padding  |     16384  |        256  |                                  32122.071 |                 ±  237.700 |                              89.3257205% | ops/s |
| AES.AESBench.decrypt |    AES/CBC/NoPadding  |     16384  |        128  |                                   -748.534 |                 ± 5583.461 |                              -0.7939351% | ops/s |
| AES.AESBench.decrypt |    AES/CBC/NoPadding  |     16384  |        192  |                                    568.676 |                 ± 3739.233 |                               0.6669335% | ops/s |
| AES.AESBench.decrypt |    AES/CBC/NoPadding  |     16384  |        256  |                                    133.825 |                 ± 1067.948 |                               0.1700800% | ops/s |
| AES.AESBench.decrypt | AES/CBC/PKCS5Padding  |     16384  |        128  |                                    256.034 |                  ± 737.258 |                               0.4003320% | ops/s |
| AES.AESBench.decrypt | AES/CBC/PKCS5Padding  |     16384  |        192  |                                   -522.007 |                  ± 660.422 |                               -0.8662270 | ops/s |
| AES.AESBench.decrypt | AES/CBC/PKCS5Padding  |     16384  |        256  |                                   1710.839 |                 ± 3647.668 |                               3.0448375% | ops/s |
| AES.AESBench.encrypt |    AES/ECB/NoPadding  |     16384  |        128  |                                  42209.311 |                  ± 611.830 |                              88.8511195% | ops/s |
| AES.AESBench.encrypt |    AES/ECB/NoPadding  |     16384  |        192  |                                  38454.756 |                 ± 1213.342 |                              89.6358311% | ops/s |
| AES.AESBench.encrypt |    AES/ECB/NoPadding  |     16384  |        256  |                                  38859.313 |                  ± 946.677 |                              90.7061904% | ops/s |
| AES.AESBench.encrypt | AES/ECB/PKCS5Padding  |     16384  |        128  |                                  28515.155 |                 ±  324.563 |                              84.7877717% | ops/s |
| AES.AESBench.encrypt | AES/ECB/PKCS5Padding  |     16384  |        192  |                                  27839.388 |                 ±  454.722 |                              86.4965071% | ops/s |
| AES.AESBench.encrypt | AES/ECB/PKCS5Padding  |     16384  |        256  |                                  25382.579 |                 ±  648.028 |                              86.7016847% | ops/s |
| AES.AESBench.encrypt |    AES/CBC/NoPadding  |     16384  |        128  |                                    143.536 |                 ±  678.473 |                               0.2448024% | ops/s |
| AES.AESBench.encrypt |    AES/CBC/NoPadding  |     16384  |        192  |                                     61.014 |                 ±  469.952 |                               0.1144389% | ops/s |
| AES.AESBench.encrypt |    AES/CBC/NoPadding  |     16384  |        256  |                                   -133.770 |                 ±  574.601 |                              -0.2751497% | ops/s |
| AES.AESBench.encrypt | AES/CBC/PKCS5Padding  |     16384  |        128  |                                    198.277 |                  ± 283.476 |                               0.5553336% | ops/s |
| AES.AESBench.encrypt | AES/CBC/PKCS5Padding  |     16384  |        192  |                                     10.993 |                 ±  294.511 |                               0.0329048% | ops/s |
| AES.AESBench.encrypt | AES/CBC/PKCS5Padding  |     16384  |        256  |                                     50.542 |                 ±  339.186 |                               0.1606772% | ops/s |


Intrinsics name: `cipherBlockChaining_decryptAESCrypt`, `_cipherBlockChaining_encryptAESCrypt`.

- Both enabled:

Benchmark                      (algorithm)  (dataSize)  (keyLength)  (provider)   Mode  Cnt      Score      Error  Units
AES.AESBench.decrypt     AES/CBC/NoPadding       16384          128              thrpt   40  98361.975 ± 2432.594  ops/s
AES.AESBench.decrypt     AES/CBC/NoPadding       16384          192              thrpt   40  87581.136 ± 2089.054  ops/s
AES.AESBench.decrypt     AES/CBC/NoPadding       16384          256              thrpt   40  79341.288 ±  439.097  ops/s
AES.AESBench.decrypt  AES/CBC/PKCS5Padding       16384          128              thrpt   40  64062.260 ±  282.793  ops/s
AES.AESBench.decrypt  AES/CBC/PKCS5Padding       16384          192              thrpt   40  60533.969 ±  365.981  ops/s
AES.AESBench.decrypt  AES/CBC/PKCS5Padding       16384          256              thrpt   40  56208.349 ± 1549.510  ops/s
AES.AESBench.encrypt     AES/CBC/NoPadding       16384          128              thrpt   40  58799.729 ±  194.803  ops/s
AES.AESBench.encrypt     AES/CBC/NoPadding       16384          192              thrpt   40  53295.596 ±  195.141  ops/s
AES.AESBench.encrypt     AES/CBC/NoPadding       16384          256              thrpt   40  48360.097 ±  250.391  ops/s
AES.AESBench.encrypt  AES/CBC/PKCS5Padding       16384          128              thrpt   40  35492.881 ±  182.200  ops/s
AES.AESBench.encrypt  AES/CBC/PKCS5Padding       16384          192              thrpt   40  33442.130 ±  162.938  ops/s
AES.AESBench.encrypt  AES/CBC/PKCS5Padding       16384          256              thrpt   40  31362.621 ±  193.425  ops/s


- Both disabled:

AES.AESBench.decrypt     AES/CBC/NoPadding       16384          128              thrpt   40  4843.357 ± 34.868  ops/s
AES.AESBench.decrypt     AES/CBC/NoPadding       16384          192              thrpt   40  4000.361 ±  9.936  ops/s
AES.AESBench.decrypt     AES/CBC/NoPadding       16384          256              thrpt   40  3527.723 ±  5.660  ops/s
AES.AESBench.decrypt  AES/CBC/PKCS5Padding       16384          128              thrpt   40  4711.391 ± 11.732  ops/s
AES.AESBench.decrypt  AES/CBC/PKCS5Padding       16384          192              thrpt   40  3886.881 ±  9.915  ops/s
AES.AESBench.decrypt  AES/CBC/PKCS5Padding       16384          256              thrpt   40  3437.542 ±  5.830  ops/s
AES.AESBench.encrypt     AES/CBC/NoPadding       16384          128              thrpt   40  4727.233 ± 14.824  ops/s
AES.AESBench.encrypt     AES/CBC/NoPadding       16384          192              thrpt   40  4045.838 ± 10.918  ops/s
AES.AESBench.encrypt     AES/CBC/NoPadding       16384          256              thrpt   40  3656.357 ± 11.961  ops/s
AES.AESBench.encrypt  AES/CBC/PKCS5Padding       16384          128              thrpt   40  4543.346 ±  6.738  ops/s
AES.AESBench.encrypt  AES/CBC/PKCS5Padding       16384          192              thrpt   40  3912.668 ±  8.405  ops/s
AES.AESBench.encrypt  AES/CBC/PKCS5Padding       16384          256              thrpt   40  3534.509 ±  7.812  ops/s


Intrinsic name: `_counterMode_AESCrypt`.

- Enabled:

Benchmark                   (algorithm)  (dataSize)  (keyLength)  (provider)   Mode  Cnt       Score      Error  Units
AES.AESBench.decrypt  AES/CTR/NoPadding       16384          128              thrpt   40  100645.692 ± 4013.679  ops/s
AES.AESBench.decrypt  AES/CTR/NoPadding       16384          192              thrpt   40   88314.073 ± 2781.598  ops/s
AES.AESBench.decrypt  AES/CTR/NoPadding       16384          256              thrpt   40   80141.006 ± 1972.228  ops/s
AES.AESBench.encrypt  AES/CTR/NoPadding       16384          128              thrpt   40  102624.785 ± 3051.622  ops/s
AES.AESBench.encrypt  AES/CTR/NoPadding       16384          192              thrpt   40   88222.155 ± 3093.865  ops/s
AES.AESBench.encrypt  AES/CTR/NoPadding       16384          256              thrpt   40   81248.308 ± 2148.645  ops/s

- Disabled:

Benchmark                   (algorithm)  (dataSize)  (keyLength)  (provider)   Mode  Cnt     Score    Error  Units
AES.AESBench.decrypt  AES/CTR/NoPadding       16384          128              thrpt   40  4155.513 ± 22.447  ops/s
AES.AESBench.decrypt  AES/CTR/NoPadding       16384          192              thrpt   40  3644.200 ± 14.133  ops/s
AES.AESBench.decrypt  AES/CTR/NoPadding       16384          256              thrpt   40  3316.264 ± 12.483  ops/s
AES.AESBench.encrypt  AES/CTR/NoPadding       16384          128              thrpt   40  4163.476 ±  9.336  ops/s
AES.AESBench.encrypt  AES/CTR/NoPadding       16384          192              thrpt   40  3637.040 ± 14.382  ops/s
AES.AESBench.encrypt  AES/CTR/NoPadding       16384          256              thrpt   40  3312.446 ± 13.983  ops/s


Intrinsics name: `_electronicCodeBook_decryptAESCrypt`, `_electronicCodeBook_encryptAESCrypt`.

- Both enabled:

Benchmark                      (algorithm)  (dataSize)  (keyLength)  (provider)   Mode  Cnt     Score    Error  Units
AES.AESBench.decrypt     AES/ECB/NoPadding       16384          128              thrpt   40  5777.190 ± 25.132  ops/s
AES.AESBench.decrypt     AES/ECB/NoPadding       16384          192              thrpt   40  4594.303 ± 11.090  ops/s
AES.AESBench.decrypt     AES/ECB/NoPadding       16384          256              thrpt   40  3973.631 ± 16.785  ops/s
AES.AESBench.decrypt  AES/ECB/PKCS5Padding       16384          128              thrpt   40  5542.104 ± 13.058  ops/s
AES.AESBench.decrypt  AES/ECB/PKCS5Padding       16384          192              thrpt   40  4394.295 ± 12.109  ops/s
AES.AESBench.decrypt  AES/ECB/PKCS5Padding       16384          256              thrpt   40  3823.424 ±  9.662  ops/s
AES.AESBench.encrypt     AES/ECB/NoPadding       16384          128              thrpt   40  5302.327 ± 20.088  ops/s
AES.AESBench.encrypt     AES/ECB/NoPadding       16384          192              thrpt   40  4441.246 ± 15.692  ops/s
AES.AESBench.encrypt     AES/ECB/NoPadding       16384          256              thrpt   40  3958.587 ±  9.024  ops/s
AES.AESBench.encrypt  AES/ECB/PKCS5Padding       16384          128              thrpt   40  5098.785 ±  9.628  ops/s
AES.AESBench.encrypt  AES/ECB/PKCS5Padding       16384          192              thrpt   40  4335.216 ±  8.330  ops/s
AES.AESBench.encrypt  AES/ECB/PKCS5Padding       16384          256              thrpt   40  3878.294 ±  8.865  ops/s

- Both disabled:

AES.AESBench.decrypt     AES/ECB/NoPadding       16384          128              thrpt   40  50318.500 ± 1271.172  ops/s
AES.AESBench.decrypt     AES/ECB/NoPadding       16384          192              thrpt   40  45688.514 ± 1227.200  ops/s
AES.AESBench.decrypt     AES/ECB/NoPadding       16384          256              thrpt   40  44044.193 ±  404.360  ops/s
AES.AESBench.decrypt  AES/ECB/PKCS5Padding       16384          128              thrpt   40  40160.658 ±  542.879  ops/s
AES.AESBench.decrypt  AES/ECB/PKCS5Padding       16384          192              thrpt   40  36172.835 ± 1698.906  ops/s
AES.AESBench.decrypt  AES/ECB/PKCS5Padding       16384          256              thrpt   40  35820.989 ±  675.413  ops/s
AES.AESBench.encrypt     AES/ECB/NoPadding       16384          128              thrpt   40  47145.485 ±  985.241  ops/s
AES.AESBench.encrypt     AES/ECB/NoPadding       16384          192              thrpt   40  45380.545 ±  393.660  ops/s
AES.AESBench.encrypt     AES/ECB/NoPadding       16384          256              thrpt   40  40899.002 ± 1878.081  ops/s
AES.AESBench.encrypt  AES/ECB/PKCS5Padding       16384          128              thrpt   40  32769.163 ±  448.900  ops/s
AES.AESBench.encrypt  AES/ECB/PKCS5Padding       16384          192              thrpt   40  30833.535 ±  317.452  ops/s
AES.AESBench.encrypt  AES/ECB/PKCS5Padding       16384          256              thrpt   40  30452.329 ±  623.586  ops/s

### [AES GCM microbenchmark](https://github.com/ArsenyBochkarev/OpenJDK-RISCV-Intrinsics/tree/main/benchmarks/AESGCM)

Intrinsics name: `_galoisCounterMode_AESCrypt`, `_ghash_processBlocks`.

- Both enabled:

| Benchmark                           |  (dataSize) | (keyLength) | (provider) |  Mode | Cnt  |     Score   |   Error | Units |
| ----------------------------------- | --------- | ------------- | ---------- | ------ | --- | --------- | ------- | --------- |
| AESGCM.AESGCMBench.decrypt            |     1024  |        128   |         |  thrpt |  40 | 28629.640 | ± 157.278 | ops/s |
| AESGCM.AESGCMBench.decrypt            |     1500  |        128   |         |  thrpt |  40 | 19960.400 | ± 111.239 | ops/s |
| AESGCM.AESGCMBench.decrypt            |     4096  |        128   |         |  thrpt |  40 |  7391.601 | ±  84.120 | ops/s |
| AESGCM.AESGCMBench.decrypt            |    16384  |        128   |         |  thrpt |  40 |  1879.423 | ±   5.485 | ops/s |
| AESGCM.AESGCMBench.decryptMultiPart   |     1024  |        128   |         |  thrpt |  40 | 27471.354 | ± 543.842 | ops/s |
| AESGCM.AESGCMBench.decryptMultiPart   |     1500  |        128   |         |  thrpt |  40 | 18791.903 | ± 196.276 | ops/s |
| AESGCM.AESGCMBench.decryptMultiPart   |     4096  |        128   |         |  thrpt |  40 |  6939.279 | ± 113.761 | ops/s |
| AESGCM.AESGCMBench.decryptMultiPart   |    16384  |        128   |         |  thrpt |  40 |  1775.320 | ±   8.054 | ops/s |
| AESGCM.AESGCMBench.encrypt            |     1024  |        128   |         |  thrpt |  40 | 28664.292 | ±  89.116 | ops/s |
| AESGCM.AESGCMBench.encrypt            |     1500  |        128   |         |  thrpt |  40 | 20067.191 | ±  65.471 | ops/s |
| AESGCM.AESGCMBench.encrypt            |     4096  |        128   |         |  thrpt |  40 |  7439.510 | ±  16.257 | ops/s |
| AESGCM.AESGCMBench.encrypt            |    16384  |        128   |         |  thrpt |  40 |  1885.435 | ±   4.602 | ops/s |
| AESGCM.AESGCMBench.encryptMultiPart   |     1024  |        128   |         |  thrpt |  40 | 28956.128 | ± 116.421 | ops/s |
| AESGCM.AESGCMBench.encryptMultiPart   |     1500  |        128   |         |  thrpt |  40 | 20073.467 | ±  61.345 | ops/s |
| AESGCM.AESGCMBench.encryptMultiPart   |     4096  |        128   |         |  thrpt |  40 |  7550.418 | ±  15.691 | ops/s |
| AESGCM.AESGCMBench.encryptMultiPart   |    16384  |        128   |         |  thrpt |  40 |  1917.206 | ±   2.695 | ops/s |


- Both disabled:

| Benchmark                           |  (dataSize) | (keyLength) | (provider) |  Mode | Cnt  |     Score   |   Error | Units |
| ----------------------------------- | --------- | ------------- | ---------- | ------ | --- | --------- | ------- | --------- |
| AESGCM.AESGCMBench.decrypt          |        1024   |       128  |          |  thrpt |  40 | 732979.029 | ± 3582.790 | ops/s |
| AESGCM.AESGCMBench.decrypt          |        1500   |       128  |          |  thrpt |  40 | 556122.197 | ± 2207.465 | ops/s |
| AESGCM.AESGCMBench.decrypt          |        4096   |       128  |          |  thrpt |  40 | 271242.259 | ±  830.528 | ops/s |
| AESGCM.AESGCMBench.decrypt          |       16384   |       128  |          |  thrpt |  40 |  87294.299 | ±  546.174 | ops/s |
| AESGCM.AESGCMBench.decryptMultiPart |        1024   |       128  |          |  thrpt |  40 | 528068.116 | ± 4941.682 | ops/s |
| AESGCM.AESGCMBench.decryptMultiPart |       1500    |      128   |          | thrpt |  40 | 357223.610 | ± 3322.837 | ops/s |
| AESGCM.AESGCMBench.decryptMultiPart |       4096    |      128   |          | thrpt |  40 | 178375.798 | ±  841.213 | ops/s |
| AESGCM.AESGCMBench.decryptMultiPart |      16384    |      128   |          | thrpt |  40 |  52347.426 | ±  300.038 | ops/s |
| AESGCM.AESGCMBench.encrypt          |       1024    |      128   |          | thrpt |  40 | 750102.928 | ± 8455.104 | ops/s |
| AESGCM.AESGCMBench.encrypt          |       1500    |      128    |         | thrpt |  40 | 572344.185 | ± 5617.239 | ops/s |
| AESGCM.AESGCMBench.encrypt          |       4096    |      128    |         | thrpt |  40 | 272109.045 | ±  807.501 | ops/s |
| AESGCM.AESGCMBench.encrypt          |      16384    |      128    |         | thrpt |  40 |  86756.289 | ±  684.782 | ops/s |
| AESGCM.AESGCMBench.encryptMultiPart |       1024    |      128    |         | thrpt |  40 | 714129.803 | ± 2074.856 | ops/s |
| AESGCM.AESGCMBench.encryptMultiPart |       1500    |      128    |         | thrpt |  40 | 495959.068 | ± 1736.952 | ops/s |
| AESGCM.AESGCMBench.encryptMultiPart |       4096    |      128    |         | thrpt |  40 | 267605.590 | ±  837.379 | ops/s |
| AESGCM.AESGCMBench.encryptMultiPart |      16384    |      128    |         | thrpt |  40 |  86216.486 | ±  551.756 | ops/s |

All tests were run on:

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915)
OpenJDK 64-Bit Server VM (build 22-testing-builds.shipilev.net-openjdk-jdk-b559-20230915, mixed mode)
```

with additional flags: `-XX:+UnlockDiagnosticVMOptions -XX:DisableIntrinsic=<intrinsic name>` (where needed).

### Full test stand overview

#### Raspberry Pi 4

```
$ uname -a
Linux raspbpi4 5.15.0-1012-raspi #14-Ubuntu SMP PREEMPT Fri Jun 24 13:10:28 UTC 2022 aarch64 aarch64 aarch64 GNU/Linux
```

```
$ lscpu
Architecture:            aarch64
  CPU op-mode(s):        32-bit, 64-bit
  Byte Order:            Little Endian
CPU(s):                  4
  On-line CPU(s) list:   0-3
Vendor ID:               ARM
  Model name:            Cortex-A72
    Model:               3
    Thread(s) per core:  1
    Core(s) per cluster: 4
    Socket(s):           -
    Cluster(s):          1
    Stepping:            r0p3
    CPU max MHz:         1500.0000
    CPU min MHz:         600.0000
    BogoMIPS:            108.00
    Flags:               fp asimd evtstrm crc32 cpuid
Caches (sum of all):     
  L1d:                   128 KiB (4 instances)
  L1i:                   192 KiB (4 instances)
  L2:                    1 MiB (1 instance)
Vulnerabilities:         
  Gather data sampling:  Not affected
  Itlb multihit:         Not affected
  L1tf:                  Not affected
  Mds:                   Not affected
  Meltdown:              Not affected
  Mmio stale data:       Not affected
  Retbleed:              Not affected
  Spec store bypass:     Vulnerable
  Spectre v1:            Mitigation; __user pointer sanitization
  Spectre v2:            Vulnerable
  Srbds:                 Not affected
  Tsx async abort:       Not affected
```

```
$ cat /proc/cpuinfo
processor       : 0
BogoMIPS        : 108.00
Features        : fp asimd evtstrm crc32 cpuid
CPU implementer : 0x41
CPU architecture: 8
CPU variant     : 0x0
CPU part        : 0xd08
CPU revision    : 3

processor       : 1
BogoMIPS        : 108.00
Features        : fp asimd evtstrm crc32 cpuid
CPU implementer : 0x41
CPU architecture: 8
CPU variant     : 0x0
CPU part        : 0xd08
CPU revision    : 3

processor       : 2
BogoMIPS        : 108.00
Features        : fp asimd evtstrm crc32 cpuid
CPU implementer : 0x41
CPU architecture: 8
CPU variant     : 0x0
CPU part        : 0xd08
CPU revision    : 3

processor       : 3
BogoMIPS        : 108.00
Features        : fp asimd evtstrm crc32 cpuid
CPU implementer : 0x41
CPU architecture: 8
CPU variant     : 0x0
CPU part        : 0xd08
CPU revision    : 3

Hardware        : BCM2835
Revision        : d03114
Serial          : 1000000089722afc
Model           : Raspberry Pi 4 Model B Rev 1.4
```

Due to Raspberry Pi 4 overheating issues, the CPU frequency was set to minimum (600 Mhz):

Before disabling:
```
ubuntu@raspbpi4:~$ cpufreq-info
cpufrequtils 008: cpufreq-info (C) Dominik Brodowski 2004-2009
Report errors and bugs to cpufreq@vger.kernel.org, please.
analyzing CPU 0:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 1.50 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 900 MHz.
  cpufreq stats: 600 MHz:53.95%, 700 MHz:6.24%, 800 MHz:2.14%, 900 MHz:1.36%, 1000 MHz:1.25%, 1.10 GHz:0.93%, 1.20 GHz:0.68%, 1.30 GHz:0.62%, 1.40 GHz:0.45%, 1.50 GHz:32.37%  (1975886)
analyzing CPU 1:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 1.50 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 900 MHz.
  cpufreq stats: 600 MHz:53.95%, 700 MHz:6.24%, 800 MHz:2.14%, 900 MHz:1.36%, 1000 MHz:1.25%, 1.10 GHz:0.93%, 1.20 GHz:0.68%, 1.30 GHz:0.62%, 1.40 GHz:0.45%, 1.50 GHz:32.37%  (1975886)
analyzing CPU 2:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 1.50 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 900 MHz.
  cpufreq stats: 600 MHz:53.95%, 700 MHz:6.24%, 800 MHz:2.14%, 900 MHz:1.36%, 1000 MHz:1.25%, 1.10 GHz:0.93%, 1.20 GHz:0.68%, 1.30 GHz:0.62%, 1.40 GHz:0.45%, 1.50 GHz:32.37%  (1975887)
analyzing CPU 3:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 1.50 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 1.40 GHz.
  cpufreq stats: 600 MHz:53.95%, 700 MHz:6.24%, 800 MHz:2.14%, 900 MHz:1.36%, 1000 MHz:1.25%, 1.10 GHz:0.93%, 1.20 GHz:0.68%, 1.30 GHz:0.62%, 1.40 GHz:0.45%, 1.50 GHz:32.37%  (1975887)
```


After disabling:
```
$ cpufreq-info
cpufrequtils 008: cpufreq-info (C) Dominik Brodowski 2004-2009
Report errors and bugs to cpufreq@vger.kernel.org, please.
analyzing CPU 0:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 600 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 600 MHz.
  cpufreq stats: 600 MHz:71.29%, 700 MHz:3.89%, 800 MHz:1.34%, 900 MHz:0.85%, 1000 MHz:0.78%, 1.10 GHz:0.58%, 1.20 GHz:0.42%, 1.30 GHz:0.39%, 1.40 GHz:0.28%, 1.50 GHz:20.18%  (1976771)
analyzing CPU 1:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 600 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 600 MHz.
  cpufreq stats: 600 MHz:71.29%, 700 MHz:3.89%, 800 MHz:1.34%, 900 MHz:0.85%, 1000 MHz:0.78%, 1.10 GHz:0.58%, 1.20 GHz:0.42%, 1.30 GHz:0.39%, 1.40 GHz:0.28%, 1.50 GHz:20.18%  (1976771)
analyzing CPU 2:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 600 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 600 MHz.
  cpufreq stats: 600 MHz:71.29%, 700 MHz:3.89%, 800 MHz:1.34%, 900 MHz:0.85%, 1000 MHz:0.78%, 1.10 GHz:0.58%, 1.20 GHz:0.42%, 1.30 GHz:0.39%, 1.40 GHz:0.28%, 1.50 GHz:20.18%  (1976771)
analyzing CPU 3:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 0.97 ms.
  hardware limits: 600 MHz - 1.50 GHz
  available frequency steps: 600 MHz, 700 MHz, 800 MHz, 900 MHz, 1000 MHz, 1.10 GHz, 1.20 GHz, 1.30 GHz, 1.40 GHz, 1.50 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 600 MHz and 600 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 600 MHz.
  cpufreq stats: 600 MHz:71.29%, 700 MHz:3.89%, 800 MHz:1.34%, 900 MHz:0.85%, 1000 MHz:0.78%, 1.10 GHz:0.58%, 1.20 GHz:0.42%, 1.30 GHz:0.39%, 1.40 GHz:0.28%, 1.50 GHz:20.18%  (1976771)
```

#### Radxa Rock5 Model B
Test stand overview for CRC32, GHASH and AES microbenchmarks:

```
$ uname -a
Linux rock-5b 5.10.110-34-rockchip-gca15bbe36e6c #rockchip SMP Wed Dec 7 06:54:05 UTC 2022 aarch64 aarch64 aarch64 GNU/Linux
```

```
$ lscpu
Architecture:                    aarch64
CPU op-mode(s):                  32-bit, 64-bit
Byte Order:                      Little Endian
CPU(s):                          8
On-line CPU(s) list:             0-7
Thread(s) per core:              1
Core(s) per socket:              2
Socket(s):                       3
Vendor ID:                       ARM
Model:                           0
Model name:                      Cortex-A55
Stepping:                        r2p0
CPU max MHz:                     2400.0000
CPU min MHz:                     408.0000
BogoMIPS:                        48.00
L1d cache:                       256 KiB
L1i cache:                       256 KiB
L2 cache:                        1 MiB
L3 cache:                        3 MiB
Vulnerability Itlb multihit:     Not affected
Vulnerability L1tf:              Not affected
Vulnerability Mds:               Not affected
Vulnerability Meltdown:          Not affected
Vulnerability Spec store bypass: Mitigation; Speculative Store Bypass disabled v
                                 ia prctl
Vulnerability Spectre v1:        Mitigation; __user pointer sanitization
Vulnerability Spectre v2:        Vulnerable: Unprivileged eBPF enabled
Vulnerability Srbds:             Not affected
Vulnerability Tsx async abort:   Not affected
Flags:                           fp asimd evtstrm aes pmull sha1 sha2 crc32 atom
                                 ics fphp asimdhp cpuid asimdrdm lrcpc dcpop asi
                                 mddp
```

```
$ cat /proc/cpuinfo
processor	: 0
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x2
CPU part	: 0xd05
CPU revision	: 0

processor	: 1
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x2
CPU part	: 0xd05
CPU revision	: 0

processor	: 2
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x2
CPU part	: 0xd05
CPU revision	: 0

processor	: 3
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x2
CPU part	: 0xd05
CPU revision	: 0

processor	: 4
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x4
CPU part	: 0xd0b
CPU revision	: 0

processor	: 5
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x4
CPU part	: 0xd0b
CPU revision	: 0

processor	: 6
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x4
CPU part	: 0xd0b
CPU revision	: 0

processor	: 7
BogoMIPS	: 48.00
Features	: fp asimd evtstrm aes pmull sha1 sha2 crc32 atomics fphp asimdhp cpuid asimdrdm lrcpc dcpop asimddp
CPU implementer	: 0x41
CPU architecture: 8
CPU variant	: 0x4
CPU part	: 0xd0b
CPU revision	: 0

Serial		: 1fa0bc2c51185a02
```

Due to possible trottling issues, the CPU frequency was lowered to minimum (408 Mhz) using `cpufreq` utility. 
Before disabling:

```
~$ cpufreq-info
cpufrequtils 008: cpufreq-info (C) Dominik Brodowski 2004-2009
Report errors and bugs to cpufreq@vger.kernel.org, please.
analyzing CPU 0:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 1.42 GHz and 1.61 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 1.42 GHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879807)
analyzing CPU 1:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 1.42 GHz and 1.61 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 1.42 GHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879807)
analyzing CPU 2:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 1.42 GHz and 1.61 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 1.42 GHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879807)
analyzing CPU 3:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 1.42 GHz and 1.61 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 1.42 GHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879807)
analyzing CPU 4:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 4 5
  CPUs which need to have their frequency coordinated by software: 4 5
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.48%, 600 MHz:0.20%, 816 MHz:0.12%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.07%, 2.21 GHz:0.26%, 2.40 GHz:2.45%  (2067300)
analyzing CPU 5:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 4 5
  CPUs which need to have their frequency coordinated by software: 4 5
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.48%, 600 MHz:0.20%, 816 MHz:0.12%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.07%, 2.21 GHz:0.26%, 2.40 GHz:2.45%  (2067300)
analyzing CPU 6:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 6 7
  CPUs which need to have their frequency coordinated by software: 6 7
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.65%, 600 MHz:0.23%, 816 MHz:0.13%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.06%, 2.21 GHz:0.22%, 2.40 GHz:2.28%  (2109260)
analyzing CPU 7:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 6 7
  CPUs which need to have their frequency coordinated by software: 6 7
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.65%, 600 MHz:0.23%, 816 MHz:0.13%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.06%, 2.21 GHz:0.22%, 2.40 GHz:2.28%  (2109260)
```

and after disabling:

```
$ cpufreq-info
cpufrequtils 008: cpufreq-info (C) Dominik Brodowski 2004-2009
Report errors and bugs to cpufreq@vger.kernel.org, please.
analyzing CPU 0:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 408 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879818)
analyzing CPU 1:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 408 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879818)
analyzing CPU 2:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 408 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879818)
analyzing CPU 3:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 0 1 2 3
  CPUs which need to have their frequency coordinated by software: 0 1 2 3
  maximum transition latency: 84.0 us.
  hardware limits: 408 MHz - 1.80 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 408 MHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:6.68%, 600 MHz:0.72%, 816 MHz:0.06%, 1.01 GHz:60.04%, 1.20 GHz:0.02%, 1.42 GHz:29.03%, 1.61 GHz:3.44%, 1.80 GHz:0.01%  (2879818)
analyzing CPU 4:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 4 5
  CPUs which need to have their frequency coordinated by software: 4 5
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.48%, 600 MHz:0.20%, 816 MHz:0.12%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.07%, 2.21 GHz:0.26%, 2.40 GHz:2.45%  (2067300)
analyzing CPU 5:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 4 5
  CPUs which need to have their frequency coordinated by software: 4 5
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.48%, 600 MHz:0.20%, 816 MHz:0.12%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.07%, 2.21 GHz:0.26%, 2.40 GHz:2.45%  (2067300)
analyzing CPU 6:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 6 7
  CPUs which need to have their frequency coordinated by software: 6 7
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.65%, 600 MHz:0.23%, 816 MHz:0.13%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.06%, 2.21 GHz:0.22%, 2.40 GHz:2.28%  (2109260)
analyzing CPU 7:
  driver: cpufreq-dt
  CPUs which run at the same hardware frequency: 6 7
  CPUs which need to have their frequency coordinated by software: 6 7
  maximum transition latency: 324 us.
  hardware limits: 408 MHz - 2.40 GHz
  available frequency steps: 408 MHz, 600 MHz, 816 MHz, 1.01 GHz, 1.20 GHz, 1.42 GHz, 1.61 GHz, 1.80 GHz, 2.02 GHz, 2.21 GHz, 2.40 GHz
  available cpufreq governors: conservative, ondemand, userspace, powersave, performance, schedutil
  current policy: frequency should be within 408 MHz and 2.40 GHz.
                  The governor "ondemand" may decide which speed to use
                  within this range.
  current CPU frequency is 408 MHz.
  cpufreq stats: 408 MHz:96.65%, 600 MHz:0.23%, 816 MHz:0.13%, 1.01 GHz:0.10%, 1.20 GHz:0.11%, 1.42 GHz:0.08%, 1.61 GHz:0.07%, 1.80 GHz:0.06%, 2.02 GHz:0.06%, 2.21 GHz:0.22%, 2.40 GHz:2.28%  (2109260)
```
