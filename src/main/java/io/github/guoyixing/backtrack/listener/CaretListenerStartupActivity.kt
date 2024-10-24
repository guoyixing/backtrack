package io.github.guoyixing.backtrack.listener

import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import io.github.guoyixing.backtrack.BacktrackDisposable

class CaretListenerStartupActivity : ProjectActivity {

    override suspend fun execute(project: Project) {
        val editorFactory = EditorFactory.getInstance()
        val listener = PositionHistoryListener(project)
        val disposable = BacktrackDisposable.getInstance(project)
        editorFactory.eventMulticaster.addCaretListener(listener, disposable)
    }

}