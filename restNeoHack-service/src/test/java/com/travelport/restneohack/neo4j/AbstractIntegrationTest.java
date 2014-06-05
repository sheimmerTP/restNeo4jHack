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

import com.travelport.restneohack.neo4j.core.Address;
import com.travelport.restneohack.neo4j.core.Country;
import com.travelport.restneohack.neo4j.core.Traveler;
import com.travelport.restneohack.neo4j.core.FormOfPayment;
import com.travelport.restneohack.neo4j.order.AccountView;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestApplicationConfig.class })
@Transactional
public abstract class AbstractIntegrationTest {

	@Autowired
    protected Neo4jTemplate template;
    protected FormOfPayment iPad;
    protected FormOfPayment mbp;
    protected Traveler dave;

    /*
insert into Traveler (id, email, firstname, lastname) values (1, 'dave@dmband.com', 'Dave', 'Matthews');
insert into Traveler (id, email, firstname, lastname) values (2, 'carter@dmband.com', 'Carter', 'Beauford');
insert into Traveler (id, email, firstname, lastname) values (3, 'boyd@dmband.com', 'Boyd', 'Tinsley');

insert into Address (id, street, city, country, traveler_id) values (1, '27 Broadway', 'New York', 'United States', 1);

insert into FormOfPayment (id, name, description, price) values (1, 'iPad', 'Apple tablet device', 499.0);
insert into FormOfPayment (id, name, description, price) values (2, 'MacBook Pro', 'Apple notebook', 1299.0);

insert into Orders (id, traveler_id) values (1, 1);
insert into LineItem (id, formOfPayment_id, amount, order_id) values (1, 1, 2, 1);
insert into LineItem (id, formOfPayment_id, amount, order_id) values (2, 2, 1, 1);
    
     */
    @Before
    public void setUp() throws Exception {
        dave = template.save(new Traveler("Dave", "Matthews", "dave@dmband.com"));
        template.save(new Traveler("Carter","Beauford","carter@dmband.com"));
        template.save(new Traveler("Boyd","Tinsley","boyd@dmband.com"));
        final Country usa = template.save(new Country("US", "United States"));
        template.save(new Address("27 Broadway","New York",usa));
        iPad = template.save(new FormOfPayment("iPad", "Apple tablet device").withPrice(BigDecimal.valueOf(499D)));
        mbp = template.save(new FormOfPayment("MacBook Pro", "Apple notebook").withPrice(BigDecimal.valueOf(1299D)));
        final AccountView accountView = new AccountView(dave);
        accountView.add(iPad,2);
        accountView.add(mbp,1);
        template.save(accountView);
    }
}
