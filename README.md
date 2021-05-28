tiny-rpc 是 RPC 原理的最小化实现方式，实现了动态代理，参数序列化，远程调用，结果反序列化等功能。

# Client

1. 扫描所有带有注解 [@RemoteClass](client/src/main/java/site/likailee/rpc/client/annotation/RemoteClass.java) 的接口；
2. 为所有接口通过 JDK 代理，生成代理对象，通过 `by type` 的形式注入到 Bean 容器中；
3. 在 `invoke` 方法中获取 rpc 的真实类，序列化类名、方法名、参数类型、参数值，通过 HTTP 请求 rpc server，获取返回结果。

# Server

1. 获取接口所在的 class、参数类型、参数值；
2. 反序列化参数类型、参数值，获取需要调用的真实方法；
3. 通过反射调用方法，若 Bean 不存在，需要先创建对应的 Bean 实例；