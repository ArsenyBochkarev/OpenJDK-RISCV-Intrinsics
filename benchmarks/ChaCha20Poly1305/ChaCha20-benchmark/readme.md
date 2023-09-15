### ChaCha20 + Poly1305 intrisics microbenchmark

Entierly based on the [CipherBench.java:ChaCha20Poly1305](https://github.com/openjdk/jdk/blob/master/test/micro/org/openjdk/bench/javax/crypto/full/CipherBench.java#L187) test in OpenJDK

And please don't get confused on the naming of the whole thing, this benchmark is **different** than the ChaCha20 only.

#### How to run
1. `mvn clean verify`
2. `java -jar target/benchmarks.jar`