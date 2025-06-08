package com.github.zjjfly.template.client;

import com.github.zjjfly.template.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
@FeignClient(name = "person", url = "http://localhost:8088/api/person", configuration = FeignConfig.class)
public interface PersonClient {



}
