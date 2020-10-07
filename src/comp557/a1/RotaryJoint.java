package comp557.a1;
//Student Name: Curtis Lin
//Student ID: 260770287

import javax.vecmath.Tuple2d;
import javax.vecmath.Tuple3d;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class RotaryJoint extends GraphNode {
	

	DoubleParameter tx;
	DoubleParameter ty;
	DoubleParameter tz;
	
	DoubleParameter ax;
	DoubleParameter ay;
	DoubleParameter az;
	
	DoubleParameter degree;
	
	public RotaryJoint(String name) {
		super(name);
		tx = new DoubleParameter( name+" tx", 0, -2, 2 );
		ty = new DoubleParameter( name+" ty", 0, -2, 2 );
		tz = new DoubleParameter( name+" tz", 0, -2, 2 );
		ax = new DoubleParameter( name+" ax", 0, 0, 1 );
		ay = new DoubleParameter( name+" ay", 0, 0, 1 );
		az = new DoubleParameter( name+" az", 0, 0, 1 );
		dofs.add(degree = new DoubleParameter(name+" degree", 0, -180, 180));
	}
	
	public void setPosition(Tuple3d position) {
		this.tx.setValue(position.x);
		this.ty.setValue(position.y);
		this.tz.setValue(position.z);
	}
	
	public void setAxis(Tuple3d axis) {
		this.ax.setValue(axis.x);
		this.ay.setValue(axis.y);
		this.az.setValue(axis.z);
	}
	
	public void setDegree(Double d) {
		this.degree.setValue(d.doubleValue());
	}
	
	public void setMinMaxDegree(Tuple2d minMax) {
		this.degree.setMinimum(minMax.x);
		this.degree.setMaximum(minMax.y);
	}
	
	@Override
	public void display(GLAutoDrawable drawable, BasicPipeline pipeline) {
		pipeline.push();
		pipeline.translate(tx.getValue(), ty.getValue(), tz.getValue());
		pipeline.rotate(Math.toRadians(degree.getValue()), ax.getValue(), ay.getValue(), az.getValue());
		GL4 gl = drawable.getGL().getGL4();
		pipeline.setModelingMatrixUniform( gl );
		super.display(drawable, pipeline);
		pipeline.pop();
	}
}
