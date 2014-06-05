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
package com.travelport.restneohack.neo4j.accountView;

import com.travelport.restneohack.neo4j.order.PaymentType;
import com.travelport.restneohack.neo4j.order.AccountView;
import com.travelport.restneohack.neo4j.core.FormOfPayment;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.*;

public class OrderMatchers {

	public static <T> Matcher<Iterable<? super T>> containsOrder(Matcher<T> matcher) {
		return hasItem(matcher);
	}

	public static Matcher<AccountView> LineItem(Matcher<PaymentType> matcher) {
		return hasProperty("lineItems", hasItem(matcher));
	}

	public static Matcher<PaymentType> formOfPayment(Matcher<FormOfPayment> matcher) {
		return hasProperty("formOfPayment", matcher);
	}

	public static Matcher<PaymentType> amount(int amount) {
		return hasProperty("amount", is(amount));
	}
}
