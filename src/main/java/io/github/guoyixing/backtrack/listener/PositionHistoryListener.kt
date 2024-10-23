package io.github.guoyixing.backtrack.listener

import com.intellij.openapi.editor.event.CaretEvent
import com.intellij.openapi.editor.event.CaretListener
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.vfs.VirtualFile

class PositionHistoryListener : CaretListener {

    override fun caretPositionChanged(event: CaretEvent) {
        val caret = event.caret ?: return
        val position = caret.logicalPosition
        val editor = event.editor
        val document = editor.document
        val file: VirtualFile? = FileDocumentManager.getInstance().getFile(document)

        if (file != null) {
            println("${file.path}[${position.line},${position.column}]")
        } else {
            println(" not found[${position.line},${position.column}]")
        }
    }

}
