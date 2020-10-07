# COMP 557 A1 Submission By Curtis Lin, 260770287
You can pretty much ignore everything except <strong>The Character</strong> and <strong>The Animation</strong> if the coding part isn't that relevant to grading.


## Matrix Stack
In my case it's actually matrix <strong>stacks</strong>. I've implemented two matrix stacks, one for the modeling matrix, the other for the inverse transpose of it.
It was easier to visualize the stack operations in my head with two stacks for me.
I initialized the stacks right after the matrices were initialized, by pushing the matrices (Identity matrices) onto them.

## Nodes
### FreeJoint Nodes
I've implemented the rotation aspect of FreeJoint nodes to be in Euler rotations (XYZ).
I did not implement any min max restrictions for FreeJoint type of nodes as I thought they should remain "Free".

### SphericalJoint Nodes
I've implemented the rotation aspect of SphericalJoint nodes to be in Euler rotations (XYZ) as well.
The only difference from FreeJoint Nodes would be the restrictions. I've allowed the user (programmer?) to specify the min and max of each specific SphericalJoint Node according to their preferences.

### RotaryJoint Nodes
I've implemented the rotation aspect of Rotary nodes to be rotating around a given axis.
For the restrictions, I've done the same thing as Spherical Nodes by allowing the user to set the min and max rotation of every RotaryJoint node.

### BodyBox Nodes
I've implemented this class to be the node that draws a cube onto the screen.

### BodySphere Nodes
I've implemented this class to be the node that draws a sphere onto the screen.

## The Character
Inspired by Among Us, I've decided to create a crewmate with limbs, colorful, long and slender limbs.
The light-blue cuboid in the middle is supposed to be the visor of a crewmate, and the red cuboid at the back is suppoed to resemble the backpack that all crewmates wear.
I've decided to give it longer limbs than normal, as the assignment requires a character with some complexity in it(E.g. RotaryJoints as elbows, knees).
I've also decided to draw a sphere at every joint, as it makes it look more like the skeletons I usually see in graphics programs.

## The Animation
The animation is a sequence of events.
KICK -> FAILED KICK -> SLIPS -> STARTS FALLING -> FELL ONTO THE GROUND -> SPRINGS BACK UP -> SIN OF THE DECADE(DAB)

# Thank you!
