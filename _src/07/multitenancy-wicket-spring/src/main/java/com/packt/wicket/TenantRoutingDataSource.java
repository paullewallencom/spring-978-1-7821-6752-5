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

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;

/**
 *
 * @author anjana.m
 */
 public class TenantRoutingDataSource extends AbstractRoutingDataSource {
 protected final Log logger = LogFactory.getLog(this.getClass());

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
    }

    @Override
    protected DataSource determineTargetDataSource() {
         System.out.println(DataSource.class.getCanonicalName()+"------DataSource");
        return super.determineTargetDataSource();
    }

    @Override
    public Connection getConnection() throws SQLException {
         System.out.println(Connection.class.getName()+"------Connection");
        return super.getConnection();
      
    }

    @Override
    protected DataSource resolveSpecifiedDataSource(Object dataSource) throws IllegalArgumentException {
        return super.resolveSpecifiedDataSource(dataSource);
    }

    @Override
    protected Object resolveSpecifiedLookupKey(Object lookupKey) {
        return super.resolveSpecifiedLookupKey(lookupKey);
    }

    @Override
    public void setDataSourceLookup(DataSourceLookup dataSourceLookup) {
        super.setDataSourceLookup(dataSourceLookup);
    }

    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        System.out.println(defaultTargetDataSource+"------defaultTargetDataSource");
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
         System.out.println(targetDataSources+"------targetDataSources");
    }

    @Override
    public PrintWriter getLogWriter() {
        return super.getLogWriter();
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return super.getLoginTimeout();
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return super.isWrapperFor(iface);
    }

    @Override
    public void setLogWriter(PrintWriter pw) throws SQLException {
        super.setLogWriter(pw);
    }

    @Override
    public void setLoginTimeout(int timeout) throws SQLException {
        super.setLoginTimeout(timeout);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return super.unwrap(iface);
    }


protected Object determineCurrentLookupKey() {
    
// Retrieve the current tenant id from the thread local object
// where it was stored in the filter earlier
String lookupKey = (String) ThreadLocalContextUtil.getTenantId();
System.out.println(lookupKey+"------lookupKey");

return lookupKey;
}
}