/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.garaaj.connect.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MyServiceImpl implements MyService {

	public String echo(String message) {
		return "Echo processed: " + message;
	}

	public void ListDatabses(MongoClient mongo) {
		List<String> dbs = mongo.getDatabaseNames();
		for (String db : dbs) {

			System.out.println(db);
		}

	}
	public MongoDatabase connectOrCreateDB(MongoClient mongo, String dbName){
		//MongoClientURI uri  = new MongoClientURI("mongodb://user:pass@host:port/db"); 
		//String dbURI = "mongodb://localhost";
        MongoClient client = new MongoClient("localhost");
 //       MongoDatabase db = client.getDatabase(uri.getDatabase());
		 MongoDatabase db = mongo.getDatabase(dbName);
	//	 db.createCollection("users");
		 return db;
	}
	public void insert(MongoDatabase db){
		MongoCollection<Document> songs = db.getCollection("songs");
		songs.insertMany(sampleData());
		
	}
	public List<Document> sampleData(){
		List<Document> seedData = new ArrayList<Document>();

        seedData.add(new Document("decade", "1970s")
            .append("artist", "Debby Boone")
            .append("song", "You Light Up My Life")
            .append("weeksAtOne", 10)
        );

        seedData.add(new Document("decade", "1980s")
            .append("artist", "Olivia Newton-John")
            .append("song", "Physical")
            .append("weeksAtOne", 10)
        );

        seedData.add(new Document("decade", "1990s")
            .append("artist", "Mariah Carey")
            .append("song", "One Sweet Day")
            .append("weeksAtOne", 16)
        );
        return seedData;
	}
	public static void main(String[] args) {
		MongoClient mongo = new MongoClient("localhost", 27017);
		MyServiceImpl m=new MyServiceImpl();
		MongoDatabase d =m.connectOrCreateDB(mongo, "tempu");
	//	m.insert(d);
		 //Iterator<Document> cursor = d.getCollection("songs").find().iterator();
		 Document findQuery = new Document("_id", new ObjectId("596010c931b3761f546dbd22"));
		 MongoCursor<Document> cursor = d.getCollection("songs").find(findQuery).iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		m.ListDatabses(mongo);
		mongo.close();
	}
}