package io.github.guoyixing.backtrack.ui.popup

import com.intellij.ui.JBColor
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel

/**
 * 连接线，用于连接两个节点
 */
class LinePanel(private val startPanel: JPanel, private val endPanel: JPanel) : JPanel() {

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2d = g as Graphics2D
        g2d.color = JBColor.GRAY

        // Calculate start and end points
        val startX = startPanel.x + startPanel.width / 2
        val startY = startPanel.y + startPanel.height / 2
        val endX = endPanel.x + endPanel.width / 2
        val endY = endPanel.y + endPanel.height / 2

        // Draw line
        g2d.drawLine(startX, startY, endX, endY)
    }
}