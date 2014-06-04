package server.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JImageBox extends JPanel {
	
	private static final long serialVersionUID = 982702346825835376L;
	
	private BufferedImage _image;
	private boolean _stretch = false;
	private ArrayList<BufferedImage> _overlays = new ArrayList<BufferedImage>();
	
	public JImageBox(String imgFile) {
		try {
			File imgF = new File(imgFile);
			if (imgF.exists() && !imgF.isDirectory()) {
				_image = ImageIO.read(imgF);
				this.setPreferredSize(new Dimension(_image.getWidth(), _image.getHeight()));
			}
		} catch (Exception e) {
			System.out.println("JImageBox: " + e.getMessage());
			_image = null;
		}
	}
	
	public JImageBox(BufferedImage img) {
		_image = img;
		this.setPreferredSize(new Dimension(_image.getWidth(), _image.getHeight()));
	}
	
	public void addOverlay(BufferedImage overlay) {
		_overlays.add(overlay);
	}
	
	public boolean getStretch() { return _stretch; }
	public void setStretch(boolean value) { _stretch = value; }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (_image == null) return;
		if (_stretch) {
			g.drawImage(_image, 0, 0, getWidth(), getHeight(), null);
			if (!_overlays.isEmpty()) {
				for (int i=0;i<_overlays.size();i++) {
					g.drawImage(_overlays.get(i), 0, 0, getWidth(), getHeight(), null);					
				}
			}
		}
		else {
			g.drawImage(_image, 0, 0, null);
			if (!_overlays.isEmpty()) {
				for (int i=0;i<_overlays.size();i++) {
					g.drawImage(_overlays.get(i), 0, 0, null);					
				}
			}			
		}
	}
	
}
