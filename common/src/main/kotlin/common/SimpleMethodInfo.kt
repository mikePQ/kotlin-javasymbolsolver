package common

import com.github.javaparser.symbolsolver.model.declarations.MethodDeclaration
import com.github.javaparser.symbolsolver.model.resolution.SymbolReference

class SimpleMethodInfo(symbolReference: SymbolReference<MethodDeclaration>) : MethodInfo {
    override fun getClassName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCalls(): List<MethodCall> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNumberOfCalls(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun SymbolReference<MethodDeclaration>.merge(methodInfo: MethodInfo?): MethodInfo {
    val info = SimpleMethodInfo(this)
    return methodInfo?.merge(methodInfo) ?: info
}

private fun  MethodInfo.merge(methodInfo: MethodInfo): MethodInfo? {
    return methodInfo //TODO implement
}
