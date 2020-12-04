package com.yash.product_management;

import java.io.IOException;

import com.yash.product_management.util.MenuUtil;

public class App 
{
	public static void main(String[] args) throws IOException 
	{
		MenuUtil menuUtil = new MenuUtil();
		menuUtil.start();
	}
}