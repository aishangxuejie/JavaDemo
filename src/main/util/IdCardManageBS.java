package util;

/**
 * 身份证管�?
 * 
 * @author 验证身份�?,获取性别与出生日�?
 */

public class IdCardManageBS {
	final static int[] Weight = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 }; // 加权因子
	final static String[] Verifycode = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" }; // 校验�?

	
	/**
	 * 判断身份证号码有效�??
	 * 
	 * @param idCard
	 *            身份证号�?
	 * @return 校验结果 0表示无效,1表示有效
	 * @throws AppException
	 */
	public String checkIdCard(String idCard) {
		String newIdCard = idCard;		
		String str = "";

		if (idCard.indexOf(" ") >= 0) { // 如果有空格，返回0			
			str = "身份证中不能含有空格!";
		} else {
			if (idCard.length() != 15 && idCard.length() != 18) { // idCard.length() != 15 &&
				str = "身份证位数错�?!";
			} else {
				if (idCard.length() == 15) { // 如果�?15�?,转换�?18�?
					Long m = 0L;
					Long d = 0L;
					try {
						m = Long.parseLong(idCard.substring(8, 10));
						d = Long.parseLong(idCard.substring(10, 12));
					} catch (Exception e) {
						str = "身份证无�?!";					
					}
					if (m > 12 || d > 31) {
						str = "身份证无�?!";
					} else {
						newIdCard = proIdCard15to18(idCard);
						if (newIdCard.length() != 18) { // 位数不对,返回0
							return "身份证无�?!";
						} else {
							String verify = newIdCard.substring(17, 18);

							if (verify.equalsIgnoreCase(getVerify(newIdCard))) { // �?查有效�??,并返回检查结�?
								
							} else {
								str = "身份证无�?!"; // 无效,返回0
							}
						}
					}
				} else if (idCard.length() == 18) {
					String verify = newIdCard.substring(17, 18);
					if (verify.equalsIgnoreCase(getVerify(newIdCard))) { // �?查有效�??,并返回检查结�?
						
					} else {
						str = "身份证无�?!"; // 无效,返回0
					}
				}
			}
		}
		return str;
	}
	
	/**
	 * 获取正确的身份证
	 * 
	 * @param idCard
	 * @return
	 */
	public String getAae135(String idCard) {
		String newIdCard = null;
		if (idCard.length() == 15) {
			newIdCard = proIdCard15to18(idCard);
		}
		if (idCard.length() == 18) {
			newIdCard = idCard;
		}
		return newIdCard;
	}

	/**
	 * 从身份证号码中获取�?�别
	 * 
	 * @param idCard
	 *            身份证号�?
	 * @return 性别,'2'为女�?,'1'为男�?
	 */
	public String getSexFromIdCard(String idCard) {
		if (idCard.length() == 15) { // 如果�?15�?,转换�?18�?
			idCard = proIdCard15to18(idCard);
		}
		if(idCard.length()!= 18){//实在处理不出来就默认�?1�?
			return "1";
		}
		int a = Integer.parseInt(idCard.substring(16, 17)); // 取�?�数�?2�?
		if (a % 2 == 0) { // 偶数为女�?,基数为男�?
			return "2";
		} else {
			return "1";
		}
	}

	/**
	 * 从身份证号码中获取出生日�?
	 * 
	 * @param idCard
	 *            身份证号�?
	 * @return 出生日期
	 */
	public String getBirthdayFromIdCard(String idCard) {
		if (idCard.length() == 15) { // 如果�?15�?,转换�?18�?
			idCard = proIdCard15to18(idCard);
		}
		String birthday = idCard.substring(6, 14); // 获取表示出生日期的第7-14�?
		return birthday.substring(0, 4) + "-" + birthday.substring(4, 6) + "-" + birthday.substring(6, 8);
	}

	/**
	 * 15位身份证号码转换�?18�?
	 * 
	 * @param idCard
	 *            15位身份证号码
	 * @return newidCard 扩充后的18位身份证号码
	 */
	public static String proIdCard15to18(String idCard) {
		if (idCard.length() != 15) {
			return idCard.toUpperCase();
		}
		int i, j, s = 0;
		String newidCard;
		newidCard = idCard;
		newidCard = newidCard.substring(0, 6) + "19" + newidCard.substring(6, idCard.length());
		for (i = 0; i < newidCard.length(); i++) {
			j = Integer.parseInt(newidCard.substring(i, i + 1)) * Weight[i];
			s = s + j;
		}
		s = s % 11;
		newidCard = newidCard + Verifycode[s];
		return newidCard;
	}

	/**
	 * 18位身份证号码转换�?15�?
	 * 
	 * @param idCard
	 *            15位身份证号码
	 * @return newidCard 扩充后的18位身份证号码
	 */
	public static String proIdCard18to15(String idCard) {
		if (idCard.length() != 18) {
			return idCard;
		}
		String newidCard;
		newidCard = idCard;
		newidCard = newidCard.substring(0, 6) + newidCard.substring(8, idCard.length() - 1);
		return newidCard;
	}

	/**
	 * 获取身份证校验码
	 * 
	 * @param idCard
	 *            身份证号�?
	 * @return 身份证号码的校验�?
	 * @throws NumberFormatException
	 */
	
	private String getVerify(String idCard) {
		int[] ai = new int[18];
		int remaining = 0;
		if (idCard.length() == 18) {
			idCard = idCard.substring(0, 17);
		}
		if (idCard.length() == 17) {
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				String k = idCard.substring(i, i + 1);
				try {
					ai[i] = Integer.parseInt(k);
				} catch (NumberFormatException e) {
					remaining = -1;
				}
			}
			for (int i = 0; i < 17; i++) {
				sum = sum + Weight[i] * ai[i];
			}
			remaining = sum % 11;
		}
		return remaining == 2 ? "X" : String.valueOf(Verifycode[remaining]);
	}

}
