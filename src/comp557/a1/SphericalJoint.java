package comp557.a1;
//Student Name: Curtis Lin
//Student ID: 260770287

import javax.vecmath.Tuple2d;
import javax.vecmath.Tuple3d;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class SphericalJoint extends GraphNode {
	DoubleParameter tx;
	DoubleParameter ty;
	DoubleParameter tz;
	
	DoubleParameter dx;
	DoubleParameter dy;
	DoubleParameter dz;
	
	public SphericalJoint(String name) {
		super(name);
		tx = new DoubleParameter( name+" tx", 0, -2, 2 );
		ty = new DoubleParameter( name+" ty", 0, -2, 2 );
		tz = new DoubleParameter( name+" tz", 0, -2, 2 );
		dofs.add( dx = new DoubleParameter( name+" rx", 0, -180, 180 ) );		
		dofs.add( dy = new DoubleParameter( name+" ry", 0, -180, 180 ) );
		dofs.add( dz = new DoubleParameter( name+" rz", 0, -180, 180 ) );
	}
	
	public void setPosition(Tuple3d position) {
		this.tx.setValue(position.x);
		this.ty.setValue(position.y);
		this.tz.setValue(position.z);
	}
	
	public void setDegrees(Tuple3d degrees) {
		this.dx.setValue(degrees.x);
		this.dy.setValue(degrees.y);
		this.dz.setValue(degrees.z);
	}
	
	public void setMinMaxRx(Tuple2d minMax) {
		this.dx.setMinimum(minMax.x);
		this.dx.setMaximum(minMax.y);
	}
	
	public void setMinMaxRy(Tuple2d minMax) {
		this.dy.setMinimum(minMax.x);
		this.dy.setMaximum(minMax.y);
	}
	
	public void setMinMaxRz(Tuple2d minMax) {
		this.dz.setMinimum(minMax.x);
		this.dz.setMaximum(minMax.y);
	}
	
	@Override
	public void display(GLAutoDrawable drawable, BasicPipeline pipeline) {
		pipeline.push();
		pipeline.translate(tx.getValue(), ty.getValue(), tz.getValue());
		pipeline.rotate(Math.toRadians(dx.getValue()), 1, 0, 0);
		pipeline.rotate(Math.toRadians(dy.getValue()), 0, 1, 0);
		pipeline.rotate(Math.toRadians(dz.getValue()), 0, 0, 1);
		
		GL4 gl = drawable.getGL().getGL4();
		pipeline.setModelingMatrixUniform( gl );
		super.display(drawable, pipeline);
		
		pipeline.pop();
	}
}
