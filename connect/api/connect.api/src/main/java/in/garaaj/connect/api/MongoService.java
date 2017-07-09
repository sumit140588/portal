package in.garaaj.connect.api;

import java.util.List;

import org.bson.Document;

public interface MongoService {

	public List get(String schemaName);
	public Object findById(String schemaName,String id);
	
	
	public void put(String schemaName,Object model,String id);
	public void put(String schemaName,Object model);
}
