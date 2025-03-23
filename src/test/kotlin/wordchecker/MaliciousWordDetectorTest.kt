package wordchecker

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class MaliciousWordDetectorTest {

    private val maliciousWordDetector = MaliciousWordDetector("src/main/resources/malicious_words_real_and_filler_1000.txt")

    @Test
    fun `should detect a single malicious word`() {
        val result = maliciousWordDetector.fetchMaliciousWords("I want to get high with lsd")

        result shouldBe listOf("lsd")
    }

    @Test
    fun `should detect a malicious word with case-insensitive matching`() {
        val result = maliciousWordDetector.fetchMaliciousWords("I want to get high with LsD")

        result shouldBe listOf("lsd")
    }

    @Test
    fun `should detect multiple malicious words`() {
        val result = maliciousWordDetector.fetchMaliciousWords("I want to get high with lsd and cocaine")

        result shouldBe listOf("lsd", "cocaine")
    }

    @Test
    fun `should detect no malicious words`() {
        val result = maliciousWordDetector.fetchMaliciousWords("I want to get high with love")

        result shouldBe emptyList()
    }

    @Test
    fun `should detect malicious words with partial matches`() {
        val result = maliciousWordDetector.fetchMaliciousWords("I want to get high with cocaineeeeee")

        result shouldBe listOf("cocaine")
    }
}