/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.common;

/**
 * @author likailee.llk
 * @version RpcRequest.java 2021/05/28 Fri 1:35 PM likai
 */
public class RpcRequest {
    private String clazz;
    private String methodName;
    private String argTypes;
    private String argValues;

    public RpcRequest() {
    }

    public RpcRequest(String clazz, String methodName, String argTypes, String argValues) {
        this.clazz = clazz;
        this.methodName = methodName;
        this.argTypes = argTypes;
        this.argValues = argValues;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "clazz='" + clazz + '\'' +
                ", methodName='" + methodName + '\'' +
                ", argTypes='" + argTypes + '\'' +
                ", argValues='" + argValues + '\'' +
                '}';
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getArgTypes() {
        return argTypes;
    }

    public void setArgTypes(String argTypes) {
        this.argTypes = argTypes;
    }

    public String getArgValues() {
        return argValues;
    }

    public void setArgValues(String argValues) {
        this.argValues = argValues;
    }
}
