package lab.hashmap;

import java.util.Objects;

public class StringKey {
    String key;

    public StringKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof StringKey)) return false;
//        StringKey stringKey = (StringKey) o;
//        return Objects.equals(getKey(), stringKey.getKey());
//    }

    @Override
    public int hashCode() {
        return 1234567890;
    }
}
