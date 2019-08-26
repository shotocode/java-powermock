/**
 * 
 * ************************************************************
 *  Copyright (c) 2019 Shotocode.com All rights reserved.
 *	
 *  This work is licensed under the terms of the MIT license.  
 *	For a copy, see <https://opensource.org/licenses/MIT>.
 * ************************************************************
 *	
 * @date Aug 26, 2019
 * @author Katsum
 */

package com.shotocode.org;

public class Parent {
	
	public Parent(){
		
	}
	
	public String getMessage() {
		
		return " I am from Parent class";
	}
	
	public String createNewObject() {
		Child child = new Child();
		return child.getMessage();
	}
	
	public String createConstructorWithParams(String message) {
		Child child = new Child(message);
		return child.getConstructorMessage();
	}

}
