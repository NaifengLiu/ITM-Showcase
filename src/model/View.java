package model;

public class View extends DAO{
	public static String JsonAllResult()
	{
		return JsonSearch("select view_table.view_id,view_table.title,count(*) as count from view_table,view_note where view_note.view_id=view_table.view_id group by view_table.title, view_table.view_id order by view_table.view_id");
	}
}
