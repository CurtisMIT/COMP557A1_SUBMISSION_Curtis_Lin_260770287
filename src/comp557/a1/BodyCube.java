package comp557.a1;
//Student Name: Curtis Lin
//Student ID: 260770287

import javax.vecmath.Tuple3d;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;

import comp557.a1.geom.Cube;
import mintools.parameters.DoubleParameter;

public class BodyCube extends GraphNode {
	
	double cx;
	double cy;
	double cz;
	
	double sx;
	double sy;
	double sz;
	
	double r;
	double g;
	double b;
	
	public BodyCube(String name) {
		super(name);
	}
	
	@Override
	public void display(GLAutoDrawable drawable, BasicPipeline pipeline) {
		pipeline.push();
		GL4 gl = drawable.getGL().getGL4();
		
		
		pipeline.translate(cx, cy, cz);
		pipeline.scale(sx, sy, sz);
		gl.glUniform3f(pipeline.kdID, (float) r, (float) g, (float) b);
		
		Cube.draw(drawable, pipeline);
		pipeline.setModelingMatrixUniform( gl );
		super.display(drawable, pipeline);
		pipeline.pop();
	}
	
	public void setCentre(Tuple3d centre) {
		this.cx = centre.x;
		this.cy = centre.y;
		this.cz = centre.z;
	}
	
	public void setScale(Tuple3d scale) {
		this.sx = scale.x;
		this.sy = scale.y;
		this.sz = scale.z;
	}
	
	public void setColor(Tuple3d color) {
		this.r = color.x;
		this.g = color.y;
		this.b = color.z;
	}
}