<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String[] nums 	= request.getParameterValues("nums");
	int state		= -1;
	int bonus		= 0;
	boolean flag	= false;
	int cnt			= 0;
	
	/* 숫자 유효성 검증 */
	try {
		for(int k = 0; k < nums.length; k++) {
			if( Integer.parseInt(nums[k]) > 45 && Integer.parseInt(nums[k]) <= 0) {
				flag = true;
			} else {
				flag = false;
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] == nums[j]) {
					flag = false;
				} else {
					flag = true;
				}
			}
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	/* 당첨여부 비교 */
	String[] okNums = {"38", "10", "9", "40", "27", "17", "41"};
	
	try {
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < okNums.length - 1; j++) {
				if( nums[i].equals(okNums[j]) ) {
					cnt++;
				}
				if( nums[i].equals(okNums[6]) ) {
					bonus = 1;
				} else {
					bonus = 0;
				}
			}
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	
	String[] noti	= {"lotto_result.jsp?state=0&cnt=" + cnt + "&bonus=" + bonus, "lotto.jsp?state=1"};
	if(flag == true) {
		state = 0;
	} else {
		state = 1;
	}
	response.sendRedirect(noti[state]);
%>