/*
 * Copyright 2013 the original author or authors.
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

package org.springframework.xd.dirt.rest;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.xd.dirt.stream.TriggerDefinition;
import org.springframework.xd.rest.client.domain.TriggerDefinitionResource;

/**
 * Knows how to build a REST resource out of our domain model {@link TriggerDefinition}.
 * 
 * @author Gunnar Hillert
 * @since 1.0
 */
public class TriggerDefinitionResourceAssembler extends
		ResourceAssemblerSupport<TriggerDefinition, TriggerDefinitionResource> {

	public TriggerDefinitionResourceAssembler() {
		super(TriggersController.class, TriggerDefinitionResource.class);
	}

	@Override
	public TriggerDefinitionResource toResource(TriggerDefinition entity) {
		return createResourceWithId(entity.getName(), entity);
	}

	@Override
	protected TriggerDefinitionResource instantiateResource(TriggerDefinition entity) {
		return new TriggerDefinitionResource(entity.getName(), entity.getDefinition());
	}

}
