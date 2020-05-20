# spring使用工厂模式
设计模式是一种思想，在具体应用中要具体使用，本例演示在springboot使用工厂模式

## 使用场景：
    很多场合下，我们会有这种需求，就是根据不同的选择条件，调用不同的服务,这样能大大减少程序中的if -else
    示例请参考BeanfactoryApplicationTests测试
    
## 读书[笔记](http://lrwinx.github.io/2017/03/04/%E7%BB%86%E6%80%9D%E6%9E%81%E6%81%90-%E4%BD%A0%E7%9C%9F%E7%9A%84%E4%BC%9A%E5%86%99java%E5%90%97/)
### 1.浅拷贝
如果要在DTO和实体对象之间进行转换,可以使用一大堆繁琐的set/get方法，较好的方法是使用BeanUtils.copyProperties
    
    User lh = User.builder().age("18").name("lh").build();
    UserInfo userInfo = new UserInfo();
    /* userInfo.setName(lh.getName());
    userInfo.setAge(lh.getAge());*/
    BeanUtils.copyProperties(lh, userInfo);
    System.out.println(userInfo);
    可以看到和一系列get/set相比，BeanUtils.copyProperties(lh, userInfo);更好用
    拷贝两个的属性要名字和类型均相同
    
        
        
如果继续深入考虑这个问题，可以看出上面的问题就是一个类型转换，如果我们把这个过程抽象出一个接口呢

    public interface DTOConvert<S,T> {
        T convert(S s);
    }
    
    public class UserInputDTOConvert implements DTOConvert<User,UserInfo> {
        @Override
        public UserInfo convert(User user) {
                UserInfo userInfo = new UserInfo();
                BeanUtils.copyProperties(user,userInfo);
                return userInfo;
        }
    
    }
    我们可以实现很多不同的类型的转换，使用起来也比较简单
    UserInfo userInfo = new UserInputDTOConvert().convert(user);
    这样就实现了类型的转换
    
 ###2.bean的验证
 任何前端请求都是不可信的，要保证入参和正确，合理
 
 ### 3.bean 链式调用
 
 使用强大的lombok
 
    @Accessors(chain = true)
    @Setter
    @Getter
    public class Student {
        private String name;
        private int age;
    }
    
    
 静态构造方法
 
    @Accessors(chain = true)
    @Setter
    @Getter
    @RequiredArgsConstructor(staticName = "of")
    public class Student {
            @NonNull 
            private String name;
            private int age;
    }
    Student student = Student.of("zs");
    此时就不能使用new Student() 来创建对象了，因为上面的注释已经帮我们构建了一个静态的构造函数
    
    
 建造者模式 使用lombok注解轻松实现建造者模式
 
    @Builder
    public class Student {
        private String name;
        private int age;
    }
    Student student = Student.builder().name("zs").age(24).build();
    
 可以看看不适用注解的实现方式
    
    public class Student {
        private String name;
        private int age;
    
        public String getName() {
                return name;
        }
    
        public void setName(String name) {
                this.name = name;
        }
    
        public int getAge() {
                return age;
        }
    
        public void setAge(int age) {
                this.age = age;
        }
    
        public static Builder builder(){
                return new Builder();
        }
        public static class Builder{
                private String name;
                private int age;
                public Builder name(String name){
                        this.name = name;
                        return this;
                }
    
                public Builder age(int age){
                        this.age = age;
                        return this;
                }
    
                public Student build(){
                        Student student = new Student();
                        student.setAge(age);
                        student.setName(name);
                        return student;
                }
        }
    
    }
 显而易见，lombok给我们带来的极大便利之处
 
 