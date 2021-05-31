package p1;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDB {
  public static MongoClient mongoClient;
  public static DB database;
  public static DBCollection test;

  public static void main(String[] args) {
    mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    database = mongoClient.getDB("MongoDBTutorial");
    test = database.getCollection("test");

    Test testObj = new Test();
    testObj.setMemberID("abc");
    testObj.setTimer(1);
    testObj.setXp(1234);

    test.insert(convert(testObj));
    DBObject query = new BasicDBObject("XP",1234);
    DBCursor cursor = test.find(query);
    System.out.println(cursor.one());




  }
  public static DBObject convert(Test testObj){
    return new BasicDBObject("XP", testObj.getXp()).append("Timer", testObj.getTimer()).append("memberID", testObj.getMemberID());
  }


}
