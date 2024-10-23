//package io.github.guoyixing.backtrack.listener
//
//import com.intellij.openapi.fileEditor.impl.IdeDocumentHistoryImpl
//import com.intellij.openapi.project.Project
//import io.github.guoyixing.backtrack.manger.PathTrajectoryManager
//import io.github.guoyixing.backtrack.model.tree.PathTrajectoryNode
//import io.github.guoyixing.backtrack.model.tree.PathTrajectoryTree
//
//class `PositionHistoryListener-bak`(project: Project) : IdeDocumentHistoryImpl.RecentPlacesListener {
//
//    private val manager: PathTrajectoryManager = project.getService(PathTrajectoryManager::class.java)
//
//    override fun recentPlaceAdded(changePlace: IdeDocumentHistoryImpl.PlaceInfo, isChanged: Boolean) {
//        val node = PathTrajectoryNode(changePlace, isChanged)
//        val tree = manager.pathTrajectoryTree
//
//        manager.pathTrajectoryTree = tree?.apply {
//            current.addChild(node)
//            current = node
//        } ?: PathTrajectoryTree(node, node)
//
//        manager.sendUpdate()
//    }
//
//    override fun recentPlaceRemoved(changePlace: IdeDocumentHistoryImpl.PlaceInfo, isChanged: Boolean) {
//        val tree = manager.pathTrajectoryTree!!
//        val parent = tree.current.parent
//        if (tree.current.data == changePlace && parent != null) {
//            tree.current = parent
//            manager.sendUpdate()
//        }
//
//    }
//
//
//}