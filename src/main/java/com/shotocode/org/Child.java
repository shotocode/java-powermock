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

public class Child {
	
	private String message;
	
	public Child() {
		
	}
	
	public Child(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return "I am from child class";
	}
	
	public String getConstructorMessage() {
		return this.message;
	}

}
