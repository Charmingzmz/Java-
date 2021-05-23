今日内容介绍

	1、Object类
	2、System类
	3、Date类的用法
	4、Calendar类的用法
	5、包装类
	6、正则表达式

###01、Object类概述
>* A:Object类概述

		* 类层次结构的根类
		* 所有类都直接或者间接的继承自该类
		* Object中描述的所有方法子类都可以使用
		* 所有类在创建对象的时候，最终找的父类就是Object。
	
###02、Object类中的方法
>* A:Object类中有哪些方法？

		* String toString()  
		* boolean equals(Object obj)  
		* Class<?> getClass() 
		* int hashCode() 
###03、Object中的toString方法
>* A:什么是toString方法？
>* B:为什么要重写toString方法？


	总结：
		* A:toString()方法
			该方法返回的是对象的字符串的表现形式

		* B:重写toString方法
			* a: 为什么要重写toString方法
				* toString方法返回该对象的字符串表示，其实该字符串内容就是对象的类型+@+内存地址值。
				* 由于toString方法返回的结果是内存地址，而在开发中，经常需要按照对象的属性得到相应的字符串表现形式，因此也需要重写它。
				* Object类中的toString的核心代码
					getClass().getName() + "@" + Integer.toHexString(hashCode());
				* 由于默认情况下的数据对我们来说没有意义，一般建议重写该方法。
			* b: 案例核心代码(重写Person类中的toString方法)
				/*
				 * 重写父类的方法toString()
				 * 没有必要让调用者看到内存地址
				 * 要求: 方法中,返回类中所有成员变量的值
				 */
				public String toString(){
					return name + age;
				}	
				//推荐使用Eclipse中自动生成的toString
				@Override
				public String toString() {
					return "Person [name=" + name + ", age=" + age + "]";
				}
				//测试代码
				public class TestToString {
					public static void main(String[] args) {
						//调用Person类的方法toString()
						//输出语句中,写的是一个对象,默认调用对象的toString方法
						Person p = new Person("张三",20);
						String s = p.toString();
						System.out.println(p);
						System.out.println(s);
						/*
						 * System.out.println(p);
						 * System.out.println(p.toString());
						 */
						//其他类对比
						/*Random r = new Random();
						System.out.println(r.toString());
						
						Scanner sc = new Scanner(System.in);
						System.out.println(sc.toString());*/
					}
				}

>* 案例

	定义一个Student类
	  属性:姓名,年龄
	定义一个测试类
	  在测试类中定义一个Student对象,为姓名和年龄分别赋
	  值,要求在打印学生对象的时候,输出效果示例:
	    Student [name=zhangsan, age=18]


###04、Object中的getClass()方法
>* A:getClass()方法的作用是什么？
>* B:获取对象的字节码的有几种方式？

	总结:
		* A：
			获取的是类的字节码对象
		* B：
			a:方式一
				*通过Object类的getClass获取
			b:方式二
				*通过类名调用属性class获取
			c:方式三
				*通过Class的静态方法forNanme(String name)
	

###04、Object中的equals()方法

>* A:回顾==号和equals方法的区别
>* B:equals方法比较内存地址

	总结:
		*A:==号和equals方法的区别
			==：
			equals：

		* B:equals方法比较内存地址
			* a: Object类中的equals方法
				* 用于比较两个对象是否相同，Object类中就是使用两个对象的内存地址在比较。
				* Object类中的equals方法内部使用的就是==比较运算符。
			* b:重写equals和不重写equals的区别？
				*重写equals
					* 开发中要比较两个对象是否相同，经常会根据对象中的属性值进行比较			
					* 在开发经常需要子类重写equals方法根据对象的属性值进行比较。	
				*不重写equals 
					*equals方法和==号比较引用数据类型没有什么区别，比较的是内存的地址值

		案例演示：
			

#System类
###01、System类中的方法
>* static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
>* static long currentTimeMillis():用于计算程序的执行时间
>* static void exit(int status) : 退出jvm


###02.System类中的arraycopy()方法

	   void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
	   * System类方法,复制数组
	   * arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
	   * Object src, 要复制的源数组
	   * int srcPos, 源数组的起始索引
	   * Object dest,复制后的目标数组
	   * int destPos,目标数组起始索引 
	   * int length, 复制几个
	
 	   案例演示：

		public class ArrayCopyDemo {
			public static void main(String[] args) {
				//定义源数组
				int[] src = {1,2,3,4,5,6,7};
				//目标数组，长度为src.length
				int[] dest = new int[src.length];
				//将src数组从0索引开始复制，复制到目标数组dest，从0索引开始，一直存储到dest最后一个
				System.arraycopy(src, 0, dest, 0, src.length);
				System.out.println(Arrays.toString(dest));
			}
		}
		
###03.System类currentTimeMillis()方法

	* A：System类方法currentTimeMillis():用于计算程序的执行时间
	
		/*
		 *  获取系统当前毫秒值
		 *  static long currentTimeMillis()
		 *  对程序执行时间测试
		 */

		public static void function(){
			long start = System.currentTimeMillis();//当前时间x-1970年1月1日零时零分零秒
			for(int i = 0 ; i < 10000; i++){
				System.out.println(i);
			}
			long end = System.currentTimeMillis();//当前时间y-1970年1月1日零时零分零秒
			System.out.println(end - start);//当前时间y-当前时间x
		}
 

###04.System类exit()方法
	*A:System类方法exit()方法：退出虚拟机,所有程序全停止

		案例演示：
			public static void function_1(){
				while(true){
					System.out.println("hello");
					System.exit(0);//该方法会在以后的finally代码块中使用(讲到再说)
				}
			}
	
#Data类
###01、Date类的构造方法
	* A: Date类的构造方法
		* a: 空参构造
			* public Date():获取的是当前系统的时间
		* b: 带参构造
			* public Date(long times)：将毫秒值转成日期对象

###02、Date类的get和set方法			
	* A：Date类的get和set方法
		* public long getTime()	
			* 将当前的日期对象，转为对应的毫秒值
		* public void setTime(long times);
			* 根据给定的毫秒值，生成对应的日期对象

###03、日期格式化SimpleDateFormat
>* A：SimpleDateFormat概述
>* B：SimpleDateFormat构造方法
>* B：使用SimpleDateFormat日期格式进行String和Date之间的转换

		* 对日期格式化的类 java.text.DateFormat 抽象类, 普通方法,也有抽象的方法
		* 实际使用是子类 java.text.SimpleDateFormat 可以使用父类普通方法,重写了抽象方法

	总结：
		*A：
			SimpleDateFormat主要是针对String和Date之间的相互转换
			
			格式化：
				将Date 转换成我们想要的格式，比如我们想要2017年05月25日
			解析：
				将String字符串，解析成Date对象，解析的时候，传入的字符串格式，必须是SimpleDateFormat手动指定字符串格式，或者是默认的格式

		*B：SimpleDateFormat构造方法
			* SimpleDateFormat()：使用默认的格式进行对日期进行格式化
			* SimpleDateFormat(String pattern) ：通过指定的方式进行格式化
			
		*C: 日期格式化SimpleDateFormat
			* a: 使用默认的方式进行对象的格式化
			
				   //创建SimpleDateFormat对象空参
					SimpleDateFormat sf = new SimpleDateFormat();
					//创建Date对象
					Date d = new Date();
					//使用SimpleDateFormat进行对Date日期格式化
					String format = sf.format(d);
					//打印格式化后的日期
					System.out.println(format);
					
					//将字符串转换成日期对象
					Date date = sf.parse("17-5-25 上午1:01");
					System.out.println(date);

			*注意：
					解析字符串的时候，必须跟构建SimpleDateFormat对象的模式一样的字符串，才能解析，否则报错java.text.ParseException:解析异常

			* b: 对日期进行格式化的步骤
				* 1: 创建SimpleDateFormat对象
					* 在类构造方法中,写入字符串的日期格式 (自己定义)
				* 2: SimpleDateFormat调用方法format对日期进行格式化
					* public String format(Date date) 传递日期对象,返回字符串
					* 日期模式:
		 			* yyyy    年份
		 			* MM      月份
					* dd      月中的天数
					* HH       0-23小时
					* mm      小时中的分钟
		 			* ss      秒
		 			* yyyy年MM月dd日 HH点mm分钟ss秒  汉字修改,: -  字母表示的每个字段不可以随便写

			案例演示：
				
				1.按照yyyy年MM月dd日格式进行格式化			

					// 使用指定格式进行格式化日期yyyy年MM月dd日
					SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
					// 创建日期Date对象
					Date d = new Date();
					// 按照yyyy年MM月dd日格式进行格式化
					String format = sf.format(d);
					System.out.println(format);
			
					//解析：yyyy年MM月dd日进行解析封装成Date对象
					Date date = sf.parse("2017年05月25日");
					System.out.println(date.toLocaleString());

				2.按照yyyy年MM月dd日 HH：mm:ss格式进行格式化
						
					// 使用指定格式进行格式化日期yyyy年MM月dd日 HH:mm:ss
					SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
					// 创建日期Date对象
					Date d = new Date();
					// 按照yyyy年MM月dd日格式进行格式化
					String format = sf.format(d);
					System.out.println(format);
			
					// 解析：yyyy年MM月dd日进行解析封装成Date对象
					Date date = sf.parse("2017年05月25日 01:28:40 ");
					System.out.println(date.toLocaleString());

>* 案例：求出你来这个世界上多少天？

	案例代码：
		//出生日期
		String birthday = "1990-11-19";
		//今天的日期
		Date d = new Date();
		System.out.println(d.toLocaleString());
		
		//格式化
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sf.format(d);
		
		long d1 = sf.parse(birthday).getTime();
		long d2 = sf.parse(format).getTime();
		System.out.println((d2-d1)/1000/60/60/24);


#Calendar时间类

>* A：Calendar概述
>* B: 获取Calendar对象
>* C:Calendar的获取功能

	总结：
		A：就是操作 年 月 日 的类
		B：
			通过查看API发现，calendar对象的构造方法为protected权限，我们是不能直接new创建Calendar对象，只能使用getInstance() 来获取对象
			例如：Calendar c = Calendar.getInstance();

		C:
			*获取功能
				* int get(int field) 获取指定字段的值
				举例：
					// 获取年份
					int year = c.get(Calendar.YEAR);
					// 获取月份
					int month = c.get(Calendar.MONTH) + 1;
					// 获取天数
					int day = c.get(Calendar.DAY_OF_MONTH);
					System.out.println(year + "年" + month + "月" + day + "日");

				注意：月份是从0开始的，我们获取到月份要进行+1，才真是我们想要的月份		
	
			*修改功能
				* void set(int field, int value)： 将给定的日历字段设置为给定值。 
				* void set(int year, int month, int date) ：设置日历字段 YEAR、MONTH 和 DAY_OF_MONTH 的值。 

				举例：
					// 设置,月份,设置到10月分
					c.set(Calendar.MONTH, 9);
					// 设置年,月,日
					c.set(2099, 4, 1);
				
			*添加功能
				* add(int field, int value) 进行整数的偏移
				举例：
					// 让日历中的天数,向后偏移280天
					c.add(Calendar.DAY_OF_MONTH, -280);
			

>* Calendar中常用的常量：

		* int year = cal.get(Calendar.YEAR);//当前年 
		* int month = (cal.get(Calendar.MONTH))+1;//当前月 Calendar.MONTH从0开始     
		* int day_of_month = cal.get(Calendar.DAY_OF_MONTH);//当前月的第几天:即当前日 
		* int hour24 = cal.get(Calendar.HOUR_OF_DAY);//当前时钟:HOUR_OF_DAY-24小时制     
		* int hour12 = cal.get(Calendar.HOUR);  //HOUR-12小时制   
		* int minute = cal.get(Calendar.MINUTE);  //当前:分钟   
		* int second = cal.get(Calendar.SECOND);  //当前秒   
		* int day_of_week = cal.get(Calendar.DAY_OF_WEEK)-1; // 星期几  Calendar.DAY_OF_WEEK用数字（1~7）表示（星期日~星期六）    
		* int ampm = cal.get(Calendar.AM_PM); //0-上午；1-下午  
		* int week_of_year = cal.get(Calendar.WEEK_OF_YEAR); //当前年的第几周      
		* int week_of_month = cal.get(Calendar.WEEK_OF_MONTH);   //当前月的星期数  
		* int day_of_week_in_month = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);  //当前月中的第几个星期     
		* int day_of_year = cal.get(Calendar.DAY_OF_YEAR); //当前年的第几天


#包装类
###01、基本数据类型对象包装类概述
	* A：基本数据类型对象包装类概述
		*a.基本类型包装类的产生
			
			基本数据类型只能做一些简单的操作运算，所以Java为我们封装了基本数据类型，为每一种数据类型提供了包装类
			包装类就是封装了基本数据类型的类，为我们提供了一些复杂的方法，和一些变量
			
			在实际程序使用中，程序界面上用户输入的数据都是以字符串类型进行存储的。
			而程序开发中，我们需要把字符串数据，根据需求转换成指定的基本数据类型，
			如年龄需要转换成int类型，考试成绩需要转换成double类型等...

	* B：八种基本类型对应的包装类
	
			char    ：Character
			int     ：Integer
			byte    ：Byte
			short   ：Short
			long    ：Long
			float   ：Float
			double  ：Double
			boolean ：Boolean

###02、Integer类构造方法
	* A：Integer类构造方法

		*Integer(int value) 
          	*将int类型的数据封装成Integer对象 
		*Integer(String s) 
         	*将字符串的数值封装成Integer对象
	
		案例演示：
		    /*
		     *  Integer类构造方法
		     *   Integer (String s)
		     *   将数字格式的字符串,传递到Integer类的构造方法中
		     *   创建Integer对象,包装的是一个字符串
		     *   将构造方法中的字符串,转成基本数据类型,调用方法,非静态的, intValue()
		     */
		    public static void function_3(){
			Integer in = new Integer("100");
			int i = in.intValue();
			System.out.println(--i);//99
		    }



###03、Integer类字符串转int
>* String转Integer有几种方法？

	总结：
		有两种种方式
			*A：int intValue()  
				举例：
					Integer in = new Integer("234");//将字符串"234"封装成Integer对象
					int number = in.intValue();
			*B：Integer.parseInt()
	
				举例：
				****	int n = Integer.parseInt("123");
				
		



###04、Integer类int转成字符串 
	*A:Integer类int转成字符串:
		*a:使用+与字符串拼接
			int i = 3;
          		String s = i+"";
          		System.out.println(s+1);//"31"
	*B: 
		String toString()： 
			举例：
				Integer i = new Integer(12);
				String string = i.toString();
		static String toString(int i)  
			举例：
				String string2 = Integer.toString(123);
				System.out.println(string2);

###05Integer类其他方法
>* toBinarString(int)
>* toOctalString(int)
>* toHexString(int)
	* A：Integer类其他方法
		 /*
		 * Integer类的3个静态方法
		 * 做进制的转换
		 * 十进制转成二进制  toBinarString(int)
		 * 十进制转成八进制  toOctalString(int)
		 * 十进制转成十六进制 toHexString(int)
		 * 三个方法,返回值都是以String形式出现
		 */
	      a:十进制转二,八,十六进制
			  public static void function_1(){
				System.out.println(Integer.toBinaryString(99));
				System.out.println(Integer.toOctalString(99));
				System.out.println(Integer.toHexString(999));
			  }
	      b:获取int的最大值和最小值
		      /*
		       *   Integer类的静态成员变量
		       *   MAX_VALUE
		       *   MIN_VALUE
		       */
		      public static void function(){
				System.out.println(Integer.MAX_VALUE);
				System.out.println(Integer.MIN_VALUE);
		      }
 
###06自动装箱和自动拆箱
>* 自动装箱
>* 自动拆箱
	* A：自动装箱
		* 将int类型的数据赋值给Integer对象
			* Integer i = 10;  //自动装箱相当于 Integer i = new Integer(10);
			
		//JDK1.5新特性
		//自动装箱,拆箱的 好处: 基本类型和引用类直接运算
		//自动装箱:使用Integer.valueOf(整数值)返回一个封装了该整数值的Integer对象
		//自动拆箱:使用Integer对象.intValue()返回Integer对象中封装的整数值
		public static void function(){
			//自动把基本数据类型1转成引用数据类型
			Integer in = 1;
			//先把引用数据类型in转成基本数据类型，加1之后结果变成2。把基本数据类型的2又赋值给了引用变量in
			in = in + 1;
			System.out.println(in);
		}
	* B:自动拆箱:
		* 将Integer类型赋值给int类型
			* Integer i = new Integer(10);
			  int number = i;//自动拆箱
	

#正则表达式
###01正则表达式的概念和作用
	* A: 正则表达式的概念和作用
		* a: 正则表达式的概述
			* 正则表达式也是一个字符串，用来定义匹配规则，在Pattern类中有简单的规则定义。
			  可以结合字符串类的方法使用。
			* 简单记：正则表达式是具有特殊含义的字符串。
		* b: 正则表达式的作用
			* 比如注册邮箱,邮箱有用户名和密码,一般会对其限制长度,这个限制长度的事情就是正则表达式做的

###02、正则表达式语法规则
	* A: 正则表达式语法规则
		* a: 字符
			* x  代表的是字符x
			* \\ 代表的是反斜线字符'\'
			* \t 代表的是制表符
			* \n 代表的是换行符
			* \r 代表的是回车符
		* b: 字符类
			* [abc]    a、b 或 c（简单类）
			* [^abc]   任何字符，除了 a、b 或 c（否定）
			* [a-zA-Z] a到 z 或 A到 Z，两头的字母包括在内（范围） 
			* [0-9]    0到9的字符都包括
			* [a-zA-Z_0-9] 代表的字母或者数字或者下划线(即单词字符)
		* c: 预定义字符类
			* . 任何字符（与行结束符可能匹配也可能不匹配） 
			* \d 数字：[0-9] 
			* \D 非数字： [^0-9] 
			* \s 空白字符：[ \t\n\x0B\f\r] 
			* \S 非空白字符：[^\s] 
			* \w 单词字符：[a-zA-Z_0-9] 
			* \W 非单词字符：[^\w] 
		* d: 数量词
			* X?     X，一次或一次也没有
			* X*     X，零次或多次
			* X+     X，一次或多次
			* X{n}   X，恰好 n 次 
			* X{n,}  X，至少 n 次 
			* X{n,m} X，至少 n 次，但是不超过 m 次

###03、正则表达式练习校验qq号是否合法

	需求：
		要求必须是5-15位
 		0不能开头
 		必须都是数字

	
###04、正则表达式练习判断字符串中间的字符是否是元音
	
		需求:
			判断字符串”qaq”中间的字符是否是元音 
			

###05、正则表达式切割练习

	需求：
	 切割字符串"aa,bb,cc";
	 切割字符串"-1 99 4 23";
	 切割字符串"-1   99 4     23";
	 String[] split(String regex) 根据给定正则表达式的匹配拆分此字符串。 

###06、正则表达式替换联系

	匹配正确的数字:
		匹配规则：
			* 匹配正整数：”\\d+”
			* 匹配正小数：”\\d+\\.\\d+”  
			* 匹配负整数：”-\\d+”
			* 匹配负小数：”-\\d+\\.\\d+”
			* 匹配保留两位小数的正数：”\\d+\\.\\d{2}”
			* 匹配保留1-3位小数的正数：”\\d+\\.\\d{1,3}”


	  
