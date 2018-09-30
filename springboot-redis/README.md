#[Redis 的集成和简单使用](http://www.importnew.com/29554.html)

#RedisTemplate的很多功能是以子API的形式提供的，它们区分了单个值和集合值的场景

|方法 |子API接口　|　描述|
| --------   | -----:   | :----: |
|opsForValue() |ValueOperations<K, V> |操作具有简单值的条目|
|opsForList() |ListOperations<K, V> |操作具有list值的条目|
|opsForSet() |SetOperations<K, V> |操作具有set值的条目|
|opsForZSet() |ZSetOperations<K, V> |操作具有ZSet值（排序的set）的条目|
|opsForHash() |HashOperations<K, HK, HV> |操作具有hash值的条目|
|boundValueOps(K) |BoundValueOperations<K,V> |以绑定指定key的方式，操作具有简单值的条目|
|boundListOps(K) |BoundListOperations<K,V> |以绑定指定key的方式，操作具有list值的条目|
|boundSetOps(K) |BoundSetOperations<K,V> |以绑定指定key的方式，操作具有set值的条目|
|boundZSet(K) |BoundZSetOperations<K,V> |以绑定指定key的方式，操作具有ZSet值（排序的set）的条目|
|boundHashOps(K) |BoundHashOperations<K,V> |以绑定指定key的方式，操作具有hash值的条目|

