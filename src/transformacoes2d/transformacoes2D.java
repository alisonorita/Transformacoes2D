package transformacoes2d;

import transformacoes2d.utils.Matrix;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class transformacoes2D extends javax.swing.JFrame {

    private Boolean desenhandoReta;
    private Boolean desenhandoRetangulo;
    private int desenhandoTriangulo;
    private Boolean fazendoTranslacao;
    
    private final Graphics2D graphic;
    
    private Point pPrimeiro;
    private Point pSegundo;
    private Point pTerceiro;
    
    private final Polygon[] retas;
    private final Polygon[] retangulos;
    private final Polygon[] triangulos;
    
    private int countRetas;
    private int countRetangulos;
    private int countTriangulos;
    
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    
    public transformacoes2D() {
        initComponents();
 
        btClear.setIcon(new ImageIcon(getClass().getResource("imagens/clear.png")));
        btTranslacao.setIcon(new ImageIcon(getClass().getResource("imagens/move.png")));
        btMudEscala.setIcon(new ImageIcon(getClass().getResource("imagens/scale.png")));
        btRotacao.setIcon(new ImageIcon(getClass().getResource("imagens/rotate.png")));
        btZoom.setIcon(new ImageIcon(getClass().getResource("imagens/zoom.png")));        
        btFechar.setIcon(new ImageIcon(getClass().getResource("imagens/close.png")));
        
        this.setLocationRelativeTo(null);
        panelDraw.setBackground(Color.WHITE);
        
        graphic = (Graphics2D) panelDraw.getGraphics();
        graphic.setBackground(Color.WHITE);
        graphic.setColor(Color.BLACK);
        graphic.setStroke(new BasicStroke(10));
        
        retas = new Polygon[100];
        retangulos = new Polygon[100];
        triangulos = new Polygon[100];
        
        inicializar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btClear = new javax.swing.JButton();
        rbCursor = new javax.swing.JRadioButton();
        rbReta = new javax.swing.JRadioButton();
        rbRetangulo = new javax.swing.JRadioButton();
        rbTriangulo = new javax.swing.JRadioButton();
        btTranslacao = new javax.swing.JToggleButton();
        btMudEscala = new javax.swing.JToggleButton();
        btRotacao = new javax.swing.JToggleButton();
        btZoom = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btFechar = new javax.swing.JButton();
        tfComando = new javax.swing.JTextField();
        panelDraw = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setFocusableWindowState(false);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btClear.setText("Clear");
        btClear.setToolTipText("");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbCursor);
        rbCursor.setSelected(true);
        rbCursor.setText("Cursor");
        rbCursor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCursorActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbReta);
        rbReta.setText("Reta");
        rbReta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRetaActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbRetangulo);
        rbRetangulo.setText("Retângulo");
        rbRetangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRetanguloActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbTriangulo);
        rbTriangulo.setText("Triângulo");
        rbTriangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTrianguloActionPerformed(evt);
            }
        });

        buttonGroup1.add(btTranslacao);
        btTranslacao.setText("Translação");
        btTranslacao.setMaximumSize(new java.awt.Dimension(90, 23));
        btTranslacao.setMinimumSize(new java.awt.Dimension(90, 23));
        btTranslacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTranslacaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(btMudEscala);
        btMudEscala.setText("M. Escala");
        btMudEscala.setMaximumSize(new java.awt.Dimension(90, 23));
        btMudEscala.setMinimumSize(new java.awt.Dimension(90, 23));
        btMudEscala.setPreferredSize(new java.awt.Dimension(85, 23));
        btMudEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMudEscalaActionPerformed(evt);
            }
        });

        buttonGroup1.add(btRotacao);
        btRotacao.setText("Rotação");
        btRotacao.setMaximumSize(new java.awt.Dimension(90, 23));
        btRotacao.setMinimumSize(new java.awt.Dimension(90, 23));
        btRotacao.setPreferredSize(new java.awt.Dimension(85, 23));
        btRotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRotacaoActionPerformed(evt);
            }
        });

        btZoom.setText("Zoom Extend");
        btZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btZoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btClear)
                .addGap(37, 37, 37)
                .addComponent(rbCursor)
                .addGap(18, 18, 18)
                .addComponent(rbReta)
                .addGap(18, 18, 18)
                .addComponent(rbRetangulo)
                .addGap(18, 18, 18)
                .addComponent(rbTriangulo)
                .addGap(18, 18, 18)
                .addComponent(btTranslacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btMudEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btRotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btZoom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btZoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRotacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btMudEscala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbReta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbRetangulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbTriangulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbCursor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btTranslacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfComando)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfComando)
                    .addComponent(btFechar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelDraw.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDraw.setForeground(new java.awt.Color(255, 255, 255));
        panelDraw.setName(""); // NOI18N
        panelDraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDrawMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelDrawLayout = new javax.swing.GroupLayout(panelDraw);
        panelDraw.setLayout(panelDrawLayout);
        panelDrawLayout.setHorizontalGroup(
            panelDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        panelDrawLayout.setVerticalGroup(
            panelDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btFecharActionPerformed

    private void panelDrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDrawMouseClicked
        if (rbReta.isSelected()) {
            adicionarReta(evt.getPoint());
        } 
        else if (rbRetangulo.isSelected()) {
            adicionarRetangulo(evt.getPoint());
        } 
        else if (rbTriangulo.isSelected()) {
            adicionarTriangulo(evt.getPoint());
        }
        else if (btTranslacao.isSelected()) {
            transladarObjeto(evt.getPoint());
        }
        else if (btMudEscala.isSelected()) {
            mudarEscalaObjeto(evt.getPoint());
        }        
        else if (btRotacao.isSelected()) {
            rotacionarObjeto(evt.getPoint());
        }
    }//GEN-LAST:event_panelDrawMouseClicked

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        graphic.clearRect(0, 0, getWidth(), getHeight());
        graphic.setBackground(Color.WHITE);
        inicializar();
    }//GEN-LAST:event_btClearActionPerformed

    private void rbRetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRetaActionPerformed
        controlarPainel();
        tfComando.setText(
                "Selecione na área de desenho um ponto inicial para a RETA!");
    }//GEN-LAST:event_rbRetaActionPerformed

    private void rbRetanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRetanguloActionPerformed
        controlarPainel();
        tfComando.setText(
                "Selecione na área de desenho um ponto inicial para o RETÂNGULO!");
    }//GEN-LAST:event_rbRetanguloActionPerformed

    private void rbTrianguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTrianguloActionPerformed
        controlarPainel();
        tfComando.setText(
                "Selecione na área de desenho um ponto inicial para o TRIÂNGULO!");
    }//GEN-LAST:event_rbTrianguloActionPerformed

    private void rbCursorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCursorActionPerformed
        controlarPainel();
        tfComando.setText("");
    }//GEN-LAST:event_rbCursorActionPerformed

    private void btTranslacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTranslacaoActionPerformed
        tfComando.setText(
            "Selecione um objeto! OBS: Para selecionar pode clicar em um ponto "
                    + "que contém o objeto");
    }//GEN-LAST:event_btTranslacaoActionPerformed

    private void btMudEscalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMudEscalaActionPerformed
        tfComando.setText(
            "Selecione um objeto! OBS: Para selecionar pode clicar em um ponto "
                    + "que contém o objeto");
    }//GEN-LAST:event_btMudEscalaActionPerformed

    private void btRotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRotacaoActionPerformed
        tfComando.setText(
            "Selecione um objeto! OBS: Para selecionar pode clicar em um ponto "
                    + "que contém o objeto");
    }//GEN-LAST:event_btRotacaoActionPerformed

    private void btZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btZoomActionPerformed
        transformacaoZoomExtend();
    }//GEN-LAST:event_btZoomActionPerformed

    private void inicializar() {
        desenhandoReta = Boolean.FALSE;
        desenhandoRetangulo = Boolean.FALSE;
        desenhandoTriangulo = 0;
        fazendoTranslacao = Boolean.FALSE;
        
        Arrays.fill(retas, null);
        Arrays.fill(retangulos, null);
        Arrays.fill(triangulos, null);        
        
        countRetas = 0;
        countRetangulos = 0;
        countTriangulos = 0;
        
        minX = 1000;
        minY = 1000;
        maxX = 0;
        maxY = 0;
    }
    
    private void adicionarReta(Point point) {
        if (desenhandoReta) {
            desenhandoReta = Boolean.FALSE;
            pSegundo = point;
            
            Polygon reta = new Polygon();
            reta.addPoint((int) pPrimeiro.getX(), (int) pPrimeiro.getY());
            reta.addPoint((int) pSegundo.getX(), (int) pSegundo.getY());
            
            retas[countRetas] = reta;
            countRetas++;
            
            pintarObjetos();
            
            tfComando.setText(
                "Selecione na área de desenho um ponto inicial para a RETA!");
        } else {
            desenhandoReta = Boolean.TRUE;
            pPrimeiro = point;
            
            graphic.setColor(Color.RED);
            graphic.drawLine((int) pPrimeiro.getX(), (int) pPrimeiro.getY(),
                    (int) pPrimeiro.getX(), (int) pPrimeiro.getY());
            
            tfComando.setText(
                "Selecione outro ponto para fechar a RETA!");
        }
    }
    
    private void adicionarRetangulo(Point point) {
        if (desenhandoRetangulo) {
            desenhandoRetangulo = Boolean.FALSE;
            pSegundo = point;
            
            Polygon retangulo = new Polygon();
            retangulo.addPoint((int) pPrimeiro.getX(), (int) pPrimeiro.getY());
            retangulo.addPoint((int) pSegundo.getX(), (int) pPrimeiro.getY());
            retangulo.addPoint((int) pSegundo.getX(), (int) pSegundo.getY());
            retangulo.addPoint((int) pPrimeiro.getX(), (int) pSegundo.getY());
            
            retangulos[countRetangulos] = retangulo;
            countRetangulos++;
            
            pintarObjetos();
            
            tfComando.setText(
                "Selecione na área de desenho um ponto inicial para o RETÂNGULO!");
        } else {
            desenhandoRetangulo = Boolean.TRUE;
            pPrimeiro = point;
            
            graphic.setColor(Color.RED);
            graphic.drawLine((int) pPrimeiro.getX(), (int) pPrimeiro.getY(),
                    (int) pPrimeiro.getX(), (int) pPrimeiro.getY());
            
            tfComando.setText(
                "Selecione outro ponto para fechar o RETÂNGULO!");
        }
    }
    
    private void adicionarTriangulo(Point point) {
        switch (desenhandoTriangulo) {
            case 0:
                desenhandoTriangulo++;
                pPrimeiro = point;
                
                graphic.setColor(Color.RED);
                graphic.drawLine((int) pPrimeiro.getX(), (int) pPrimeiro.getY(),
                        (int) pPrimeiro.getX(), (int) pPrimeiro.getY());
                
                tfComando.setText(
                    "Selecione outro ponto para o TRIÂNGULO!");
                break;
            case 1:
                desenhandoTriangulo++;
                pSegundo = point;
                
                graphic.setColor(Color.BLACK);
                graphic.drawLine((int) pPrimeiro.getX(), (int) pPrimeiro.getY(),
                        (int) pSegundo.getX(), (int) pSegundo.getY());
               
                graphic.setColor(Color.RED);
                graphic.drawLine((int) pPrimeiro.getX(), (int) pPrimeiro.getY(),
                        (int) pPrimeiro.getX(), (int) pPrimeiro.getY());
                
                graphic.setColor(Color.GREEN);
                graphic.drawLine((int) pSegundo.getX(), (int) pSegundo.getY(),
                        (int) pSegundo.getX(), (int) pSegundo.getY());
                
                tfComando.setText(
                    "Selecione o último ponto para fechar o TRIÂNGULO!");
                break;
            default:
                desenhandoTriangulo = 0;
                pTerceiro = point;
                
                Polygon triangulo = new Polygon();
                triangulo.addPoint((int) pPrimeiro.getX(), 
                        (int) pPrimeiro.getY());
                triangulo.addPoint((int) pSegundo.getX(), 
                        (int) pSegundo.getY());
                triangulo.addPoint((int) pTerceiro.getX(), 
                        (int) pTerceiro.getY());
                
                triangulos[countTriangulos] = triangulo;
                countTriangulos++;
                
                pintarObjetos();
                
                tfComando.setText(
                    "Selecione na área de desenho um ponto inicial para o TRIÂNGULO!");
                break;
        }
    }
    
    private void transladarObjeto(Point point) {
        if (fazendoTranslacao) {
            fazendoTranslacao = Boolean.FALSE;
            pSegundo = point;
            
            for (int i=0; i<countRetas; i++) {
                if (retas[i].intersects(pPrimeiro.getX(), pPrimeiro.getY(),5,5)) {
                    int distanciaX = (int) (pSegundo.getX() - retas[i].xpoints[0]);
                    int distanciaY = (int) (pSegundo.getY() - retas[i].ypoints[0]);

                    retas[i].translate(distanciaX, distanciaY);
                }
            }

            for (int i=0; i<countRetangulos; i++) {
                if (retangulos[i].contains(pPrimeiro) ) {
                    int distanciaX = (int) (pSegundo.getX() - retangulos[i].xpoints[0]);
                    int distanciaY = (int) (pSegundo.getY() - retangulos[i].ypoints[0]);

                    retangulos[i].translate(distanciaX, distanciaY);
                }
            }

            for (int i=0; i<countTriangulos; i++) {
                if (triangulos[i].contains(pPrimeiro) ) {
                    int distanciaX = (int) (pSegundo.getX() - triangulos[i].xpoints[0]);
                    int distanciaY = (int) (pSegundo.getY() - triangulos[i].ypoints[0]);

                    triangulos[i].translate(distanciaX, distanciaY);
                }
            }
            
            pintarObjetos();
            
            tfComando.setText(
                    "Selecione um objeto! OBS: Para selecionar pode clicar em "
                            + "um ponto que contém o objeto");
        } else {
            if (verificarPontoContemObjeto(point)) {
                fazendoTranslacao = Boolean.TRUE;
                pPrimeiro = point;
                        
                tfComando.setText("Selecione outro ponto para onde deseja "
                        + "transladar o objeto!");
            } else {
                tfComando.setText("Ponto inválido! Selecione outro ponto!");
            }
        }
    }
    
    private void mudarEscalaObjeto(Point point) {
        if (verificarPontoContemObjeto(point)) {  
            for (int i=0; i<countRetas; i++) {
                if (retas[i].intersects(point.getX(), point.getY(),2,2) ) {
                    
                    String input = JOptionPane.showInputDialog(null,
                                    "Digite o fator de escala :","1.00");
                    
                    Double escala;
                    if (input == null) {
                        escala = 1.00;
                    } else {
                        escala = Double.parseDouble(input);
                    }
                    
                    int novoX = 
                            (int) ((retas[i].xpoints[1] - retas[i].xpoints[0]) * 
                            escala) + retas[i].xpoints[0];
                    int novoY = 
                            (int) ((retas[i].ypoints[1] - retas[i].ypoints[0]) * 
                            escala) + retas[i].ypoints[0];
                    
                    Polygon reta = new Polygon();
                    reta.addPoint(retas[i].xpoints[0], retas[i].ypoints[0]);
                    reta.addPoint(novoX, novoY);

                    retas[i] = reta;
                }
            }

            for (int i=0; i<countRetangulos; i++) {
                if (retangulos[i].contains(point) ) {
                    String inputX = JOptionPane.showInputDialog(null,
                            "Digite o fator de escala em X: ","1.00");
                    
                    Double escalaX;
                    if (inputX == null) {
                        escalaX = 1.00;
                    } else {
                        escalaX = Double.parseDouble(inputX);
                    }

                    String inputY = JOptionPane.showInputDialog(null,
                            "Digite agora o fator de escala em Y: ","1.00");
                    
                    Double escalaY;
                    if (inputY == null) {
                        escalaY = 1.00;
                    } else {
                        escalaY = Double.parseDouble(inputY);
                    }
                    
                    int novoWidth = 
                            (int) ((retangulos[i].xpoints[2] - 
                            retangulos[i].xpoints[0]) * escalaX);
                    
                    int novoHeight = 
                            (int) ((retangulos[i].ypoints[2] - 
                             retangulos[i].ypoints[0]) * escalaY);
                    
                    Polygon retangulo = new Polygon();
                    retangulo.addPoint(
                            retangulos[i].xpoints[0], retangulos[i].ypoints[0]);
                    retangulo.addPoint(
                            (retangulos[i].xpoints[0] + novoWidth), retangulos[i].ypoints[0]);
                    retangulo.addPoint(
                            (retangulos[i].xpoints[0] + novoWidth), 
                            (retangulos[i].ypoints[0] + novoHeight));
                    retangulo.addPoint(
                            retangulos[i].xpoints[0], (retangulos[i].ypoints[0] + novoHeight));

                    retangulos[i] = retangulo;
                }
            }

            for (int i=0; i<countTriangulos; i++) {
                if (triangulos[i].contains(point) ) {
                    String input = JOptionPane.showInputDialog(null,
                            "Digite o fator de escala: ","1.00");
                    
                    Double escala;
                    if (input == null) {
                        escala = 1.00;
                    } else {
                        escala = Double.parseDouble(input);
                    }
                   
                    int novoXdeA = 
                            (int) ((triangulos[i].xpoints[1] - 
                                triangulos[i].xpoints[0]) 
                                * escala) + triangulos[i].xpoints[0];
                    int novoYdeA = 
                            (int) ((triangulos[i].ypoints[1] - 
                                triangulos[i].ypoints[0]) 
                                * escala) + triangulos[i].ypoints[0];
                    
                    int novoXdeB = 
                            (int) ((triangulos[i].xpoints[2] - 
                                triangulos[i].xpoints[0]) 
                                * escala) + triangulos[i].xpoints[0];
                    int novoYdeB = 
                            (int) ((triangulos[i].ypoints[2] - 
                                triangulos[i].ypoints[0]) 
                                * escala) + triangulos[i].ypoints[0];
                    
                    Polygon triangulo = new Polygon();
                    triangulo.addPoint(triangulos[i].xpoints[0], 
                            triangulos[i].ypoints[0]);
                    triangulo.addPoint(novoXdeA, novoYdeA);
                    triangulo.addPoint(novoXdeB, novoYdeB);

                    triangulos[i] = triangulo;
                }
            }
            
            pintarObjetos();
            
            tfComando.setText(
                    "Selecione um objeto! OBS: Para selecionar pode clicar em "
                            + "um ponto que contém o objeto");
        } else {
            tfComando.setText("Ponto inválido! Selecione outro ponto!");
        }
    }
    
    private void rotacionarObjeto(Point point) {
        if (verificarPontoContemObjeto(point)) {
             for (int i=0; i<countRetas; i++) {
                if (retas[i].intersects(point.getX(), point.getY(),2,2) ) {                    
                    double[][] matrizObjAux = new double[3][2];  
                    
                    matrizObjAux[0][0] = retas[i].xpoints[0];
                    matrizObjAux[0][1] = retas[i].xpoints[1];
                    matrizObjAux[1][0] = retas[i].ypoints[0];
                    matrizObjAux[1][1] = retas[i].ypoints[1];
                    matrizObjAux[2][0] = 1;
                    matrizObjAux[2][1] = 1;  
                    
                    Matrix matrizObj = new Matrix(matrizObjAux);
                    
                    Matrix matrizRes = matrizObj.rotate(matrizObj, 
                            retas[i].xpoints[0], retas[i].ypoints[0]);
                    
                    Polygon reta = new Polygon();
                    reta.addPoint((int) matrizRes.getData(0, 0),
                            (int) matrizRes.getData(1, 0));
                    reta.addPoint((int) matrizRes.getData(0, 1),
                            (int) matrizRes.getData(1, 1));
                    
                    retas[i] = reta;
                }
            }

            for (int i=0; i<countRetangulos; i++) {
                if (retangulos[i].contains(point) ) {                    
                    double[][] matrizObjAux = new double[3][4];  
                    
                    matrizObjAux[0][0] = retangulos[i].xpoints[0];
                    matrizObjAux[0][1] = retangulos[i].xpoints[1];
                    matrizObjAux[0][2] = retangulos[i].xpoints[2];
                    matrizObjAux[0][3] = retangulos[i].xpoints[3];
                    matrizObjAux[1][0] = retangulos[i].ypoints[0];
                    matrizObjAux[1][1] = retangulos[i].ypoints[1];
                    matrizObjAux[1][2] = retangulos[i].ypoints[2];
                    matrizObjAux[1][3] = retangulos[i].ypoints[3];
                    matrizObjAux[2][0] = 1;
                    matrizObjAux[2][1] = 1;
                    matrizObjAux[2][2] = 1;
                    matrizObjAux[2][3] = 1;    
                    
                    Matrix matrizObj = new Matrix(matrizObjAux);
                    
                    Matrix matrizRes = matrizObj.rotate(
                            matrizObj, retangulos[i].xpoints[0], 
                            retangulos[i].ypoints[0]);
                    
                    Polygon retangulo = new Polygon();
                    retangulo.addPoint((int) matrizRes.getData(0, 0), 
                            (int) matrizRes.getData(1, 0));
                    retangulo.addPoint((int) matrizRes.getData(0, 1), 
                            (int) matrizRes.getData(1, 1));
                    retangulo.addPoint((int) matrizRes.getData(0, 2), 
                            (int) matrizRes.getData(1, 2));
                    retangulo.addPoint((int) matrizRes.getData(0, 3), 
                            (int) matrizRes.getData(1, 3));
                    
                    retangulos[i] = retangulo;
                }
            }

            for (int i=0; i<countTriangulos; i++) {
                if (triangulos[i].contains(point) ) {
                    double[][] matrizObjAux = new double[3][3];
                    
                    matrizObjAux[0][0] = triangulos[i].xpoints[0];
                    matrizObjAux[0][1] = triangulos[i].xpoints[1];
                    matrizObjAux[0][2] = triangulos[i].xpoints[2];
                    matrizObjAux[1][0] = triangulos[i].ypoints[0];
                    matrizObjAux[1][1] = triangulos[i].ypoints[1];
                    matrizObjAux[1][2] = triangulos[i].ypoints[2];
                    matrizObjAux[2][0] = 1;
                    matrizObjAux[2][1] = 1;
                    matrizObjAux[2][2] = 1;
                    
                    Matrix matrizObj = new Matrix(matrizObjAux);
                    
                    Matrix matrizRes = matrizObj.rotate(
                            matrizObj, triangulos[i].xpoints[0], triangulos[i].ypoints[0]);
                    
                    Polygon triangulo = new Polygon();                    
                    triangulo.addPoint((int) matrizRes.getData(0, 0), 
                            (int) matrizRes.getData(1, 0));
                    triangulo.addPoint((int) matrizRes.getData(0, 1), 
                            (int) matrizRes.getData(1, 1));
                    triangulo.addPoint((int) matrizRes.getData(0, 2), 
                            (int) matrizRes.getData(1, 2));
                    
                    triangulos[i] = triangulo;
                }
            }
            
            pintarObjetos();
            
            tfComando.setText(
                    "Selecione um objeto! OBS: Para selecionar pode clicar em "
                            + "um ponto que contém o objeto");
        } else {
            tfComando.setText("Ponto inválido! Selecione outro ponto!");
        }
    }
    
    private void transformacaoZoomExtend() {
        int minViewX = 50;
        int minViewY = 50;
        int maxViewX = panelDraw.getWidth()-50;
        int maxViewY = panelDraw.getHeight()-50;
        
        int minWinX = 0;
        int minWinY = 0;
        int maxWinX = panelDraw.getWidth();
        int maxWinY = panelDraw.getHeight();
            
        for (int i=0; i<countRetas; i++) {
            double[][] matrizObjAux = new double[3][2];

            matrizObjAux[0][0] = retas[i].xpoints[0];
            matrizObjAux[0][1] = retas[i].xpoints[1];
            matrizObjAux[1][0] = retas[i].ypoints[0];
            matrizObjAux[1][1] = retas[i].ypoints[1];
            matrizObjAux[2][0] = 1;
            matrizObjAux[2][1] = 1;  

            Matrix matrizObj = new Matrix(matrizObjAux);

            Matrix matrizRes = new Matrix(3,3).getMatrixTransformacao(
                minViewX, minViewY, maxViewX, maxViewY, 
                minWinX, minWinY, maxWinX, maxWinY, matrizObj);

            Polygon reta = new Polygon();
            reta.addPoint((int) matrizRes.getData(0, 0),
                    (int) matrizRes.getData(1, 0));
            reta.addPoint((int) matrizRes.getData(0, 1),
                    (int) matrizRes.getData(1, 1));

            retas[i] = reta;
        }  
        
        for (int i=0; i<countRetangulos; i++) {
            double[][] matrizObjAux = new double[3][4];  

            matrizObjAux[0][0] = retangulos[i].xpoints[0];
            matrizObjAux[0][1] = retangulos[i].xpoints[1];
            matrizObjAux[0][2] = retangulos[i].xpoints[2];
            matrizObjAux[0][3] = retangulos[i].xpoints[3];
            matrizObjAux[1][0] = retangulos[i].ypoints[0];
            matrizObjAux[1][1] = retangulos[i].ypoints[1];
            matrizObjAux[1][2] = retangulos[i].ypoints[2];
            matrizObjAux[1][3] = retangulos[i].ypoints[3];
            matrizObjAux[2][0] = 1;
            matrizObjAux[2][1] = 1;
            matrizObjAux[2][2] = 1;
            matrizObjAux[2][3] = 1;    

            Matrix matrizObj = new Matrix(matrizObjAux);

            Matrix matrizRes = new Matrix(3,3).getMatrixTransformacao(
                minViewX, minViewY, maxViewX, maxViewY, 
                minWinX, minWinY, maxWinX, maxWinY, matrizObj);

            Polygon retangulo = new Polygon();
            retangulo.addPoint((int) matrizRes.getData(0, 0), 
                    (int) matrizRes.getData(1, 0));
            retangulo.addPoint((int) matrizRes.getData(0, 1), 
                    (int) matrizRes.getData(1, 1));
            retangulo.addPoint((int) matrizRes.getData(0, 2), 
                    (int) matrizRes.getData(1, 2));
            retangulo.addPoint((int) matrizRes.getData(0, 3), 
                    (int) matrizRes.getData(1, 3));

            retangulos[i] = retangulo;
        }
        
        for (int i=0; i<countTriangulos; i++) {            
            double[][] matrizObjAux = new double[3][3];

            matrizObjAux[0][0] = triangulos[i].xpoints[0];
            matrizObjAux[0][1] = triangulos[i].xpoints[1];
            matrizObjAux[0][2] = triangulos[i].xpoints[2];
            matrizObjAux[1][0] = triangulos[i].ypoints[0];
            matrizObjAux[1][1] = triangulos[i].ypoints[1];
            matrizObjAux[1][2] = triangulos[i].ypoints[2];
            matrizObjAux[2][0] = 1;
            matrizObjAux[2][1] = 1;
            matrizObjAux[2][2] = 1;

            Matrix matrizObj = new Matrix(matrizObjAux);

            Matrix matrizRes = new Matrix(3,3).getMatrixTransformacao(
                minViewX, minViewY, maxViewX, maxViewY, 
                minWinX, minWinY, maxWinX, maxWinY, matrizObj);

            Polygon triangulo = new Polygon();                    
            triangulo.addPoint((int) matrizRes.getData(0, 0), 
                    (int) matrizRes.getData(1, 0));
            triangulo.addPoint((int) matrizRes.getData(0, 1), 
                    (int) matrizRes.getData(1, 1));
            triangulo.addPoint((int) matrizRes.getData(0, 2), 
                    (int) matrizRes.getData(1, 2));

            triangulos[i] = triangulo;
        }
        
        pintarObjetos();
    }
    
    private Boolean verificarPontoContemObjeto(Point point) {
        Boolean contem = Boolean.FALSE;
        
        for (int i=0; i<countRetas; i++) {
            if (retas[i].intersects(point.getX(), point.getY(),5,5))
                contem = Boolean.TRUE;
        }
        
        for (int i=0; i<countRetangulos; i++) {
            if (retangulos[i].contains(point) )
                contem = Boolean.TRUE;
        }
        
        for (int i=0; i<countTriangulos; i++) {
            if (triangulos[i].contains(point) )
                contem = Boolean.TRUE;
        }
        
        return contem;
    } 
    
    private void pintarObjetos() {
        graphic.clearRect(0, 0, getWidth(), getHeight());
        graphic.setBackground(Color.WHITE);
        
        for (int i=0; i<countRetas; i++) {
            graphic.setColor(Color.BLACK);
            graphic.draw(retas[i]);

            graphic.setColor(Color.RED);
            graphic.drawLine(retas[i].xpoints[0], retas[i].ypoints[0],
                    retas[i].xpoints[0], retas[i].ypoints[0]);
            
            if (minX > retas[i].getBounds().getMinX())
                minX = (int) retas[i].getBounds().getMinX();
            
            if (minY > retas[i].getBounds().getMinY())
                minY = (int) retas[i].getBounds().getMinY();
            
            if (maxX < retas[i].getBounds().getMaxX())
                maxX = (int) retas[i].getBounds().getMaxX();
            
            if (maxY < retas[i].getBounds().getMaxY())
                maxY = (int) retas[i].getBounds().getMaxY();
        }
        
        for (int i=0; i<countRetangulos; i++) {
            graphic.setColor(Color.BLACK);
            graphic.draw(retangulos[i]);
            
            graphic.setColor(Color.RED);
            graphic.drawLine(retangulos[i].xpoints[0], retangulos[i].ypoints[0], 
                    retangulos[i].xpoints[0], retangulos[i].ypoints[0]);
            
            if (minX > retangulos[i].getBounds().getMinX())
                minX = (int) retangulos[i].getBounds().getMinX();
            
            if (minY > retangulos[i].getBounds().getMinY())
                minY = (int) retangulos[i].getBounds().getMinY();
            
            if (maxX < retangulos[i].getBounds().getMaxX())
                maxX = (int) retangulos[i].getBounds().getMaxX();
            
            if (maxY < retangulos[i].getBounds().getMaxY())
                maxY = (int) retangulos[i].getBounds().getMaxY();
        }
        
        for (int i=0; i<countTriangulos; i++) {            
            graphic.setColor(Color.BLACK);
                graphic.drawPolygon(triangulos[i]);
                
            graphic.setColor(Color.RED);
            graphic.drawLine(triangulos[i].xpoints[0], 
                    triangulos[i].ypoints[0],
                    triangulos[i].xpoints[0], 
                    triangulos[i].ypoints[0]);
            
            if (minX > triangulos[i].getBounds().getMinX())
                minX = (int) triangulos[i].getBounds().getMinX();
            
            if (minY > triangulos[i].getBounds().getMinY())
                minY = (int) triangulos[i].getBounds().getMinY();
            
            if (maxX < triangulos[i].getBounds().getMaxX())
                maxX = (int) triangulos[i].getBounds().getMaxX();
            
            if (maxY < triangulos[i].getBounds().getMaxY())
                maxY = (int) triangulos[i].getBounds().getMaxY();
        }
    }
    
    private void controlarPainel() {
        Boolean flag = rbCursor.isSelected();
        
        btClear.setEnabled(flag);
        btTranslacao.setEnabled(flag);
        btMudEscala.setEnabled(flag);
        btRotacao.setEnabled(flag);
        btZoom.setEnabled(flag);
        
        if (!flag) {
            btTranslacao.setSelected(Boolean.FALSE);
            btMudEscala.setSelected(Boolean.FALSE);
            btRotacao.setSelected(Boolean.FALSE);
        }
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transformacoes2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new transformacoes2D().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btFechar;
    private javax.swing.JToggleButton btMudEscala;
    private javax.swing.JToggleButton btRotacao;
    private javax.swing.JToggleButton btTranslacao;
    private javax.swing.JButton btZoom;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelDraw;
    private javax.swing.JRadioButton rbCursor;
    private javax.swing.JRadioButton rbReta;
    private javax.swing.JRadioButton rbRetangulo;
    private javax.swing.JRadioButton rbTriangulo;
    private javax.swing.JTextField tfComando;
    // End of variables declaration//GEN-END:variables

    private Object Point() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
