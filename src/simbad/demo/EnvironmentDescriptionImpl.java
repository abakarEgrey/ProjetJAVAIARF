package simbad.demo;

import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.LineArray;
import javax.media.j3d.Material;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.Arc;
import simbad.sim.Arch;
import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;
import simbad.sim.PastilleAgent;
import simbad.sim.PastilleAgentPartielle;
import simbad.sim.PieceRobot;
import simbad.sim.Rectangle;
import simbad.sim.Robot;
import simbad.sim.TypeProduit;
import simbad.sim.Wall;

public class EnvironmentDescriptionImpl extends Demo {
	Robot myRobot;
	public EnvironmentDescriptionImpl() {
		// Construction du mur
		wallColor = new Color3f(0.63f, 0.32f, 0.18f); //couleur orange fonce
		/*Wall wx = new Wall(new Vector3d(0, 2, 0), 12, 1, this);
        add(wx);*/
		Wall w1 = new Wall(new Vector3d(12.5, 0, 0), 12, 1, this);
        w1.rotate90(1);
        add(w1);
        Wall w2 = new Wall(new Vector3d(-12.5, 0, 0), 12, 1, this);
        w2.rotate90(1);
        add(w2);
        Wall w3 = new Wall(new Vector3d(0, 0, 6), 25, 1, this);
        add(w3);
        Wall w4 = new Wall(new Vector3d(0, 0, -6), 25, 1, this);
        add(w4);
        //les murs internes
        Wall w5 = new Wall(new Vector3d(25/2 - 4, 0, 6-2), 12/2 - 2, 1, this);
        w5.rotate90(1);
        add(w5);
        Wall w6 = new Wall(new Vector3d(25/2 - 4, 0, -6+2), 12/2 - 2, 1, this);
        w6.rotate90(1);
        add(w6);
        
        //les murs dans la zone interdite
        Wall w7 = new Wall(new Vector3d(-25./2 + 6.5 + 2, 0, 3.3/2), 12/2 - 2, 1, this);
        add(w7);
        Wall w8 = new Wall(new Vector3d(-25./2 + 10 + 4/2, 0, -3.3/2), 12/2 - 2, 1, this);
        add(w8);
        //Box b1 = new Box(new Vector3d(-3, 0, -3), new Vector3f(1, 1, 1), this);
        //add(b1);
        //Wall w1 = new Wall(new Vector3d(9, 0, 0), 19, 1, this);        
		
       //add(new Box(new Vector3d(10, 0, 0), new Vector3f(3f, 3f, 3f), this));
		add(new Box(new Vector3d(12.5 - 1.5, 0, 6-1.5), new Vector3f(3f, 0.001f, 3f), this));
		add(new Box(new Vector3d(12.5 - 1.5, 0, -6+1.5), new Vector3f(3f, 0.001f, 3f), this, new Color3f(0f, 0f, 1.0f) ));
		add(new Box(new Vector3d(12.5 - 1.5, 0, 0), new Vector3f(3f, 0.001f, 3f), this, new Color3f(0f, 0f, 0f) ));
       myRobot = new Robot(new Vector3d(10, 0, 0), "MyRobot");
       add(myRobot);
       
       //ajout d'un rectangle&
     
       //****************************************************************/
      
          PastilleAgentPartielle pastilleDroitBas = new PastilleAgentPartielle((new Vector3d(6.18,0.1,-3.86)), (new Color3f(0.0f,0.0f,0.0f)), "myPastille", 0.23f, 32,24,29);
           add(pastilleDroitBas);
           PastilleAgentPartielle pastilleGaucheBas = new PastilleAgentPartielle((new Vector3d(6.18,0.1,+3.86)), (new Color3f(0.0f,0.0f,0.0f)), "myPastille", 0.23f, 32,0,10);
           add(pastilleGaucheBas);
           PastilleAgentPartielle pastilleDroitHaut = new PastilleAgentPartielle((new Vector3d(-10.34,0.1,-3.89)), (new Color3f(0.0f,0.0f,0.0f)), "myPastille", 0.21f, 32,16,25);
           add(pastilleDroitHaut);
           PastilleAgentPartielle pastilleGaucheHaut = new PastilleAgentPartielle((new Vector3d(-10.34,0.1,3.89)), (new Color3f(0.0f,0.0f,0.0f)), "myPastille", 0.21f, 32,0,16);
           add(pastilleGaucheHaut);
          //PastilleAgent pastille2 = new PastilleAgent((new Vector3d(0.,0.3,0.1)), (new Color3f(0.0f,255.0f,0.0f)), "myPastille", 0.5f, 32);
           //add(pastille2);
       
           PastilleAgent pastilleJauneCU2 = new PastilleAgent((new Vector3d(-4.05,0.11,-4.)), (new Color3f(255.0f,255.0f,0.0f)), "myPastille", 0.3f, 32);
           add(pastilleJauneCU2);
           PastilleAgent pastilleJauneCU1 = new PastilleAgent((new Vector3d(-.5,0.11,4)), (new Color3f(255.0f,255.0f,0.0f)), "myPastille", 0.3f, 32);
           add(pastilleJauneCU1);
           PastilleAgent pastilleVertDebut = new PastilleAgent((new Vector3d(6.3,0.11,0)), (new Color3f(.0f,255.0f,0.0f)), "myPastille", 0.3f, 32);
           add(pastilleVertDebut);
           //ajout des box rectangles
           Box recLargeur1 = new Box(new Vector3d(6.3,0.1,0.0), new Vector3f(0.2f, 0.001f, 7.75f), this, new Color3f(0f, 0f, 0.0f) );
           add(recLargeur1);
           //fin ajout des box rectangles
          // Rectangle recLargeur1 = new Rectangle(new Vector3d(/*3.2*/3.15,0.1,0.0), (new Color3f(0.0f,0.0f,0.0f)), "myPastille",new Vector3d(0.2,0,7.75));
           //rec.rotateX(90);
           //add(recLargeur1);
           Box recLargeur2 = new Box(new Vector3d(-10.45,0.1,0.0), new Vector3f(0.2f, 0.001f, 7.78f), this, new Color3f(0f, 0f, 0.0f) );
           add(recLargeur2);
           /*Rectangle recLargeur2 = new Rectangle(new Vector3d(-5.22,0.1,0.0), (new Color3f(0.0f,0.0f,0.0f)), "myPastille",new Vector3d(0.25,0,7.79));
           add(recLargeur2);*/
           /*Rectangle recLongueur1 = new Rectangle(new Vector3d(-1.025,0.1,-2), (new Color3f(0.0f,0.0f,0.0f)), "myPastille",new Vector3d(16.5,0,0.2));//16.5 au lieu de 16.9
           add(recLongueur1);*/
           Box recLongueur1 = new Box(new Vector3d(-2.05,0.1,-4.0), new Vector3f(16.5f, 0.001f, 0.2f), this, new Color3f(0f, 0f, 0.0f) );
           add(recLongueur1);
           
          /* Rectangle recLongueur1 = new Rectangle(new Vector3d(-1.025,0.1,-2), (new Color3f(0.0f,0.0f,0.0f)), "myPastille",new Vector3d(16.5,0,0.2));//16.5 au lieu de 16.9
           add(recLongueur1);*/
           Box bord_gauche = new Box(new Vector3d(-2.05,0.1,4.0), new Vector3f(16.5f, 0.001f, 0.2f), this, new Color3f(0.0f, 0f, 0.0f) );
           add(bord_gauche);
           /*Rectangle bord_gauche = new Rectangle(new Vector3d(-1.025,0.1,2), (new Color3f(0.0f,0.0f,0.0f)), "myPastille",new Vector3d(16.5,0,0.2));
           add(bord_gauche);*/
           
           Box recCU1 = new Box(new Vector3d(-0.5,0.1,1.2), new Vector3f(0.2f, 0.001f, 5.5f), this, new Color3f(0.0f, 0f, 0.0f) );
           add(recCU1);
           
           /*Rectangle recCU1 = new Rectangle(new Vector3d(-.25,0.1,0.7), (new Color3f(0.0f,0.0f,0.0f)), "myPastille",new Vector3d(0.25,0,4.8));
           add(recCU1);*/
           Box recCU2 = new Box(new Vector3d(-4.0,0.1,-1.2), new Vector3f(0.2f, 0.001f, 5.5f), this, new Color3f(0.0f, 0f, 0.0f) );
           add(recCU2);
           /*Rectangle recCU2 = new Rectangle(new Vector3d(-2.03,0.1,-0.7), (new Color3f(0.0f,0.0f,0.0f)), "myPastille",new Vector3d(0.25,0,4.8));
           add(recCU2);*/
            //ajout des zones cu1 et cu2
           //cu1
           add(new Box(new Vector3d(-12.5 + 5.25, 0, 0), new Vector3f(2.5f, 0.001f, 3.3f), this, new Color3f(0f, 0f, 1.0f) ));
           //cu2
           add(new Box(new Vector3d(-12.5 + 15.25, 0, 0), new Vector3f(2.5f, 0.001f, 3.3f), this, new Color3f(1.0f, 0f, 0.0f) ));
           
           /*Wall w9 = new Wall(new Vector3d(0, 0, 0), 0.48f, 0.15f, 0.1f,this);
           w9.rotate90(1);
        add(w9);
        
        Wall w10 = new Wall(new Vector3d(0, 0.1, 0), 0.12f, 0.15f, 0.28f,this);
           w10.rotate90(1);
        add(w10);
        
        Wall w11 = new Wall(new Vector3d(0, 0.35, 0), 0.48f, 0.15f, 0.1f,this);
           w11.rotate90(1);
        add(w11);*/
           //Piece piece = new Piece(new Vector3d(0, 0, 0), 0.48f, 0.15f, 0.55f, this);
          /* Arch arch = new Arch(new Vector3d(0, 0, 0), this);
           add(arch);*/
           PieceRobot gp1 = new PieceRobot(new Vector3d(6.25 - 0.48/2 + 0.02, 0, -3 + 0.10), this, TypeProduit.GRANDPRODUIT);
           add(gp1);
           PieceRobot gp2 = new PieceRobot(new Vector3d(6.25 - 0.48/2 + 0.02, 0, -3 + 0.10 + 0.10), this, TypeProduit.GRANDPRODUIT);
           add(gp2);
           PieceRobot gp3 = new PieceRobot(new Vector3d(6.25 - 0.48/2 + 0.02, 0, -3 + 0.10 + 2*0.10), this, TypeProduit.GRANDPRODUIT);
           add(gp3);
           PieceRobot pp1 = new PieceRobot(new Vector3d(6.25 - 0.31/2, 0, 3 - 0.10), this, TypeProduit.PETITPRODUIT);
           add(pp1);
           PieceRobot pp2 = new PieceRobot(new Vector3d(6.25 - 0.31/2, 0, 3 - 0.10 - 0.10), this, TypeProduit.PETITPRODUIT);
           add(pp2);
           PieceRobot pp3 = new PieceRobot(new Vector3d(6.25 - 0.31/2, 0, 3 - 0.10 - 2*0.10), this, TypeProduit.PETITPRODUIT);
           add(pp3);
           
          // Vector3d [] vectorTab = new Vector3d[]{
        //	   new Vector3d(6.35,0.2,-4.0),
        //	   new Vector3d(6.40,0.2,-3.9)
          // };
           
           //Arc arc = new Arc(new Vector3d(5.90, 0.2, -3.97), new Vector3d(6.4, 0.2, -3.40), vectorTab, "arc");
           //arc.tracePolygone(null);
           //add(arc);
           
           //Arch arch = new Arch(new Vector3d(12.5 - 1.5, 0, 6-1.5), this);
          // add(arch);
           
    }

	
}
