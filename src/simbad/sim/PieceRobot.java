/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simbad.sim;

import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author mahamat
 */
public class PieceRobot extends BlockWorldCompositeObject {
    private  float longGrandPiece = 0.48f;
    private  float longPetitPiece = 0.31f;
    private  float hautGrandPiece = 0.55f;
    private  float hautPetitPiece = 0.38f;
    private  float EpaisPiece = 0.15f;
    private Vector3d pos;
     public PieceRobot(Vector3d pos,EnvironmentDescription wd, TypeProduit typeProduit) {
        this.pos = pos;
        create3D(wd, typeProduit);
        translateTo(pos);
    }
     
    void create3D(EnvironmentDescription wd, TypeProduit typeProduit){
        Vector3d posLocal = new Vector3d(pos);
        Box b1, b2, b3;
        super.create3D();
        
        // Use 3 boxes to construct the arch.
        /*Box b1 = new Box(new Vector3d(-1.5,0,0),new Vector3f(1,1.5f,1),wd);
        Box b2 = new Box(new Vector3d(1.5,0,0),new Vector3f(1,1.5f,1),wd);
        Box b3 = new Box(new Vector3d(0,1.5f,0),new Vector3f(4,0.5f,1),wd);*/
        switch(typeProduit) {
            case GRANDPRODUIT:
                this.hautGrandPiece -= 0.45f;
                System.out.println("this.pos.y2 = "+this.pos.y);
                posLocal.y -= 0.25;
                this.pos.y = posLocal.y;
                b1 = new Box(this.pos,new Vector3f(longGrandPiece,hautGrandPiece ,EpaisPiece),wd);
                System.out.println("this.pos.y = "+this.pos.y);
                posLocal.y += this.hautGrandPiece;
                this.pos.y = posLocal.y;
                this.hautGrandPiece += 0.25f;
                this.longGrandPiece -= 0.36f;
                b2 = new Box(this.pos,new Vector3f(longGrandPiece,hautGrandPiece,EpaisPiece),wd);
                posLocal.y += this.hautGrandPiece;
                this.pos.y = posLocal.y;
                this.hautGrandPiece -= 0.25f;
                this.longGrandPiece += 0.36f;
                b3 = new Box(this.pos,new Vector3f(longGrandPiece,hautGrandPiece,EpaisPiece),wd);
                b1.setColor(wd.archColor);
                b2.setColor(wd.archColor);
                b3.setColor(wd.archColor);
                addComponent(b1);
                addComponent(b2);
                addComponent(b3);
                break;
            case PETITPRODUIT:
                this.hautPetitPiece -= 0.30f;
                System.out.println("this.pos.y2 = "+this.pos.y);
                posLocal.y -= 0.17;
                this.pos.y = posLocal.y;
                b1 = new Box(this.pos,new Vector3f(longPetitPiece,hautPetitPiece ,EpaisPiece),wd);
                System.out.println("this.pos.y = "+this.pos.y);
                posLocal.y += this.hautPetitPiece;
                this.pos.y = posLocal.y;
                this.hautPetitPiece += 0.14f;
                this.longPetitPiece -= 0.26f;
                b2 = new Box(this.pos,new Vector3f(longPetitPiece,hautPetitPiece,EpaisPiece),wd);
                posLocal.y += this.hautPetitPiece;
                this.pos.y = posLocal.y;
                this.hautPetitPiece -= 0.14f;
                this.longPetitPiece += 0.26f;
                b3 = new Box(this.pos,new Vector3f(longPetitPiece,hautPetitPiece,EpaisPiece),wd);
                b1.setColor(wd.archColor);
                b2.setColor(wd.archColor);
                b3.setColor(wd.archColor);
                addComponent(b1);
                addComponent(b2);
                addComponent(b3);
                break;
            default:
                break;
        }
        
        
    }    
}
