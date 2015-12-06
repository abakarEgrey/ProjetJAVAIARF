/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simbad.demo;

import javax.vecmath.Vector3d;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

/**
 *
 * @author mahamat
 */
public class Piece {
    private EnvironmentDescription env;
    private float longueur;
    private float epaisseur;
    private float hauteur;
    private Vector3d pos;
    public Piece(Vector3d pos, float longueur, float epaisseur, float hauteur, EnvironmentDescription env) {
        this.env = env;
        this.longueur = longueur;
        this.epaisseur = epaisseur;
        this.hauteur = hauteur;
        this.pos = pos;
        createPiece();
    }
    
    private void createPiece() {
        /*Wall w9 = new Wall(new Vector3d(0, 0, 0), 0.48f, 0.15f, 0.1f,env);
           w9.rotate90(1);
        env.add(w9);
        
        Wall w10 = new Wall(new Vector3d(0, 0.1, 0), 0.12f, 0.15f, 0.35f,env);
           w10.rotate90(1);
        env.add(w10);
        
        Wall w11 = new Wall(new Vector3d(0, 0.45, 0), 0.48f, 0.15f, 0.1f,env);
           w11.rotate90(1);
        env.add(w11);*/
        
        float h = this.hauteur - 0.45f;
        Wall wallBas = new Wall(this.pos, this.longueur, this.epaisseur, h,env);
        wallBas.rotate90(1);
        env.add(wallBas);
        System.out.println("this.pos.y = "+this.pos.y);
        this.pos.y += h ;
        h += 0.25f;
        float l = this.longueur - 0.36f;
        Wall wallVertical = new Wall(this.pos, l , this.epaisseur, h,env);
        wallVertical.rotate90(1);
        env.add(wallVertical);
        pos.y += h - 0.050000011920928955;
        System.out.println("h = "+h);
        Wall wallHaut = new Wall(this.pos, this.longueur, this.epaisseur, hauteur - h,env);
        wallHaut.rotate90(1);
        env.add(wallHaut);
        
    }
            
}
