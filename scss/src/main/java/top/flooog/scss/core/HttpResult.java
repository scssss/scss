package top.flooog.scss.core;

/**
 * 对返回的数据结果进行封装，包括错误信息，正确信息
 * @author 方立清
 */
public class HttpResult {
    private int code = 200;
    private String msg;
    private Object data;

    public static HttpResult error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR.getCode(),"未知错误，请联系管理员！");
    }

    public static HttpResult error(String msg){
            return error(HttpStatus.SC_INTERNAL_SERVER_ERROR.getCode(),msg);
    }

    public static HttpResult error(int code,String msg){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(code);
        httpResult.setMsg(msg);
        return httpResult;
    }

    public static HttpResult ok(Object data){
        HttpResult httpResult = new HttpResult();
        httpResult.setData(data);
        return httpResult;
    }

    public static HttpResult ok(String msg){
        HttpResult httpResult = new HttpResult();
        httpResult.setMsg(msg);
        return httpResult;
    }

    public static HttpResult ok(){
        return new HttpResult();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
