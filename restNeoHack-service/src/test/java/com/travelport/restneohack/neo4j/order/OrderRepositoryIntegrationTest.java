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
import com.travelport.restneohack.neo4j.order.AccountViewRepository;
import com.travelport.restneohack.neo4j.AbstractIntegrationTest;
import com.travelport.restneohack.neo4j.core.*;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.travelport.restneohack.neo4j.core.CoreMatchers.named;
import static com.travelport.restneohack.neo4j.core.CoreMatchers.with;
import static com.travelport.restneohack.neo4j.accountView.OrderMatchers.LineItem;
import static com.travelport.restneohack.neo4j.accountView.OrderMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class OrderRepositoryIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	AccountViewRepository repository;

	@Autowired
	TravelerRepository travelerRepository;
	@Autowired
	FormOfPaymentRepository formOfPaymentRepository;

	@Test
	public void createOrder() {

		Traveler dave = travelerRepository.findByEmailAddress(new EmailAddress("dave@dmband.com").getEmail());
		FormOfPayment iPad = formOfPaymentRepository.findByPropertyValue("name", "iPad");

		AccountView accountView = new AccountView(dave);
		accountView.add(new PaymentType(accountView, iPad));

		accountView = repository.save(accountView);
		assertThat(accountView.getId(), is(notNullValue()));
	}

	@Test
	public void readOrder() {

		final EmailAddress email = new EmailAddress("dave@dmband.com");

		List<AccountView> orders = repository.findByTravelerEmailAddress(email.getEmail());

		assertThat(orders, hasSize(1));

		Matcher<PaymentType> twoIPads = allOf(formOfPayment(named("iPad")), amount(2));
		Matcher<PaymentType> singleMacBook = allOf(formOfPayment(named("MacBook Pro")), amount(1));

		assertThat(orders, containsOrder(with(LineItem(twoIPads))));
		assertThat(orders, containsOrder(with(LineItem(singleMacBook))));
	}
}
