package com.retroflix;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.collection.NitriteCollection;
import org.dizitart.no2.collection.Document;
import org.dizitart.no2.collection.DocumentCursor;
import org.dizitart.no2.mvstore.MVStoreModule;
		
import static org.dizitart.no2.filters.FluentFilter.where;

import java.util.List;

public class DatabaseHandler {

	public static String FILE_PATH = "database.db";
	
	private static String USERS_COLLECTIONS_NAME = "usersCollection";
	private static String MIDIA_COLLECTIONS_NAME = "midiaCollection";
	private static String ALLOCATION_COLLECTIONS_NAME = "allocationCollection";
	
	private static MVStoreModule storeModule;
	private static Nitrite database;
	
	private static NitriteCollection userCollection;
	private static NitriteCollection midiaCollection;
	private static NitriteCollection locationCollection;
	
	private static final int CLIENT_REQUEST_TYPE = 0;
	private static final int MIDIA_REQUEST_TYPE = 1;
	private static final int LOCATION_REQUEST_TYPE = 2;
	
	public static void init() {
		storeModule = MVStoreModule.withConfig()
				.filePath(FILE_PATH)
				.compress(true)
				.build();
		
		database = Nitrite.builder()
				.loadModule(storeModule)
				.openOrCreate();
		
		userCollection = database.getCollection(USERS_COLLECTIONS_NAME);
		midiaCollection = database.getCollection(MIDIA_COLLECTIONS_NAME);
		locationCollection = database.getCollection(ALLOCATION_COLLECTIONS_NAME);
	}
	
	public void insert(Document content, int type) {
		switch(type) {
			case CLIENT_REQUEST_TYPE:
				userCollection.insert(content);
			break;
			
			case MIDIA_REQUEST_TYPE: 
				midiaCollection.insert(content);
			break;
			
			case LOCATION_REQUEST_TYPE:
				locationCollection.insert(content);
			break;
		}
	}
	
	public List<Document> request(String field, String key, int type) {
		switch (type) {
			case CLIENT_REQUEST_TYPE: 
				return userCollection.find(where(field).eq(key)).toList();
			
			case MIDIA_REQUEST_TYPE:
				return midiaCollection.find(where(field).eq(key)).toList();
				
			case LOCATION_REQUEST_TYPE:
				return locationCollection.find(where(field).eq(key)).toList();
		}
		return null;
	}
}
