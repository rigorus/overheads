
package ru.sirius.overheads.documents.goods;

import javax.swing.tree.DefaultMutableTreeNode;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;
import ru.sirius.overheads.model.entity.Position;


public class GoodsTreeTableModel extends DefaultTreeTableModel{

    private DefaultMutableTreeNode realRoot;
    private DefaultMutableTreeNode visibleRoot;         

    public GoodsTreeTableModel(DefaultMutableTreeNode root) {                
        super();
        realRoot = root;
        visibleRoot = root;
    }    
    
    
//    public GoodsNode findIdentityNode(GoodsNode node, GoodsNode root){
//        
//        Enumeration<GoodsNode> enumeration = root.children();
//        while(enumeration.hasMoreElements()){
//            root = enumeration.nextElement();
//            if( node.identical(root) ){
//                return root;
//            }else if(!root.isLeaf()){
//                findIdentityNode(node, root);                
//            }
//        }
//        
//        return null;        
//    }
    
    @Override
    public boolean isLeaf(Object node) {
        DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) node;
        return treenode.isLeaf();
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(Object object, int columnIndex) {
        
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)object;
        Position position = (Position) node.getUserObject();
        
        switch(columnIndex){
            case 0: 
                return position.getName();
            case 1:
                return position.getId();
            default:
                return "Unknown";
        }        
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Наименование";
            case 1:
                return "Количество";
            default:
                return "Unknown";
        }
    }
}
