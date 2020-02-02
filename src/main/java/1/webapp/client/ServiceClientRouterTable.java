package 1.webapp.client;

/*-
 * #%L
 * learn
 * %%
 * Copyright (C) 2016 Emory University
 * %%
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
 * #L%
 */

import 1.common.comm.clients.Route;
import 1.common.comm.clients.RouterTable;

import javax.inject.Inject;

/**
 * Created by akalsan on 9/15/16.
 */
public class ServiceClientRouterTable implements RouterTable{

	private final InternalServiceClient client;

	@Inject
	public ServiceClientRouterTable(InternalServiceClient inClient) {
		this.client = inClient;
	}
	@Override
	public Route[] load() {
		return new Route[]{new Route("/", "/api/protected/", this.client)};
	}

}
