### GHASH intrinsic microbenchmark

Entierly based on the [TestGHASH.java](https://github.com/openjdk/jdk/blob/master/test/jdk/com/sun/crypto/provider/Cipher/AES/TestGHASH.java) regression test in OpenJDK

#### How to run
1. `mvn clean verify`
2. `java -jar target/benchmarks.jar`