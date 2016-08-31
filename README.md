# LightAdapter
一个为`RecyclerView`打造的轻量级，可配置化，无侵入性，快速的Adapter。( Inspired by - [drakeet/MultiType](https://github.com/drakeet/MultiType) )

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)

我们使用`RecyclerView`的Adapter无非就几个目的：

1. 基本使用
1. 显示多种类型试图
1. 添加header和footer
1. 滑到底部自动加载更多（加载失败，重新加载等多种状态）

至于下拉刷新，Google已经提供了`SwipeRefreshLayout`，它已经非常好用，无需重复造轮子，而其他的功能LightAdapter均已实现。注意,滑到底部自动加载更多
其实不属于LightAdapter的功能，而是LightAdapter的一个扩展footer，你完全可以不用或者实现自己的footer，而对LightAdapter没有任何影响。下面说一下LightAdapter的核心：

LightAdapter的核心其实是多类型视图，是看了[drakeet/MultiType](https://github.com/drakeet/MultiType)的开源库受到启发并进行了改进（没用采用全局静态注册，注册时添加泛型约束，减少出错）。

先说滑到底部自动加载更多原理：

`RecyclerView`的Adapter的原理大家都知道：当某一个Item显示在屏幕中时，会调用Adapter的`onBindViewHolder`方法来让你绑定数据，但我们可以不用来绑定数据，列表中的最后一个Item出现时，
在这个Item会调用`onBindViewHolder`方法，所以如果增加一个回调，那这个Item不就是一个可以加载更多的Item了吗？原理大致就是这样了。。。

所以header和footer其实只是一个和你的普通数据类型不一样的Item罢了，








License
-------

    Copyright 2016 lufficc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.