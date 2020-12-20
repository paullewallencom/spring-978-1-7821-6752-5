/*
 * Copyright 2013 anjana.m.
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
package com.packt.wicket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
/**
 *
 * @author anjana.m
 */
public class ThreadLocalContextUtil {
    private static final ThreadLocal<String> contextHolder =
                    new ThreadLocal<String>();
          protected final Log logger = LogFactory.getLog(this.getClass());
           public static void setTenantId(String tenantId) {
              Assert.notNull(tenantId, "customerType cannot be null");
              contextHolder.set(tenantId);
           }
         
           public static String getTenantId() {
              return (String) contextHolder.get();
           }
         
           public static void clearTenant() {
              contextHolder.remove();
           } 
}
