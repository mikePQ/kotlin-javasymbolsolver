import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages
import common.StringGenerator

class HelloAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getData(PlatformDataKeys.PROJECT)
        Messages.showMessageDialog(project, "HelloWorld " + StringGenerator().generate(), "Greeting " + StringGenerator().generate() , Messages.getInformationIcon())
    }
}