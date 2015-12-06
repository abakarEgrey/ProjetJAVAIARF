package simbad.sim;

import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.Material;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

public class Rectangle extends SimpleAgent {

    float minx = -5;
    float maxx = 5;
    float minz = -2;
    float maxz = 0;
    Color3f couleur;
    QuadArray myQuads;

    //boolean sens: true mettre longueur 

    public Rectangle(Vector3d pos, Color3f couleur, String name, Vector3d dimension) {
        super(pos, name);
        /*this.minx = (float) -2.05;
         System.out.println("this.minx = "+this.minx);
         System.out.println("pos.z = "+pos.z);
         this.maxx = (float) (-2.05+16.9);
         System.out.println("this.maxx = "+this.maxx);
         this.minz = (float) -4.3;
         this.maxz = (float) (-4.3 + 8.1);*/
        this.couleur = couleur;
        this.minx = (float) pos.x - (float) dimension.x / 2;
        this.maxx = (float) pos.x + (float) dimension.x / 2;
        this.minz = (float) pos.z - (float) dimension.z / 2;
        this.maxz = (float) pos.z + (float) dimension.z / 2;

        /*System.out.println("this.minx = "+this.minx);
         System.out.println("pos.z = "+pos.z);
         this.maxx = (float) (-2.05+16.9);
         System.out.println("this.maxx = "+this.maxx);
         this.minz = (float) -4.3;
         this.maxz = (float) (-4.3 + 8.1);*/
    }

    @Override
    protected void create3D() {
        super.create3D(false);
		//Create a QuadArray and set the vertex coordinates and normals
        Point3f[] floorCoords = {
            new Point3f(minx, 0.0f, minz),
            new Point3f(minx, 0.0f, maxz),
            new Point3f(maxx, 0.0f, maxz),
            new Point3f(maxx, 0.0f, minz)
        };

        Vector3f[] floorNormals = {
            new Vector3f(-0.6f, 0.6f, -0.6f),
            new Vector3f(-0.6f, 0.6f, 0.6f),
            new Vector3f(0.6f, 0.6f, 0.6f),
            new Vector3f(0.6f, 0.6f, -0.6f)
        };

        myQuads = new QuadArray(
                floorCoords.length,
                GeometryArray.COORDINATES
                | GeometryArray.NORMALS);

        myQuads.setCoordinates(0, floorCoords);
        myQuads.setNormals(0, floorNormals);

        Appearance floorAppear = new Appearance();

        PolygonAttributes polyAttrib = new PolygonAttributes();

        polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
        polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_FILL);
        floorAppear.setPolygonAttributes(polyAttrib);
        ColoringAttributes ca = new ColoringAttributes();
        ca.setColor(this.couleur);
        floorAppear.setColoringAttributes(ca);

        Shape3D myShape = new Shape3D(myQuads, floorAppear);
        myShape.setPickable(false);
        myShape.setCollidable(false);
        addChild(myShape);
    }

    public void rotateX(double angle) {
        Transform3D t3d = new Transform3D();
        t3d.rotY(angle);
        rotation.mul(t3d);
        rotationGroup.setTransform(rotation);
    }

}
