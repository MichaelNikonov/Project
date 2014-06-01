package sgi.entities;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.io.File;
import javax.imageio.ImageIO;

public class SGIImage implements ISGIImage {

	private int _id;
	private Location _location;
	private Date _datetime;
	private BufferedImage _image;
	
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
		} catch (Exception e) { 
			System.out.println("SGI Image: " + e.getMessage());
			_image = null;
		}
	}

	public int getId() { return _id; }
	public Location getLocation() { return _location; }
	public Date getDateTime() { return _datetime; }
	public BufferedImage getImage() { return _image; }

	public void setImage(String imageFile) {
		try {
			_image = ImageIO.read(new File(imageFile));
		} catch (Exception e) {
			System.out.println("SGI Image: " + e.getMessage());
			_image = null;
		}
	}

	public void setImage(BufferedImage img) {
		_image = img;
	}

}