/**
 * Copyright © 2010-2011 Nokia
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
package com.github.restdriver.serverdriver.http;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

public class RequestTimeoutTest {
    
    @Test
    public void timeoutIsAppliedCorrectlyToRequest() {
        ServerDriverHttpUriRequest request = new ServerDriverHttpUriRequest(new HttpGet());
        RequestTimeout timeout = new RequestTimeout(1111, 2222);
        
        timeout.applyTo(request);
        
        assertThat(request.getConnectionTimeout(), is(1111L));
        assertThat(request.getSocketTimeout(), is(2222L));
    }
    
}
