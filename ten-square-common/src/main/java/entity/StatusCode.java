package entity;

/**
 * @Description: 状态码实体类
 * @Author: limaob
 * @CreateDate: 2019/3/26
 */
public class StatusCode {


    public static final int OK = 20000; //成功
    public static final int ERROR = 20001; //失败
    public static final int LOGINERROR = 20002; //用户名或者密码错误
    public static final int ACCESSERROR = 20003; //权限不足
    public static final int REMOTEERROE = 20004; //远程调用失败
    public static final int REPEERROR = 20005; //重复操作失败
}
