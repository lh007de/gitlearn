import java.util.Optional;

/**
 * @ClassName: NpeDemo
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/12 11:31
 * @Version: 1.0
 **/
public class NpeDemo {
    public static void main(String[] args) throws Exception {
        String s = "33333";
        Optional<String> s1 = Optional.ofNullable(s);
        System.out.println(s1.orElseThrow(()->new Exception("ss")));
//        Staff staff = new Staff();
//
//        Optional<Staff> staffOpt =Optional.ofNullable(staff);
//        staffOpt
//                .flatMap(Staff::getDepartment)
//                .flatMap(Department::getCompany)
//                .map(Company::getName)
//                .orElse("Unknown");
//        System.out.println(staffOpt.get().getDepartment().get().getCompany().get().getName());
    }
}

 class Staff {
    private Department department;
    public Optional<Department> getDepartment() {
        return Optional.ofNullable(department);
    }

}
 class Department {

    private Company company;
    public Optional<Company> getCompany() {
        return Optional.ofNullable(company);
    }
}

 class Company {
    private String name;
    public String getName() {
        return name;
    }
}

