package model;

public class Result extends DAO{
	public static String JsonAllResult(String str)
	{
		return JsonSearch("select * from topic_temp where topic_id='"+str+"'");
	}
}