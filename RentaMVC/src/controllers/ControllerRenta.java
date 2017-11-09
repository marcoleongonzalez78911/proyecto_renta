/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelRenta;
import views.ViewRenta;
/**
 *
 * @author mark
 */
public class ControllerRenta {
    private final ModelRenta modelren;
    private final ViewRenta  viewren;
    
    
public ControllerRenta(ModelRenta modelren, ViewRenta viewren){
      this.modelren = modelren;
      this.viewren = viewren;
      
    this.viewren.jbtn_primero.addActionListener(e -> jbtn_primero_click());
    this.viewren.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
    this.viewren.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
    this.viewren.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
    this.viewren.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
    this.viewren.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
    this.viewren.jbtn_eliminar.addActionListener(e -> jbtn_borrar_click());
 //   this.viewcli.jbtn_actualizar.addActionListener(e -> jbtn_modificar_click());
    initView();

}
public void getValores(){
viewren.jtf_id_renta.setText(""+modelren.getId_renta());
viewren.jtf_id_cliente.setText(""+modelren.getId_cliente());
viewren.jtf_id_pelicula.setText(""+modelren.getId_pelicula());
viewren.jtf_costo.setText(modelren.getCosto());
viewren.jtf_no_dias.setText(""+modelren.getNo_dias());
viewren.jtf_costo_renta.setText(modelren.getCosto_renta());

}//fin de getvalores

public void setValores(){
modelren.setId_renta(Integer.parseInt(viewren.jtf_id_renta.getText()));
modelren.setId_cliente(Integer.parseInt(viewren.jtf_id_cliente.getText()));
modelren.setId_pelicula(Integer.parseInt(viewren.jtf_id_pelicula.getText()));
modelren.setCosto(viewren.jtf_costo.getText());
modelren.setNo_dias(Integer.parseInt(viewren.jtf_no_dias.getText()));
modelren.setCosto_renta(viewren.jtf_costo_renta.getText());
}//fin de setvalores

public void jbtn_nuevo_click(){
viewren.jtf_id_renta.setText("");
viewren.jtf_id_cliente.setText("");
viewren.jtf_id_pelicula.setText("");
viewren.jtf_costo.setText("");
viewren.jtf_no_dias.setText("");
viewren.jtf_costo_renta.setText("");
}//boton nuevo

public void jbtn_agregar_click(){
setValores();
modelren.Insertar();
getValores();

}//boton agragar

/*public void jbtn_modificar_click(){
setValores();
modelcli.Insertar(modelcli.getNombre(),modelcli.getEmail(),modelcli.getTelefono(),modelcli.getDireccion());
getValores();

}//boton modificar*/

public void jbtn_primero_click(){
setValores();
modelren.moverPrimero();
getValores();

}//boton moverPrimero

public void jbtn_ultimo_click(){
setValores();
modelren.moverUltimo();
getValores();

}//boton ultimo

public void jbtn_borrar_click(){
setValores();
modelren.borrar();
getValores();

}//boton modificar

public void jbtn_siguiente_click(){
setValores();
modelren.moverSiguiente();
getValores();

}//boton siguiente

public void jbtn_anterior_click(){
setValores();
modelren.moverAnterior();
getValores();

}//boton anterior

public void initView(){
modelren.Conectar();
viewren.setVisible(true);
modelren.moverPrimero();
getValores();

}//initView
    
    
    
}// fin de la clase del controlador 
