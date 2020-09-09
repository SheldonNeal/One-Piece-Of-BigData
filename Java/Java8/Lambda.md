##Java8特性1：Lambda表达式
参考链接：http://lucida.me/blog/java-8-lambdas-insideout-language-features/?nsukey=nxO%2BOzInSp7juTbGP1li3qHXYBENcYxrrtgZxWY4GPkP3fV1PSM9ikm7uDCwR5N0oT3zs4eekQQJ%2BhB0yXXtdJz0dnxMl9%2FJjfQrH%2B2OsQQuoA4V5MsTqoSLMdBC%2BUiLLgqrfRrxjmdaenVAJxGBsLa58gMKPWQKvuakiYiL0%2F5CvPYzT1VuDBr06WDreJjio1Mrk1cmODMMfCbXVY6%2B4Q%3D%3D  
###函数式接口  
1. 可以在接口上声明@FunctionalInterface是一个函数式接口  
2. 接口中只有一个抽象方法，也会自动识别为函数式接口
3. 函数式接口中有且只有一个抽象方法，所以使用lambda表达式的时候，方法体默认就是实现的接口中的抽象方法
4. Lambda表达式为Java添加了缺失的函数式编程特性，使得我们能将函数作为一等公民使用  
5. 在将函数作为一等公民的语言中，Lambda表达式的类型是函数，但是在Java中，**Lambda表达式是对象**，
他们必须依附于一类特殊的对象类型--函数式接口
6. 函数式接口可以通过Lambda表达式、方法引用、构造器引用来实现

+ 外部迭代与内部迭代 
+ Lambda表达式的类型要通过上下文才能确定