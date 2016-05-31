/**
 * 设计模式 学习之   模板方法 模式
 * 
 * 模板方法模式的定义： 定义一个操作中算法的骨架，而将一些步骤延续到子类中，
 * 模板方法可以使子类不改变算法的
 * 结构即可重新定义该算法的某些特定的步骤。
 * 
 * 
 * 
 * 总结：
 * 模板方法模式使用场景：
 * 1, 算法或者操作逻辑相似
 * 2,重构时（把相似的代码抽取到上层类中）
 * 。。。。。。
 * 优点：
 * 1，封装性好
 * 2，复用性好
 * 3，屏蔽性好
 * 4，易于维护
 * 缺点
 * Java 中是单继承
 * 
 * 
 * 
 * 好莱坞法则 Do not call me ,we will call you 
 * 钩子方法
 * 
 * @author yueli
 *
 */
package com.yl.myproject.patterns.template;