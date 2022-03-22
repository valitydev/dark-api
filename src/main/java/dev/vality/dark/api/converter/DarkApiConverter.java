package dev.vality.dark.api.converter;

public interface DarkApiConverter<R, T> {

    R convertToThrift(T value);

    T convertToSwag(R value);

}
