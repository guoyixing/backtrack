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
    val column: Int,

    /**
     * 方法名
     */
    val methodName: String,

    /**
     * 类名
     */
    val className: String,

    /**
     * 代码片段
     */
    val code: String
)
