package com.bill.cappu.app;

import java.util.WeakHashMap;

/**
 * 管理控制项
 * 配置文件的存储 获取
 */

public class Configurator {
    private static final WeakHashMap<String, Object> CAPPU_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        CAPPU_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.instnace;
    }

    final WeakHashMap<String, Object> getCappuConfigs() {
        return CAPPU_CONFIGS;
    }

    /*
        * 如果要使用懒汉模式
        * 1.双重校验锁（syncrhonic关键字），防止线程冲突
        * 2.枚举类
        * 3.静态内部类，然后getInstance
     */
    private static class Holder {
        private static final Configurator instnace = new Configurator();
    }

    public final void configure() {
        CAPPU_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        CAPPU_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfigurations() {
        final boolean isReady = (boolean) CAPPU_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready.");
        }
    }

    final <T> T getConfigurations(Enum<ConfigType> key) {
        checkConfigurations();
        return (T) CAPPU_CONFIGS.get(key);
    }
}
