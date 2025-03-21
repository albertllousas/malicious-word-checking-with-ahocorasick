# Malicious word checking with ahocorasick

Assess performance of [ahocorasick algorithm](https://en.wikipedia.org/wiki/Aho%E2%80%93Corasick_algorithm) for malicious word checking using 
an existent [jvm library](https://github.com/robert-bor/aho-corasick).

## Malicious word detector

The malicious word detector is a simple class that checks if a given text contains any of the malicious words, check it [here](/src/main/kotlin/wordchecker/MaliciousWordDetector.kt). 

## Functional tests

You can check the functional tests [here](/src/test/kotlin/wordchecker/MaliciousWordDetectorTest.kt)

## Benchmarking

You can check benchmark class [here](/src/jmh/kotlin/benchmark/MaliciousWordDetectorBenchmark.kt)

or run it with:

```shell
./gradlew jmh
```

Result of the benchmarking:

```shell
Benchmark                                          Mode  Cnt  Score    Error  Units
MaliciousWordDetectorBenchmark.benchmarkDetection  avgt   25  0.001 ±  0.001  ms/op
MaliciousWordDetectorBenchmark.benchmarkLoad       avgt   25  0.439 ±  0.019  ms/op
```
Summary:
- load time: around half a second (loading 1000 from a file to the class) 
- detection time: 1 microsecond per detection 🚀

