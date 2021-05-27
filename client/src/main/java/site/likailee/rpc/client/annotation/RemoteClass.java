/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author likailee.llk
 * @version RemoteClass.java 2021/05/27 Thu 3:28 PM likai
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RemoteClass {
    String value();
}
