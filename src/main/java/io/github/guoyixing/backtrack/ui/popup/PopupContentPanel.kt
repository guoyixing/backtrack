package io.github.guoyixing.backtrack.ui.popup

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.components.JBScrollPane
import com.intellij.util.ui.JBUI
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import javax.swing.JPanel

class PopupContentPanel(project: Project, toolWindow: ToolWindow) {

    var contentPanel = JPanel()
    var scrollPane = JBScrollPane(contentPanel)

    init {
        contentPanel.layout = GridBagLayout()
        val gbc = GridBagConstraints()
        //左上对其
        gbc.anchor = GridBagConstraints.NORTHWEST

        // 第一行，显示1个
        gbc.gridx = 0
        gbc.gridy = 0
        gbc.gridwidth = GridBagConstraints.REMAINDER
        gbc.insets = JBUI.insets(5)
        contentPanel.add(TreeNodePanel(), gbc)

        // 第二行，显示其他的
        gbc.gridwidth = 1
        gbc.gridy = 1
        gbc.weightx = 1.0
        for (i in 1..4) {
            gbc.gridx = i - 1
            contentPanel.add(TreeNodePanel(), gbc)
        }

        gbc.gridy = 2
        for (i in 1..2) {
            gbc.gridx = i - 1
            contentPanel.add(TreeNodePanel(), gbc)
        }

        // 确保剩余空间被占用，以便组件对齐到左上角
        gbc.gridx = 0
        gbc.gridy = 2
        gbc.weightx = 1.0
        gbc.weighty = 1.0
        gbc.fill = GridBagConstraints.BOTH
        contentPanel.add(JPanel(), gbc)
    }

    /**
     * 创建节点面板
     */
    fun createNodePanel() {
        //创建一个节点面板，用于展示路径轨迹树的节点

    }

}