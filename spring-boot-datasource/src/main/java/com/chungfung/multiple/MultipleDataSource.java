package com.chungfung.multiple;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * @Description
 * @Author chungfung
 * @Date 2019/6/20 13:57
 * @Version 1.0
 */

public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}