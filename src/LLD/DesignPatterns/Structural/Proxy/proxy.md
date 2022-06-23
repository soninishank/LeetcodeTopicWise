1.Proxy pattern is a structural design pattern.
2.Proxy is a wrapper or an agent that has been called by the client to access the real object behind the scenes. Proxy forwards the request to real objects.
3.It can perform authorization on behalf to restrict access to subset of the object or it may cache the responses received already and serve since the network call might be costly to make.
4.For the client interacting with the proxy , it is transparent the client will not be aware it is operating with the real object or proxy.
5.used for metadata : additional functionality should be provided to the response received such as wrapping the result and metadata.
6.used for caching purpose since the underlying resource may add latency
7.RestController is an example of Proxy pattern.