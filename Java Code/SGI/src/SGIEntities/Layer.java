package SGIEntities;

public class Layer implements ILayer {

	private int _id;
	private int _imageid;
	private ILayerType _type;
	
	public Layer(int id, int imageid, ILayerType type) {
		_id = id;
		_imageid = imageid;
		_type = type;
	}
	
	public int getId() { return _id; }
	public int getImageId() { return _imageid; }
	public ILayerType getType() { return _type; }
	
}
