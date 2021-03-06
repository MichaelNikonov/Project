package sgi.entities;
import java.awt.image.BufferedImage;

public interface ILayer {	
	int getId();
	int getImageId();
	LayerType getType();
	BufferedImage getLayerImage();	
	void setImage(String layerFile);
}
