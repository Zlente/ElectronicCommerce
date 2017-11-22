package com.bill.cappu.app;

/**
 * 使用枚举类 进行 安全的惰性单例初始化（线程安全的懒汉模式）
 */

public enum ConfigType {
    API_HOST,
    APPLICATION_CONTEXT,
    CONFIG_READY,
    ICON
}
