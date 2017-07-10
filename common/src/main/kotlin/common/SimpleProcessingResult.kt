package common

import java.util.*

class SimpleProcessingResult(values: MutableCollection<MethodInfo>) : ProcessingResult {
    override fun getMethodInfos(): List<MethodInfo> {
        return Collections.emptyList() //TODO implement
    }
}