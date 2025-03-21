package benchmark

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import wordchecker.MaliciousWordDetector
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
open class MaliciousWordDetectorBenchmark {

    private lateinit var text: String
    private lateinit var detector: MaliciousWordDetector

    @Setup(Level.Trial)
    fun setup() {
        detector = MaliciousWordDetector("src/main/resources/malicious_words_real_and_filler_1000.txt")
        text = "This message contains cocaine and other suspicious terms like lsd."
    }

    @Benchmark
    fun benchmarkLoad(): MaliciousWordDetector {
        return MaliciousWordDetector("src/main/resources/malicious_words_real_and_filler_1000.txt")
    }

    @Benchmark
    fun benchmarkDetection(): List<String> {
        return detector.fetchMaliciousWords(text)
    }
}