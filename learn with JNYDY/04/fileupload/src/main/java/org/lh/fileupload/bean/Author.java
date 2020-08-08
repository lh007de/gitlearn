package org.lh.fileupload.bean;

/**
 * @ClassName: Author
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 15:29
 * @Version: 1.0
 **/
public class Author {
    private String name;
    private Integer age;


    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
