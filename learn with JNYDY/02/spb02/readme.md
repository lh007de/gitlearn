# 定制banner


# spring 属性注入
    @Value("${book.age}")

# @PropertySource 可以指定从哪个properties加载
默认是application.properties
        
    @PropertySource("classpath:book.properties")


# 类型安全的属性注入

    @ConfigurationProperties(prefix = "book")
# yaml配置方式
    1.yaml配置有序，properties配置无序
    2.