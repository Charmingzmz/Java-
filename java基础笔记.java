
今日内容

	* 知识回顾
	* static 关键字
	* 代码块


#知识回顾
##java中的基础语法
>* A:数据类型：
>* B:基本数据类型的转换



	总结：
		* A：数据类型
			* 数据类型的分类
			*基本数据类型(四类八种)
				* 整数类型
					byte	1个字节		-128~127
					short	2个字节
					int		4个字节
					long	8个字节

				* 浮点类型
					float 	4个字节
					double	8个字节
				* 字符类型
					char	2个字节
				* 布尔类型
					boolean true  false
					* 理论上是占了八分之一个字节,java最小的数据单位是字节
			*引用数据类型
				数组,类,接口,String List

			变量定义的格式:
				数据类型 变量名 = 初始化值;
				int a  = 10;
				byte b = 20;


		* B：数据类型的转换
			* 隐式转换
				将小的数据类型自动提升为大的数据类型
				byte short char --> int -->long-->float--double
			* 强制转换
				int a  = 10;
				byte b = 20;

				b = a;

				格式:
					目标数据类型 变量名 = (目标数据类型)(转换的数据);
					byte b = (byte)a;
			

>* 运算符
	
	什么是运算符:用于操作变量和常量的符号
	什么是表达式:用运算符链接起来的符合java语法的式子叫表达式
	int a  = 10;
	int b = 20;
	a+b; 算数表达式
	a>b; 比较表达式(关系表达式)

	运算符的分类
		* 算数运算符
		* 比较运算符
		* 赋值运算符
		* 逻辑运算符
		* 三元运算符(三目运算符)

		* 算数运算符
			* 分类
				+ - * / % ++ --
			* / 和 % 之间的区别?
			 / : 取的是两个数的商,如果参与运算的是int类型的数,结果是int类型的,如果想要小数的话,那么这两个数当中必须是有一个浮点类型的数据.结果都是浮点类型的
			 % : 取的是两个数的余数

			 7 / 4 = 1
			 7 % 4 = 3
			* ++ 和 --
			  单独使用
			  	++ -- 不管在前还是在后,结果都是一样的
			  参与运算
			  	++ -- 在前的时候,是先自赠或自减,然后在参与运算
			  	++ -- 在后的时候,是先参与运算,然后自赠或自减

		* 比较运算符
			* 分类: 
				> >= < <= == !=

			* == 和 = 的区别?
				== 如果是比较的是基本数据类型,比较的是值.

				   如果是引用数据类型比较的是内存地址值.

				 = 赋值运算符
				
				int a  = 10;
				int b  = 20;



			
		* 赋值运算符
			* 分类: 
				= += -= /= %=
			* 扩展运算符
				+= : 将左右两边的数据进行相加,然后在把值赋值给左边,同时类型强制转换的作用
				int a = 10;
				byte b = 10;
				b += a;

				
		* 逻辑运算符

			* 分类:
				& | ^ ! && ||
			
			* 运算规则:
				&:有false则为false
				|:有true则为true
				^:相同则为false 不同则为true 
				!:非false即为true ,非true即为false
				
		
			* && 和 &
				他们两个的结果都是一样的,只不过是&& 有短路的效果
				&& 当左边为false的时候,右边就不在执行了,提高了效率


			* || 和 |
				他们两个的结果都是一样的,只不过是|| 有短路的效果
				|| 当左边为true的时候,右边就不在执行了,提高了效率


			
				
		* 三元运算符

			* 格式：
				(关系表达式) ? 表达式1:表达式2;
			*执行顺序
				先计算关系表达式的值是true还是false
				如果是true就执行表达式1的值
				如果是false就执行表达式2的值
			 


##方法的回顾
>* A:什么是方法
>* B:方法的格式
>* C:定义方法(举例：求两个数的和)
>* D:方法的调用
>* E:方法的重载

	总结:
		* A：什么是方法？
			具有完成特定功能的代码块,提高了复用性
		* B：方法的格式？
			修饰符  返回值类型  方法名(参数类型 参数名1,参数类型 参数名2,参数类型 参数名3...){
				方法体;
				return 返回值;
			}
		   
		* C：定义方法(举例：求两个数的和)
			/*
			 * 求两个整数的和
			 *  两个明确:
			 *  	1.明确返回值类型 int
			 *  	2.明确参数列表:int a,int b
			 */
			
			public static int getSum(int a,int b){
				return a+b;
			}

		* D：方法的调用
			* 有返回值调用
				*赋值调用 推荐的方式
				*输出调用
				*单独调用
			* 无返回值调用
				*单独调用
			
		* E：方法的重载
			方法名相同,参数列表不同,与返回值无关
				参数类表不同
					1.数据类型不同
					2.个数不同
                                                                                3，参数位置不同
			

##数组的回顾
>* A:什么是数组
>* B:数组的格式
>* C:数组的特点
>* D:数组的初始化

	总结:
		* A:什么是数组
			可以存储同一种数据类型的多个元素的容器,叫数组
			
		* B:定义数组的格式 :
			格式一:数据类型[] 数组名 = new 数据类型[长度];
			格式二:数据类型[] 数组名 = {元素1,元素2,元素3...};
			格式三:数据类型[] 数组名 = new数据类型[]{元素1,元素2,元素3...};

		* C:数组的特点
			int[] arr = new int[10];
			ArrayList<String> list = new ArrayList<>();
			Student[] stu = new Student[10];
			*  长度不可变
			*  只能存储同一种数据类型
			*  数组不进能存储基本数据类型也能存储引用数据类型
			*  通过索引操作数组,数组的索引从0开始,最大索引length-1
			
		
		* D:数组的初始化
			* 动态初始化：
				由我们自己给出长度,有系统给出默认值
				数据类型[] 数组名 = new 数据类型[长度];
			* 静态初始化：
				由我们给出值,由系统给出长度
				数据类型[] 数组名 = {元素1,元素2,元素3...};

			注意:动静结合

##定义学生标准类
>* 标准的学生的类都包括哪些内容
	姓名,年龄,性别,毕业院校
	学习,吃饭,睡觉
	
	总结:
		* A:成员变量要私有化 private 
		* B: 有参/无惨构造
		* C:get和set方法
		

#静态
##一、static的概念
	* A：概念
		* static 是一个关键字,可以修饰成员变量和成员方法,被static修饰的成员变量和成员方法,他是属于类的共享数据,已经不在是数据某个对象了
	特点：
		1.数据共享
		2.通过类名调用成员变量和成员方法
		3.优先于对象而加载的
		4.随着类的加载而加载的
		
	
	
##二、static的内存图（了解）
	* A: 见图
		
##三、static注意事项
	
		总结:
			静态只能调用静态的
			非静态的能调用静态的也能调用非静态的
			
		问题:在静态方法中是否有this对象?
			 this:代表的是当前对象的引用
			 没有this对象
		* A: 注意事项
			* 优点
				* 可以通过类名调用成变量和成员方法
				* 节省了内存
			* 缺点
				* 静态只能调用静态的
		* B: 访问静态成员的格式：
			* a:通过类名.调用
			* b:创建对象调用


##四、Math
>* Math类中的常用的方法

	* static double PI 						： 圆周率
	* static double ceil(double a) 			： 向上取整
	* static double floor(double a)  		： 向下取整
	* static long round(double a) 			： 四舍五入
	* static int min(int a, int b) 			： 求最小值
	* static int max(int a, int b) 			： 求最大值
	* static double pow(double a, double b) ： 求a的b次幂
	* static double random()			    ： 随机数[0,1)
 
		
	案例代码：
		// * static double PI ： 圆周率
		System.out.println(Math.PI);
		// * static double ceil(double a) ： 向上取整
		System.out.println(Math.ceil(1.5));
		// * static double floor(double a) ： 向下取整
		System.out.println(Math.floor(1.5));
		// * static long round(double a) ： 四舍五入
		System.out.println(Math.round(1.26));
		System.out.println(Math.round(1.6));
		// * static int min(int a, int b) ： 求最小值
		System.out.println(Math.min(19, 20));
		// * static int max(int a, int b) ： 求最大值
		System.out.println(Math.max(20, 21));
		// * static double pow(double a, double b) ： 求a的b次幂
		System.out.println(Math.pow(3, 3));
		// * static double random() ： 随机数[0,1)
		System.out.println(Math.random());

##四、static静态的使用场景
	* A: 使用场景
			
		* 什么时候使用static修饰成员变量？
			* 如果类中有数据共享的内容,我们就考虑使用static关键字修饰
			
		* 什么时候使用static修饰成员方法？
			* 定义工具类
			
			
	
###五、自定义工具类

		案例演示.
		

###六、定义静态常量
	* A: 静态常量
		在我们实际开发当中,如果一个类中,某个变量是属于共享数据,而且又是不被改变的.
		 public static final
	* B: 定义格式：
		public static final 数据类型 常量名 = 值;
		案例代码:
			public class StaticDemo {
				// 定义常量的格式
				// public static final 数据类型 常量名 = 值;
				// ctrl+shift+x,ctrl+shift+y
				public static final String SCHOOL_NAME = "传智博客";
			}

		* 总结:
			public static final  如果修饰的是基本数据类型的时候,修饰的是值不能被改变
			public static final  如果修饰的是引用数据类型的时候,修饰的是地址值不能被改变

			
		
#代码块
>* A代码块的分类
	
	总结:
		* A:局部代码块
		* B:构造代码块
		* C:静态代码块
		* D:同步代码块(多线程讲)

>* 局部代码块

	* A:局部代码块的作用
		* 存在于方法当中,作用主要是控制变量的生命周期

	   案例代码:
	   public class Demo {
			public static void main(String[] args) {
				/*
				 * 存在于方法当中,作用主要是控制变量的生命周期
				 */
				{
					int a = 10;
					System.out.println(a);
				}
		//		System.out.println(a);
			}
		}
			
		
>* 构造代码块

	* A:构造代码块的作用
		*  抽取构造方法里面共性的内容,放到构造代码块里面.每创建一次对象,构造代码块就会执行一次.
		    优先于无惨和有参的构造方法执行

		案例代码:
			public class Demo1 {
				int a = 10;
				// 构造代码块:抽取构造方法里面共性的内容,放到构造代码块里面.
				// 每创建一次对象,构造代码块就会执行一次
				{
					for (int i = 0; i < 10; i++) {
						System.out.println("HelloWorld");
					}
				}

				public Demo1() {
					// for (int i = 0; i <10; i++) {
					// System.out.println("HelloWorld");
					// }
				}

				public Demo1(int a) {
					// for (int i = 0; i <10; i++) {
					// System.out.println("HelloWorld");
					// }
					this.a = a;
				}
		}

>* 静态代码块

	* A:静态代码块的作用
		* 主要创建对象的时候,加载一些驱动和初始化数据!随着类的加载而加载.而且只执行一次

		案例代码:

		public class StaticBlock {
			// 定义静态代码块
			// 作用:主要是在创建类的时候,加载一些驱动!数据库加载驱动的时候使用,只运行一次
			static{
				System.out.println("这是静态代码块!");
			}
			
		}
		
>* 代码块的面试题
	
	需求:在一个Coder类中有静态代码块,构造代码块,无惨构造
		定义一个类CoderTest 在这个类中有静态代码块,构造代码块,无惨构造
		在main方法当中
			Coder c = new Coder();
		请问:他们之间的执行的顺序是?

			CoderTest静态代码块执行了! -->CoderTest的main方法执行了! -->Coder静态代码块执行了! -->Coder构造代码块执行了! -->
			Coder无惨构造执行了! --> Coder构造代码块执行了! --> Coder无惨构造执行了!

		案例代码:
			public class Coder {
				// 静态代码块
				static{
					System.out.println("Coder静态代码块执行了!");
				}
				// 构造代码块
				{
					System.out.println("Coder构造代码块执行了!");
				}
				
				public Coder(){
					System.out.println("Coder无惨构造执行了!");
				}
			}

			public class CoderTest {
				static{
					System.out.println("CoderTest静态代码块执行了!");
				}
				// 构造代码块
				{
					System.out.println("CoderTest构造代码块执行了!");
				}
				
				public CoderTest() {
					System.out.println("CoderTest无惨构造执行了!");
				}

				public static void main(String[] args) {
					System.out.println("CoderTest的main方法执行了!");
					Coder c = new Coder();
					Coder c1 = new Coder();
				}
			}
		
	