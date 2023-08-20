package com.fourth.sproject;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenGenerator {
	public static void generate(HttpServletRequest req) {
		// 중복이 안될만한 거 나오도록 -> 시간
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmssSS");
		req.setAttribute("token", sdf.format(now));
	}
}



