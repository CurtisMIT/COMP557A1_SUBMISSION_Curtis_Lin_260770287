package comp557.a1;
//Student Name: Curtis Lin
//Student ID: 260770287

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class FreeJoint extends GraphNode {

	DoubleParameter tx;
	DoubleParameter ty;
	DoubleParameter tz;
	DoubleParameter rx;
	DoubleParameter ry;
	DoubleParameter rz;
		
	public FreeJoint( String name ) {
		super(name);
		dofs.add( tx = new DoubleParameter( name+" tx", 0, -2, 2 ) );		
		dofs.add( ty = new DoubleParameter( name+" ty", 0, -2, 2 ) );
		dofs.add( tz = new DoubleParameter( name+" tz", 0, -2, 2 ) );
		dofs.add( rx = new DoubleParameter( name+" rx", 0, -180, 180 ) );		
		dofs.add( ry = new DoubleParameter( name+" ry", 0, -180, 180 ) );
		dofs.add( rz = new DoubleParameter( name+" rz", 0, -180, 180 ) );
	}
	
	@Override
	public void display( GLAutoDrawable drawable, BasicPipeline pipeline ) {
		pipeline.push();
		// TODO: Objective 3: FreeJoint, transformations must be applied before drawing children
		pipeline.translate(tx.getValue(), ty.getValue(), tz.getValue());
		pipeline.rotate(Math.toRadians(rx.getValue()), 1, 0, 0);
		pipeline.rotate(Math.toRadians(ry.getValue()), 0, 1, 0);
		pipeline.rotate(Math.toRadians(rz.getValue()), 0, 0, 1);
		
		
		GL4 gl = drawable.getGL().getGL4();
		pipeline.setModelingMatrixUniform( gl );
		super.display( drawable, pipeline );
		
		pipeline.pop();
	}
	
}
