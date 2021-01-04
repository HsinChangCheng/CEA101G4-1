package jdbc.util.CompositeQuery;
import java.util.*;
public class jdbcUtil_CompositeQuery_Activity_Period {
	public static String get_aCondition_For_Oracle(String columnName, String value) {

		String aCondition = null;

		if ("key_word".equals(columnName)) // 用於varchar
			aCondition = "act_period_id" + " like '%" + value + "%' "+
		"or act_id" + " like '%" + value + "%' "+
		"or act_up_limit" + " like '%" + value + "%' "+
		"or act_low_limit" + " like '%" + value + "%' "+
		"or act_cur_price" + " like '%" + value + "%' "+
		"or act_period_status" + " like '%" + value + "%' "+
		"or act_sign_sum" + " like '%" + value + "%' ";
		else if ("act_period_start".equals(columnName))                          // 用於Oracle的date
			aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";

		return aCondition + " ";
	}

	public static String get_WhereCondition(Map<String, String[]> map) {
		Set<String> keys = map.keySet();
		StringBuffer whereCondition = new StringBuffer();
		int count = 0;
		for (String key : keys) {
			String value = map.get(key)[0];
			if (value != null && value.trim().length() != 0	&& !"action".equals(key)) {
				count++;
				String aCondition = get_aCondition_For_Oracle(key, value.trim());

				if (count == 1)
					whereCondition.append(" where " + aCondition);
				else
					whereCondition.append(" and " + aCondition);

				System.out.println("有送出查詢資料的欄位數count = " + count);
			}
		}
		
		return whereCondition.toString();
	}
}
