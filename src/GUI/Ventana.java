/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Model.AlgoritmosDeBusquedaNoInformada;
import Model.Archivo;
import Model.BusquedaAvara;
import Model.Nodo;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import javax.swing.JLabel;
import java.util.Timer;

public class Ventana extends javax.swing.JFrame {

    public Tablero tb = new Tablero();
    Archivo infoArchivo;
    JLabel[][] tablero;
    int optb, opab;

    public Ventana() {
        tablero = new JLabel[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = new JLabel();
            }
        }
        initComponents();
        cbxTipoBusqueda.addItem("Busqueda NO informada");
        cbxTipoBusqueda.addItem("Búsqueda informada");
        tipoBusqueda.setEnabled(false);
        tipoBusqueda.addItem("Búsqueda por amplitud");
        tipoBusqueda.addItem("Búsqueda por costo uniforme");
        tipoBusqueda.addItem("Búsqueda por profundidad");
        System.out.println("Selección: " + cbxTipoBusqueda.getSelectedIndex());
        setTitle("Goku Smart");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        infoArchivo = Archivo.abrirArchivo();
        tb.dibujarTablero(infoArchivo.getMatriz(), PanelTablero, tablero);
        //AlgoritmosDeBusquedaNoInformada.busquedaPorAmplitud(matriz,0,0);
        //BusquedaAvara.busquedaAvara(matriz, 4, 0, 9, 3);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        tipoBusqueda = new javax.swing.JComboBox<>();
        PanelTablero = new javax.swing.JPanel();
        panelInfo = new javax.swing.JPanel();
        etiPath = new javax.swing.JLabel();
        etiCostoEditable = new javax.swing.JLabel();
        etiNodoExpandidos = new javax.swing.JLabel();
        etiCosto = new javax.swing.JLabel();
        etiProfundidadArb = new javax.swing.JLabel();
        etiProfundidadArbEditable = new javax.swing.JLabel();
        etiTiempoEjecucionEditable = new javax.swing.JLabel();
        etiTiempoEjecucion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        etiPathEditable = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        etiNodosExpandidosEditable = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelFondo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setForeground(new java.awt.Color(102, 102, 255));
        setMinimumSize(new java.awt.Dimension(1000, 581));
        setSize(new java.awt.Dimension(1150, 581));

        cbxTipoBusqueda.setBackground(new java.awt.Color(102, 255, 102));
        cbxTipoBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxTipoBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona..." }));
        cbxTipoBusqueda.setFocusable(false);
        cbxTipoBusqueda.setMinimumSize(new java.awt.Dimension(102, 30));
        cbxTipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoBusquedaActionPerformed(evt);
            }
        });

        tipoBusqueda.setBackground(new java.awt.Color(102, 255, 102));
        tipoBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tipoBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        tipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona..." }));
        tipoBusqueda.setFocusable(false);
        tipoBusqueda.setMinimumSize(new java.awt.Dimension(102, 30));
        tipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBusquedaActionPerformed(evt);
            }
        });

        PanelTablero.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelTablero.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout PanelTableroLayout = new javax.swing.GroupLayout(PanelTablero);
        PanelTablero.setLayout(PanelTableroLayout);
        PanelTableroLayout.setHorizontalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        PanelTableroLayout.setVerticalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        panelInfo.setBackground(new java.awt.Color(102, 102, 205));
        panelInfo.setToolTipText("");
        panelInfo.setAutoscrolls(true);
        panelInfo.setMaximumSize(new java.awt.Dimension(306, 392));
        panelInfo.setMinimumSize(new java.awt.Dimension(306, 392));

        etiPath.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiPath.setForeground(new java.awt.Color(255, 255, 255));
        etiPath.setText("Ruta");

        etiCostoEditable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etiCostoEditable.setForeground(new java.awt.Color(255, 255, 255));
        etiCostoEditable.setText("....");

        etiNodoExpandidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiNodoExpandidos.setForeground(new java.awt.Color(255, 255, 255));
        etiNodoExpandidos.setText("Nodos expandidos");

        etiCosto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiCosto.setForeground(new java.awt.Color(255, 255, 255));
        etiCosto.setText("Costo de solución");

        etiProfundidadArb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiProfundidadArb.setForeground(new java.awt.Color(255, 255, 255));
        etiProfundidadArb.setText("Profundidad de árbol");

        etiProfundidadArbEditable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etiProfundidadArbEditable.setForeground(new java.awt.Color(255, 255, 255));
        etiProfundidadArbEditable.setText("....");

        etiTiempoEjecucionEditable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etiTiempoEjecucionEditable.setForeground(new java.awt.Color(255, 255, 255));
        etiTiempoEjecucionEditable.setText("....");

        etiTiempoEjecucion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiTiempoEjecucion.setForeground(new java.awt.Color(255, 255, 255));
        etiTiempoEjecucion.setText("Tiempo de ejecución");

        jScrollPane1.setBackground(new java.awt.Color(102, 102, 205));
        jScrollPane1.setForeground(new java.awt.Color(102, 102, 205));
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(16, 16));
        jScrollPane1.setOpaque(false);

        etiPathEditable.setBackground(new java.awt.Color(102, 102, 205));
        etiPathEditable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etiPathEditable.setForeground(new java.awt.Color(255, 255, 255));
        etiPathEditable.setText("....");
        etiPathEditable.setAutoscrolls(true);
        etiPathEditable.setOpaque(true);
        jScrollPane1.setViewportView(etiPathEditable);

        jScrollPane2.setBackground(new java.awt.Color(102, 102, 205));
        jScrollPane2.setForeground(new java.awt.Color(102, 102, 205));
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(16, 16));
        jScrollPane2.setOpaque(false);

        etiNodosExpandidosEditable.setBackground(new java.awt.Color(102, 102, 205));
        etiNodosExpandidosEditable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etiNodosExpandidosEditable.setForeground(new java.awt.Color(255, 255, 255));
        etiNodosExpandidosEditable.setText("....");
        etiNodosExpandidosEditable.setAutoscrolls(true);
        etiNodosExpandidosEditable.setOpaque(true);
        jScrollPane2.setViewportView(etiNodosExpandidosEditable);

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiNodoExpandidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiCostoEditable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiCosto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiProfundidadArbEditable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiProfundidadArb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiTiempoEjecucionEditable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiTiempoEjecucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(etiPath, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiNodoExpandidos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiProfundidadArb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiProfundidadArbEditable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiCostoEditable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiTiempoEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiTiempoEjecucionEditable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnIniciar.setBackground(new java.awt.Color(102, 102, 255));
        btnIniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar búsqueda");
        btnIniciar.setEnabled(false);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de búsqueda");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo de algoritmo");

        panelFondo.setMinimumSize(new java.awt.Dimension(1150, 581));
        panelFondo.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo-namek.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setMaximumSize(new java.awt.Dimension(1321, 581));
        jLabel4.setMinimumSize(new java.awt.Dimension(1321, 581));
        jLabel4.setPreferredSize(new Dimension(panelFondo.getWidth(), panelFondo.getHeight()));

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1179, Short.MAX_VALUE)
            .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFondoLayout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFondoLayout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipoBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnIniciar)))
                .addGap(44, 44, 44)
                .addComponent(PanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void movimientoGokuTiempo(List<Nodo> path) {
        Timer t = new Timer();
        TimerTask tarea = new TimerTask() {
            int c = 0;

            @Override
            public void run() {
                if (c != path.size()) {
                    tb.movimientoGoku(infoArchivo.getMatriz(), path, c, PanelTablero, tablero);
                } else {
                    btnIniciar.setEnabled(true);
                    t.cancel();
                }
                c++;
            }
        };

        t.schedule(tarea, 0, 500);
    }

    public void pintarInfoAlgoritmo(List<Nodo> path) {
        String strPath = "", strNodosExpandidos = "";
        for (int i = 0; i < path.size(); i++) {
            strPath += "[" + path.get(i).x + "," + path.get(i).y + "] ";
        }
        for (int i = 0; i < path.get(path.size() - 1).nodosExpandidos.size(); i++) {
            strNodosExpandidos += "[" + path.get(path.size() - 1).nodosExpandidos.get(i).x + "," + path.get(path.size() - 1).nodosExpandidos.get(i).y + "] ";
        }
        etiNodosExpandidosEditable.setText(path.get(path.size() - 1).nodosExpandidos.size() + " - " + strNodosExpandidos);
        etiProfundidadArbEditable.setText(String.valueOf(path.get(path.size() - 1).level));
        etiPathEditable.setText(path.size() + " - " + strPath);
    }

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        btnIniciar.setEnabled(false);
        List<Nodo> path = new ArrayList<>();
        infoArchivo = Archivo.abrirArchivo();
        tb.dibujarTablero(infoArchivo.getMatriz(), PanelTablero, tablero);

        if (optb == 1 && opab == 0) {
            long startTime = System.currentTimeMillis();
            path = AlgoritmosDeBusquedaNoInformada.busquedaPorAmplitud(infoArchivo.getMatriz(),infoArchivo.getGoku());
            //AlgoritmosDeBusquedaNoInformada.busquedaPorAmplitud(matriz,0,0);
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            etiTiempoEjecucionEditable.setText(String.valueOf(totalTime) + " ms");
            System.out.println("El tiempo total de ejecución de la función fue: " + totalTime + " milisegundos.");
            pintarInfoAlgoritmo(path);
            movimientoGokuTiempo(path);
        } else if (optb == 1 && opab == 1) {
            long startTime = System.currentTimeMillis();
            path = BusquedaAvara.busquedaAvara(infoArchivo.getMatriz(), infoArchivo.getGoku(), infoArchivo.getEsfera1(), infoArchivo.getEsfera2());
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            etiTiempoEjecucionEditable.setText(String.valueOf(totalTime) + " ms");
            System.out.println("El tiempo total de ejecución de la función fue: " + totalTime + " milisegundos.");
            pintarInfoAlgoritmo(path);
            movimientoGokuTiempo(path);
        } else if (optb == 1 && opab == 2) {
            long startTime = System.currentTimeMillis();
            path = AlgoritmosDeBusquedaNoInformada.busquedaPorProfundidad(infoArchivo.getMatriz(), infoArchivo.getGoku());
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            etiTiempoEjecucionEditable.setText(String.valueOf(totalTime) + " ms");
            System.out.println("El tiempo total de ejecución de la función fue: " + totalTime + " milisegundos.");
            pintarInfoAlgoritmo(path);
            movimientoGokuTiempo(path);
        }

        if (optb == 2 && opab == 0) {
            long startTime = System.currentTimeMillis();
            path = BusquedaAvara.busquedaAvara(infoArchivo.getMatriz(), infoArchivo.getGoku(), infoArchivo.getEsfera1(), infoArchivo.getEsfera2());
            //AlgoritmosDeBusquedaNoInformada.busquedaPorAmplitud(matriz,0,0);
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            etiTiempoEjecucionEditable.setText(String.valueOf(totalTime) + " ms");
            System.out.println("El tiempo total de ejecución de la función fue: " + totalTime + " milisegundos.");
            System.out.println("AVARA:");
            pintarInfoAlgoritmo(path);
            movimientoGokuTiempo(path);
        }
        if (optb == 2 && opab == 1) {
            long startTime = System.currentTimeMillis();
            path = AlgoritmosDeBusquedaNoInformada.busquedaPorAmplitud(infoArchivo.getMatriz(), infoArchivo.getGoku());
            //AlgoritmosDeBusquedaNoInformada.busquedaPorAmplitud(matriz,0,0);
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            etiTiempoEjecucionEditable.setText(String.valueOf(totalTime) + " ms");
            System.out.println("El tiempo total de ejecución de la función fue: " + totalTime + " milisegundos.");
            pintarInfoAlgoritmo(path);
            movimientoGokuTiempo(path);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void tipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBusquedaActionPerformed
        opab = tipoBusqueda.getSelectedIndex();
    }//GEN-LAST:event_tipoBusquedaActionPerformed

    private void cbxTipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoBusquedaActionPerformed
        optb = cbxTipoBusqueda.getSelectedIndex();

        switch (optb) {
            case 1:
                tipoBusqueda.setEnabled(true);
                btnIniciar.setEnabled(true);
                tipoBusqueda.removeAllItems();
                tipoBusqueda.addItem("Búsqueda por amplitud");
                tipoBusqueda.addItem("Búsqueda por costo uniforme");
                tipoBusqueda.addItem("Búsqueda por profundidad");
                break;
            case 2:
                tipoBusqueda.setEnabled(true);
                btnIniciar.setEnabled(true);
                tipoBusqueda.removeAllItems();
                tipoBusqueda.addItem("Búsqueda Avara");
                tipoBusqueda.addItem("Búsqueda Estrella");
                break;
            default:
                btnIniciar.setEnabled(false);
                tipoBusqueda.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_cbxTipoBusquedaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTablero;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JLabel etiCosto;
    private javax.swing.JLabel etiCostoEditable;
    private javax.swing.JLabel etiNodoExpandidos;
    private javax.swing.JLabel etiNodosExpandidosEditable;
    private javax.swing.JLabel etiPath;
    private javax.swing.JLabel etiPathEditable;
    private javax.swing.JLabel etiProfundidadArb;
    private javax.swing.JLabel etiProfundidadArbEditable;
    private javax.swing.JLabel etiTiempoEjecucion;
    private javax.swing.JLabel etiTiempoEjecucionEditable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JComboBox<String> tipoBusqueda;
    // End of variables declaration//GEN-END:variables
}
