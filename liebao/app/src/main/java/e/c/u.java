package e.c;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: QueryMap.java */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface u {
    boolean a() default false;
}
