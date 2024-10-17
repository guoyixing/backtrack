package io.github.guoyixing.backtrack.listener

import com.intellij.openapi.fileEditor.impl.IdeDocumentHistoryImpl

class PositionHistoryListener : IdeDocumentHistoryImpl.RecentPlacesListener {

    override fun recentPlaceAdded(changePlace: IdeDocumentHistoryImpl.PlaceInfo, isChanged: Boolean) {
        println("add$changePlace")
        println("add$isChanged")
    }

    override fun recentPlaceRemoved(changePlace: IdeDocumentHistoryImpl.PlaceInfo, isChanged: Boolean) {
        println("remove$changePlace")
        println("remove$isChanged")
    }




}