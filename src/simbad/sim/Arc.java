package simbad.sim;

import java.awt.Color;

import javax.media.j3d.Alpha;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.LineArray;
import javax.media.j3d.LineAttributes;
import javax.media.j3d.Material;
import javax.media.j3d.PointArray;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.QuadArray;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TriangleArray;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.ColorCube;

public class Arc extends SimpleAgent {

    float minx = -5;
    float maxx = 5;
    float minz = -2;
    float maxz = 0;
    Color3f couleur;
    QuadArray myQuads;
    Vector3d[] listAttraction, listAuxiliaire;
    Vector3d debut;
    Vector3d fin;

    //boolean sens: true mettre longueur 

    public Arc(Vector3d debut, Vector3d fin, Vector3d[] listAttraction, String nom) {
        super(new Vector3d(0, 0, 0), nom);
        this.listAttraction = listAttraction;
        this.listAuxiliaire = null;
        this.debut = debut;
        this.fin = fin;

    }

    /*protected void create3D(){
			
     //Create a QuadArray and set the vertex coordinates and normals

     Point3f[] floorCoords = {
     new Point3f(  minx, 0.0f,minz),
     new Point3f(  minx, 0.0f,maxz ),
     new Point3f(  maxx, 0.0f,maxz),
     new Point3f(  maxx, 0.0f,minz )
     };
		    
     Vector3f[] floorNormals = {
     new Vector3f(-0.6f, 0.6f, -0.6f ),
     new Vector3f(-0.6f, 0.6f, 0.6f ),
     new Vector3f(0.6f, 0.6f, 0.6f ),
     new Vector3f(0.6f, 0.6f, -0.6f )
     };
			
     myQuads = new QuadArray(
     floorCoords.length,
     GeometryArray.COORDINATES |
     GeometryArray.NORMALS );
	        
     myQuads.setCoordinates( 0, floorCoords );
     myQuads.setNormals( 0, floorNormals );
	        
     Appearance floorAppear = new Appearance();
	        
     PolygonAttributes polyAttrib = new PolygonAttributes();
	        
     polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
     polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_FILL);
     floorAppear.setPolygonAttributes(polyAttrib);
     ColoringAttributes ca = new ColoringAttributes();
     ca.setColor(this.couleur);
     floorAppear.setColoringAttributes(ca);
	        
     Shape3D myShape = new Shape3D(myQuads, floorAppear );
     myShape.setPickable(false);
     myShape.setCollidable(false);
     addChild(myShape);
     }
	        
     public void tracePolygone(Vec
	        
     }*/
    public void rotationAnimation() {
        BranchGroup objWurzel = new BranchGroup();
        Transform3D drehung = new Transform3D();
        Transform3D drehung2 = new Transform3D();
        drehung.rotX(Math.PI / 4.0d);
        drehung2.rotY(Math.PI / 5.0d);
        drehung.mul(drehung2);
        TransformGroup objDreh = new TransformGroup(drehung);
        TransformGroup spin = new TransformGroup();
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        spin.addChild(new ColorCube(0.4));
        objDreh.addChild(spin);
        objWurzel.addChild(objDreh);

        // Drehung
        Alpha spinAlpha = new Alpha(-1, 5000);
        RotationInterpolator dreher = new RotationInterpolator(spinAlpha, spin);
        BoundingSphere zone = new BoundingSphere();
        dreher.setSchedulingBounds(zone);
        spin.addChild(dreher);
        objWurzel.compile();

        addChild(objWurzel);
        /*NormalGenerator ng = new NormalGenerator();
         ng.generateNormals(geometryInfo);*/

    }

    private void TracerTrangle() {
        
        TriangleArray mytriangleArray = new TriangleArray(3, TriangleArray.COORDINATES);
        mytriangleArray.setCoordinate(0, new Point3f(10.0f, 0.01f, 0.0f));
        mytriangleArray.setCoordinate(1, new Point3f(-10.0f, 0.01f, 0.0f));
        mytriangleArray.setCoordinate(2, new Point3f(0.0f, 0.01f, 5.0f));

        Appearance floorAppear = new Appearance();

        PolygonAttributes polyAttrib = new PolygonAttributes();

        polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
        polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_FILL);
        floorAppear.setPolygonAttributes(polyAttrib);

        Shape3D myShape = new Shape3D(mytriangleArray, floorAppear);

        myShape.setPickable(false);
        myShape.setCollidable(false);
        this.addChild(myShape);
    }

    public void tracePolygone(Vector3d[] tabVector3d) {
        //TracerTrangle();
        /*Vector3f viewTranslation = new Vector3f();
         viewTranslation.z = 3;
         viewTranslation.x = 0f;
         viewTranslation.y = .3f;
         Transform3D viewTransform = new Transform3D();
         viewTransform.setTranslation(viewTranslation);
         Transform3D rotation = new Transform3D();
         rotation.rotX(-Math.PI / 12.0d);
         rotation.mul(viewTransform);*/

		// lights
        /*TransformGroup objSpin = new TransformGroup();
         objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         Alpha rotationAlpha = new Alpha(-1, 4000);
         RotationInterpolator rotator = new RotationInterpolator(rotationAlpha, objSpin);
         objSpin.addChild(rotator);*/
        /**
         * ************* Fin de la partie relative a l'animation **************
         */
		//LineArray myLine= new LineArray (2, LineArray.COORDINATES);
        TriangleArray mytriangleArray = new TriangleArray(3, TriangleArray.COORDINATES);
        /*mytriangleArray.setCoordinate(0, new Point3f( 10.0f, 0.01f, 0.0f));
         mytriangleArray.setCoordinate(1, new Point3f( -10.0f, 0.01f, 0.0f));
         mytriangleArray.setCoordinate(2, new Point3f( 0.0f, 0.01f, 5.0f));
  
         myLine.setCoordinate(0, new Point3f(-10.0f, 0.01f, 0.0f));
         myLine.setCoordinate(1, new Point3f( 10.0f, 0.01f, 10.0f));*/
        Appearance floorAppear = new Appearance();

        //LineAttributes lineAtt = new LineAttributes(0.2f,LineAttributes.ALLOW_WIDTH_WRITE,true);
        /*PolygonAttributes polyAttrib = new PolygonAttributes();
        
         polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
         polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_FILL);
         floorAppear.setPolygonAttributes(polyAttrib);*/
        //floorAppear.setLineAttributes(lineAtt);
        //Shape3D myShape = new Shape3D(mytriangleArray, floorAppear);
        /*myShape.setPickable(false);
         myShape.setCollidable(false);
         this.addChild(myShape);*/
        //addChild(myShape);
        Vector3d[] tabAux = calculPointAux(debut, fin, listAttraction, listAttraction.length - 1);
        showPoint();
        showAux(tabAux);
        showLine(tabAux);
    }

    private void showLine(Vector3d[] tabAux) {
        int j = 0;
        if (tabAux == null) {
            return;
        }
        LineArray myPoint = new LineArray(2 * tabAux.length + 2, LineArray.COORDINATES);
        myPoint.setCoordinate(j++, new Point3f((float) debut.x, (float) debut.y, (float) debut.z));
        for (int i = 0; i < tabAux.length; i++) {
            myPoint.setCoordinate(j++, new Point3f((float) tabAux[i].x, (float) tabAux[i].y, (float) tabAux[i].z));
            myPoint.setCoordinate(j++, new Point3f((float) tabAux[i].x, (float) tabAux[i].y, (float) tabAux[i].z));

        }

        myPoint.setCoordinate(j, new Point3f((float) fin.x, (float) fin.y, (float) fin.z));
        Shape3D myShape = new Shape3D(myPoint);
        myShape.setPickable(false);
        myShape.setCollidable(false);
        this.addChild(myShape);
    }

    private void showPoint() {
        if (this.listAttraction == null) {
            return;
        }
        PointArray myPoint = new PointArray(listAttraction.length + 2, PointArray.COORDINATES);
        for (int i = 0; i < listAttraction.length; i++) {
            myPoint.setCoordinate(i, new Point3f((float) listAttraction[i].x, (float) listAttraction[i].y, (float) listAttraction[i].z));
        }
        myPoint.setCoordinate(listAttraction.length, new Point3f((float) debut.x, (float) debut.y, (float) debut.z));
        myPoint.setCoordinate(listAttraction.length + 1, new Point3f((float) fin.x, (float) fin.y, (float) fin.z));
        Shape3D myShape = new Shape3D(myPoint);
        myShape.setPickable(false);
        myShape.setCollidable(false);
        this.addChild(myShape);
    }

    private void showAux(Vector3d[] tabVector3d) {
        PointArray myPoint = new PointArray(tabVector3d.length, PointArray.COORDINATES);
        for (int i = 0; i < tabVector3d.length; i++) {
            myPoint.setCoordinate(i, new Point3f((float) tabVector3d[i].x, (float) tabVector3d[i].y, (float) tabVector3d[i].z));
        }

        Shape3D myShape = new Shape3D(myPoint);
        myShape.setPickable(false);
        myShape.setCollidable(false);
        this.addChild(myShape);
    }

    private Vector3d milieu(Vector3d p1, Vector3d p2) {
        return new Vector3d((p1.x + p2.x) / 2.0, (p1.y + p2.y) / 2.0, (p1.z + p2.z) / 2.0);
    }

    private Vector3d[] calculPointAux(Vector3d debut, Vector3d fin, Vector3d[] tabs, int degre) {
        Vector3d[] tabLocal = new Vector3d[tabs.length];
        tabLocal[0] = milieu(debut, tabs[1]);
        for (int i = 0; i < tabs.length; i++) {
            if (i + 2 >= tabs.length) {
                break;
            }
            tabLocal[i + 1] = milieu(tabs[i], tabs[i + 2]);
        }
        tabLocal[tabs.length - 1] = milieu(tabs[tabs.length - 2], fin);
        if (degre > 2) {
            return calculPointAux(debut, fin, tabLocal, degre - 1);
        }
        return tabLocal;
    }

}
//classe droite

class Droite {

    private Vector3d debut, fin;

    public Droite(Vector3d debut, Vector3d fin, float epaisseur) {
        this.debut = debut;
        this.fin = fin;
    }
}
