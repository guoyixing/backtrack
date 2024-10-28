package io.github.guoyixing.backtrack.listener

import com.intellij.openapi.editor.event.CaretEvent
import com.intellij.openapi.editor.event.CaretListener
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import io.github.guoyixing.backtrack.manger.PathTrajectoryManager
import io.github.guoyixing.backtrack.model.BacktrackPosition
import io.github.guoyixing.backtrack.model.tree.PathTrajectoryNode
import io.github.guoyixing.backtrack.model.tree.PathTrajectoryTree


class PositionHistoryListener(private val project: Project) : CaretListener {

    private val manager: PathTrajectoryManager = project.getService(PathTrajectoryManager::class.java)

    override fun caretPositionChanged(event: CaretEvent) {
        // 获取光标位置
        getCaretPosition(event)?.let {

            // 更新路径轨迹树
            updateTree(it)

            // 发送更新信息
            manager.sendUpdate()
        }


    }

    /**
     * 更新路径轨迹树
     * @param position BacktrackPosition
     */
    private fun updateTree(position: BacktrackPosition) {
        val tree = manager.pathTrajectoryTree
        val parent = tree?.current?.parent
        val children = tree?.current?.children
        val node = PathTrajectoryNode(position)


        when {
            // 如果当前节点的父节点是当前节点，说明是回退操作
            parent?.data == position -> {
                tree.current = parent
            }

            // 如果当前节点的子节点包含当前位置，说明是前进操作
            children.orEmpty().any { it.data == position } -> {
                children.orEmpty()
                    .find { it.data == position }
                    ?.let { tree?.current = it }
            }

            // 否则是新的位置
            else -> {
                manager.pathTrajectoryTree = tree?.apply {
                    current.addChild(node)
                    current = node
                } ?: PathTrajectoryTree(node, node)
            }
        }
    }

    /**
     * 获取光标位置
     * @param event CaretEvent
     * @return BacktrackPosition? 光标位置
     */
    private fun getCaretPosition(event: CaretEvent): BacktrackPosition? {
        val caret = event.caret ?: return null
        val position = caret.logicalPosition
        val editor = event.editor
        val document = editor.document
        val file: VirtualFile? = FileDocumentManager.getInstance().getFile(document)

        val psiFile: PsiFile = PsiDocumentManager.getInstance(project).getPsiFile(document) ?: return null
        val elementAtCaret: PsiElement? = psiFile.findElementAt(caret.offset)
        val method: PsiMethod? = PsiTreeUtil.getParentOfType(elementAtCaret, PsiMethod::class.java)

        // 获取方法名和类名
        val className = method?.containingClass?.name ?: "无"
        val methodName = method?.name ?: "无"

        // 光标前后的代码片段
        val startLine = (position.line - 3).coerceAtLeast(0)
        val endLine = (position.line + 3).coerceAtMost(document.lineCount - 1)
        val codeSnippet = (startLine..endLine).joinToString("\n") { line ->
            val startOffset = document.getLineStartOffset(line)
            val endOffset = document.getLineEndOffset(line)
            document.getText(TextRange(startOffset, endOffset))
        }

        file?.let {
            println("${it.path}[${position.line},${position.column}]")
        } ?: println("not found[${position.line},${position.column}]")


        return BacktrackPosition(file?.path, position.line, position.column, methodName, className, codeSnippet)
    }

}
