package com.leibangzhu.demob;

@com.alibaba.dubbo.config.annotation.Service
public class TestService implements ITestService {
    @Override
    public String test() {
        return "test";
    }
}
