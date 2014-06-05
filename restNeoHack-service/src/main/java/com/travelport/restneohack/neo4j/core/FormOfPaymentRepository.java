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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.MapResult;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.ResultColumn;
import org.springframework.data.neo4j.repository.CypherDslRepository;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

public interface FormOfPaymentRepository extends GraphRepository<FormOfPayment>, CypherDslRepository<FormOfPayment> {

	Page<FormOfPayment> findByDescriptionLike(String description, Pageable pageable);

	List<FormOfPayment> findByAttributesContains(String attribute);

    // search string must be description:text
    @Query("START formOfPayment=node:formOfPayment_search({0}) " +
           " MATCH formOfPayment-[r:RATED]-traveler " +
           " RETURN formOfPayment " +
           " ORDER BY avg(r.stars) DESC")
    Page<FormOfPayment> listFormOfPaymentsRanked(String description, Pageable page);

    @Query("start cat=node:Category(name={0}) match cat-[SUB_CAT*0..5]-leaf<-[:CATEGORY]-formOfPayment return formOfPayment")
    Iterable<FormOfPayment> findByCategory(String category);
    
    @Query("START cust=node({0}) " +
           " MATCH cust-[r1:RATED]->formOfPayment<-[r2:RATED]-similar-[:ORDERED]->accountView-[:FOPS]->suggestion " +
           " where abs(r1.stars - r2.stars) <= 2 "+
           " RETURN suggestion, count(*) as score" +
           " ORDER BY score DESC")
    List<Suggestion> recommendFormOfPayments(Traveler traveler);
    
    @MapResult
    interface Suggestion {
        @ResultColumn("suggestion") FormOfPayment getFormOfPayment();
        @ResultColumn("score") Integer getScore();
    }
}
