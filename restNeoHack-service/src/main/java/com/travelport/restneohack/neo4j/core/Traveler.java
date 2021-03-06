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

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Traveler extends AbstractEntity {

	private String firstName, lastName;
        
        //Needs default constructor

	@Indexed(unique = true)
	private String emailAddress;

	@RelatedTo(type = "ADDRESS")//require direction type here to address
	private Set<Address> addresses = new HashSet<Address>();

        public Traveler() {

	}
	public Traveler(String firstName, String lastName, String emailAddress) {

        Assert.hasText(firstName);
		Assert.hasText(lastName);
		Assert.hasText(emailAddress);

		this.firstName = firstName;
		this.lastName = lastName;
        this.emailAddress = emailAddress;
	}

	public void add(Address address) {
		this.addresses.add(address);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Set<Address> getAddresses() {
		return Collections.unmodifiableSet(addresses);
	}

    public boolean hasAddress(Address address) {
        return addresses.contains(address);
    }

    @Override
    public String toString() {
        return String.format("%s %s <%s>",firstName,lastName,emailAddress);
    }
}
