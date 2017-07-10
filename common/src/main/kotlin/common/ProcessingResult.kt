package common

import java.util.*

fun emptyProcessingResult(): ProcessingResult = EmptyProcessingResult()

interface ProcessingResult {
    fun getMethodInfos(): List<MethodInfo>
}

private class EmptyProcessingResult : ProcessingResult {
    override fun getMethodInfos(): List<MethodInfo> = Collections.emptyList()
}