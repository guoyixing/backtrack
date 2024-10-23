package io.github.guoyixing.backtrack.model.tree

import com.intellij.openapi.fileEditor.impl.IdeDocumentHistoryImpl

/**
 * 路径轨迹节点
 */
class PathTrajectoryNode(var data: IdeDocumentHistoryImpl.PlaceInfo,var isChanged: Boolean) {

    var parent: PathTrajectoryNode? = null

    var children: MutableList<PathTrajectoryNode> = mutableListOf()

    fun addChild(child: PathTrajectoryNode) {
        children.add(child)
        child.parent = this
    }

    fun removeChild(child: PathTrajectoryNode) {
        children.remove(child)
        child.parent = null
    }

    fun remove() {
        parent?.removeChild(this)
    }

    fun isRoot(): Boolean {
        return parent == null
    }

    fun isLeaf(): Boolean {
        return children.isEmpty()
    }



}