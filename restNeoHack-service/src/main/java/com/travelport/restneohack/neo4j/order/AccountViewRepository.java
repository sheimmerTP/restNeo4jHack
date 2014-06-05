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

import com.travelport.restneohack.neo4j.core.Traveler;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

public interface AccountViewRepository extends GraphRepository<AccountView> {

	List<AccountView> findByTraveler(Traveler traveler);
	List<AccountView> findByTravelerEmailAddress(String emailAddress);
}
