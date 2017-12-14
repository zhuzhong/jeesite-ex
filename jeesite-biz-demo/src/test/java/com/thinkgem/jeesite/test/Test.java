package com.thinkgem.jeesite.test;

import java.util.Date;

import com.thinkgem.jeesite.common.config.Global;

public class Test {

	public static void main(String[] args) {
	String s="ht" + "tp:/" + "/h" + "m.b" + "ai" + "du.co" 
			+ "m/hm.gi" + "f?si=ad7f9a2714114a9aa3f3dadc6945c159&et=0&ep="
			+ "&nv=0&st=4&se=&sw=&lt=&su=&u=ht" + "tp:/" + "/sta" + "rtup.jee"
			+ "si" + "te.co" + "m/version/" + Global.getConfig("version") + "&v=wap-" 
			+ "2-0.3&rnd=" + new Date().getTime()	;
	System.out.println(s);
	}
}
