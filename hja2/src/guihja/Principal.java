/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guihja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSlider;

/**
 *
 * @author YVCX
 */
public class Principal extends javax.swing.JPanel {
    /**
     * Creates new form principal
     */
    public Principal() {
        initComponents();
        t.reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t = new guihja.Tablero();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugador ");

        jButton1.setText("Pintar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(1000);
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jTextField2.setText("0,0%");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1))
                            .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String input = jTextField1.getText(), linea="";
        int a,b,temp,i=0,v=1, h=1, c,d,max=0;
        
        t.reset();
        while(i<input.length()){
        
            a=LogicaGui.CharToInt(input.charAt(i));
            b=LogicaGui.CharToInt(input.charAt(i+1));
            
            //CAMBIO DE A<B 
            if((i+2)<input.length() && ((input.charAt(i+2)=='o' && b<a) || (input.charAt(i+2)=='s' && a<b))){
                temp=a;
                a=b;
                b=temp;
            }  
            
            if((i+2)<input.length() && ((input.charAt(i+2)=='o' ) || (input.charAt(i+2)=='s' ))) i+=3;
            else i+=2;
            
            //SI ES XX+
            if(i<input.length() && input.charAt(i)=='+'){
                max=t.tam()-a+2;
                
                if(a<b){
                    v=0;
                    h=1;
                    max=b-a;
                }
                else if(a>b){
                    h=0;
                    v=1;
                    max=a-b;
                }
                else{
                    v=1;
                    h=1;
                }
                   
                for(int x=0;x<max; x++){
                    t.pintar(a+x*h, b+x*v,0);
                }
               i++;
            }
            
            if((i)<input.length() && input.charAt(i)=='-'){
                i++;
                c=LogicaGui.CharToInt(input.charAt(i));
                d=LogicaGui.CharToInt(input.charAt(i+1));
                
               //CAMBIO DE A<B  parte2
                if((i+2)<input.length() && ((input.charAt(i+2)=='o' && d<c) || (input.charAt(i+2)=='s' && c<d))){
                    temp=c;
                    c=d;
                    d=temp;
                }  

                if(input.charAt(i+2)=='o' || input.charAt(i+2)=='s') i+=3;
                else i+=2;
                
                if(a==c){
                    max=b-d;
                    h=0;
                }
                else if(b==d){
                    max=a-c;
                    v=0;
                }
                
                for(int x=0;x<=max; x++){
                    t.pintar(c+x*h, d+x*v,0);
                }
              
            }
            else  t.pintar(a, b,0);
            
            i++; //saltar la coma
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        double valor= jSlider1.getValue();
        valor=valor/10;
        jTextField2.setText(valor+"%");
        LogicaGui.setPorcentaje(valor);
    }//GEN-LAST:event_jSlider1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("0.0%");
        t.reset();
        jSlider1.setValue(0);
        LogicaGui.setPorcentaje(0.0);
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public static void updateContador(){
        jTextField2.setText(LogicaGui.getPorcentaje()+"%");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    private static javax.swing.JTextField jTextField2;
    private guihja.Tablero t;
    // End of variables declaration//GEN-END:variables
}
