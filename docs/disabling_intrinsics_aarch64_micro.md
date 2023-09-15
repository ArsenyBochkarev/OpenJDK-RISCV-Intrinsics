Results on enabling/disabling intrinsics for AArch64 platform:

### [ChaCha20 jmh microbench](https://github.com/openjdk/jdk/blob/master/test/micro/org/openjdk/bench/javax/crypto/full/CipherBench.java#L212):

- disabled:

| Benchmark | (dataSize) | (keyLength) | (mode) | (padding) | (permutation) | (provider) | Mode | Cnt | Score | Error | Units |
|--|--|--|--|--|--|--|--|--|--|--|--|
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 256   | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 456316.299 | ± 12180.723 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 1024  | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 138535.386 | ± 1190.564  | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 4096  | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 36094.544  | ± 1381.519   | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 16384 | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 9108.648   | ± 242.598    | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 256   | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 452528.958 | ± 6252.491  | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 1024  | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 137316.985 | ± 625.280   | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 4096  | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 36364.548  | ± 76.557   | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 16384 | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 9145.344   | ± 60.685    | ops/s |

- enabled:

| Benchmark | (dataSize) | (keyLength) | (mode) | (padding) | (permutation) | (provider) | Mode | Cnt | Score | Error | Units |
|--|--|--|--|--|--|--|--|--|--|--|--|
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 256   | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 486372.227 | ± 12226.477 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 1024  | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 149943.053 | ± 1033.448  | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 4096  | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 39594.900  | ± 130.949   | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 16384 | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 9980.993   | ± 56.326    | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 256   | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 477170.954 | ± 7535.557  | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 1024  | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 148329.106 | ± 660.362   | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 4096  | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 39500.988  | ± 128.961   | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 16384 | 256 | None | NoPadding | ChaCha20 |  | thrpt | 40 | 9954.132   | ± 98.263    | ops/s |

- final results:

| Benchmark | (dataSize) | Score | Error | Units |
|--|--|--|--|--|
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 256   | 30055,928 | ± 24407,2   | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 1024  | 11407,667 | ± 2224,012  | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 4096  | 3500,356  | ± 1512,468  | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.decrypt | 16384 | 872,345   | ± 298,924   | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 256   | 24641,996 | ± 13788,048 | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 1024  | 11012,121 | ± 1285,642  | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 4096  | 3136,44   | ± 205,518   | ops/s |
| ChaCha20.CipherBench.ChaCha20Class.encrypt | 16384 | 808,788   | ± 158,948   | ops/s |


### [Poly1305 jmh microbench](https://github.com/openjdk/jdk/blob/master/test/micro/org/openjdk/bench/javax/crypto/full/Poly1305DigestBench.java):

- disabled:

| Benchmark | (dataSize) | (provider) | Mode | Cnt | Score | Error | Units |
|--|--|--|--|--|--|--|--|
| Poly1305DigestBench.digestBuffer | 64      |  | thrpt | 40 | 408192.554  | ± 24756.514 | ops/s |
| Poly1305DigestBench.digestBuffer | 256     |  | thrpt | 40 | 283801.266  | ± 89832.816 | ops/s |
| Poly1305DigestBench.digestBuffer | 1024    |  | thrpt | 40 | 122885.167  | ± 7844.812  | ops/s |
| Poly1305DigestBench.digestBuffer | 16384   |  | thrpt | 40 | 10246.396   | ± 421.247   | ops/s |
| Poly1305DigestBench.digestBuffer | 1048576 |  | thrpt | 40 | 160.314     | ± 26.593    | ops/s |
| Poly1305DigestBench.digestBytes  | 64      |  | thrpt | 40 | 419785.263  | ± 74915.078 | ops/s |
| Poly1305DigestBench.digestBytes  | 256     |  | thrpt | 40 | 291280.982  | ± 79230.490 | ops/s |
| Poly1305DigestBench.digestBytes  | 1024    |  | thrpt | 40 | 118732.874  | ± 24403.306 | ops/s |
| Poly1305DigestBench.digestBytes  | 16384   |  | thrpt | 40 | 9698.849    | ± 50.834    | ops/s |
| Poly1305DigestBench.digestBytes  | 1048576 |  | thrpt | 40 | 155.083     | ± 10.998    | ops/s |
| Poly1305DigestBench.updateBytes  | 64      |  | thrpt | 40 | 2169341.654 | ± 32746.104 | ops/s |
| Poly1305DigestBench.updateBytes  | 256     |  | thrpt | 40 | 606347.304  | ± 365.631   | ops/s |
| Poly1305DigestBench.updateBytes  | 1024    |  | thrpt | 40 | 159423.675  | ± 935.020   | ops/s |
| Poly1305DigestBench.updateBytes  | 16384   |  | thrpt | 40 | 9941.092    | ± 16.864    | ops/s |
| Poly1305DigestBench.updateBytes  | 1048576 |  | thrpt | 40 | 157.191     | ± 12.532    | ops/s |

- enabled:

| Benchmark | (dataSize) | (provider) | Mode | Cnt | Score | Error | Units |
|--|--|--|--|--|--|--|--|
| Poly1305DigestBench.digestBuffer | 64      |  | thrpt | 40 | 438402.724  | ± 61776.535  | ops/s |
| Poly1305DigestBench.digestBuffer | 256     |  | thrpt | 40 | 383667.994  | ± 104615.379 | ops/s |
| Poly1305DigestBench.digestBuffer | 1024    |  | thrpt | 40 | 231995.020  | ± 31201.699  | ops/s |
| Poly1305DigestBench.digestBuffer | 16384   |  | thrpt | 40 | 25088.180   | ± 1805.592   | ops/s |
| Poly1305DigestBench.digestBuffer | 1048576 |  | thrpt | 40 | 366.941     | ± 1556.345   | ops/s |
| Poly1305DigestBench.digestBytes  | 64      |  | thrpt | 40 | 443187.432  | ± 174740.931 | ops/s |
| Poly1305DigestBench.digestBytes  | 256     |  | thrpt | 40 | 399186.858  | ± 181377.285 | ops/s |
| Poly1305DigestBench.digestBytes  | 1024    |  | thrpt | 40 | 239226.604  | ± 61172.293  | ops/s |
| Poly1305DigestBench.digestBytes  | 16384   |  | thrpt | 40 | 24965.534   | ± 1190.294   | ops/s |
| Poly1305DigestBench.digestBytes  | 1048576 |  | thrpt | 40 | 369.061     | ± 1502.792   | ops/s |
| Poly1305DigestBench.updateBytes  | 64      |  | thrpt | 40 | 4741932.577 | ± 8152.387   | ops/s |
| Poly1305DigestBench.updateBytes  | 256     |  | thrpt | 40 | 1539268.189 | ± 6394.249   | ops/s |
| Poly1305DigestBench.updateBytes  | 1024    |  | thrpt | 40 | 420293.755  | ± 2292.149   | ops/s |
| Poly1305DigestBench.updateBytes  | 16384   |  | thrpt | 40 | 26942.829   | ± 169.665    | ops/s |
| Poly1305DigestBench.updateBytes  | 1048576 |  | thrpt | 40 | 376.803     | ± 1332.892   | ops/s |

- final results:

| Benchmark | (dataSize) | Score | Error | Units |
|--|--|--|--|--|
| Poly1305DigestBench.digestBuffer | 64      | +30210,17    | ± 86533,049  | ops/s |
| Poly1305DigestBench.digestBuffer | 256     | +99866,728   | ± 194448,195 | ops/s |
| Poly1305DigestBench.digestBuffer | 1024    | +109109,853  | ± 39046,511  | ops/s |
| Poly1305DigestBench.digestBuffer | 16384   | +109109,853  | ± 2226,839   | ops/s |
| Poly1305DigestBench.digestBuffer | 1048576 | +206,627     | ± 1582,938   | ops/s |
| Poly1305DigestBench.digestBytes  | 64      | +23402,169   | ± 249656,009 | ops/s |
| Poly1305DigestBench.digestBytes  | 256     | +107905,876  | ± 260607,775 | ops/s |
| Poly1305DigestBench.digestBytes  | 1024    | +120493,73   | ± 85575,599  | ops/s |
| Poly1305DigestBench.digestBytes  | 16384   | +15266,685   | ± 1241,128   | ops/s |
| Poly1305DigestBench.digestBytes  | 1048576 | +213,978     | ± 1513,79    | ops/s |
| Poly1305DigestBench.updateBytes  | 64      | +2572590,923 | ± 40898,491  | ops/s |
| Poly1305DigestBench.updateBytes  | 256     | +932920,885  | ± 6759,88    | ops/s |
| Poly1305DigestBench.updateBytes  | 1024    | +260870,08   | ± 3227,169   | ops/s |
| Poly1305DigestBench.updateBytes  | 16384   | +17001,737   | ± 186,529    | ops/s |
| Poly1305DigestBench.updateBytes  | 1048576 | +219,612     | ± 1345,424   | ops/s |

all tests were run on:

```
openjdk version "22-testing" 2024-03-19
OpenJDK Runtime Environment (fastdebug build 22-testing-builds.shipilev.net-openjdk-jdk-b552-20230909)
OpenJDK 64-Bit Server VM (fastdebug build 22-testing-builds.shipilev.net-openjdk-jdk-b552-20230909, mixed mode)
``` 