package de.pesse.gwt.jsinterop.threeJs.materials;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.math.Vector2;
import de.pesse.gwt.jsinterop.threeJs.textures.Texture;

/** Wrapper for MeshPhongMaterial class of ThreeJS
 * 
 * A material for shiny surfaces with specular highlights.
 * 
 * The uses a non-physically based Blinn-Phong model	for calculating reflectance. Unlike the Lambertian model used in the MeshLambertMaterial this can simulate shiny surfaces with specular highlights (such as varnished wood).
 * 
 * Shading is calculated using a Phong shading model. This calculates shading per pixel (i.e. in the fragment shader, AKA pixel shader)	which gives more accurate results than the Gouraud model used by MeshLambertMaterial, at the cost of some performance. The MeshStandardMaterial and MeshPhysicalMaterial also use this shading model.
 * 
 * Performance will generally be greater when using this material over the	MeshStandardMaterial or MeshPhysicalMaterial, at the cost of some graphical accuracy.
 * 
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class MeshPhongMaterial extends Material
{
	/** The alpha map is a grayscale texture that controls the opacity across the surface (black: fully transparent; white: fully opaque). Default is null.
	 * Only the color of the texture is used, ignoring the alpha channel if one exists. For RGB and RGBA textures, the WebGL renderer will use the green channel when sampling this texture due to the extra bit of precision provided for green in DXT-compressed and uncompressed RGB 565 formats. Luminance-only and luminance/alpha textures will also still work as expected.
	 */
	public Texture alphaMap;

	/** The ambient occlusion map. Default is null. */
	public Texture aoMap;

	/** Intensity of the ambient occlusion effect. Default is 1. Zero is no occlusion effect. */
	public double aoMapIntensity;
	
	/** The texture to create a bump map. The black and white values map to the perceived depth in relation to the lights. Bump doesn't actually affect the geometry of the object, only the lighting. If a normal map is defined this will be ignored. */
	public Texture bumpMap;

	/** How much the bump map affects the material. Typical ranges are 0-1. Default is 1. */
	public double bumpScale;
	
	/** Color of the material, by default set to white (0xffffff). */
	public int color;

	/** How to combine the result of the surface's color with the environment map, if any.
	 * Options are THREE.Multiply (default), THREE.MixOperation, THREE.AddOperation. If mix is chosen, the .reflectivity is used to blend between the two colors.
	 */
	public int combine;

	/** The displacement map affects the position of the mesh's vertices. Unlike other maps which only affect the light and shade of the material the displaced vertices can cast shadows, block other objects, and otherwise act as real geometry. The displacement texture is an image where the value of each pixel (white being the highest) is mapped against, and repositions, the vertices of the mesh. */
	public Texture displacementMap;

	/** How much the displacement map affects the mesh (where black is no displacement, and white is maximum displacement). Without a displacement map set, this value is not applied. Default is 1. */
	public double displacementScale;

	/** The offset of the displacement map's values on the mesh's vertices. Without a displacement map set, this value is not applied. Default is 0. */
	public double displacementBias;

	/** Emissive (light) color of the material, essentially a solid color unaffected by other lighting. Default is black. */
	public int emissive;

	/** Set emisssive (glow) map. Default is null. The emissive map color is modulated by the emissive color and the emissive intensity. If you have an emissive map, be sure to set the emissive color to something other than black. */
	public Texture emissiveMap;

	/** Intensity of the emissive light. Modulates the emissive color. Default is 1. */
	public double emissiveIntensity;

	/** The environment map. Default is null. */
	public Object envMap; // TODO: Find the correct type

	/** Used to check whether this or derived classes are mesh Phong materials. Default is true.
	 * You should not change this, as it used internally for optimisation.
	 * @return
	 */
	@JsProperty(name="isMeshPhongMaterial") public native boolean isMeshPhongMaterial();

	/** The light map. Default is null. The lightMap requires a second set of UVs. */
	public Texture lightMap;

	/** Intensity of the baked light. Default is 1. */
	public double lightMapIntensity;

	/** The color map. Default is null. The texture map color is modulated by the diffuse .color. */
	public Texture map;

	/** Defines whether the material uses morphNormals. Set as true to pass morphNormal attributes from the Geometry	to the shader. Default is false. */
	public boolean morphNormals;
	
	/** Define whether the material uses morphTargets. Default is false. */
	public boolean morphTargets;
	
	/** The texture to create a normal map. The RGB values affect the surface normal for each pixel fragment and change the way the color is lit. Normal maps do not change the actual shape of the surface, only the lighting. */
	public Texture normalMap;

	/** How much the normal map affects the material. Typical ranges are 0-1. Default is a Vector2 set to (1,1). */
	public Vector2 normalScale;

	/** How much the environment map affects the surface; also see .combine. */
	public double reflectivity;
	
	/** The index of refraction for an environment map using THREE.CubeRefractionMapping. Default is 0.98. */
	public double refractionRatio;

	/** How shiny the .specular highlight is; a higher value gives a sharper highlight. Default is 30. */
	public double shininess;

	/** Define whether the material uses skinning. Default is false. */
	public boolean skinning;
	
	/** Specular color of the material. Default is a Color set to 0x111111 (very dark grey). 
	 * This defines how shiny the material is and the color of its shine.
	 */
	public int specular;

	/** The specular map value affects both how much the specular surface highlight contributes and how much of the environment map affects the surface. Default is null. */
	public Texture specularMap;

	/** Render geometry as wireframe. Default is false (i.e. render as flat polygons). */
	public boolean wireframe;
	
	/** Define appearance of line ends. Possible values are "butt", "round" and "square". Default is 'round'. 
	 * This corresponds to the 2D Canvas lineCap property and it is ignored by the WebGL renderer.
	 */
	public String wireframeLinecap;
	
	/** Define appearance of line joints. Possible values are "round", "bevel" and "miter". Default is 'round'.
	 * This corresponds to the 2D Canvas lineJoin property and it is ignored by the WebGL renderer.
	 */
	public String wireframeLinejoin;

	/** Controls wireframe thickness. Default is 1.Due to limitations in the ANGLE layer, on Windows platforms linewidth will always be 1 regardless of the set value.
	 * 
	 */
	public double wireframeLinewidth;
	
	public MeshPhongMaterial() {}
	
	/** parameters - (optional) an object with one or more properties defining the material's appearance. Any property of the material (including any property inherited from Material) can be passed in here.
	 *  
	 *  The exception is the property color, which can be passed in as a hexadecimal string and is 0xffffff (white) by default. Color.set( color ) is called internally.
	 */
	public MeshPhongMaterial( MeshPhongMaterialParameters parameters ) {}
}
