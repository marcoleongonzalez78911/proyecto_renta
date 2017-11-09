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
public class ModelCliente {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private  int id_cliente;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    
    
     public void setId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
        
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public int getId_cliente(){
        return id_cliente;
    }
    public String getNombre(){
     return nombre;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getEmail(){
        return email;
    }
    public String getDireccion(){
        return direccion;
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
        setId_cliente(rs.getInt("id_cliente"));
        setNombre(rs.getString("nombre"));
        setEmail(rs.getString("email"));
        setTelefono(rs.getString("telefono"));
        setDireccion(rs.getString("direccion"));
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
         sql = "select * from clientes;";
         ps = conexion.prepareStatement(sql);
         rs = ps.executeQuery();
         moverPrimero();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 107");
    }
   
    }//fin de mover siguiente
      
    public void Insertar(){
     try{
        sql = "insert into clientes(id_cliente, nombre, email,telefono,direccion)values(?,?,?,?,?);";
        ps = conexion.prepareStatement(sql);
        ps.setInt(5,getId_cliente());
        ps.setString(1,getNombre());
        ps.setString(2,getEmail());
        ps.setString(3,getTelefono());
         ps.setString(4,getDireccion());
        ps.executeUpdate();
         Conectar();
         moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 108" + ex.getMessage());
    }
    }//fin de insertar 
   
     public void borrar(){
     try{
        sql = "Delete from clientes where id_cliente = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setInt(0,getId_cliente());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 109");
    }
    }//fin de borrar 
     
     public void actualizar(){
     try{
        sql = "UPDATE clientes SET nombre = ?, email = ?, telefono = ?, direccion = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setInt(4, getId_cliente());
        ps.setString(0,getNombre());
        ps.setString(1,getEmail());
        ps.setString(2,getTelefono());
        ps.setString(3,getDireccion());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 110");
    }
    }//fin de actualizar
     
     
}// fin de la Clase del ModelCliente
