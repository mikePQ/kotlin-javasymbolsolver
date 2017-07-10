package common

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.expr.MethodCallExpr
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade
import com.github.javaparser.symbolsolver.model.declarations.MethodDeclaration
import descendantsOfType
import java.io.File
import java.util.concurrent.ConcurrentHashMap

class JavaFilesProcessor(private val javaParser: JavaParserFacade) {
    fun process(files: List<JavaFile>): ProcessingResult {
        var result = emptyProcessingResult()
        files.forEach {
            result = result.merge(process(it))
        }
        return result
    }

    fun process(file: JavaFile): ProcessingResult {
        val result  = ConcurrentHashMap<MethodDeclaration, MethodInfo>()
        processJavaFile(file.getFile(), javaParser, result)
        return SimpleProcessingResult(result.values)
    }

    private fun processJavaFile(file: File, javaParserFacade: JavaParserFacade, result: MutableMap<MethodDeclaration, MethodInfo>) {
        JavaParser.parse(file).descendantsOfType(MethodCallExpr::class.java).forEach {
            val methodRef = javaParserFacade.solve(it)
            if (methodRef.isSolved) {
                val methodDeclaration = methodRef.correspondingDeclaration
                result.put(methodDeclaration, methodRef.merge(result[methodDeclaration]))
            }
        }
    }
}

private fun ProcessingResult.merge(result: ProcessingResult): ProcessingResult {
    return result //TODO implement
}

