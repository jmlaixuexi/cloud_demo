package com.jml.sharding.db.sharding.config.algorithm;


import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.*;

public class OrderDbComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        Collection<String> result = new HashSet<>();

        Map<String,Collection> columnNameAndShardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();
        Set<String> keySet = columnNameAndShardingValuesMap.keySet();
        for (String key : keySet) {
            Collection collection = columnNameAndShardingValuesMap.get(key);
            for (Object val: collection) {
                String value = val.toString();
                String userId = value;
                if (value.length() > 4) {
                    userId = value.substring(value.length() - 4);
                }
                int mod = Integer.parseInt(userId) % 2;
                for (Object name : availableTargetNames) {
                    if (name.toString().endsWith(String.valueOf(mod))) {
                        result.add(name.toString());
                    }
                }
            }
        }
        return result;

    }
}
