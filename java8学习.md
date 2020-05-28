# [java8新特性](https://lw900925.github.io/java/java8-lambda-expression.html)


## 行为参数化

多使用接口，进行抽象能显著提升自己的设计功底

	public interface Predicate<T> {
	    public boolean test(T t);
	}


	public interface BookPredicate {
    	public boolean test(Book book);
	}

	public List<Book> filter(List<Book> books, BookPredicate bookPredicate) {
    List<Book> result = new ArrayList<>();
	for (Book book : books) {
		if (bookPredicate.test(book)) {
			result.add(book);
			}
		}
	return result;
	}


	// 根据作者过滤,使用内部类
	final String author = "张三";
	List<Book> result = filter(books, new BookPredicate() {
	    @Override
	    public boolean test(Book book) {
	        return author.equals(book.getAuthor());
	    }
	});


## lambda表达式

使用内部类，程序可读性，明显差很多，如果这样使用呢

	// 根据作者过滤
	List<Book> result = filter(books, book -> "张三".equals(book.getAuthor()));

*Lambda表达式（lambda expression）是一个匿名函数，由数学中的λ演算而得名。在Java 8中可以把Lambda表达式理解为匿名函数，它没有名称，但是有参数列表、函数主体、返回类型等。*
	
	// 语法如下
	(parameters) -> { statements; }

	
	// 体验一下lambda强大之处

	// Comparator排序
	List<Integer> list = Arrays.asList(3, 1, 4, 5, 2);
	list.sort(new Comparator<Integer>() {
	    @Override
	    public int compare(Integer o1, Integer o2) {
	        return o1.compareTo(o2);
	    }
	});
	
	// 使用Lambda表达式简化
	list.sort((o1, o2) -> o1.compareTo(o2));

	// Runnable代码块
	Thread thread = new Thread(new Runnable() {
	    @Override
	    public void run() {
	        System.out.println("Hello Man!");
	    }
	});
	
	// 使用Lambda表达式简化
	Thread thread = new Thread(() -> System.out.println("Hello Man!"));


排序甚至可以更简化

	list.sort(Integer::compareTo);

	这种写法被称为 方法引用，方法引用是Lambda表达式的简便写法。如果你的Lambda表达式只是调用这个方法，最好使用名称调用，而不是描述如何调用，这样可以提高代码的可读性。

	方法引用使用::分隔符，分隔符的前半部分表示引用类型，后面半部分表示引用的方法名称。例如：Integer::compareTo表示引用类型为Integer，引用名称为compareTo的方法。
	
	// 此外集合打印的一个简化写法

	list.forEach(System.out::println);

## 函数式接口

>函数式接口又是什么鬼？在Java 8中，把那些仅有一个抽象方法的接口称为函数式接口。如果一个接口被@FunctionalInterface注解标注，表示这个接口被设计成函数式接口，只能有一个抽象方法，如果你添加多个抽象方法，编译时会提示“Multiple non-overriding abstract methods found in interface XXX”之类的错误。



