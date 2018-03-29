package model;

public class Train extends DAO{
	public static String JsonAllResult()
	{
		return JsonSearch("select * from train_request;");
	}
}
