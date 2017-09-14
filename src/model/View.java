package model;

public class View extends DAO{
	public static String JsonAllResult()
	{
		return JsonSearch("select view_table.idview,view_table.title,count(*) as count from view_table,view_note where view_note.viewid=view_table.idview group by view_table.title, view_table.idview order by view_table.idview");
	}
}
