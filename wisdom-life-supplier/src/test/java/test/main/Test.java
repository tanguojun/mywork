package test.main;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.IndexOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.Mongo;

public class Test {

	// public static void main(String[] args) throws Exception {

	// MongoTemplate ops = new MongoTemplate(new Mongo("111.67.194.166"),
	// "test");
	// File f = new File("D:\\svnWorkFile\\sinoicity\\a.jar");
	//
	// Mongo mongo = new Mongo("111.67.194.166");
	// GridFS gridFS = new GridFS(mongo.getDB("test"));
	// // GridFSInputFile gif = gridFS.createFile(f);
	// // gif.save();
	// List<GridFSDBFile> fsl = gridFS.find("a.jar");
	// for (GridFSDBFile file : fsl) {
	// System.out.println(file);
	// }
	// TypedAggregation<Info> info = newAggregation(Info.class,
	// group("status").sum("age").as("totalAges"));
	// AggregationResults<HashMap> results = ops
	// .aggregate(info, HashMap.class);
	// List<HashMap> rs = results.getMappedResults();
	// for (HashMap m : rs) {
	// System.out.println(m);
	// }
	// System.out.println("===========");
	// List<HashMap> ms = ops.findAll(HashMap.class, "info");
	// for (HashMap m : ms) {
	// System.out.println(m);
	// }
	// ops.updateFirst(
	// new Query().addCriteria(Criteria.where("city").is("北京")),
	// new Update().set("city", "深圳"), Info.class);
	// GroupByResults<Info> rs = ops
	// .group("info",
	// GroupBy.key("status")
	// .initialDocument("{count:0,num:0}")
	// .finalizeFunction(
	// "function(result){result.count=result.count+10;result.num=result.num+100;}")
	// .reduceFunction(
	// "function(doc,value){value.count++;value.num++;}"),
	// Info.class);
	// System.out.println(rs.getKeys());
	// System.out.println(rs.getCount());
	// System.out.println(rs.getRawResults());
	// ops.aggregate(new Aggregation(), );
	// GroupByResults<Info> results = ops.group(
	// "info",
	// GroupBy.key("age").initialDocument("{count:0}")
	// .reduceFunction("function(doc,aaa){aaa.count++;}"),
	// Info.class);
	// System.out.println(results.getCount());
	// System.out.println(results.getKeys());
	// System.out.println(results.getRawResults());

	// String map =
	// "var map = function (){if(this.x!=undefined&&this.x!=null){for(var i = 0 ; i < this.x.length ; i++){emit(this.x[i],1);}}}";
	// String reduce =
	// "var reduce = function (key,values){var sum = 0;for (var i = 0; i < values.length; i++){sum += values[i];}return sum;}";
	// MapReduceResults<HashMap> mrr = ops.mapReduce("info", map, reduce,
	// HashMap.class);
	// for (HashMap v : mrr) {
	// System.out.println(v);
	// }
	public static void main(String[] args) throws UnknownHostException {

		MongoTemplate ops = new MongoTemplate(new Mongo("111.67.194.166"),
				"test");
		IndexOperations io = ops.indexOps(Info.class);

	}

}

// public static void main(String[] args) throws Exception {
//
// MongoOperations ops = new MongoTemplate(
// new Mongo("demo.sinoicity.com"), "test");
// Info info = new Info();
// info.setId(1);
// // WriteResult result = ops.updateMulti(new Query()
// // .addCriteria(new Criteria("id").is(1)),
// // new Update().set("ss", 12).inc("age", 1.3), Info.class);
// // System.out.println(result.isUpdateOfExisting());
// // System.out.println(result.getN());
// // Info i = ops.findOne(new Query().addCriteria(new
// // Criteria("id").is(1)),
// // Info.class);
// info = ops.findAndModify(
// new Query().addCriteria(Criteria.where("id").is(1)),
// new Update().set("age", 1),
// new FindAndModifyOptions().returnNew(true), Info.class);
// System.out.println(info.getAge());
// BasicQuery query = new BasicQuery("{id:1}");
// info = ops.findOne(query, Info.class);
// System.out.println(info.getAddress());
//
// }
// public static void main(String[] args) throws Exception {
//
// // MongoOperations ops = new MongoTemplate(
// // new Mongo("demo.sinoicity.com"), "test");
// // ops.insert(new Man("3", "aa"));
// // MongoFactoryBean mongo = new MongoFactoryBean();
// // mongo.setHost("demo.sinoicity.com");
// // System.out.println(mongo.getObject());
// MongoOperations ops = new MongoTemplate(
// new Mongo("demo.sinoicity.com"), "test");
// Person p = new Person("9", "b");
// Info info = new Info();
// info.setAddress("知春路");
// info.setPhone("13322112211");
// p.setAddress(info);
// p.setFriend("a,b,c,d,e,f".split(","));
// ops.dropCollection(Person.class);
// List list = new ArrayList();
// list.add(info);
// Info info1 = new Info();
// info1.setAddress("不知道");
// info1.setPhone("4444");
// list.add(info1);
// Map map = new HashMap();
// map.put("key1", "value1");
// map.put("key2", "value2");
// map.put("key3", info);
// p.setMap(map);
// p.setList(list);
// ops.insert(p);
// }

/*
 * public static void main(String[] args) throws UnknownHostException {
 * 
 * Mongo mongo = new MongoClient("demo.sinoicity.com"); DB db =
 * mongo.getDB("test"); System.out.println(db); DBCollection collection =
 * db.getCollection("java"); System.out.println(collection); DBObject user = new
 * BasicDBObject(); user.put("_id", "2"); user.put("name", "java1"); WriteResult
 * result = collection.insert(user); mongo.close();
 * System.out.println("insert ");
 * 
 * }
 */

// }
class Value {

	private String id;
	private double value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}

class Man {

	public Man() {
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	private String sex = "man";

}

class Info {

	private int id;
	@Indexed
	private String phone;
	private int age;
	@Indexed
	private int status;
	private Man man = new Man();

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Man getMan() {
		return man;
	}

	public void setMan(Man man) {
		this.man = man;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String address;

}

@Document(collection = "perSON")
class Person {
	private Info address;
	private String[] friend;
	private String id;
	private String name;
	private List<Info> list;
	private Map map;

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List<Info> getList() {
		return list;
	}

	public void setList(List<Info> list) {
		this.list = list;
	}

	public String[] getFriend() {
		return friend;
	}

	public void setFriend(String[] friend) {
		this.friend = friend;
	}

	public Info getAddress() {
		return address;
	}

	public void setAddress(Info address) {
		this.address = address;
	}

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getAAA() {
		return "1";
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Tdd {

	public Exception getException(Exception e) {
		return e;
	}

	public void add() throws Exception {
		try {

		} catch (Exception e) {
			throw getException(e);
		}
	}

}
