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
        
        DefaultMutableTreeNode tree = new DefaultMutableTreeNode(root);
        addChildren(tree, root.getChildren(),true);
        return tree;
    }

    public DefaultMutableTreeNode buidComplexTree() {
        DefaultMutableTreeNode tree = new DefaultMutableTreeNode(root);
        addChildren(tree, root.getChildren(), false);
        return tree;
    }
    
    private void addChildren(DefaultMutableTreeNode node, Set<Position> children, boolean onlyGroup){
        
        if( children.isEmpty()) return;
        for( Position position : children ){
            if( !onlyGroup || position.isGroup() ){
                DefaultMutableTreeNode child = new DefaultMutableTreeNode(position);
                node.add(child);
                if( !position.getChildren().isEmpty() ){
                    addChildren(child, position.getChildren(), onlyGroup);
                }
            }
        }
    }
}
