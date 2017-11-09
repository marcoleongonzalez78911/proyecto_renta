/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.*;
import views.*;
import controllers.*;

/**
 *
 * @author mark
 */
public class Main {
     public static void main(String mar[]){
         ModelCliente modelcli = new ModelCliente();
         ViewCliente   viewcli = new ViewCliente();
         ControllerCliente controller_cli = new ControllerCliente(modelcli, viewcli);
         
         ModelPeliculas modelpelis = new ModelPeliculas();
         ViewPeliculas   viewpelis = new ViewPeliculas();
         ControllerPeliculas controller_pelis = new ControllerPeliculas(modelpelis, viewpelis);
         
          ModelRenta modelren = new ModelRenta();
         ViewRenta   viewren = new ViewRenta();
         ControllerRenta controller_ren = new ControllerRenta(modelren, viewren);
   
         ModelPrincipal modelp = new ModelPrincipal();
         ViewPrincipal viewp = new  ViewPrincipal();
         Object views[] = new Object[4];
         views[0] = viewcli;
         views[1] = viewpelis;
         views[2] = viewren;
         views[3] = viewp;
         ControllerPrincipal controllerp = new ControllerPrincipal(modelp, views);
    }
    
}
