/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sirius.overheads.documents.goods;

import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.swing.SwingValidationGroup;
import ru.sirius.overheads.model.entity.Position;

/**
 *
 * @author igor
 */
public class CreateArticlePanel extends javax.swing.JPanel {

    private Position article = new Position();
    private final SwingValidationGroup validationGroup = SwingValidationGroup.create();

    /**
     * Creates new form CreateGroupPanel
     */
    public CreateArticlePanel(Position parent) {

        article.setParent(parent);
        article.setGroup(false);

        initComponents();

        validationGroup.add(nameTextField, StringValidators.REQUIRE_NON_EMPTY_STRING);
        validationGroup.add(fullNameTextField, StringValidators.REQUIRE_NON_EMPTY_STRING);
        validationGroup.add(priceTextField, StringValidators.REQUIRE_VALID_INTEGER);
        parentGroupTextField.setText(article.getParent().getName());
    }

    public SwingValidationGroup getValidationGroup() {
        return validationGroup;
    }

    public Position getArticle() {
        article.setName(nameTextField.getText());
//        article.getInfo() TODO как тут быть то ????
        article.setPrice(Integer.parseInt(priceTextField.getText()));
        return article;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        parentGroupTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fullNameTextField = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.jLabel2.text")); // NOI18N
        jLabel2.setToolTipText(org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.jLabel2.toolTipText")); // NOI18N

        nameTextField.setText(org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.nameTextField.text")); // NOI18N
        nameTextField.setToolTipText(org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.nameTextField.toolTipText")); // NOI18N
        nameTextField.setName("Наименование"); // NOI18N

        parentGroupTextField.setEditable(false);
        parentGroupTextField.setText(org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.parentGroupTextField.text")); // NOI18N
        parentGroupTextField.setToolTipText(org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.parentGroupTextField.toolTipText")); // NOI18N
        parentGroupTextField.setFocusable(false);
        parentGroupTextField.setRequestFocusEnabled(false);
        parentGroupTextField.setVerifyInputWhenFocusTarget(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.jLabel3.text")); // NOI18N

        priceTextField.setText(org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.price.text")); // NOI18N
        priceTextField.setName("price"); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.jLabel4.text")); // NOI18N

        fullNameTextField.setText(org.openide.util.NbBundle.getMessage(CreateArticlePanel.class, "CreateArticlePanel.fullName.text")); // NOI18N
        fullNameTextField.setName("fullName"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceTextField)
                    .addComponent(nameTextField)
                    .addComponent(parentGroupTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(fullNameTextField))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parentGroupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fullNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField parentGroupTextField;
    private javax.swing.JTextField priceTextField;
    // End of variables declaration//GEN-END:variables
}