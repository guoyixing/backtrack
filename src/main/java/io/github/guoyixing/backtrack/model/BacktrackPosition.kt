package io.github.guoyixing.backtrack.model

data class BacktrackPosition(
    /**
     * 文件路径
     */
    val path: String?,

    /**
     * 行号
     */
    val line: Int,

    /**
     * 列号
     */
    val column: Int
)
