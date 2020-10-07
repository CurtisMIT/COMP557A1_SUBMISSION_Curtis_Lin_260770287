#version 400
// Student Name: Curtis Lin
// Student ID: 260770287

uniform vec3 kd;
uniform vec3 ambient;
uniform vec3 lightDir;
uniform vec3 lightIntensity;
uniform vec3 viewing;

in vec3 normalForFP;

out vec4 fragColor;

// TODO: Objective 7, GLSL lighting

void main(void) {
	float diffuse = max(0.0, dot(normalForFP, lightDir));
	float shininess = 2.3;
	
	vec3 halfVector = normalize(lightDir + viewing);
	
	float specular = max(0.0, dot(normalForFP, halfVector));
	
	if (diffuse == 0.0)
		specular = 0.0;
	else
		specular = pow(specular, shininess);
	
	
	vec3 diffusedLight = kd * lightIntensity * diffuse;
	vec3 ambientLight = kd * ambient;
	vec3 specularLight = kd * lightIntensity * specular;
	
	vec3 result = diffusedLight + ambientLight + specularLight;
	
	fragColor = vec4(result, 1);
}