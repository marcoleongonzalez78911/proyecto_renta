/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import views.ViewPrincipal;
import models.ModelPrincipal;
import views.ViewCliente;
import views.ViewPeliculas;
import views.ViewRenta;


/**
 *
 * @author mark
 */
public class ControllerPrincipal {
    ModelPrincipal modelp;
    ViewCliente viewcli;
    ViewPeliculas viewpelis;
    ViewRenta viewren;
    ViewPrincipal viewp;
    ControllerCliente controller_cli;
    
    
 public ControllerPrincipal(ModelPrincipal modelp,Object views[]){
    this.modelp = modelp;
    this.viewp = (ViewPrincipal) views[3];
    this.viewcli = (ViewCliente) views[0];
    this.viewpelis = (ViewPeliculas) views[1];
    this.viewren = (ViewRenta) views[2];
    
    
  //  viewp.jmi_salir.addActionListener(e -> jmi_salir_click());
    viewp.jmi_cliente.addActionListener(e -> jmi_clienteActionPerformed());
    viewp.jmi_pelicula.addActionListener(e -> jmi_peliculaActionPerformed());
    viewp.jmi_renta.addActionListener(e -> jmi_rentaActionPerformed());
    viewp.salir.addActionListener(e -> salir_click());
    
  initView();


}//contructor

 public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewp.jmi_cliente)
            jmi_clienteActionPerformed();
        if(e.getSource()==viewp.jmi_pelicula)
            jmi_peliculaActionPerformed();
        if(e.getSource()==viewp.jmi_renta)
            jmi_rentaActionPerformed();

 }
 
 public void jmi_clienteActionPerformed(){
        this.viewp.setContentPane(viewcli);
        this.viewp.revalidate();
        this.viewp.repaint();
    }
  public void jmi_peliculaActionPerformed(){
        this.viewp.setContentPane(viewpelis);
        this.viewp.revalidate();
        this.viewp.repaint();
    }
    public void jmi_rentaActionPerformed(){
        this.viewp.setContentPane(viewren);
        this.viewp.revalidate();
        this.viewp.repaint();
    }
 
 
    private void initView(){
       this.viewp.setLocationRelativeTo(null);
       this.viewp.setVisible(true);
    }
     
    private void salir_click(){
        System.exit(0);
    }
    
}//fin de la clase principal 
