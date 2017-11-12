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
public class ModelRenta {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private  int id_renta;
    private int id_cliente;
    private int id_pelicula;
    private String costo;
    private int no_dias;
    private  String costo_renta;
     
    
    public void setId_renta(int id_renta){
        this.id_renta = id_renta;
    }
    public void setId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    public void setId_pelicula(int id_pelicula){
        this.id_pelicula = id_pelicula;
    }
    public void setCosto(String costo){
        this.costo = costo;
        
    }
    public void setNo_dias(int no_dias){
        this.no_dias = no_dias;
    }
    public void setCosto_renta(String costo_renta){
        this.costo_renta = costo_renta;
    }
    public int getId_renta(){
        return id_renta;
    }
    public int getId_cliente(){
        return id_cliente;
    }
    public int getId_pelicula(){
     return id_pelicula;
    }
    public String getCosto(){
        return costo;
    }
    public int getNo_dias(){
        return no_dias;
    }
    public String getCosto_renta(){
        return costo_renta;
    }
    
   /* public void multi(){
        costo_renta = costo * no_dias;
    }*/
    
     public void Conectar(){
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","marko");
        st = conexion.createStatement();
        SelecccionarTodo();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 121");
    }
    }//conectar
     
     public void llenarValores(){
    try{
        setId_renta(rs.getInt("id_renta"));
        setId_cliente(rs.getInt("id_cliente"));
        setId_pelicula(rs.getInt("id_pelicula"));
        setCosto(rs.getString("costo"));
        setNo_dias(rs.getInt("no_dias"));
        setCosto_renta(rs.getString("Costo_renta"));
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 122");
    }
    }//fin del llenarvalores
    
   public void moverPrimero(){
     try{
       rs.first();
       llenarValores();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 123");
    }
   
    }//fin de mover primero
    
     public void moverUltimo(){
     try{
       rs.last();  
       llenarValores();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 124");
    }
   
    }//fin de mover ultimo
     
      public void moverSiguiente(){
     try{
         if(rs.isLast()==false){
             rs.next();
             llenarValores();
         } 
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 125");
    }
   
    }//fin de mover siguiente
    
     public void moverAnterior(){
     try{
         if(rs.isFirst()==false){
             rs.previous();
             llenarValores();
         } 
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 126");
    }
   
    }//fin de mover anterior
     
      public void SelecccionarTodo(){
     try{
         sql = "select * from renta;";
         ps = conexion.prepareStatement(sql);
         rs = ps.executeQuery();
         moverPrimero();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 127");
    }
   
    }//fin de mover siguiente
      
    public void Insertar(){
     try{
        sql = "insert into renta(id_renta, id_cliente, id_pelicula, costo,no_dias,costo_renta)values(?,?,?,?,?,?);";
        ps = conexion.prepareStatement(sql);
        ps.setInt(1,getId_renta());
        ps.setInt(2,getId_cliente());
        ps.setInt(3,getId_pelicula());
        ps.setString(4,getCosto());
        ps.setInt(5,getNo_dias());
        ps.setString(6,getCosto_renta());
        ps.executeUpdate();
         Conectar();
         moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 128" + ex.getMessage());
    }
    }//fin de insertar 
   
     public void borrar(){
     try{
        sql = "Delete from renta where id_renta = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setInt(1,getId_renta());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 129");
    }
    }//fin de borrar 
     
     public void actualizar(){
     try{
        sql = "UPDATE renta SET id_renta = ?, id_cliente = ?, id_pelicula = ?, costo = ?, no_dias = ?, costo_renta?;";
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, getId_renta());
        ps.setInt(2,getId_cliente());
        ps.setInt(3,getId_pelicula());
        ps.setString(4,getCosto());
        ps.setInt(5,getNo_dias());
        ps.setString(6,getCosto_renta());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 130");
    }
    }//fin de actualizar
     
     
    
    
    
    
}//fin de la clase model renta 
