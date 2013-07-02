package ru.sirius.overheads.documents.goods;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.validation.api.ui.swing.ValidationPanel;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import ru.sirius.overheads.model.entity.Position;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//ru.sirius.overheads.documents.goods//Goods//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "GoodsTopComponent",
        iconBase = "ru/sirius/overheads/documents/goods/1371165588_Autocomplete.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "ru.sirius.overheads.documents.goods.GoodsTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_GoodsAction",
        preferredID = "GoodsTopComponent")
@Messages({
    "CTL_GoodsAction=Goods",
    "CTL_GoodsTopComponent=Goods Window",
    "HINT_GoodsTopComponent=This is a Goods window"
})
public final class GoodsTopComponent extends TopComponent {

    private TreeModel groupModel;
    private GoodsTreeTableModel complexModel;
    private final GoodsTreeBuilder builder;

    public GoodsTopComponent() {

        builder = new GoodsTreeBuilder();
        groupModel = builder.buildGroupTree();
        complexModel = builder.buidComplexTree();

        initComponents();
        setName(Bundle.CTL_GoodsTopComponent());
        setToolTipText(Bundle.HINT_GoodsTopComponent());

        complexTreeTable.setTreeTableModel(complexModel);

        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(new ImageIcon(getClass().getResource("/ru/sirius/overheads/documents/goods/folder_close_16.png")));
        renderer.setOpenIcon(new ImageIcon(getClass().getResource("/ru/sirius/overheads/documents/goods/folder_open_16.png")));
        renderer.setClosedIcon(new ImageIcon(getClass().getResource("/ru/sirius/overheads/documents/goods/folder_close_16.png")));
        groupTree.setCellRenderer(renderer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        addGroupMenuItem = new javax.swing.JMenuItem();
        addArticleMenuItem = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        groupTree = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        complexTreeTable = new org.jdesktop.swingx.JXTreeTable();

        org.openide.awt.Mnemonics.setLocalizedText(addGroupMenuItem, org.openide.util.NbBundle.getMessage(GoodsTopComponent.class, "GoodsTopComponent.addGroupMenuItem.text")); // NOI18N
        addGroupMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGroupMenuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(addGroupMenuItem);

        org.openide.awt.Mnemonics.setLocalizedText(addArticleMenuItem, org.openide.util.NbBundle.getMessage(GoodsTopComponent.class, "GoodsTopComponent.addArticleMenuItem.text")); // NOI18N
        addArticleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addArticleMenuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(addArticleMenuItem);

        groupTree.setModel(groupModel);
        groupTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupTreeMouseClicked(evt);
            }
        });
        groupTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                groupTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(groupTree);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jScrollPane2.setViewportView(complexTreeTable);

        jSplitPane1.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void groupTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_groupTreeValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_groupTreeValueChanged

    private void groupTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupTreeMouseClicked
        int clickCount = evt.getClickCount();
        int button = evt.getButton();
        if (clickCount == 1 && button == MouseEvent.BUTTON3) {
            int x = evt.getX();
            int y = evt.getY();
            int row = groupTree.getClosestRowForLocation(x, y);
            groupTree.setSelectionRow(row);

//            int rowIndex = groupTree.getSelectedRow();
//            TreePath path = classifierTreeTable.getPathForRow(rowIndex);
//            NmNode node = (NmNode) path.getLastPathComponent();
//            builder.mergeSelectionTree((NmNode) selectionModel.getRoot(), node);
//            selectionTree.updateUI();

            jPopupMenu1.show(groupTree, x, y);
        }
    }//GEN-LAST:event_groupTreeMouseClicked

    private void addGroupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGroupMenuItemActionPerformed
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) groupTree.getSelectionPath().getLastPathComponent();
        Position parent = (Position) node.getUserObject();
        CreateGroupPanel panel = new CreateGroupPanel(parent);
        ValidationPanel validationPanel = new ValidationPanel(panel.getValidationGroup());
        validationPanel.setInnerComponent(panel);
        if (validationPanel.showOkCancelDialog("Создание подгруппы")) {
            builder.createNewGroup(node, panel.getGroup());
            groupTree.updateUI();
            complexTreeTable.updateUI();
        }


//        DialogDescriptor descriptor = new DialogDescriptor(panel,"Создание подгруппы");
//        DialogDisplayer.getDefault().notify(descriptor);
    }//GEN-LAST:event_addGroupMenuItemActionPerformed

    private void addArticleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addArticleMenuItemActionPerformed
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) groupTree.getSelectionPath().getLastPathComponent();
        Position parent = (Position) node.getUserObject();
//        CreateGroupPanel panel = new CreateArticlePanel(parent);
//        DialogDescriptor descriptor = new DialogDescriptor(panel, "Создание артикула");
//        DialogDisplayer.getDefault().notify(descriptor);
    }//GEN-LAST:event_addArticleMenuItemActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addArticleMenuItem;
    private javax.swing.JMenuItem addGroupMenuItem;
    private org.jdesktop.swingx.JXTreeTable complexTreeTable;
    private javax.swing.JTree groupTree;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
