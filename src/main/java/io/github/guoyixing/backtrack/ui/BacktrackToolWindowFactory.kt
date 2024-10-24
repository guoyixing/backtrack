package io.github.guoyixing.backtrack.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import io.github.guoyixing.backtrack.ui.popup.PopupContentPanel


class BacktrackToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {

        val scrollPane = PopupContentPanel(project, toolWindow).scrollPane
        val factory: ContentFactory = ContentFactory.getInstance()
        val content = factory.createContent(scrollPane, "", false)
        toolWindow.contentManager.addContent(content);
    }

}