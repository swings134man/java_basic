package etc_methods.generics.wildcard;

/************
 * @info : Java Wild Card - Company Extends Class
 * @name : Kia
 * @date : 2023/02/16 5:44 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Kia extends Company{

    private static final String NAME = "Kia";

    @Override
    public void getToCompany() {
        super.getToCompany();
    }

    @Override
    public void getCompanyName() {
        System.out.println("Company name is : " + NAME);
    }
}
