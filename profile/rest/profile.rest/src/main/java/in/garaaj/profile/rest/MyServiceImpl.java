/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.garaaj.profile.rest;

import java.nio.BufferUnderflowException;

import in.garaaj.profile.api.Activator;
import in.garaaj.profile.api.ProfileContext;

public class MyServiceImpl implements MyService {
    Activator activator;
    public String echo(String message) {
    	 
    	activator.start(new ProfileContext());
        return "Echo processed: " + message;
    }
	public Activator getActivator() {
		return activator;
	}
	public void setActivator(Activator activator) {
		this.activator = activator;
	}
	public String defaultMessage() {
		// TODO Auto-generated method stub
		return "Hello World";
	}
    
}