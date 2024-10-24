package io.github.guoyixing.backtrack

import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.NotNull


@Service(Service.Level.PROJECT)
class BacktrackDisposable: Disposable {

    companion object {
        @JvmStatic
        fun getInstance(@NotNull project: Project): Disposable {
            return project.getService(BacktrackDisposable::class.java)
        }
    }

    override fun dispose() {
    }


}