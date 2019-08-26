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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/*
 * Whenever you are mocking a new instance you have to add the class under test to PrepareForTest
 * If you are using Jacoco for code coverage reporting then use offline instrumentation. 
 * Jacoco fails to cover the class which is added to preparefortest and has mocking for new instance creation
 * 
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({Parent.class})
public class MockingNewInstanceTest {

	@InjectMocks
	Parent mockParent;
	
	@Mock
	Child mockChild;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	/*
	 * Using powermockito lets mock the child instance and return something different string
	 */
	
	@Test
	public void testNewInstance() {
		try {
			PowerMockito.whenNew(Child.class).withNoArguments().thenReturn(mockChild);
			when(mockChild.getMessage()).thenReturn("I am mock child");
			String string = mockParent.createNewObject();
			assertTrue(string.equalsIgnoreCase("I am mock child"));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	/*
	 * This is the other way of mocking child class where we don't use mock annotation object
	 */
	@Test
	public void testNewInstanceOtherWay() {
		try {
			Child mockChild2 = PowerMockito.mock(Child.class);
			PowerMockito.whenNew(Child.class).withNoArguments().thenReturn(mockChild2);
			when(mockChild2.getMessage()).thenReturn("I am mock child");
			String string = mockParent.createNewObject();
			assertTrue(string.equalsIgnoreCase("I am mock child"));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	
	/*
	 * Mocking new instance with arguments
	 */
	@Test
	public void testNewInstanceWithOrguments() {
		try {

			PowerMockito.whenNew(Child.class).withArguments(Mockito.anyString()).thenReturn(mockChild);
			when(mockChild.getConstructorMessage()).thenReturn("This is mock message");
			String string = mockParent.createConstructorWithParams("This is actual message");
			assertTrue(string.equalsIgnoreCase("This is mock message"));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	
	
	/*
	 * Without mocking getting actual message
	 */
	
	@Test
	public void testNewInstanceWithArgsFail() {
		try {
			String string = mockParent.createNewObject();
			assertFalse("Fails as we did not mock the instance creations", string.equalsIgnoreCase("I am from child class"));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	/*
	 * Without mocking getting actual message
	 */
	
	@Test
	public void testNewInstanceFail() {
		try {
			String string = mockParent.createConstructorWithParams("This is actual message");
			assertFalse("Fails as we did not mock the instance creations", string.equalsIgnoreCase("This is actual message"));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}

}
