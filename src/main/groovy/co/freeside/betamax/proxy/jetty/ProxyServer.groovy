/*
 * Copyright 2011 Rob Fletcher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.freeside.betamax.proxy.jetty

import static Recorder.DEFAULT_PROXY_PORT
import co.freeside.betamax.Recorder
import co.freeside.betamax.proxy.RecordAndPlaybackProxyInterceptor

class ProxyServer extends SimpleServer {

	ProxyServer() {
		super(DEFAULT_PROXY_PORT)
	}

	void start(Recorder recorder) {
		def handler = new ProxyHandler()
		handler.interceptor = new RecordAndPlaybackProxyInterceptor(recorder)
		handler.timeout = recorder.proxyTimeout

		super.start(handler)
	}


}