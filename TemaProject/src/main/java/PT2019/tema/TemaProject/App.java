package PT2019.tema.TemaProject;

import controller.*;
import gui.*;
import stocare.*;
import operatie.*;

public class App 
{
    public static void main( String[] args )
    {
       View view = new View();
       Polinom polinom = new Polinom();
       ControllerCalcPolinoame calc=  new ControllerCalcPolinoame(polinom, view);
       view.setVisible(true);
  
    }
}

