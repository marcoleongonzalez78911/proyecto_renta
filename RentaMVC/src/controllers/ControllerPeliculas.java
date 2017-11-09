/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelPeliculas;
import views.ViewPeliculas;
/**
 *
 * @author mark
 */
public class ControllerPeliculas {
    private final  ModelPeliculas modelpelis;
    private final  ViewPeliculas viewpelis;
    
   
public ControllerPeliculas(ModelPeliculas modelpelis, ViewPeliculas viewpelis){
    this.modelpelis = modelpelis;
    this.viewpelis = viewpelis;
    
    
    this.viewpelis.jbtn_primero.addActionListener(e -> jbtn_primero_click());
    this.viewpelis.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
    this.viewpelis.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
    this.viewpelis.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
    this.viewpelis.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
    this.viewpelis.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
    this.viewpelis.jbtn_eliminar.addActionListener(e -> jbtn_borrar_click());
 //   this.viewcli.jbtn_actualizar.addActionListener(e -> jbtn_modificar_click());


    initView();
}//fin del contructor

 public void getValores(){
viewpelis.jtf_id_pelicula.setText(""+modelpelis.getId_pelicula());
viewpelis.jtf_nombre.setText(modelpelis.getNombre());
viewpelis.jtf_formato.setText(modelpelis.getFormato());
viewpelis.jtf_duracion.setText(modelpelis.getDuracion());
viewpelis.jtf_descripcion.setText(modelpelis.getDescripcion());

}//fin de getvalores

public void setValores(){
modelpelis.setId_pelicula(Integer.parseInt(viewpelis.jtf_id_pelicula.getText()));
modelpelis.setNombre(viewpelis.jtf_nombre.getText());
modelpelis.setFormato(viewpelis.jtf_formato.getText());
modelpelis.setDuracion(viewpelis.jtf_duracion.getText());
modelpelis.setDescripcion(viewpelis.jtf_duracion.getText());
}//fin de setvalores

public void jbtn_nuevo_click(){
viewpelis.jtf_id_pelicula.setText("");
viewpelis.jtf_nombre.setText("");
viewpelis.jtf_formato.setText("");
viewpelis.jtf_duracion.setText("");
viewpelis.jtf_descripcion.setText("");
}//boton nuevo

public void jbtn_agregar_click(){
setValores();
modelpelis.Insertar();
getValores();

}//boton agragar


public void jbtn_primero_click(){
setValores();
modelpelis.moverPrimero();
getValores();

}//boton moverPrimero

public void jbtn_ultimo_click(){
setValores();
modelpelis.moverUltimo();
getValores();

}//boton ultimo

public void jbtn_borrar_click(){
setValores();
modelpelis.borrar();
getValores();

}//boton modificar

public void jbtn_siguiente_click(){
setValores();
modelpelis.moverSiguiente();
getValores();

}//boton siguiente

public void jbtn_anterior_click(){
setValores();
modelpelis.moverAnterior();
getValores();

}//boton anterior

    /**
     *
     */
public void initView(){
modelpelis.Conectar();
viewpelis.setVisible(true);
modelpelis.moverPrimero();
getValores();

}//initView

    
    
    
}/// fin de la clase
