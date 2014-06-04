package sgi.entities;

import java.io.File;
import java.io.Serializable;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

public class Layer implements ILayer , Serializable {

	// Variables
	private static final long serialVersionUID = -4848363460556448969L;
	private int _id;
	private int _imageid;
	private LayerType _type;
	private transient BufferedImage _layer = null;
	private transient ByteArrayOutputStream baos = null;
	private byte[] imageInByte = null;
	// End variables
	
	// Constructors
	public Layer(int id, int imageid, LayerType type) {
		_id = id;
		_imageid = imageid;
		_type = type;
		_layer = null;
	}
	
	public Layer(int id, int imageid, LayerType type, String layerFile) {
		_id = id;
		_imageid = imageid;
		_type = type;
		try {
			_layer = ImageIO.read(new File(layerFile));
			imageToBytes();
		} catch (Exception e) { _layer = null; }
	}

	public Layer(int id, int imageid, LayerType type, BufferedImage layerImg) {
		_id = id;
		_imageid = imageid;
		_type = type;
		_layer = layerImg;
		imageToBytes();
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public int getImageId() { return _imageid; }
	public LayerType getType() { return _type; }
	public BufferedImage getLayerImage() { return _layer; }
	public byte[] getImageBytes() { return imageInByte; }
	public void setImage(String layerFile) {
		try {
			_layer = ImageIO.read(new File(layerFile));
			imageToBytes();
		} catch (Exception e) { _layer = null; }
	}
	public void setIayer(BufferedImage layerImg) {
		_layer = layerImg;
		imageToBytes();
	}
	
	private void imageToBytes() {
		try {
			baos = new ByteArrayOutputStream();
			ImageIO.write( _layer, "png", baos );
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch (Exception e) {} 
	}
	// End methods
}
