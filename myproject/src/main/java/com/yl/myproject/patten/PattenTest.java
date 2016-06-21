package com.yl.myproject.patten;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PattenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "";
        Pattern pattern = Pattern.compile("(.)*(\\w\\sV[0-9]{3}R[0-9]{3}C[0-9]{2}(B[0-9]{3})?)");
        pattern.matcher(name).matches();
        long a  = 10001;
        System.out.println(a/10000);
	}

}
