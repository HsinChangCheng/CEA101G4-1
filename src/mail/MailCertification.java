package mail;

import redis.clients.jedis.*;

public class MailCertification {
	private static JedisPool pool = null;

	static {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(8);
		config.setMaxIdle(8);
		config.setMaxWaitMillis(10000);
		pool = new JedisPool(config, "localhost", 6379);
	}

	public static String getAuthCode() {
		StringBuffer rand_num = new StringBuffer();
		String str = "01234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < 8; i++)
			rand_num.append(str.charAt((int) (Math.random() * str.length())));
		return rand_num.toString();
	}
	
	public String insertCode(String mem_id) {
		Jedis jedis = pool.getResource();
		jedis.auth("123456");
		String rand_num = getAuthCode();
		jedis.set(mem_id, rand_num);
		jedis.close();
		return rand_num;
	}
	
	public boolean verifyCode(String mem_id, String rand_num) {
		Jedis jedis = pool.getResource();
		jedis.auth("123456");
		if (jedis.get(mem_id).equals(rand_num)) {
			jedis.close();
			return true;
		} else {
			jedis.close();
			return false;
		}
	}

}
