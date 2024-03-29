package farmacia.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import farmacia.controller.Controller;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.UIManager;
 
public class Principal extends javax.swing.JFrame {
    
    private Controller controller;
    private Float valorTotal;
    private String nomeItemVenda;
    private String nomeItemEstoque;
    private int quantidadeItemEstoque;
    private ArrayList<String> nomeItemListaVenda;
    private ArrayList<Integer> quantidadeItemListaVenda;
    private ArrayList<Float> precoItemListaVenda;
    private NumberFormat numberFormatter;
    
    public Principal(Controller controller) {
        
        this.controller = controller;
        this.valorTotal = 0.00f;
        this.nomeItemVenda = "-";
        this.nomeItemEstoque = "-";  
        this.quantidadeItemEstoque = 0;
        this.nomeItemListaVenda = new ArrayList<>();
        this.quantidadeItemListaVenda = new ArrayList<>();
        this.precoItemListaVenda = new ArrayList<>();
        this.numberFormatter = NumberFormat.getCurrencyInstance(
                new Locale("pt", "BR"));
        
        UIManager.put("TabbedPane.selected", new Color(248, 248, 248));
        UIManager.put("TabbedPane.borderHightlightColor", new Color(175, 175, 175));
        UIManager.put("TabbedPane.contentAreaColor", new Color(248, 248, 248));
        UIManager.put("TabbedPane.focus", new Color(248, 248, 248));
                
        initComponents();
        escalarImagemVenda("remedio.png");
        escalarImagemEstoque("remedio.png");
        centralizaTela();        
        
    }
    
    public void centralizaTela(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    public void escalarImagemVenda(String nomeImagem){
        
        ImageIcon imagemMudarTamanho = new javax.swing.ImageIcon(getClass().
                getResource("/farmacia/model/imagens/"+nomeImagem));
        
        Image img = imagemMudarTamanho.getImage();
        
        //Escala Imagen da venda
        Image imgEscalada = img.getScaledInstance(fotoLabelVenda.getWidth(),
                fotoLabelVenda.getHeight(), Image.SCALE_SMOOTH);        
        ImageIcon iconeEscalado = new ImageIcon(imgEscalada);        
        fotoLabelVenda.setIcon(iconeEscalado);

    }
    
    public void escalarImagemEstoque(String nomeImagem){
        
        ImageIcon imagemMudarTamanho = new javax.swing.ImageIcon(getClass().
                getResource("/farmacia/model/imagens/"+ nomeImagem));
        
        Image img = imagemMudarTamanho.getImage();
        
        //escala Imagem do estoque
        Image imgEscalada = img.getScaledInstance(fotoLabelEstoque.getWidth(),
                fotoLabelEstoque.getHeight(), Image.SCALE_SMOOTH);        
        ImageIcon iconeEscalado= new ImageIcon(imgEscalada);        
        fotoLabelEstoque.setIcon(iconeEscalado);
    }
    
    public void limparVenda(){
        
        this.listaLabelVenda.setText("<html>Nome<br><br>");
        this.quantidadeLabelVenda.setText("<html>Qtd<br><br>");
        this.precoLabelVenda.setText("<html>Preço<br><br>");
        this.valorTotal = 0.00f;
        
        this.nomeItemListaVenda.clear();
        this.precoItemListaVenda.clear();
        this.quantidadeItemListaVenda.clear();

        this.valorTotalLabelVenda.setText("Valor total " + 
                this.numberFormatter.format(this.valorTotal));
        
    }
    
    public String formataDescricao(ArrayList arrayRemedio){        
                            
        return "<html>Nome: " + arrayRemedio.get(1).toString() +
            "<br><br>Preço: R$" + arrayRemedio.get(4).toString() +
            "<br><br>Quantidade: " + arrayRemedio.get(3).toString() +
            "<br><br><br>bula:<br>" + arrayRemedio.get(2).toString();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        titulo1jLabelVenda = new javax.swing.JLabel();
        listaLabelVenda = new javax.swing.JLabel();
        titulo2LabelVenda = new javax.swing.JLabel();
        fotoLabelVenda = new javax.swing.JLabel();
        descricaoLabelVenda = new javax.swing.JLabel();
        adicionarButtonVenda = new javax.swing.JButton();
        concluirButtonVenda = new javax.swing.JButton();
        titulo4LabelVenda = new javax.swing.JLabel();
        ListaDeRemediosComboBoxVenda = new javax.swing.JComboBox<>();
        valorTotalLabelVenda = new javax.swing.JLabel();
        limparButtonVendfa = new javax.swing.JButton();
        quantidadeLabelVenda = new javax.swing.JLabel();
        precoLabelVenda = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        titulo1LabelEstoque = new javax.swing.JLabel();
        fotoLabelEstoque = new javax.swing.JLabel();
        descricaoLabelEstoque = new javax.swing.JLabel();
        titulo2LabelEstoque = new javax.swing.JLabel();
        titulo3LabelEstoque = new javax.swing.JLabel();
        quantidadeTextFieldEstoque = new javax.swing.JTextField();
        MudarButtonEstoque = new javax.swing.JButton();
        ListaDeRemediosComboBoxEstoque = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Farmácia");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));

        titulo1jLabelVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1jLabelVenda.setText("Lista de itens");

        listaLabelVenda.setBackground(new java.awt.Color(255, 255, 255));
        listaLabelVenda.setText("<html>Nome<br><br>");
        listaLabelVenda.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        listaLabelVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listaLabelVenda.setOpaque(true);

        titulo2LabelVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2LabelVenda.setText("Pesquisar item");

        fotoLabelVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fotoLabelVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmacia/model.imagens/remedio.png"))); // NOI18N
        fotoLabelVenda.setToolTipText("");
        fotoLabelVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        fotoLabelVenda.setPreferredSize(new java.awt.Dimension(110, 143));
        fotoLabelVenda.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        descricaoLabelVenda.setBackground(new java.awt.Color(255, 255, 255));
        descricaoLabelVenda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        descricaoLabelVenda.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        descricaoLabelVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        descricaoLabelVenda.setOpaque(true);

        adicionarButtonVenda.setBackground(new java.awt.Color(255, 255, 255));
        adicionarButtonVenda.setText("Adicionar");
        adicionarButtonVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        adicionarButtonVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarButtonVendaActionPerformed(evt);
            }
        });

        concluirButtonVenda.setBackground(new java.awt.Color(255, 255, 255));
        concluirButtonVenda.setText("Concluir");
        concluirButtonVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        concluirButtonVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concluirButtonVendaActionPerformed(evt);
            }
        });

        titulo4LabelVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo4LabelVenda.setText("Descrição do item");

        ListaDeRemediosComboBoxVenda.setBackground(new java.awt.Color(255, 255, 255));
        ListaDeRemediosComboBoxVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Dorflex", "Xarelto", "Selozok", "Neosaldina", "Torsilax", "Aradois", "Glifage XR", "Addera D3", "Anthelios", "Buscopan composto" }));
        ListaDeRemediosComboBoxVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaDeRemediosComboBoxVendaActionPerformed(evt);
            }
        });

        valorTotalLabelVenda.setBackground(new java.awt.Color(255, 255, 255));
        valorTotalLabelVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorTotalLabelVenda.setText("Valor total R$ 0,00");
        valorTotalLabelVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        valorTotalLabelVenda.setOpaque(true);

        limparButtonVendfa.setBackground(new java.awt.Color(255, 255, 255));
        limparButtonVendfa.setText("Limpar");
        limparButtonVendfa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        limparButtonVendfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonVendfaActionPerformed(evt);
            }
        });

        quantidadeLabelVenda.setBackground(new java.awt.Color(255, 255, 255));
        quantidadeLabelVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantidadeLabelVenda.setText("<html>Qtd<br><br>");
        quantidadeLabelVenda.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        quantidadeLabelVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        quantidadeLabelVenda.setOpaque(true);

        precoLabelVenda.setBackground(new java.awt.Color(255, 255, 255));
        precoLabelVenda.setText("<html>Preço<br><br>");
        precoLabelVenda.setToolTipText("");
        precoLabelVenda.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        precoLabelVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        precoLabelVenda.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(valorTotalLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(limparButtonVendfa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(listaLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(quantidadeLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(precoLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(concluirButtonVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(titulo1jLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo2LabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fotoLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListaDeRemediosComboBoxVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titulo4LabelVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(descricaoLabelVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(adicionarButtonVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descricaoLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adicionarButtonVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(concluirButtonVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titulo2LabelVenda)
                            .addComponent(titulo1jLabelVenda)
                            .addComponent(titulo4LabelVenda))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(listaLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quantidadeLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(precoLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fotoLabelVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorTotalLabelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(limparButtonVendfa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ListaDeRemediosComboBoxVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Venda", jPanel1);

        jPanel2.setBackground(new java.awt.Color(248, 248, 248));

        titulo1LabelEstoque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1LabelEstoque.setText("Pesquisar item");

        fotoLabelEstoque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fotoLabelEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmacia/model.imagens/remedio.png"))); // NOI18N
        fotoLabelEstoque.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        descricaoLabelEstoque.setBackground(new java.awt.Color(255, 255, 255));
        descricaoLabelEstoque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        descricaoLabelEstoque.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        descricaoLabelEstoque.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        descricaoLabelEstoque.setOpaque(true);

        titulo2LabelEstoque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2LabelEstoque.setText("Descrição do item");

        titulo3LabelEstoque.setText("Mudar quantidade");

        quantidadeTextFieldEstoque.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        quantidadeTextFieldEstoque.setText("0");
        quantidadeTextFieldEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantidadeTextFieldEstoqueKeyReleased(evt);
            }
        });

        MudarButtonEstoque.setBackground(new java.awt.Color(255, 255, 255));
        MudarButtonEstoque.setText("Mudar");
        MudarButtonEstoque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MudarButtonEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MudarButtonEstoqueActionPerformed(evt);
            }
        });

        ListaDeRemediosComboBoxEstoque.setBackground(new java.awt.Color(255, 255, 255));
        ListaDeRemediosComboBoxEstoque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Dorflex", "Xarelto", "Selozok", "Neosaldina", "Torsilax", "Aradois", "Glifage XR", "Addera D3", "Anthelios", "Buscopan composto" }));
        ListaDeRemediosComboBoxEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaDeRemediosComboBoxEstoqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ListaDeRemediosComboBoxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fotoLabelEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titulo1LabelEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(descricaoLabelEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titulo2LabelEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantidadeTextFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titulo3LabelEstoque)
                            .addComponent(MudarButtonEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo1LabelEstoque)
                    .addComponent(titulo2LabelEstoque)
                    .addComponent(titulo3LabelEstoque))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fotoLabelEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descricaoLabelEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(quantidadeTextFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MudarButtonEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(ListaDeRemediosComboBoxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jTabbedPane1.addTab("Estoque", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Tabs");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void concluirButtonVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concluirButtonVendaActionPerformed
        
        if(this.valorTotal == 0.00f){
            
            showMessageDialog(null, "Lista de compras vazia");
        }else{

            this.controller.finalizaVenda(this.nomeItemListaVenda, 
                    this.quantidadeItemListaVenda);
            limparVenda();
            this.descricaoLabelVenda.setText("");
            escalarImagemVenda("remedio.png");
            this.ListaDeRemediosComboBoxVenda.setSelectedIndex(0);
            this.descricaoLabelEstoque.setText("");
            escalarImagemEstoque("remedio.png");
            this.ListaDeRemediosComboBoxEstoque.setSelectedIndex(0);
            showMessageDialog(null, "Venda realizada com sucesso");
            
        }
        
    }//GEN-LAST:event_concluirButtonVendaActionPerformed

    private void ListaDeRemediosComboBoxVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaDeRemediosComboBoxVendaActionPerformed
        
        if(this.ListaDeRemediosComboBoxVenda.getSelectedItem() != "-"){
            
            String itemSelecionado = this.ListaDeRemediosComboBoxVenda.
                            getSelectedItem().toString();
        
            ArrayList arrayRemedio = controller.retornaDescricao(itemSelecionado);
            
            this.nomeItemVenda = arrayRemedio.get(1).toString();

            this.descricaoLabelVenda.setText(formataDescricao(arrayRemedio));
            escalarImagemVenda(this.controller.nomeImagem());
            
        }else{
            this.descricaoLabelVenda.setText("");
            escalarImagemVenda("remedio.png");
        }
        
    }//GEN-LAST:event_ListaDeRemediosComboBoxVendaActionPerformed

    private void ListaDeRemediosComboBoxEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaDeRemediosComboBoxEstoqueActionPerformed
        
        if(this.ListaDeRemediosComboBoxEstoque.getSelectedItem() != "-"){
            
            String itemSelecionado = this.ListaDeRemediosComboBoxEstoque.
                            getSelectedItem().toString();
            
            ArrayList arrayRemedio = this.controller.retornaDescricao(itemSelecionado);
            
            this.nomeItemEstoque = arrayRemedio.get(1).toString();
            
            this.descricaoLabelEstoque.setText(formataDescricao(arrayRemedio));
            escalarImagemEstoque(this.controller.nomeImagem());
            
        }else{
            
            this.descricaoLabelEstoque.setText("");
            escalarImagemEstoque("remedio.png");
        }
        
    }//GEN-LAST:event_ListaDeRemediosComboBoxEstoqueActionPerformed

    private void adicionarButtonVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarButtonVendaActionPerformed
        
        String listaString = "";
        String quantidadeString = "";
        String precoString = "";
        
        if(this.ListaDeRemediosComboBoxVenda.getSelectedItem() != "-"){
            
            String nomeItem = this.controller.getNome();
            Float precoItem = this.controller.getPreco();
            
            if(this.nomeItemListaVenda.contains(this.controller.getNome())){
                
                int index = this.nomeItemListaVenda.
                            indexOf(this.controller.getNome());
                
                this.quantidadeItemListaVenda.set(index, 
                        (this.quantidadeItemListaVenda.get(index)+1));
                this.precoItemListaVenda.set(index, (this.precoItemListaVenda.
                        get(index)+ precoItem));
                
                Iterator percorreLista = this.quantidadeItemListaVenda.
                                            iterator();                
                quantidadeString = "<html>Qtd<br><br>";
                while(percorreLista.hasNext()){
                    
                    quantidadeString += (percorreLista.next()+"<br>");
                }
                
                percorreLista = this.precoItemListaVenda.
                                            iterator();                
                precoString = "<html>Preço<br><br>";
                while(percorreLista.hasNext()){
                    
                    precoString += (this.numberFormatter.format(
                            percorreLista.next())+"<br>");
                }
                
            }else{
                
                this.nomeItemListaVenda.add(nomeItem);
                this.precoItemListaVenda.add(precoItem);
                this.quantidadeItemListaVenda.add(1);
                
                listaString = this.listaLabelVenda.getText()+ nomeItem + 
                        "<br>";;
                quantidadeString = this.quantidadeLabelVenda.getText() + 
                        "1<br>";                
                precoString = this.precoLabelVenda.getText() + 
                        this.numberFormatter.format(precoItem) + "<br>";

                this.listaLabelVenda.setText(listaString);    
            }     
            
            this.quantidadeLabelVenda.setText(quantidadeString);
            this.precoLabelVenda.setText(precoString);
            this.valorTotal = this.valorTotal + precoItem;

            this.valorTotalLabelVenda.setText("Valor total " + 
                    this.numberFormatter.format(this.valorTotal));
        }       
        
    }//GEN-LAST:event_adicionarButtonVendaActionPerformed

    private void limparButtonVendfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonVendfaActionPerformed
        
        limparVenda();
    }//GEN-LAST:event_limparButtonVendfaActionPerformed

    private void MudarButtonEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MudarButtonEstoqueActionPerformed
        
        if(!this.nomeItemEstoque.contains("-")){
            
            this.controller.mudaQuantidadeEstoque(this.quantidadeItemEstoque, 
                    this.nomeItemEstoque);
            
            String itemSelecionado = this.ListaDeRemediosComboBoxEstoque.
                            getSelectedItem().toString();
            
            ArrayList arrayRemedio = this.controller.retornaDescricao(itemSelecionado);

            this.descricaoLabelEstoque.setText(formataDescricao(arrayRemedio));
            this.quantidadeTextFieldEstoque.setText("0");
                        
            if(this.nomeItemEstoque.contains(this.nomeItemVenda)){
                
                this.descricaoLabelVenda.setText(formataDescricao(arrayRemedio));                
            }
            escalarImagemEstoque(this.controller.nomeImagem());
            
        }
    }//GEN-LAST:event_MudarButtonEstoqueActionPerformed

    private void quantidadeTextFieldEstoqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadeTextFieldEstoqueKeyReleased
        
        try {
            
            this.quantidadeItemEstoque = 
                    Integer.parseInt(this.quantidadeTextFieldEstoque.getText());
            
        } catch (NumberFormatException e) {
            
            this.quantidadeTextFieldEstoque.setText("0");
        }
    }//GEN-LAST:event_quantidadeTextFieldEstoqueKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ListaDeRemediosComboBoxEstoque;
    private javax.swing.JComboBox<String> ListaDeRemediosComboBoxVenda;
    private javax.swing.JButton MudarButtonEstoque;
    private javax.swing.JButton adicionarButtonVenda;
    private javax.swing.JButton concluirButtonVenda;
    private javax.swing.JLabel descricaoLabelEstoque;
    private javax.swing.JLabel descricaoLabelVenda;
    private javax.swing.JLabel fotoLabelEstoque;
    private javax.swing.JLabel fotoLabelVenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton limparButtonVendfa;
    private javax.swing.JLabel listaLabelVenda;
    private javax.swing.JLabel precoLabelVenda;
    private javax.swing.JLabel quantidadeLabelVenda;
    private javax.swing.JTextField quantidadeTextFieldEstoque;
    private javax.swing.JLabel titulo1LabelEstoque;
    private javax.swing.JLabel titulo1jLabelVenda;
    private javax.swing.JLabel titulo2LabelEstoque;
    private javax.swing.JLabel titulo2LabelVenda;
    private javax.swing.JLabel titulo3LabelEstoque;
    private javax.swing.JLabel titulo4LabelVenda;
    private javax.swing.JLabel valorTotalLabelVenda;
    // End of variables declaration//GEN-END:variables
}
