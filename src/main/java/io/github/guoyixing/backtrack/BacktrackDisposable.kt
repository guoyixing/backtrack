package io.github.guoyixing.backtrack

import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service

@Service(Service.Level.PROJECT)
class BacktrackDisposable() : Disposable {

    override fun dispose() {
    }


}