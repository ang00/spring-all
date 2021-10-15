* 按照启动 es
参考：[https://zhuanlan.zhihu.com/p/54384152](https://zhuanlan.zhihu.com/p/54384152)
* 设置es 密码
参考：[https://juejin.cn/post/6844903808733184014](https://juejin.cn/post/6844903808733184014)
> bin/elasticsearch-setup-passwords interactive
> xpack.security.enabled: true
> bin/elasticsearch-setup-passwords interactive
* 修改 `kibana` 配置文件 `config/kibana.yml` 文件添加
```yml
elasticsearch.username: "elastic"
elasticsearch.password: "123456"
```
