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

import 1.common.comm.clients.EurekaClinicalClient;

/**
 * Created by akalsan on 9/29/16.
 */
public final class ExternalClient extends EurekaClinicalClient{
	private final String webappURL;


	public ExternalClient(String inWebappUrl) {
		super(null);
		this.webappURL = inWebappUrl;
	}

	@Override
	protected String getResourceUrl() {
		return this.webappURL;
	}
}
