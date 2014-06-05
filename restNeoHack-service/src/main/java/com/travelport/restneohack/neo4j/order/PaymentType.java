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
import com.travelport.restneohack.neo4j.core.FormOfPayment;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;
import org.springframework.util.Assert;

@RelationshipEntity(type = "FOPS")
public class PaymentType extends AbstractEntity {

	@StartNode
	private AccountView accountView;
    @Fetch
    @EndNode
	private FormOfPayment formOfPayment;

	private int amount;

	public PaymentType(AccountView accountView, FormOfPayment formOfPayment) {
		this(accountView,formOfPayment, 1);
	}

	public PaymentType(AccountView accountView, FormOfPayment formOfPayment, int amount) {
        Assert.notNull(formOfPayment);
        Assert.notNull(accountView);

        this.accountView = accountView;
		this.formOfPayment = formOfPayment;
		this.amount = amount;
	}

	public PaymentType() {

	}

	public FormOfPayment getFormOfPayment() {
		return formOfPayment;
	}

    public AccountView getOrder() {
        return accountView;
    }

    public int getAmount() {
		return amount;
	}
}
