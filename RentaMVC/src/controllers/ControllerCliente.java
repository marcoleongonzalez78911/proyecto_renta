/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelCliente;
import views.ViewCliente;
/**
 *
 * @author mark
 */
public class ControllerCliente {
    private final  ModelCliente modelcli;
    private final  ViewCliente viewcli;
    
    
 public ControllerCliente(ModelCliente modelcli, ViewCliente viewcli){
     
    this.modelcli = modelcli;
    this.viewcli = viewcli;
    
    this.viewcli.jbtn_primero.addActionListener(e -> jbtn_primero_click());
    this.viewcli.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
    this.viewcli.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
    this.viewcli.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
    this.viewcli.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
    this.viewcli.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
    this.viewcli.jbtn_eliminar.addActionListener(e -> jbtn_borrar_click());
 //   this.viewcli.jbtn_actualizar.addActionListener(e -> jbtn_modificar_click());
    
    initView();
    
 }//fin del Contructor 
 
 public void getValores(){
viewcli.jtf_id_cliente.setText(""+modelcli.getId_cliente());
viewcli.jtf_nombre.setText(modelcli.getNombre());
viewcli.jtf_email.setText(modelcli.getEmail());
viewcli.jtf_telefono.setText(modelcli.getTelefono());
viewcli.jtf_direccion.setText(modelcli.getDireccion());

}//fin de getvalores

public void setValores(){
modelcli.setId_cliente(Integer.parseInt(viewcli.jtf_id_cliente.getText()));
modelcli.setNombre(viewcli.jtf_nombre.getText());
modelcli.setTelefono(viewcli.jtf_telefono.getText());
modelcli.setEmail(viewcli.jtf_email.getText());
}//fin de setvalores

public void jbtn_nuevo_click(){
viewcli.jtf_id_cliente.setText("");
viewcli.jtf_nombre.setText("");
viewcli.jtf_telefono.setText("");
viewcli.jtf_email.setText("");
viewcli.jtf_direccion.setText("");
}//boton nuevo

public void jbtn_agregar_click(){
setValores();
modelcli.Insertar();
getValores();

}//boton agragar

/*public void jbtn_modificar_click(){
setValores();
modelcli.Insertar(modelcli.getNombre(),modelcli.getEmail(),modelcli.getTelefono(),modelcli.getDireccion());
getValores();

}//boton modificar*/

public void jbtn_primero_click(){
setValores();
modelcli.moverPrimero();
getValores();

}//boton moverPrimero

public void jbtn_ultimo_click(){
setValores();
modelcli.moverUltimo();
getValores();

}//boton ultimo

public void jbtn_borrar_click(){
setValores();
modelcli.borrar();
getValores();

}//boton modificar

public void jbtn_siguiente_click(){
setValores();
modelcli.moverSiguiente();
getValores();

}//boton siguiente

public void jbtn_anterior_click(){
setValores();
modelcli.moverAnterior();
getValores();

}//boton anterior

public void initView(){
modelcli.Conectar();
viewcli.setVisible(true);
modelcli.moverPrimero();
getValores();

}//initView



}// fin de la clase ControllerCliente
