package test.streams.streamcreation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SampleStreamBuilder implements Stream.Builder<String> {
    List<String> list = new ArrayList<String>();

    @Override
    public void accept(String t) {
       list.add(t);
    }

    @Override
    public Stream<String> build() {
       return list.stream();
    }
}
