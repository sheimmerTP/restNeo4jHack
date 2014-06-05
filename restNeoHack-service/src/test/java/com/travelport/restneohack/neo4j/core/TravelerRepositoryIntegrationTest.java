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
package com.travelport.restneohack.neo4j.core;

import com.travelport.restneohack.neo4j.AbstractIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TravelerRepositoryIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	TravelerRepository repository;

	@Test
	public void savesTravelerCorrectly() {

		EmailAddress email = new EmailAddress("alicia@keys.com");

		Traveler alicia = new Traveler("Alicia", "Keys",email.getEmail()); // todo
        Country usa=new Country("US","United States");
        alicia.add(new Address("27 Broadway", "New York", usa));

		Traveler result = repository.save(alicia);
		assertThat(result.getId(), is(notNullValue()));
	}

	@Test
	public void readsTravelerByEmail() {

		EmailAddress email = new EmailAddress("alicia@keys.com");
		Traveler alicia = new Traveler("Alicia", "Keys",email.getEmail());

		repository.save(alicia);

		Traveler result = repository.findByEmailAddress(email.getEmail());
		assertThat(result, is(alicia));
	}

	@Test
	public void preventsDuplicateEmail() {

        final EmailAddress email = new EmailAddress("dave@dmband.com");
        Traveler dave = repository.findByEmailAddress(email.getEmail());

		Traveler anotherDave = new Traveler("Dave", "Matthews",dave.getEmailAddress());

        repository.save(anotherDave);
	}
}
