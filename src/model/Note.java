package model;

public class Note extends DAO{
	public static String JsonAllResult(String str)
	{
		return JsonSearch("select * from note_table where (noteid="+str+");");
	}
}
