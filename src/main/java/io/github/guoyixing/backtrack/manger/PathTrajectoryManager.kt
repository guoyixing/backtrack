package io.github.guoyixing.backtrack.manger

import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import io.github.guoyixing.backtrack.model.tree.PathTrajectoryNode
import io.github.guoyixing.backtrack.model.tree.PathTrajectoryTree

/**
 * 路径轨迹管理器
 */
@Service(Service.Level.PROJECT)
class PathTrajectoryManager(private val project: Project) {

    /**
     * 路径轨迹树
     */
    var pathTrajectoryTree: PathTrajectoryTree? = null

    /**
     * 发出更新信息
     */
    fun sendUpdate() {
        println("\n\n\n\n\n")
        traverse()
    }

    /**
     * 遍历路径轨迹树
     */
    fun traverse() {
        pathTrajectoryTree?.root?.let {
            traverse(it)
        }
    }

    private fun traverse(node: PathTrajectoryNode) {
        if (node.isLeaf()) {
            return
        }

        var str = "|"
        node.children.forEach{
            for (i in 0 until it.data.toString().length+2) {
                str += "-"
            }
            str += "|"
        }
        println(str)
        node.children.forEach{
            print("${it.data} ")
        }
        println("\n")

        node.children.forEach {
            traverse(it)
        }
    }


}