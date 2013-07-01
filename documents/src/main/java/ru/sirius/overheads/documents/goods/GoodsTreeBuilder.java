package ru.sirius.overheads.documents.goods;

import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import ru.sirius.overheads.model.PositionService;
import ru.sirius.overheads.model.entity.Position;


public class GoodsTreeBuilder {
    
    private final Position root;
    
    public GoodsTreeBuilder(){
        //TODO обеспечить здесь полную загрузку, а не LAZY !!!
        root = PositionService.getRootPosition();
    }
            
    public DefaultTreeModel buildGroupTree(){
        
        GoodsNode tree = new GoodsNode(root);
        addChildren(tree, root.getChildren(),true);        
        return new DefaultTreeModel(tree);
    }

    public GoodsTreeTableModel buidComplexTree() {
        GoodsNode tree = new GoodsNode(root);
        addChildren(tree, root.getChildren(), false);
        return new GoodsTreeTableModel(tree);
    }

    public void createNewGroup(DefaultMutableTreeNode parentNode, Position newGroup) {
        PositionService.addGroup(newGroup);        
        GoodsNode node = new GoodsNode(newGroup);
        parentNode.add(node);
    }
    
    
    
    private void addChildren(GoodsNode node, Set<Position> children, boolean onlyGroup){
        
        if( children.isEmpty()) return;
        for( Position position : children ){
            if( !onlyGroup || position.isGroup() ){
                GoodsNode child = new GoodsNode(position);
                node.add(child);
                if( !position.getChildren().isEmpty() ){
                    addChildren(child, position.getChildren(), onlyGroup);
                }
            }
        }
    }
    
    private static class GoodsNode extends DefaultMutableTreeNode{

        public GoodsNode() {
        }

        public GoodsNode(Position userObject) {
            super(userObject);
        }

        public GoodsNode(Position userObject, boolean allowsChildren) {
            super(userObject, allowsChildren);
        }                
        
        @Override
        public String toString(){
            return ((Position) userObject).getName();
        }
    }
}
