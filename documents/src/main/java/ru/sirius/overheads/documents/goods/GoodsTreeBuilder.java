package ru.sirius.overheads.documents.goods;

import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import ru.sirius.overheads.model.PositionService;
import ru.sirius.overheads.model.entity.Position;


public class GoodsTreeBuilder {
    
    private final Position root;
    
    public GoodsTreeBuilder(){
        //TODO обеспечить здесь полную загрузку, а не LAZY !!!
        root = PositionService.getRootPosition();
    }
            
    public DefaultMutableTreeNode buildGroupTree(){
        
        GoodsNode tree = new GoodsNode(root);
        addChildren(tree, root.getChildren(),true);
        return tree;
    }

    public DefaultMutableTreeNode buidComplexTree() {
        GoodsNode tree = new GoodsNode(root);
        addChildren(tree, root.getChildren(), false);
        return tree;
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
