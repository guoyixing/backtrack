package io.github.guoyixing.backtrack.ui.popup

import com.intellij.ui.JBColor
import java.awt.*
import javax.swing.JPanel

/**
 * 节点面板，用于展示路径轨迹树的节点
 */
class TreeNodePanel:JPanel() {

    /**
     * 圆角半径
     */
    var radius = 10

    init {
        // 设置面板的首选大小
        preferredSize = Dimension(150, 50)
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)

        // 设置边框颜色
        val g2 = g as Graphics2D

        // 设置边框颜色
        g2.color = JBColor.GRAY

        // 启用抗锯齿以获得更平滑的边缘
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

        // 绘制带有2像素边框的圆角矩形
        g2.stroke = BasicStroke(2f)

        // 绘制带有1像素边框的圆角矩形
        g2.drawRoundRect(1, 1, width - 3, height - 3, radius, radius)

    }
}