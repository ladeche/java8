package test.lambda.methodreference;

import java.util.List;

public interface ConstructorListArgumentInterface<T, U> {
    T create(List<U> arg);
}