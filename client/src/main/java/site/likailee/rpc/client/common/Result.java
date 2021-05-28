/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.common;

/**
 * @author likailee.llk
 * @version Result.java 2021/05/28 Fri 2:50 PM likai
 */
public class Result {
    private boolean success;
    private String message;
    private String resultType;
    private String result;

    public Result(boolean success, String message, String resultType, String result) {
        this.success = success;
        this.message = message;
        this.resultType = resultType;
        this.result = result;
    }

    public static Result ok(String resultType, String result) {
        return new Result(true, "success", resultType, result);
    }

    public static Result fail(String msg) {
        return new Result(false, msg, null, null);
    }


    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", resultType='" + resultType + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
