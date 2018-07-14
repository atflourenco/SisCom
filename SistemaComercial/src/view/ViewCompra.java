/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CompraController;
import controller.ProdutoController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.pojo.ItemCompra;
import model.pojo.Produto;

/**
 *
 * @author Anderson
 */
public class ViewCompra extends javax.swing.JDialog {

    private Produto produto;
    private List<ItemCompra> itensCompra = new ArrayList<ItemCompra>();
    
    public ViewCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.inicializaCampos();
    }
    
    private void inicializaCampos(){
        this.txtFornecedor.setText("");
        this.dtDataCompra.setDate(new Date());
        this.txtValorTotal.setText("0.00");        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JTabbedPane();
        pnlDadosCompra = new javax.swing.JPanel();
        pnlFormulario = new javax.swing.JPanel();
        lblFornecedor = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        btnBuscaFornecedor = new javax.swing.JButton();
        lblDataCompra = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        lblRS = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        dtDataCompra = new com.toedter.calendar.JDateChooser();
        pnlBotoes = new javax.swing.JPanel();
        btnFinalizarCompra = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlItensCompra = new javax.swing.JPanel();
        pnlFormularioItens = new javax.swing.JPanel();
        lblProduto = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        btnBuscaProduto = new javax.swing.JButton();
        lblQuantidade = new javax.swing.JLabel();
        spQuantidade = new javax.swing.JSpinner();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblRSPreco = new javax.swing.JLabel();
        btnAdicionarItem = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();
        scpItensCompra = new javax.swing.JScrollPane();
        tblItensCompra = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compra");

        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Formulário"));

        lblFornecedor.setText("Fornecedor");

        txtFornecedor.setEditable(false);

        btnBuscaFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnBuscaFornecedor.setToolTipText("Selecione um fornecedor");
        btnBuscaFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaFornecedorActionPerformed(evt);
            }
        });

        lblDataCompra.setText("Data da Compra");

        lblValorTotal.setText("Valor Total");

        lblRS.setText("R$");

        txtValorTotal.setEditable(false);

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(txtFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscaFornecedor))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFornecedor)
                            .addComponent(lblDataCompra)
                            .addComponent(lblValorTotal)
                            .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dtDataCompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFormularioLayout.createSequentialGroup()
                                    .addComponent(lblRS)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaFornecedor))
                .addGap(11, 11, 11)
                .addComponent(lblDataCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblValorTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRS)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnlBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFinalizarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnFinalizarCompra.setText("Finalizar Compra");
        btnFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCompraActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(131, 25));
        btnCancelar.setPreferredSize(new java.awt.Dimension(131, 25));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFinalizarCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFinalizarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDadosCompraLayout = new javax.swing.GroupLayout(pnlDadosCompra);
        pnlDadosCompra.setLayout(pnlDadosCompraLayout);
        pnlDadosCompraLayout.setHorizontalGroup(
            pnlDadosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosCompraLayout.setVerticalGroup(
            pnlDadosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlPrincipal.addTab("Dados da Compra", pnlDadosCompra);

        pnlFormularioItens.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Formulário"));

        lblProduto.setText("Produto");

        txtProduto.setEditable(false);

        btnBuscaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnBuscaProduto.setToolTipText("Selecione um produto");
        btnBuscaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaProdutoActionPerformed(evt);
            }
        });

        lblQuantidade.setText("Quantidade");

        spQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblPreco.setText("Preço");

        txtPreco.setEditable(false);

        lblRSPreco.setText("R$");

        btnAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        btnAdicionarItem.setToolTipText("Adicionar");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        btnRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus.png"))); // NOI18N
        btnRemoverItem.setToolTipText("Remover");
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormularioItensLayout = new javax.swing.GroupLayout(pnlFormularioItens);
        pnlFormularioItens.setLayout(pnlFormularioItensLayout);
        pnlFormularioItensLayout.setHorizontalGroup(
            pnlFormularioItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioItensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioItensLayout.createSequentialGroup()
                        .addGroup(pnlFormularioItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuantidade))
                        .addGap(12, 12, 12)
                        .addComponent(lblRSPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioItensLayout.createSequentialGroup()
                                .addComponent(lblPreco)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlFormularioItensLayout.createSequentialGroup()
                                .addComponent(txtPreco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlFormularioItensLayout.createSequentialGroup()
                        .addComponent(lblProduto)
                        .addGap(0, 321, Short.MAX_VALUE))
                    .addGroup(pnlFormularioItensLayout.createSequentialGroup()
                        .addComponent(txtProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscaProduto)))
                .addContainerGap())
        );
        pnlFormularioItensLayout.setVerticalGroup(
            pnlFormularioItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioItensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscaProduto)
                    .addGroup(pnlFormularioItensLayout.createSequentialGroup()
                        .addComponent(lblProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormularioItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(lblPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRSPreco)
                        .addComponent(btnAdicionarItem))
                    .addComponent(btnRemoverItem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblItensCompra.setAutoCreateRowSorter(true);
        tblItensCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Preço Unitário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scpItensCompra.setViewportView(tblItensCompra);

        javax.swing.GroupLayout pnlItensCompraLayout = new javax.swing.GroupLayout(pnlItensCompra);
        pnlItensCompra.setLayout(pnlItensCompraLayout);
        pnlItensCompraLayout.setHorizontalGroup(
            pnlItensCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItensCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItensCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpItensCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlFormularioItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlItensCompraLayout.setVerticalGroup(
            pnlItensCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItensCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFormularioItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpItensCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPrincipal.addTab("Itens da Compra", pnlItensCompra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaProdutoActionPerformed
        ViewBuscaProdutos vbProdutos = new ViewBuscaProdutos(null, true);
        vbProdutos.setLocationRelativeTo(this);
        vbProdutos.setVisible(true);
        String nomeProduto = vbProdutos.getNomeProduto();
        if(nomeProduto!=null){
            produto = ProdutoController.getInstance().readProdutoByNome(nomeProduto);
            txtProduto.setText(produto.getNome());
            txtPreco.setText(String.valueOf(produto.getPrecoCompra()));
        }
    }//GEN-LAST:event_btnBuscaProdutoActionPerformed

    private void btnBuscaFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaFornecedorActionPerformed
      
        ViewBuscaFornecedores vbFornecedores = new ViewBuscaFornecedores(null, true);
        vbFornecedores.setLocationRelativeTo(this);
        vbFornecedores.setVisible(true);
        String nomeFornecedor = vbFornecedores.getNomeFornecedor();
        if(nomeFornecedor!=null){
            txtFornecedor.setText(nomeFornecedor);
        }
        
    }//GEN-LAST:event_btnBuscaFornecedorActionPerformed

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        if(txtProduto.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Nenhum produto selecionado!");
        }else{
            this.adicionaItemCompra();
        }
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private void btnRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItemActionPerformed
        this.removeItemCompra();
    }//GEN-LAST:event_btnRemoverItemActionPerformed

    private void btnFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCompraActionPerformed
        
        if(txtFornecedor.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Nenhum fornecedor selecionado!");
        }else{
            if(itensCompra.isEmpty()){
                JOptionPane.showMessageDialog(this, "Não existem itens adicionados!");
            }else{
                int opcao = JOptionPane.showConfirmDialog(this, "Deseja finalizar compra?");
                
                if(opcao==JOptionPane.YES_OPTION){
                    this.finalizaCompra();
                }
            }
        } 
    }//GEN-LAST:event_btnFinalizarCompraActionPerformed

    private void finalizaCompra(){
        boolean resultado;
        resultado = CompraController.getInstance().createCompra(txtFornecedor.getText(), dtDataCompra.getDate(),
                Double.parseDouble(txtValorTotal.getText()),itensCompra);
    
        if(resultado==false){
            JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso!");
            
            //Limpar todos os campos da compra
            txtFornecedor.setText("");
            txtProduto.setText("");
            txtValorTotal.setText("0");
            dtDataCompra.setDate(new Date());
            spQuantidade.setValue(1);
            itensCompra.clear();
            this.atualizaItensCompra();
        }else{
            JOptionPane.showMessageDialog(this, "Falha ao salvar a compra!");
        }
    }
    
    private void removeItemCompra(){
        DefaultTableModel modeloTabela = (DefaultTableModel) tblItensCompra.getModel();
        
        if(modeloTabela.getRowCount()<=0){
            JOptionPane.showMessageDialog(this, "Não existem itens para remoção!");
        }else{
            if(tblItensCompra.getSelectedRow()<0){
                JOptionPane.showMessageDialog(this, "Nenhum item selecionado!");
            }else{
                Long id = (Long) tblItensCompra.getValueAt(tblItensCompra.getSelectedRow(),0);
                Integer qtde = (int) tblItensCompra.getValueAt(tblItensCompra.getSelectedRow(),2);
                Double preco = (Double) tblItensCompra.getValueAt(tblItensCompra.getSelectedRow(),3);
                
                List<ItemCompra> copiaItens = new ArrayList<ItemCompra>();
                
                copiaItens.addAll(itensCompra);
                
                for(ItemCompra ic: copiaItens){
                    if(ic.getProduto().getId().intValue()==id.intValue()
                    && ic.getQuantidade().intValue()==qtde){
                        itensCompra.remove(ic);
                        break;
                    }
                }
                
                double totalCompra = Double.parseDouble(txtValorTotal.getText());
                
                totalCompra = totalCompra - qtde * preco;
                
                txtValorTotal.setText(String.valueOf(totalCompra));
                
                this.atualizaItensCompra();
                
                
            }   
        }
        
        
    }
    
    private void adicionaItemCompra(){
        int qtde = (int) spQuantidade.getValue();
        ItemCompra item = new ItemCompra();
        item.setProduto(produto);
        item.setQuantidade(qtde);
        item.setPrecoUnitario(produto.getPrecoCompra());
        itensCompra.add(item);
        this.atualizaItensCompra();
        double totalCompra = Double.parseDouble(txtValorTotal.getText());
        totalCompra = totalCompra + qtde * produto.getPrecoCompra();
        txtValorTotal.setText(String.valueOf(totalCompra));
        this.limparCamposProduto();
    }
    
    private void limparCamposProduto(){
        txtProduto.setText("");
        txtPreco.setText("");
        spQuantidade.setValue(1);
    }
    
    private void atualizaItensCompra(){
        DefaultTableModel modeloTabela = (DefaultTableModel) tblItensCompra.getModel();
        //Limpa tabela        
        while(modeloTabela.getRowCount()>0){
            modeloTabela.removeRow(0);
        }
        //Preenche os dados na tabela
        for(ItemCompra ic: itensCompra){
            Object[] row = {
                ic.getProduto().getId(),
                ic.getProduto().getNome(),
                ic.getQuantidade(),
                ic.getProduto().getPrecoCompra()
            };
            modeloTabela.addRow(row);
        }

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewCompra dialog = new ViewCompra(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnBuscaFornecedor;
    private javax.swing.JButton btnBuscaProduto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizarCompra;
    private javax.swing.JButton btnRemoverItem;
    private com.toedter.calendar.JDateChooser dtDataCompra;
    private javax.swing.JLabel lblDataCompra;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblRS;
    private javax.swing.JLabel lblRSPreco;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlDadosCompra;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlFormularioItens;
    private javax.swing.JPanel pnlItensCompra;
    private javax.swing.JTabbedPane pnlPrincipal;
    private javax.swing.JScrollPane scpItensCompra;
    private javax.swing.JSpinner spQuantidade;
    private javax.swing.JTable tblItensCompra;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
