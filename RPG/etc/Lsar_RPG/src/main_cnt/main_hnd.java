package main_cnt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface main_hnd {
	public String action(HttpServletRequest req,HttpServletResponse res) throws Exception;
}
