/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.travelport.restneohack.neo4j;

import com.travelport.restneohack.neo4j.order.PaymentType;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class PaymentTypeMatcher extends TypeSafeMatcher<PaymentType> {

	private final String name;

	public PaymentTypeMatcher(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.hamcrest.SelfDescribing#describeTo(org.hamcrest.Description)
	 */
	@Override
	public void describeTo(Description description) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hamcrest.TypeSafeMatcher#matchesSafely(java.lang.Object)
	 */
	@Override
	protected boolean matchesSafely(PaymentType item) {

		if (item == null) {
			return false;
		}

		return item.getFormOfPayment().getName().equals(name);
	}

	@Factory
	public static <T> Matcher<PaymentType> lineItemWithName(String name) {
		return new PaymentTypeMatcher(name);
	}

}
