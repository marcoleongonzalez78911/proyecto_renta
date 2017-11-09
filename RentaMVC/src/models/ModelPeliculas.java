/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mark
 */
public class ModelPeliculas {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_pelicula;
    private String nombre;
    private String formato;
    private String duracion;
    private String descripcion;
    
    public void setId_pelicula(int id_pelicula){
        this.id_pelicula = id_pelicula;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setFormato(String formato){
        this.formato = formato;
        
    }
    public void setDuracion(String duracion){
        this.duracion = duracion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
   
    public int getId_pelicula(){
        return id_pelicula;
    }
    public String getNombre(){
     return nombre;
    }
    public String getFormato(){
        return formato;
    }
    public String getDuracion(){
        return duracion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    
    
    public void Conectar(){
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","marko");
        st = conexion.createStatement();
        SelecccionarTodo();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 101");
    }
    }//conectar
     
     public void llenarValores(){
    try{
        setId_pelicula(rs.getInt("id_peliculas"));
        setNombre(rs.getString("nombre"));
        setFormato(rs.getString("formato"));
        setDuracion(rs.getString("Duracion"));
        setDescripcion(rs.getString("Descripcion"));
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 102");
    }
    }//fin del llenarvalores
    
   public void moverPrimero(){
     try{
       rs.first();
       llenarValores();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 103");
    }
   
    }//fin de mover primero
    
     public void moverUltimo(){
     try{
       rs.last();  
       llenarValores();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 104");
    }
   
    }//fin de mover ultimo
     
      public void moverSiguiente(){
     try{
         if(rs.isLast()==false){
             rs.next();
             llenarValores();
         } 
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 105");
    }
   
    }//fin de mover siguiente
    
     public void moverAnterior(){
     try{
         if(rs.isFirst()==false){
             rs.previous();
             llenarValores();
         } 
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 106");
    }
   
    }//fin de mover anterior
     
      public void SelecccionarTodo(){
     try{
         sql = "select * from peliculas;";
         ps = conexion.prepareStatement(sql);
         rs = ps.executeQuery();
         moverPrimero();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 107");
    }
   
    }//fin de mover siguiente
      
    public void Insertar(){
     try{
        sql = "insert into peliculas(id_peliculas, nombre, formato,Duracion,Descripcion)values(?,?,?,?,?);";
        ps = conexion.prepareStatement(sql);
        ps.setInt(5,getId_pelicula());
        ps.setString(1,getNombre());
        ps.setString(2,getFormato());
        ps.setString(3,getDuracion());
         ps.setString(4,getDescripcion());
        ps.executeUpdate();
         Conectar();
         moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 108" + ex.getMessage());
    }
    }//fin de insertar 
   
     public void borrar(){
     try{
        sql = "Delete from peliculas where id_peliculas = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setInt(0,getId_pelicula());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 109");
    }
    }//fin de borrar 
     
     public void actualizar(){
     try{
        sql = "UPDATE peliculas SET nombre = ?, formato = ?, duracion = ?, descripcion = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setInt(4, getId_pelicula());
        ps.setString(0,getNombre());
        ps.setString(1,getFormato());
        ps.setString(2,getDuracion());
        ps.setString(3,getDescripcion());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 110");
    }
    }//fin de actualizar
     
    
    
    
}//class
