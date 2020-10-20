package top.flooog.scss.core;

/**对部分常用状态码进行封装
 * @author 方立清
 */
public enum HttpStatus {
    SC_OK(200),
    SC_UNAUTHORIZED(401),
    SC_INTERNAL_SERVER_ERROR(500),
    SC_NOT_FOUND(404);
    private int code;
    private HttpStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
