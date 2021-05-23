今日内容介绍
	1、包&权限修饰符
	2、内部类

#包&权限修饰符
##1、包的作用和特点
	总结：	   
			a:包的作用:
				* 方便管理java文件
			b:包的特点：
				* 包有多层
				* 不同之间可以有重名的java文件
				* 包的位置必须是在类的第一行.使用关键字 package
				           
##2、不同包之间的互相访问  
	总结：       

			类的全名:包名.类名

			不同包之间的访问：
				a:导包 例如:import com.itheima.day01.Student
				b:类的全名 例如 com.itheima.day01.Student stu = new com.itheima.day01.Student();
			相同包下之间的访问
				a:直接访问即可

			注意：* 代表的是统配符.import com.itheima.day01.*;把这个包下面的所有的类,导入到当前类中

				 
##3、权限修饰符

		总结：
			public 	  ：当前类	相同包下的不同类   不同包下的类
	 		private	  ：当前类
	 		default	  ：当前类  相同包下的不同类
	 		protected ：当前类  相同包下的不同类   在字符类不同包下
 		
	 	* default 和 protected 的区别?
	 		* default   ：只能是在相同包下使用
			* protected ：在字符类的相同包下,或者是不同包下都能使用
				          注意事项:如果是不同包下,只能是在子类的类里面才能使用
			
##4、权限修饰符总结    
 
	总结：               
		  
		  修饰符		   类			成员变量			成员方法			构造方法
		  public      	   Y				Y				   Y				   Y
		  default	       Y				Y				   Y				   Y
		  protected	       N				Y				   Y				   Y
		  private	       N				Y				   Y				   Y
		  abstract	       Y				N				   Y				   N
		  static	       N				Y				   Y				   N
		  final  	       Y				Y				   Y	               N			

		  总结:
		  	  在我们创建类,定义成员变量,成员方法的时候
		  	  如果是想让整个工程下的所有的类访问,用 public 修饰
		  	  如果是想让本来中使用,用 private 修饰
		  	  如果是想让本包中使用,用 default 修饰 
		  	  如果是想让子类使用,用 protected 修饰

		


#内部类

##一、内部类的概述
	* A: 内部类的概述
		 
		在这个类中又存在另一个类叫内部类,那么这个类是叫内部类的外部类

	* B: 什么时候使用内部类
		 
		 在我们描述一个事物的时候，他又有另外一个事物存在，比如一个汽车，在我们描述一个汽车的时候，我们发现他会用到另外一个事物
		 汽车的发动机

		 代码体现:

		 	class 汽车{ // 外部类
		 		private String name = "汽车";
		 		class 汽车发动机  { //内部类

		 		}
		 	}



		
	* C: 内部类的分类
		 a: 成员内部类
		 b: 局部内部类
		 c: 匿名内部类


##二、成员内部类的概述和使用
>* A: 什么是成员内部类
		在类的成员的位置.跟成员变量和成员方法是一个位置的
		内部类可以访问外部类的成员,也能访问私用的
		
		
>* B: 定义格式
		class 外部类 {
			// 成员的变量,方法
			class 内部类{
				// 可以有其他的变量,方法
			}
		}
		

>* C: 成员内部类代码演示

	代码演示：
		// 外部类
		class Outer{
			private String name = "123";
			// 内部类
			class Inner{
				public void method(){
					System.out.println("这是内部类的方法method");
					System.out.println(name);
				}
			}
		}

>* D: 访问格式：
	 外部类.内部类 对象名 = new 外部类().new 内部类();
	  public class NoNameInnerClass {
		public static void main(String[] args) {
			// 创建对象
			Outer o = new Outer();
			// 外部类.内部类 对象名 = new 外部类().new 内部类();
			Outer.Inner in = o.new Inner();
			//这是第二中方式
			Outer.Inner inner = new Outer().new Inner();
			inner.method();
		}
	}
		
>* E:成员内部类的修饰符
		
		* 使用权限修饰符,可以使用private,但是使用private在其他类中无法使用
		* 可以使用 static 修饰成员内部类,不用创建外部类对象
		* abstract final 不建议使用
		

成员内部类的同名变量调用

	案例代码：
	public class Body { // 人的身体
	boolean flag  = true;  // 代表心的状态
	//人的身体里面有心肝脾肾
		class Heart{ //人的心
			public void jump(){
				System.out.println("心噗通噗通的跳!");
//				System.out.println("心的状态:" + flag); //访问同名的成员变量，局部变量
//				System.out.println("心的状态:" + this.flag);//访问同名的成员变量，成员变量
				System.out.println(Body.this.flag);//访问同名的外部类成员变量
			}
		}
}
	

##二、局部内部类的概述和使用(了解)
>* A 局部内部类概述
		在方法内,出了方法就不能使用了
		
>* B 定义格式
	class 外部类{

		修饰符 返回值类型 方法名(无惨/有参){
			class 内部类{
				// 可以有其他东西
			}
		}
	}
	
		

>* C :局部内部类代码演示
	class Outer1{
	public void method(){
		class Inner1{
			public void function(){
				System.out.println("我是一个比较恶心的内部类!");
			}
		}
		
		Inner1 in = new Inner1();
		in.function();
	}
}
		
				

>* D:访问方式
		public class NoNameInnerClass2 {
			public static void main(String[] args) {
				// 创建外部类的对象
				Outer1 o = new Outer1();
				o.method();
			}
		}
			

##三、匿名内部类
>* A: 概述
		就是没有名字的匿名内部类对象
		存在于方法当中
		在我们创建匿名类的时候,就确定他的对象
		

	格式：
			new 类/接口(){
				如果是抽象类,重写抽象类里面的所有的抽象方法!
				如果是接口,要重写接口里面的所有的抽象方法!
			};

	* B: 本质原理
			其实创建的是抽象类的子类和接口的实现类的对象
		
	* C: 案例
		abstract class Animal1{
			public abstract void eat();
			public abstract void drink();
		}

		public class NoNameInnerClass5 {
			public static void main(String[] args) {
				new Animal1() {

					@Override
					public void eat() {
						System.out.println("猫吃猫粮!");
					}

					@Override
					public void drink() {
						// TODO Auto-generated method stub
						
					}
				}.eat();

				Animal1 an = new Animal1() {
					@Override
					public void eat() {
						System.out.println("猫吃猫粮!");
					}

					@Override
					public void drink() {
						System.out.println("猫喝水");
					}
				};

				an.drink();
				an.eat();

			}
		}
	
 
##四、匿名内部类使用场景

	总结：
		作为方法的参数,只执行一次

	参考答案：

		
			
		
