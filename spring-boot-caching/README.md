spring-boot-caching
===================

# Features
- Use of cached data by spring

##Example
Without cached data, a slow service that takes about 5 seconds to return the information
```
2015-09-12 17:12:33.326  INFO 6042 --- [           main] demo.DemoRunner                          : .... Getting greeting 1 several times
2015-09-12 17:12:38.327  INFO 6042 --- [           main] demo.DemoRunner                          : greeting request0 -->demo.domain.Greeting@71c905a3
2015-09-12 17:12:43.327  INFO 6042 --- [           main] demo.DemoRunner                          : greeting request1 -->demo.domain.Greeting@30af7377
2015-09-12 17:12:48.328  INFO 6042 --- [           main] demo.DemoRunner                          : greeting request2 -->demo.domain.Greeting@67a056f1
2015-09-12 17:12:53.329  INFO 6042 --- [           main] demo.DemoRunner                          : greeting request3 -->demo.domain.Greeting@1dab9dd6
2015-09-12 17:12:58.329  INFO 6042 --- [           main] demo.DemoRunner                          : greeting request4 -->demo.domain.Greeting@247667dd
2015-09-12 17:13:03.330  INFO 6042 --- [           main] demo.DemoRunner                          : greeting request5 -->demo.domain.Greeting@6f099cef
2015-09-12 17:13:08.330  INFO 6042 --- [           main] demo.DemoRunner                          : greeting request6 -->demo.domain.Greeting@afb5821
2015-09-12 17:13:13.331  INFO 6042 --- [           main] demo.DemoRunner                          : greeting request7 -->demo.domain.Greeting@4bff2185
2015-09-12 17:13:18.332  INFO 6042 --- [           main] demo.DemoRunner                          : greeting request8 -->demo.domain.Greeting@5c20ffa8
2015-09-12 17:13:23.333  INFO 6042 --- [           main] demo.DemoRunner                          : greeting request9 -->demo.domain.Greeting@7fedfe27
```

## Using the cache
```
2015-09-12 17:11:17.204  INFO 6032 --- [           main] demo.DemoRunner                          : .... Getting greeting 1 several times
2015-09-12 17:11:22.212  INFO 6032 --- [           main] demo.DemoRunner                          : greeting request0 -->demo.domain.Greeting@1c025cb
2015-09-12 17:11:22.212  INFO 6032 --- [           main] demo.DemoRunner                          : greeting request1 -->demo.domain.Greeting@1c025cb
2015-09-12 17:11:22.212  INFO 6032 --- [           main] demo.DemoRunner                          : greeting request2 -->demo.domain.Greeting@1c025cb
2015-09-12 17:11:22.212  INFO 6032 --- [           main] demo.DemoRunner                          : greeting request3 -->demo.domain.Greeting@1c025cb
2015-09-12 17:11:22.213  INFO 6032 --- [           main] demo.DemoRunner                          : greeting request4 -->demo.domain.Greeting@1c025cb
2015-09-12 17:11:22.213  INFO 6032 --- [           main] demo.DemoRunner                          : greeting request5 -->demo.domain.Greeting@1c025cb
2015-09-12 17:11:22.213  INFO 6032 --- [           main] demo.DemoRunner                          : greeting request6 -->demo.domain.Greeting@1c025cb
2015-09-12 17:11:22.213  INFO 6032 --- [           main] demo.DemoRunner                          : greeting request7 -->demo.domain.Greeting@1c025cb
2015-09-12 17:11:22.214  INFO 6032 --- [           main] demo.DemoRunner                          : greeting request8 -->demo.domain.Greeting@1c025cb
2015-09-12 17:11:22.214  INFO 6032 --- [           main] demo.DemoRunner                          : greeting request9 -->demo.domain.Greeting@1c025cb
```

