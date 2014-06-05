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
package com.travelport.restneohack.neo4j.order;

import com.travelport.restneohack.neo4j.core.AbstractEntity;
import com.travelport.restneohack.neo4j.core.Address;
import com.travelport.restneohack.neo4j.core.Traveler;
import com.travelport.restneohack.neo4j.core.FormOfPayment;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class AccountView extends AbstractEntity {

	@RelatedTo
	private Traveler traveler;
	@RelatedTo
	private Address billingAddress;
	@RelatedTo
	private Address shippingAddress;

	@RelatedToVia(type = "FOPS")
    @Fetch
	private Set<PaymentType> lineItems = new HashSet<PaymentType>();

	public AccountView(Traveler traveler) {
		this.traveler = traveler;
	}

	protected AccountView() {

	}

	public void add(PaymentType lineItem) {
		this.lineItems.add(lineItem);
	}
    // TODO JIRA setter was used when hydrating object from storage, don't use BeanWrapper
    public AccountView withBillingAddress(Address billingAddress) {
        Assert.state(traveler.hasAddress(billingAddress),"valid traveler address for "+traveler);
        this.billingAddress = billingAddress;
        return this;
    }

    public AccountView withShippingAddress(Address shippingAddress) {
        Assert.state(traveler.hasAddress(shippingAddress),"valid traveler address for "+traveler);
        this.shippingAddress = shippingAddress;
        return this;
    }

    public Traveler getTraveler() {
		return traveler;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public Set<PaymentType> getLineItems() {
		return Collections.unmodifiableSet(lineItems);
	}

    public void add(FormOfPayment formOfPayment, int amount) {
        add(new PaymentType(this,formOfPayment,amount));
    }
}
