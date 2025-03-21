package wordchecker

import org.ahocorasick.trie.Trie
import java.nio.file.Files
import java.nio.file.Paths

class MaliciousWordDetector(private val maliciousWordsFile: String) {

    private val keywords = Files.readAllLines(Paths.get(maliciousWordsFile))

    private val trie: Trie = Trie.builder()
        .ignoreCase()         // case-insensitive matching
//        .onlyWholeWords()     // avoid partial matches like "coke" in "cocked"
        .addKeywords(keywords)
        .build()

    fun fetchMaliciousWords(text: String) = trie.parseText(text).map { it.keyword }

}
