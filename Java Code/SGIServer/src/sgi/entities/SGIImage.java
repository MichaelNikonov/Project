package sgi.entities;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class SGIImage implements ISGIImage , Serializable {

	private static final long serialVersionUID = 4734852160489936502L;
	private int _id;
	private Location _location;
	private Date _datetime;
	private transient BufferedImage _image = null;
	private transient ByteArrayOutputStream baos = null;
	private byte[] imageInByte = null;
	
	public SGIImage(int id, Location loc, Date dt) {
		_id = id;
		_location = loc;
		_datetime = dt;
		_image = null;
	}

	public SGIImage(int id, Location loc, Date dt,String imageFile) {
		_id = id;
		_location = loc;
		_datetime = dt;
		try {
			_image = ImageIO.read(new File(imageFile));
			imageToBytes();
		} catch (Exception e) { 
			System.out.println("SGI Image: " + e.getMessage());
			System.out.println("File name: " + imageFile);
			_image = null;
		}
	}

	public SGIImage(int id, Location loc, Date dt,BufferedImage image) {
		_id = id;
		_location = loc;
		_datetime = dt;
		_image = image;
		imageToBytes();
	}

	public int getId() { return _id; }
	public Location getLocation() { return _location; }
	public Date getDateTime() { return _datetime; }
	public BufferedImage getImage() {
		// convert byte array back to BufferedImage
		InputStream in = new ByteArrayInputStream(imageInByte);
		try {
			BufferedImage bImageFromConvert = ImageIO.read(in);
			return bImageFromConvert;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public byte[] getImageBytes() { return imageInByte; }
	
	public void setImage(String imageFile) {
		try {
			_image = ImageIO.read(new File(imageFile));
			imageToBytes();
		} catch (Exception e) {
			System.out.println("SGI Image: " + e.getMessage());
			_image = null;
		}
	}

	public void setImage(BufferedImage img) {
		_image = img;
		imageToBytes();
	}

	private void imageToBytes() {
		try {
			baos = new ByteArrayOutputStream();
			ImageIO.write( _image, "jpg", baos );
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch (Exception e) {} 
	}
}
