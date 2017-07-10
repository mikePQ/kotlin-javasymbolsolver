package common

interface MethodInfo {
    fun getNumberOfCalls(): Int
    fun getCalls(): List<MethodCall>
    fun getClassName(): String
}