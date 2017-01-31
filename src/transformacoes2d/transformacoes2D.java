package transformacoes2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class transformacoes2D extends javax.swing.JFrame {

    private Boolean desenhandoReta;
    private Boolean desenhandoRetangulo;
    private int desenhandoTriangulo;
    private Boolean fazendoTranslacao;
    private Boolean fazendoMudEscala;
    private Boolean fazendoRotacao;
    
    private final Graphics2D graphic;
    
    private Point pPrimeiro;
    private Point pSegundo;
    private Point pTerceiro;
    
    private final Line2D[] retas;
    private final Rectangle[] retangulos;
    private final Polygon[] triangulos;
    
    private int countRetas;
    private int countRetangulos;
    private int countTriangulos;
    
    public transformacoes2D() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        panelDraw.setBackground(Color.WHITE);
        
        graphic = (Graphics2D) panelDraw.getGraphics();
        graphic.setBackground(Color.WHITE);
        graphic.setColor(Color.BLACK);
        graphic.setStroke(new BasicStroke(5));
        
        retas = new Line2D[100];
        retangulos = new Rectangle[100];
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
        btTranslacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTranslacaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(btMudEscala);
        btMudEscala.setText("M. Escala");
        btMudEscala.setPreferredSize(new java.awt.Dimension(85, 23));
        btMudEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMudEscalaActionPerformed(evt);
            }
        });

        buttonGroup1.add(btRotacao);
        btRotacao.setText("Rotação");
        btRotacao.setPreferredSize(new java.awt.Dimension(85, 23));
        btRotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRotacaoActionPerformed(evt);
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
                .addGap(32, 32, 32)
                .addComponent(btTranslacao)
                .addGap(18, 18, 18)
                .addComponent(btMudEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btRotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRotacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btClear)
                                .addComponent(rbReta)
                                .addComponent(rbRetangulo)
                                .addComponent(rbTriangulo)
                                .addComponent(rbCursor)
                                .addComponent(btTranslacao))
                            .addComponent(btMudEscala, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addComponent(btFechar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar)
                    .addComponent(tfComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDrawLayout.setVerticalGroup(
            panelDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            "Selecione um objeto! OBS: Para selecionar é necessário clicar no "
                    + "ponto inicial do objeto (em vermelho)");
    }//GEN-LAST:event_btTranslacaoActionPerformed

    private void btMudEscalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMudEscalaActionPerformed
        tfComando.setText(
            "Selecione um objeto! OBS: Para selecionar é necessário clicar no "
                    + "ponto inicial do objeto (em vermelho)");
    }//GEN-LAST:event_btMudEscalaActionPerformed

    private void btRotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRotacaoActionPerformed
        tfComando.setText(
            "Selecione um objeto! OBS: Para selecionar é necessário clicar no "
                    + "ponto inicial do objeto (em vermelho)");
    }//GEN-LAST:event_btRotacaoActionPerformed

    private void inicializar() {
        desenhandoReta = Boolean.FALSE;
        desenhandoRetangulo = Boolean.FALSE;
        desenhandoTriangulo = 0;
        fazendoTranslacao = Boolean.FALSE;
        fazendoMudEscala = Boolean.FALSE;
        fazendoRotacao = Boolean.FALSE;
        
        Arrays.fill(retas, null);
        Arrays.fill(retangulos, null);
        Arrays.fill(triangulos, null);        
        
        countRetas = 0;
        countRetangulos = 0;
        countTriangulos = 0;
    }
    
    private void adicionarReta(Point point) {
        if (desenhandoReta) {
            desenhandoReta = Boolean.FALSE;
            pSegundo = point;
            
            Line2D reta = new Line2D.Double(pPrimeiro, pSegundo);            
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
            
            int iniX, iniY, finX, finY;
            
            if (pPrimeiro.getX() > pSegundo.getX()) {
                iniX = (int) pSegundo.getX();
                finX = (int) pPrimeiro.getX();
            } else {
                iniX = (int) pPrimeiro.getX();
                finX = (int) pSegundo.getX();
            }
            
            if (pPrimeiro.getY() > pSegundo.getY()) {
                iniY = (int) pSegundo.getY();
                finY = (int) pPrimeiro.getY();
            } else {
                iniY = (int) pPrimeiro.getY();
                finY = (int) pSegundo.getY();
            }
            
            Rectangle retangulo = new Rectangle(iniX, iniY, (finX - iniX),
                    (finY - iniY));
            
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
                if (retas[i].intersects(pPrimeiro.getX(), pPrimeiro.getY(),2,2) ) {
                    Double distanciaX = pSegundo.getX() - retas[i].getX1();
                    Double distanciaY = pSegundo.getY() - retas[i].getY1();

                    Point pointIniAux = new Point(
                            (int) (retas[i].getX1()+distanciaX),
                            (int) (retas[i].getY1()+distanciaY));

                    Point pointFinAux = new Point(
                            (int) (retas[i].getX2()+distanciaX), 
                            (int) (retas[i].getY2()+distanciaY));

                    retas[i].setLine(pointIniAux, pointFinAux);
                }
            }

            for (int i=0; i<countRetangulos; i++) {
                if (retangulos[i].contains(pPrimeiro) ) {
                    int distanciaX = (int) (pSegundo.getX() - retangulos[i].getX());
                    int distanciaY = (int) (pSegundo.getY() - retangulos[i].getY());

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
                    "Selecione um objeto! OBS: Para selecionar é necessário "
                            + "clicar no ponto inicial do objeto (em vermelho)");
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
                    Double escala = Double.parseDouble(
                        JOptionPane.showInputDialog("Digite o fator de escala :"));
                    
                    Double novoX = 
                            ((retas[i].getX2() - retas[i].getX1()) * escala) +
                            retas[i].getX1();
                    Double novoY = 
                            ((retas[i].getY2() - retas[i].getY1()) * escala) +
                            retas[i].getY1();

                    retas[i].setLine(retas[i].getX1(), retas[i].getY1(),
                            novoX, novoY);
                }
            }

            for (int i=0; i<countRetangulos; i++) {
                if (retangulos[i].contains(point) ) {
                    Double escalaX = Double.parseDouble(
                            JOptionPane.showInputDialog("Digite o fator de "
                                    + "escala em X: "));

                    Double escalaY = Double.parseDouble(
                            JOptionPane.showInputDialog("Digite agora o fator "
                                    + "de escala em Y: "));
                    
                    
                    Double novoWidth = retangulos[i].getWidth() * escalaX;
                    Double novoHeight = retangulos[i].getHeight() * escalaY;

                    retangulos[i].setRect(retangulos[i].getX(),
                            retangulos[i].getY(), novoWidth, novoHeight);
                }
            }

            for (int i=0; i<countTriangulos; i++) {
                if (triangulos[i].contains(point) ) {
                    Double escala = Double.parseDouble(
                            JOptionPane.showInputDialog("Digite o fator de "
                                    + "escala: "));
                   
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
                    "Selecione um objeto! OBS: Para selecionar é necessário "
                            + "clicar no ponto inicial do objeto (em vermelho)");
        } else {
            tfComando.setText("Ponto inválido! Selecione outro ponto!");
        }
    }
    
    private void rotacionarObjeto(Point point) {
        if (verificarPontoContemObjeto(point)) {
             for (int i=0; i<countRetas; i++) {
                if (retas[i].intersects(pPrimeiro.getX(), pPrimeiro.getY(),2,2) ) {                    
                    AffineTransform at = 
                            AffineTransform.getRotateInstance(
                                    Math.toRadians(90), 
                                    retas[i].getX1(), retas[i].getY1());
                    
                    Shape s = at.createTransformedShape(retas[i]);
                    
                    retas[i].setLine(retas[i].getX1(), retas[i].getY1(),
                            s.getBounds().getX(), s.getBounds().getY());
                }
            }

            for (int i=0; i<countRetangulos; i++) {
                if (retangulos[i].contains(point) ) {
                    AffineTransform at = new AffineTransform();
                    
                    at.rotate( Math.toRadians(90),
                            retangulos[i].getX(), retangulos[i].getY());
                    
                    Shape s = at.createTransformedShape(retangulos[i]);
                    
                    retangulos[i].setBounds((int) s.getBounds().getX(),
                            (int) s.getBounds().getY(), 
                            (int) s.getBounds().getWidth(),
                            (int) s.getBounds().getHeight());
                }
            }

            for (int i=0; i<countTriangulos; i++) {
                if (triangulos[i].contains(point) ) {
                    AffineTransform at = new AffineTransform();
                    
                    at.rotate( Math.toRadians(90),
                            triangulos[i].getBounds().getX(), 
                            triangulos[i].getBounds().getY());
                    
                    Shape s = at.createTransformedShape(triangulos[i]);
                    
                    //triangulos[i] = (Polygon) at.createTransformedShape(triangulos[i]);
                }
            }
            
            pintarObjetos();
            
            tfComando.setText(
                    "Selecione um objeto! OBS: Para selecionar é necessário "
                            + "clicar no ponto inicial do objeto (em vermelho)");            
        } else {
            tfComando.setText("Ponto inválido! Selecione outro ponto!");
        }
    }
    
    private Boolean verificarPontoContemObjeto(Point point) {
        Boolean contem = Boolean.FALSE;
        
        for (int i=0; i<countRetas; i++) {
            if (retas[i].intersects(point.getX(), point.getY(),2,2) )
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
            graphic.drawLine((int) retas[i].getX1(), (int) retas[i].getY1(),
                    (int) retas[i].getX2(), (int) retas[i].getY2());

            graphic.setColor(Color.RED);
            graphic.drawLine((int) retas[i].getX1(), (int) retas[i].getY1(),
                    (int) retas[i].getX1(), (int) retas[i].getY1());
        }
        
        for (int i=0; i<countRetangulos; i++) {
            graphic.setColor(Color.BLACK);
            graphic.draw((Rectangle) retangulos[i]);
            
            graphic.setColor(Color.RED);
            graphic.drawLine((int) retangulos[i].getX(), 
                    (int) retangulos[i].getY(), (int) retangulos[i].getX(),
                    (int) retangulos[i].getY());
        }
        
        for (int i=0; i<countTriangulos; i++) {            
            graphic.setColor(Color.BLACK);
                graphic.drawPolygon(triangulos[i]);
                
            graphic.setColor(Color.RED);
            graphic.drawLine((int) triangulos[i].xpoints[0], 
                    triangulos[i].ypoints[0],
                    triangulos[i].xpoints[0], 
                    triangulos[i].ypoints[0]);
        }
    }
    
    private void controlarPainel() {
        Boolean flag = rbCursor.isSelected();
        
        btClear.setEnabled(flag);
        btTranslacao.setEnabled(flag);
        btMudEscala.setEnabled(flag);
        btRotacao.setEnabled(flag);
        
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(transformacoes2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transformacoes2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transformacoes2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transformacoes2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
